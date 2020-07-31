package vn.com.osstech.uaa.model.mapper;

import java.util.List;
import vn.com.osstech.uaa.model.entity.Account;
import vn.com.osstech.uaa.model.entity.AccountRole;
import vn.com.osstech.uaa.model.reponse.AccountReponse;
import vn.com.osstech.uaa.model.request.RoleRequest;
import vn.com.osstech.uaa.model.request.UserRequest;

/**
 * @author : Truong Duong
 * @since : 03/03/2020, Tue.
 **/
public interface AccountMapper {

  AccountReponse toAccountDTO(Account account);

  List<AccountReponse> toListAccountDTO(List<Account> accounts);

  Account toAccountEntity(Account account, UserRequest userRequest);

  List<AccountRole> toListAccountRoleEntity(Account account, List<RoleRequest> roles);

}