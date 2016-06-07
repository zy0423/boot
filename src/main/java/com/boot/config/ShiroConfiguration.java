package com.boot.config;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.apache.shiro.authc.credential.PasswordMatcher;
import org.crazycake.shiro.RedisCacheManager;
import org.apache.shiro.mgt.RememberMeManager;
import org.crazycake.shiro.RedisManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.crazycake.shiro.RedisSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.boot.shiro.realm.ShiroRealmImpl;
import org.springframework.context.annotation.DependsOn;


@Configuration
public class ShiroConfiguration
{
	private static Logger logger = LoggerFactory.getLogger(ShiroConfiguration.class);

	private static Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();

	@Bean
	public static LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}

	@Bean
	@DependsOn("lifecycleBeanPostProcessor")
	public static DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
		DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
		advisorAutoProxyCreator.setProxyTargetClass(true);
		return advisorAutoProxyCreator;
	}

	@Bean(name = "shiroFilter")
	public ShiroFilterFactoryBean getShiroFilterFactoryBean()
	{
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(getDefaultWebSecurityManager());
		shiroFilterFactoryBean.setLoginUrl("/");
		shiroFilterFactoryBean.setSuccessUrl("/home");
		shiroFilterFactoryBean.setUnauthorizedUrl("/login");

		filterChainDefinitionMap.put("/home/**", "authc");
		filterChainDefinitionMap.put("/session/**", "authc");
		filterChainDefinitionMap.put("/user/**", "authc");
		filterChainDefinitionMap.put("/register/*", "anon");
		filterChainDefinitionMap.put("/static/*", "anon");

		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return shiroFilterFactoryBean;
	}

	@Bean(name = "shiroRealmImpl")
	public ShiroRealmImpl getShiroRealm() {
		final ShiroRealmImpl realm = new ShiroRealmImpl();
		realm.setCredentialsMatcher(credentialsMatcher());
		return new ShiroRealmImpl();
	}

	@Bean(name = "redisManager")
	public RedisManager getRedisManager()
	{
		RedisManager redisManager = new RedisManager();
		redisManager.setHost("127.0.0.1");
		redisManager.setPort(6379);
		redisManager.setExpire(1800);
		redisManager.setTimeout(1800);
		return  redisManager;
	}

	@Bean(name = "redisCacheManager")
	public RedisCacheManager getCacheManager() {
		RedisCacheManager redisCacheManager = new RedisCacheManager();
		redisCacheManager.setRedisManager(getRedisManager());
		redisCacheManager.setKeyPrefix("users:security:authz");
		return redisCacheManager;
	}

	@Bean(name = "sessionDAO")
	public RedisSessionDAO getRedisSessionDAO() {
		RedisSessionDAO sm = new RedisSessionDAO();
		sm.setRedisManager(getRedisManager());
		return sm;
	}

	@Bean(name = "sessionManager")
	public DefaultWebSessionManager getSessionManager() {
		DefaultWebSessionManager defaultWebSessionManager = new DefaultWebSessionManager();
		defaultWebSessionManager.setSessionDAO(getRedisSessionDAO());
		defaultWebSessionManager.setSessionIdCookie(sessionCookie());
		return defaultWebSessionManager;
	}

	@Bean(name = "securityManager")
	public DefaultWebSecurityManager getDefaultWebSecurityManager() {
		DefaultWebSecurityManager dwsm = new DefaultWebSecurityManager();
		dwsm.setRealm(getShiroRealm());
		dwsm.setRememberMeManager(rememberMeManager());
		dwsm.setCacheManager(getCacheManager());
		dwsm.setSessionManager(getSessionManager());
		return dwsm;
	}

	@Bean(name = "credentialsMatcher")
	public PasswordMatcher credentialsMatcher() {
		final PasswordMatcher credentialsMatcher = new PasswordMatcher();
		credentialsMatcher.setPasswordService(passwordService());
		return credentialsMatcher;
	}

	@Bean(name = "passwordService")
	public DefaultPasswordService passwordService() {
		return new DefaultPasswordService();
	}

	@Bean(name = "simpleCookie")
	public SimpleCookie sessionCookie()
	{
		SimpleCookie simpleCookie = new SimpleCookie();
		simpleCookie.setName("WAPSESSIONID");
		simpleCookie.setHttpOnly(true);
		simpleCookie.setMaxAge(1800);
		return simpleCookie;
	}

	@Bean(name = "rememberMeCookie")
	public SimpleCookie rememberMeCookie(){
		logger.debug("create remember me rememberMeCookie.");
		//这个参数是cookie的名称，对应前端的checkbox的name = rememberMe
		SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
		//<!-- 记住我cookie生效时间30天 ,单位秒;-->
		simpleCookie.setMaxAge(259200);
		return simpleCookie;
	}

	@Bean(name = "rememberMeManager")
	public RememberMeManager rememberMeManager()
	{
		logger.debug("create remember me manager.");
		CookieRememberMeManager	 rememberMeManager = new CookieRememberMeManager();
		rememberMeManager.setCookie(rememberMeCookie());
		return rememberMeManager;
	}

}
