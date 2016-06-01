package com.boot.mapper;

import com.boot.bean.Role;
import org.springframework.context.annotation.Lazy;
import java.util.List;
import java.util.Set;

/**
 * Created by zy on 2016/5/11.
 */
@Lazy(true)
public interface RoleMapper {

    public Role findRoleById(Long id);

    public Set<String> findRoles(String username);

    public List<Role> selectAll();

    public int add(Role role);

    public void delete(Long id);

    public int update(Role role);
}
