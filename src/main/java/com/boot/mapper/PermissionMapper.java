package com.boot.mapper;

import com.boot.bean.Permission;
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
public interface PermissionMapper {
    @Select("SELECT * FROM sys_permission WHERE id = #{id}")
    public Permission findPermissionById(Integer id);

    @Select("SELECT p.permission FROM sys_permission p INNER JOIN (SELECT rp.permission_id FROM sys_user u INNER JOIN sys_user_role ur ON u.id = ur.user_id INNER JOIN sys_role_permission rp ON ur.role_id = rp.role_id WHERE u.name = #{username}) b ON p.id = b.permission_id")
    public Set<String> findPermissions(String username);

    @Select("SELECT * FROM sys_permission")
    public List<Permission> selectAll();

    @Insert("insert into sys_permission (id,permission,description,available) values(#{id},#{permission},#{description},#{available})")
    public int add(Permission permission);

    @Delete("delete from sys_permission where id=#{id}")
    public void delete(Integer id);

    @Update("update sys_permission set permission = #{permission},description = #{description},available = #{available} where id = #{id}")
    public int update(Permission permission);
}
