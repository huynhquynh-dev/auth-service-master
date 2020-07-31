package vn.com.osstech.uaa.model.mapper;

import java.util.List;
import vn.com.osstech.uaa.model.entity.Permission;
import vn.com.osstech.uaa.model.entity.RolePermission;
import vn.com.osstech.uaa.model.reponse.PermissionReponse;
import vn.com.osstech.uaa.model.request.PermissionRequest;

/**
 * @author : Truong Duong
 * @since : 06/03/2020, Fri.
 **/
public interface PermissionMapper {

  PermissionReponse toPermissionDTO(Permission permission);

  List<PermissionReponse> toListPermissionDTO(List<Permission> permissions);

  List<PermissionReponse> toListRolePermissionDTO(List<RolePermission> rolePermissions);

  Permission toPermissionEntity(Permission permission, PermissionRequest permissionRequest);

}
