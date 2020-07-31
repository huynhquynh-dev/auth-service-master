package vn.com.osstech.uaa.model.mapper.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import vn.com.osstech.uaa.model.entity.Account;
import vn.com.osstech.uaa.model.entity.AccountRole;
import vn.com.osstech.uaa.model.entity.AccountRoleId;
import vn.com.osstech.uaa.model.entity.Role;
import vn.com.osstech.uaa.model.mapper.AccountMapper;
import vn.com.osstech.uaa.model.reponse.AccountReponse;
import vn.com.osstech.uaa.model.request.RoleRequest;
import vn.com.osstech.uaa.model.request.UserRequest;

/**
 * @author : Truong Duong
 * @since : 03/03/2020, Tue.
 **/
@Component
public class AccountMapperImpl implements AccountMapper {

  @Override
  public AccountReponse toAccountDTO(Account account) {
    if (account == null) {
      return null;
    }

    AccountReponse accountReponse = new AccountReponse();
    // Account
    accountReponse.setId(account.getId());
    accountReponse.setUsername(account.getUsername());
    accountReponse.setFullName(account.getFullName());
    accountReponse.setEmail(account.getEmail());
    accountReponse.setAccountNonExpired(account.isAccountNonExpired());
    accountReponse.setAccountNonLocked(account.isAccountNonLocked());
    accountReponse.setCredentialsNonExpired(account.isCredentialsNonExpired());
    accountReponse.setEnabled(account.isEnabled());

    // Role
    List<AccountRole> roles = account.getRoles();
    if (roles != null) {
      List<String> listRole = new ArrayList<>();
      long roleId = 0;
      for (AccountRole accountRole : roles) {
        roleId = accountRole.getRole().getId();
        listRole.add(accountRole.getRole().getName());
      }
      accountReponse.setRoleId(roleId);
      accountReponse.setRoles(listRole);
    }

    return accountReponse;
  }

  @Override
  public List<AccountReponse> toListAccountDTO(List<Account> accounts) {
    if (accounts == null) {
      return null;
    }

    List<AccountReponse> accountReponses = new ArrayList<>();
    for (Account account : accounts) {
      accountReponses.add(toAccountDTO(account));
    }

    return accountReponses;
  }

  @Override
  public Account toAccountEntity(Account account, UserRequest userRequest) {
    if (userRequest == null) {
      return null;
    }

    if (userRequest.getId() > 0) {
      account.setId(userRequest.getId());
    }
    account.setUsername(userRequest.getUsername());
    account.setFullName(userRequest.getFullName());
    account.setEmail(userRequest.getEmail());
    account.setEnabled(userRequest.isEnabled());

    return account;
  }

  @Override
  public List<AccountRole> toListAccountRoleEntity(Account account, List<RoleRequest> roles) {
    if (roles == null) {
      return null;
    }

    List<AccountRole> listItem = new ArrayList<>();

    for(RoleRequest rolePermission : roles){
      AccountRole accountRole = new AccountRole();

      AccountRoleId accountRoleId = new AccountRoleId();
      accountRoleId.setAccountId(account.getId());
      accountRoleId.setRoleId(rolePermission.getId());
      accountRole.setId(accountRoleId);
      // Account
      accountRole.setAccount(account);
      // Role
      Role role = new Role();
      role.setId(rolePermission.getId());
      accountRole.setRole(role);
      accountRole.setEnabled(rolePermission.isEnabled());

      listItem.add(accountRole);
    }

    return listItem;
  }

}
