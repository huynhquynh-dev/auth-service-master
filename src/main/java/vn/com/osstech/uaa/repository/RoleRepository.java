package vn.com.osstech.uaa.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.com.osstech.uaa.model.entity.Role;
import vn.com.osstech.uaa.model.reponse.RoleReponse;

/**
 * @author : Truong Duong
 * @since : 06/03/2020, Fri.
 **/
@Repository
@Transactional
public interface RoleRepository extends JpaRepository<Role, Long> {

//  // new vn.com.osstech.uaa.model.reponse.RoleReponse(d.name, e.name, e.email, e.address)
//  @Query("select * from Role r  ")
//  List<RoleReponse> fetchEmpDeptDataLeftJoin();

}