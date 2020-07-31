package vn.com.osstech.uaa.model.reponse;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * @author : Truong Duong
 * @since : 06/03/2020, Fri.
 **/
@Getter
@Setter
public class RoleReponse {

  // Role
  private Long id;
  private String name;
  private String description;
  private boolean enabled;

  // Permission
  private List<PermissionReponse> permissions;

  public RoleReponse() {
  }

  public RoleReponse(Long id, String name, String description, boolean enabled) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.enabled = enabled;
  }

}
