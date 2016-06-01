package com.boot.mapper;

import com.boot.bean.Permission;
import org.springframework.context.annotation.Lazy;
import java.util.List;
import java.util.Set;

/**
 * Created by zy on 2016/5/11.
 */
@Lazy(true)
public interface PermissionMapper {

    public Permission findPermissionById(Long id);

    public Set<String> findPermissions(String username);

    public List<Permission> selectAll();

    public int add(Permission permission);

    public void delete(Long id);

    public int update(Permission permission);
}
