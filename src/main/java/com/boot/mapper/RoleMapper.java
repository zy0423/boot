package com.boot.mapper;

import com.boot.bean.Role;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

/**
 * Created by zy on 2016/5/11.
 */
public interface RoleMapper {
    @Select("SELECT * FROM sys_role WHERE id = #{id}")
    public Role findRoleById(Integer id);

    @Select("SELECT r.role FROM sys_role r ,(SELECT ur.role_id,u.name FROM sys_user u INNER JOIN sys_user_role ur ON u.id = ur.user_id) b WHERE r.id = b.role_id AND b.name = #{username}")
    public Set<String> findRoles(String username);

    @Select("SELECT * FROM sys_role")
    public List<Role> selectAll();

    @Insert("insert into sys_role (id,role,description,available) values(#{id},#{role},#{description},#{available})")
    public int add(Role role);

    @Delete("delete from sys_role where id=#{id}")
    public void delete(Integer id);

    @Update("update sys_role set role = #{role},description = #{description},available = #{available} where id = #{id}")
    public int update(Role role);
}
