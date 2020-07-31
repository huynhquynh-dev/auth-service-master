package vn.com.osstech.uaa.model.request;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author : Truong Duong
 * @since : 10/03/2020, Tue.
 **/
@Getter
@Setter
@ToString
public class UserRequest {

  // User
  private long id;
  private String fullName;
  private String username;
  private String email;
  private boolean enabled;

  // Role
  private List<RoleRequest> roles;

}