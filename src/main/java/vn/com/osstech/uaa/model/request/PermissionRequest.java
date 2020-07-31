package vn.com.osstech.uaa.model.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author : Truong Duong
 * @since : 14/03/2020, Sat.
 **/
@Getter
@Setter
@ToString
public class PermissionRequest {

  private Long id;
  private String name;
  private String description;
  private boolean enabled;

}