package vn.com.osstech.uaa.model.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Truong Duong on 23/02/2020
 */

@Getter
@Setter
@Entity
@Table(name = "account_role")
public class AccountRole implements Serializable {

  @EmbeddedId
  private AccountRoleId id;

  @ManyToOne
  @JoinColumn(name = "account_id")
  @MapsId("accountId")
  private Account account;

  @ManyToOne
  @JoinColumn(name = "role_id")
  @MapsId("roleId")
  private Role role;

  @Column(name = "enabled")
  private boolean enabled;

}
