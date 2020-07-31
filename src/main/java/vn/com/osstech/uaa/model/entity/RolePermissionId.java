package vn.com.osstech.uaa.model.entity;

import java.io.Serializable;
import javax.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

/**
 * @author : Truong Duong
 * @since : 14/03/2020, Sat.
 **/
@Embeddable
@Getter
@Setter
public class RolePermissionId implements Serializable {

  private Long roleId;
  private Long permissionId;

}
