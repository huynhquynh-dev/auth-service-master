package vn.com.osstech.uaa.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.osstech.uaa.model.entity.Permission;
import vn.com.osstech.uaa.model.entity.Role;
import vn.com.osstech.uaa.model.entity.RolePermission;
import vn.com.osstech.uaa.model.mapper.RoleMapper;
import vn.com.osstech.uaa.model.request.RoleRequest;
import vn.com.osstech.uaa.repository.PermissionRepository;
import vn.com.osstech.uaa.repository.RolePermissionRepository;
import vn.com.osstech.uaa.repository.RoleRepository;
import vn.com.osstech.uaa.service.RoleService;

/**
 * @author : Truong Duong
 * @since : 06/03/2020, Fri.
 **/
@Service
public class RoleServiceImpl implements RoleService {

  @Autowired
  RoleRepository roleRepository;

  @Autowired
  RolePermissionRepository rolePermissionRepository;

  @Autowired
  RoleMapper roleMapper;

  @Override
  public List<Role> findByAll() {
    return roleRepository.findAll();
  }

  @Override
  public Role findById(long accountId) {
    Optional<Role> optional = roleRepository.findById(accountId);
    return optional.isPresent() ? optional.get() : null;
  }

  @Override
  public Role save(RoleRequest roleRequest) {
    Role role = null;
    if (roleRequest.getId() == 0) {
      role = new Role();
    } else {
      Optional<Role> optional = roleRepository.findById(roleRequest.getId());
      if (optional.isPresent()) {
        role = optional.get();
      }
    }


    roleMapper.toRoleEntity(role, roleRequest);
    List<RolePermission> rolePermissions = roleMapper.toListRolePermissionEntity(role, roleRequest.getPermissions());

    roleRepository.save(role);

    rolePermissionRepository.saveAll(rolePermissions);

    return role;
  }

  @Override
  public boolean delete(long roleId) {
    Optional<Role> optional = roleRepository.findById(roleId);
    if (optional.isPresent()) {
      Role role = optional.get();
      roleRepository.delete(role);
      return true;
    }
    return false;
  }

}
