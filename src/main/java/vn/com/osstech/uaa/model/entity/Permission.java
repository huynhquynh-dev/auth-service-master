package vn.com.osstech.uaa.model.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Truong Duong on 23/02/2020
 */

@Getter
@Setter
@Entity
@Table(name = "permission")
public class Permission extends BaseIdEntity implements Serializable {

  @Column(name = "name", nullable = false, unique = true)
  private String name;

  @Column(name = "description")
  private String description;

  @Column(name = "enabled")
  private boolean enabled;

}