package vn.com.osstech.uaa.model.reponse;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * @author : Truong Duong
 * @since : 28/02/2020, Fri.
 **/
@Getter
@Setter
public class AccountReponse {

  // Account
  private long id;
  private String fullName;
  private String username;
  private String password;
  private String email;
  private boolean enabled;
  private boolean accountNonLocked;
  private boolean accountNonExpired;
  private boolean credentialsNonExpired;

  // Role
  private long roleId;
  private List<String> roles;

}
