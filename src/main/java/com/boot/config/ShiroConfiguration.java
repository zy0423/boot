package com.boot.config;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.apache.shiro.authc.credential.PasswordMatcher;
import org.crazycake.shiro.RedisCacheManager;
import org.apache.shiro.mgt.RememberMeManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.boot.shiro.realm.ShiroRealmImpl;


@Configuration
public class ShiroConfiguration
{
	private static Logger logger = LoggerFactory.getLogger(ShiroConfiguration.class);

	private static Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();

	private RedisCacheManager cacheManager;

	@Bean(name = "shiroFilter")
	public ShiroFilterFactoryBean getShiroFilterFactoryBean()
	{
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		//shiroFilterFactoryBean.setSecurityManager(getDefaultWebSecurityManager());
		shiroFilterFactoryBean.setSecurityManager(getDefaultWebSecurityManager());
		shiroFilterFactoryBean.setLoginUrl("/login");
		shiroFilterFactoryBean.setSuccessUrl("/main");
		shiroFilterFactoryBean.setUnauthorizedUrl("/index");
		filterChainDefinitionMap.put("/main/**", "authc");
		filterChainDefinitionMap.put("/static/*", "anon");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return shiroFilterFactoryBean;
	}

	@Bean(name = "ShiroRealmImpl")
	public ShiroRealmImpl getShiroRealm() {
		final ShiroRealmImpl realm = new ShiroRealmImpl();
		realm.setCredentialsMatcher(credentialsMatcher());
		return new ShiroRealmImpl();
	}

	@Bean(name = "redisManager")
	public RedisManager getRedisManager()
	{
		RedisManager rm = new RedisManager();
		rm.setHost("127.0.0.1");
		rm.setPort(6379);
		rm.setExpire(1800);
		rm.setTimeout(10000);
		return rm;
	}

	public RedisCacheManager getCacheManager() {
		return this.cacheManager;
	}

	@Autowired
	public void setCacheManager(RedisCacheManager cacheManager)
	{
		this.cacheManager = cacheManager;
		this.cacheManager.setRedisManager(getRedisManager());
	}

	@Bean(name = "redisSessionDAO")
	public RedisSessionDAO getRedisSessionDAO() {
		RedisSessionDAO sm = new RedisSessionDAO();
		sm.setRedisManager(getRedisManager());
		return sm;
	}

	@Bean(name = "sessionManager")
	public DefaultWebSessionManager getSessionManager() {
		DefaultWebSessionManager defaultWebSessionManager = new DefaultWebSessionManager();
		defaultWebSessionManager.setSessionDAO(getRedisSessionDAO());
		return defaultWebSessionManager;
	}

	@Bean(name = "lifecycleBeanPostProcessor")
	public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor()
	{
		return new LifecycleBeanPostProcessor();
	}

	@Bean
	public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator()
	{
		DefaultAdvisorAutoProxyCreator daap = new DefaultAdvisorAutoProxyCreator();
		daap.setProxyTargetClass(true);
		return daap;
	}

	@Bean(name = "securityManager")
	public DefaultWebSecurityManager getDefaultWebSecurityManager()
	{
		DefaultWebSecurityManager dwsm = new DefaultWebSecurityManager();
		dwsm.setRealm(getShiroRealm());
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

	@Bean
	public RememberMeManager rememberMeManager()
	{
		logger.debug("create remember me manager.");

		SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
		simpleCookie.setHttpOnly(true);
		simpleCookie.setMaxAge(2592000);

		CookieRememberMeManager	 rememberMeManager = new CookieRememberMeManager();
		rememberMeManager.setCookie(simpleCookie);
		return rememberMeManager;
	}

	@Bean
	public AuthorizationAttributeSourceAdvisor getAuthorizationAttributeSourceAdvisor()
	{
		AuthorizationAttributeSourceAdvisor aasa = new AuthorizationAttributeSourceAdvisor();
		aasa.setSecurityManager(getDefaultWebSecurityManager());
		return new AuthorizationAttributeSourceAdvisor();
	}
}
