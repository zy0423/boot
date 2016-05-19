package com.boot.mapper;

import com.boot.bean.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

@Lazy(true)//因为集成shiro的原因需要延迟加载--shiro加载在bean加载之前
public interface UserMapper
{
	@Select("SELECT * FROM sys_user WHERE id = #{id}")
	public User findUserById(Integer id);

	@Select("SELECT * FROM sys_user WHERE name = #{name}")
	public User findUserByName(String name);

	@Insert("insert into sys_user (id,name,password,email) values(#{id},#{name},#{password},#{email})")
	public int add(User user);

	@Select("SELECT * FROM sys_user")
	public List<User> selectAll();

	@Delete("delete from sys_user where id=#{id}")
	public void delete(Integer id);

	@Update("update sys_user set name = #{name},password = #{password},email = #{email},salt = #{salt},locked = #{locked}")
	public int update(User user);
}
