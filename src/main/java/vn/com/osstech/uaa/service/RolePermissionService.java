package vn.com.osstech.uaa.service;

import java.util.List;
import vn.com.osstech.uaa.model.reponse.PermissionReponse;

/**
 * @author : Truong Duong
 * @since : 14/03/2020, Sat.
 **/
public interface RolePermissionService {

  List<PermissionReponse> findByRole(long roleId);

}
