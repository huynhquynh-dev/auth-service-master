package vn.com.osstech.uaa.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.osstech.uaa.model.entity.Role;
import vn.com.osstech.uaa.model.reponse.PermissionReponse;
import vn.com.osstech.uaa.repository.RolePermissionRepository;
import vn.com.osstech.uaa.service.RolePermissionService;

/**
 * @author : Truong Duong
 * @since : 14/03/2020, Sat.
 **/
@Service
public class RolePermissionServiceImpl implements RolePermissionService {

  @Autowired
  RolePermissionRepository rolePermissionRepository;

  @Override
  public List<PermissionReponse> findByRole(long roleId) {
    Role role = new Role();
    role.setId(roleId);
    return rolePermissionRepository.findByRole(role);
  }

}
