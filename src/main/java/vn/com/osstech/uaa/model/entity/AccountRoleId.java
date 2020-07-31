package vn.com.osstech.uaa.model.entity;

import java.io.Serializable;
import javax.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

/**
 * @author : Truong Duong
 * @since : 11/03/2020, Wed.
 **/
@Embeddable
@Getter
@Setter
public class AccountRoleId implements Serializable {

  private Long accountId;
  private Long roleId;

}
