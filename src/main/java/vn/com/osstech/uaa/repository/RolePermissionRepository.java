package vn.com.osstech.uaa.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.com.osstech.uaa.model.entity.Role;
import vn.com.osstech.uaa.model.entity.RolePermission;
import vn.com.osstech.uaa.model.reponse.PermissionReponse;

/**
 * @author : Truong Duong
 * @since : 14/03/2020, Sat.
 **/
@Repository
@Transactional
public interface RolePermissionRepository extends JpaRepository<RolePermission, Long> {

  @Query("SELECT new vn.com.osstech.uaa.model.reponse.PermissionReponse(p.id, p.name, p.description, (CASE WHEN r.id is not null THEN r.enabled ELSE false END)) FROM Permission p LEFT JOIN RolePermission r ON r.permission.id = p.id AND r.role = :role")
  List<PermissionReponse> findByRole(@Param("role") Role role);

}
