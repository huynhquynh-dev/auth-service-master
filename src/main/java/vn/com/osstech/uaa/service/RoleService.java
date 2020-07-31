package vn.com.osstech.uaa.service;

import java.util.List;
import vn.com.osstech.uaa.model.entity.Role;
import vn.com.osstech.uaa.model.request.RoleRequest;

/**
 * @author : Truong Duong
 * @since : 06/03/2020, Fri.
 **/
public interface RoleService {

  List<Role> findByAll();

  Role findById(long roleId);

  Role save(RoleRequest roleRequest);

  boolean delete(long roleId);

}
