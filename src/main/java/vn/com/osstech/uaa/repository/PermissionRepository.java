package vn.com.osstech.uaa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.com.osstech.uaa.model.entity.Permission;

/**
 * @author : Truong Duong
 * @since : 06/03/2020, Fri.
 **/
@Repository
@Transactional
public interface PermissionRepository extends JpaRepository<Permission, Long> {

}
