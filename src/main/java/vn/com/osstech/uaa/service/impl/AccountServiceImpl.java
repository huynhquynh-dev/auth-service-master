package vn.com.osstech.uaa.service.impl;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import vn.com.osstech.uaa.common.PasswordUtil;
import vn.com.osstech.uaa.model.entity.Account;
import vn.com.osstech.uaa.model.entity.AccountRole;
import vn.com.osstech.uaa.model.mapper.AccountMapper;
import vn.com.osstech.uaa.model.request.UserRequest;
import vn.com.osstech.uaa.repository.AccountRepository;
import vn.com.osstech.uaa.repository.AccountRoleRepository;
import vn.com.osstech.uaa.service.AccountRoleService;
import vn.com.osstech.uaa.service.AccountService;

/**
 * @author : Truong Duong
 * @since : 03/03/2020, Tue.
 **/
@Service
public class AccountServiceImpl implements AccountService {

  @Autowired
  AccountRepository accountRepository;

  @Autowired
  AccountMapper accountMapper;

  @Autowired
  AccountRoleRepository accountRoleRepository;

  @Autowired
  private JavaMailSender javaMailSender;

  @Autowired
  private PasswordEncoder userPasswordEncoder;

  @Autowired
  private SpringTemplateEngine templateEngine;

  @Autowired
  PasswordUtil passwordUtil;

  @Override
  public List<Account> findByAll() {
    return accountRepository.findAll();
  }

  @Override
  public Account findById(long accountId) {
    Optional<Account> optional = accountRepository.findById(accountId);
    return optional.isPresent() ? optional.get() : null;
  }

  @Override
  public Account save(UserRequest userRequest) {
    Account account = null;
    String password = null;
    String passwordEncode = null;
    if (userRequest.getId() == 0) {
      account = new Account();
      password = passwordUtil.alphaNumericString(8);
      passwordEncode = userPasswordEncoder.encode(password);
      account.setPassword(passwordEncode);
    } else {
      Optional<Account> optional = accountRepository.findById(userRequest.getId());
      if (optional.isPresent()) {
        account = optional.get();
      }
    }

    accountMapper.toAccountEntity(account, userRequest);

    accountRepository.save(account);

    List<AccountRole> accountRoles = accountMapper.toListAccountRoleEntity(account, userRequest.getRoles());

    accountRoleRepository.saveAll(accountRoles);

    if (userRequest.getId() == 0) {
      try {
        Map model = new HashMap();
        model.put("accountName", account.getFullName());
        model.put("accountUsername", account.getUsername());
        model.put("accountPassword", password);

        Context context = new Context();
        context.setVariables(model);
        String html = templateEngine.process("mail_template_account", context);

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,
            MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
            StandardCharsets.UTF_8.name());
        helper.setTo(account.getEmail());
        helper.setSubject("API_MAIL");
        helper.setText(html, true);
        javaMailSender.send(message);
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }

    return account;
  }

  @Override
  public boolean delete(long accountId) {
    Optional<Account> optional = accountRepository.findById(accountId);
    if (optional.isPresent()) {
      Account account = optional.get();
      if (account.isSystem()) {
        return false;
      } else {
        accountRepository.delete(account);
        return true;
      }
    }
    return false;
  }

}
