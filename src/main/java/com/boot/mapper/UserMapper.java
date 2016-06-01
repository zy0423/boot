package com.boot.mapper;

import com.boot.bean.User;
import org.springframework.context.annotation.Lazy;

import java.util.List;

@Lazy(true)
public interface UserMapper
{
	public User findUserById(Long id);

	public User findUserByName(String name);

	public int add(User user);

	public List<User> selectAll();

	public void delete(Long id);

	public int update(User user);
}
