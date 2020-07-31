package vn.com.osstech.uaa.service;

import java.util.List;
import vn.com.osstech.uaa.model.entity.Permission;
import vn.com.osstech.uaa.model.request.PermissionRequest;

/**
 * @author : Truong Duong
 * @since : 06/03/2020, Fri.
 **/
public interface PermissionService {

  List<Permission> findByAll();

  Permission findById(long permissionId);

  Permission save(PermissionRequest permissionRequest);

  boolean delete(long permissionId);

}
