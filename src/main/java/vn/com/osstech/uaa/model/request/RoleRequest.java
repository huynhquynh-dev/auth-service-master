package vn.com.osstech.uaa.model.request;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * @author : Truong Duong
 * @since : 06/03/2020, Fri.
 **/
@Getter
@Setter
public class RoleRequest {

  // Role
  private long id;
  private String name;
  private String description;
  private boolean enabled;

  // Permission
  private List<PermissionRequest> permissions;

}
