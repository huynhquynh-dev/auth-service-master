package vn.com.osstech.uaa.model.mapper.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import vn.com.osstech.uaa.model.entity.Permission;
import vn.com.osstech.uaa.model.entity.RolePermission;
import vn.com.osstech.uaa.model.mapper.PermissionMapper;
import vn.com.osstech.uaa.model.reponse.PermissionReponse;
import vn.com.osstech.uaa.model.request.PermissionRequest;

/**
 * @author : Truong Duong
 * @since : 06/03/2020, Fri.
 **/
@Component
public class PermissionMapperImpl implements PermissionMapper {

  @Override
  public PermissionReponse toPermissionDTO(Permission permission) {
    if (permission == null) {
      return null;
    }

    PermissionReponse permissionReponse = new PermissionReponse();
    permissionReponse.setId(permission.getId());
    permissionReponse.setName(permission.getName());
    permissionReponse.setDescription(permission.getDescription());
    permissionReponse.setEnabled(permission.isEnabled());

    return permissionReponse;
  }

  @Override
  public List<PermissionReponse> toListPermissionDTO(List<Permission> permissions) {
    if (permissions == null) {
      return null;
    }

    List<PermissionReponse> permissionReponses = new ArrayList<>();
    for (Permission permission : permissions) {
      permissionReponses.add(toPermissionDTO(permission));
    }

    return permissionReponses;
  }

  @Override
  public List<PermissionReponse> toListRolePermissionDTO(List<RolePermission> rolePermissions) {
    if (rolePermissions == null) {
      return null;
    }

    List<PermissionReponse> permissionReponses = new ArrayList<>();
    for (RolePermission rolePermission : rolePermissions) {
      permissionReponses.add(toPermissionDTO(rolePermission.getPermission()));
    }

    return permissionReponses;
  }

  @Override
  public Permission toPermissionEntity(Permission permission, PermissionRequest permissionRequest) {
    if (permissionRequest == null) {
      return null;
    }

    if (permissionRequest.getId() > 0) {
      permission.setId(permissionRequest.getId());
    }
    permission.setName(permissionRequest.getName());
    permission.setDescription(permissionRequest.getDescription());
    permission.setEnabled(permissionRequest.isEnabled());

    return permission;
  }

}
