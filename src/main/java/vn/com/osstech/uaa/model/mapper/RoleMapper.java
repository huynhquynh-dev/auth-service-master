package vn.com.osstech.uaa.model.mapper;

import java.util.List;
import vn.com.osstech.uaa.model.entity.Role;
import vn.com.osstech.uaa.model.entity.RolePermission;
import vn.com.osstech.uaa.model.reponse.RoleReponse;
import vn.com.osstech.uaa.model.request.PermissionRequest;
import vn.com.osstech.uaa.model.request.RoleRequest;

/**
 * @author : Truong Duong
 * @since : 06/03/2020, Fri.
 **/
public interface RoleMapper {

  RoleReponse toRoleDTO(Role role);

  List<RoleReponse> toListRoleDTO(List<Role> roles);

  Role toRoleEntity(Role role, RoleRequest roleRequest);

  List<RolePermission> toListRolePermissionEntity(Role role, List<PermissionRequest> permissions);

}
