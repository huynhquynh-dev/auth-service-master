package vn.com.osstech.uaa.model.mapper.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import vn.com.osstech.uaa.model.entity.Permission;
import vn.com.osstech.uaa.model.entity.Role;
import vn.com.osstech.uaa.model.entity.RolePermission;
import vn.com.osstech.uaa.model.entity.RolePermissionId;
import vn.com.osstech.uaa.model.mapper.RoleMapper;
import vn.com.osstech.uaa.model.reponse.RoleReponse;
import vn.com.osstech.uaa.model.request.PermissionRequest;
import vn.com.osstech.uaa.model.request.RoleRequest;

/**
 * @author : Truong Duong
 * @since : 06/03/2020, Fri.
 **/
@Component
public class RoleMapperImpl implements RoleMapper {

  @Override
  public RoleReponse toRoleDTO(Role role) {
    if (role == null) {
      return null;
    }

    RoleReponse roleReponse = new RoleReponse();
    roleReponse.setId(role.getId());
    roleReponse.setName(role.getName());
    roleReponse.setDescription(role.getDescription());
    roleReponse.setEnabled(role.isEnabled());

    return roleReponse;
  }

  @Override
  public List<RoleReponse> toListRoleDTO(List<Role> roles) {
    if (roles == null) {
      return null;
    }

    List<RoleReponse> roleReponses = new ArrayList<>();
    for (Role role : roles) {
      roleReponses.add(toRoleDTO(role));
    }

    return roleReponses;
  }

  @Override
  public Role toRoleEntity(Role role, RoleRequest roleRequest) {
    if (roleRequest == null) {
      return null;
    }

    if (roleRequest.getId() > 0) {
      role.setId(roleRequest.getId());
    }

    role.setName(roleRequest.getName());
    role.setDescription(roleRequest.getDescription());
    role.setEnabled(roleRequest.isEnabled());

    return role;
  }

  @Override
  public List<RolePermission> toListRolePermissionEntity(Role role,
      List<PermissionRequest> permissions) {
    if (permissions == null) {
      return null;
    }

    List<RolePermission> listItem = new ArrayList<>();

    for(PermissionRequest permissionRequest : permissions){
      RolePermission rolePermission = new RolePermission();

      RolePermissionId rolePermissionId = new RolePermissionId();
      rolePermissionId.setRoleId(role.getId());
      rolePermissionId.setPermissionId(permissionRequest.getId());
      rolePermission.setId(rolePermissionId);
      // Role
      rolePermission.setRole(role);
      // Permission
      Permission permission = new Permission();
      permission.setId(permissionRequest.getId());
      rolePermission.setPermission(permission);
      rolePermission.setEnabled(permissionRequest.isEnabled());

      listItem.add(rolePermission);
    }

    return listItem;
  }

}
