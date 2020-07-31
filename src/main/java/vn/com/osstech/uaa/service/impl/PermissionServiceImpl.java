package vn.com.osstech.uaa.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.osstech.uaa.model.entity.Permission;
import vn.com.osstech.uaa.model.mapper.PermissionMapper;
import vn.com.osstech.uaa.model.request.PermissionRequest;
import vn.com.osstech.uaa.repository.PermissionRepository;
import vn.com.osstech.uaa.service.PermissionService;

/**
 * @author : Truong Duong
 * @since : 06/03/2020, Fri.
 **/
@Service
public class PermissionServiceImpl implements PermissionService {

  @Autowired
  PermissionRepository permissionRepository;

  @Autowired
  PermissionMapper permissionMapper;

  @Override
  public List<Permission> findByAll() {
    return permissionRepository.findAll();
  }

  @Override
  public Permission findById(long accountId) {
    Optional<Permission> optional = permissionRepository.findById(accountId);
    return optional.isPresent() ? optional.get() : null;
  }

  @Override
  public Permission save(PermissionRequest permissionRequest) {
    Permission permission = null;
    if (permissionRequest.getId() == 0) {
      permission = new Permission();
    } else {
      Optional<Permission> optional = permissionRepository.findById(permissionRequest.getId());
      if (optional.isPresent()) {
        permission = optional.get();
      }
    }

    permissionMapper.toPermissionEntity(permission, permissionRequest);

    permissionRepository.save(permission);

    return permission;
  }

  @Override
  public boolean delete(long permissionId) {
    Optional<Permission> optional = permissionRepository.findById(permissionId);
    if (optional.isPresent()) {
      Permission permission = optional.get();
      permissionRepository.delete(permission);
      return true;
    }
    return false;
  }

}
