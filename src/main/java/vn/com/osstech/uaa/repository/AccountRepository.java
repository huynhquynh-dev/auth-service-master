package vn.com.osstech.uaa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.com.osstech.uaa.model.entity.Account;

/**
 * @author Truong Duong on 23/02/2020
 */

@Repository
@Transactional
public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findByUsername(String username);

}
