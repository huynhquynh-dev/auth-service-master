package vn.com.osstech.uaa.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.com.osstech.uaa.model.entity.Account;
import vn.com.osstech.uaa.model.entity.AccountRole;
import vn.com.osstech.uaa.model.entity.Role;
import vn.com.osstech.uaa.model.reponse.RoleReponse;

/**
 * @author Truong Duong on 23/02/2020
 */

@Repository
@Transactional
public interface AccountRoleRepository extends JpaRepository<AccountRole, Long> {

    @Query("SELECT new vn.com.osstech.uaa.model.reponse.RoleReponse(r.id, r.name, r.description, (CASE WHEN a.id is not null THEN a.enabled ELSE false END)) FROM Role r LEFT JOIN AccountRole a ON a.role.id = r.id AND a.account = :account")
    List<RoleReponse> findByAccount(@Param("account") Account account);

    void deleteByAccount(@Param("account") Account account);

    AccountRole findByAccountAndRole(@Param("account") Account account, @Param("role") Role role);

}
