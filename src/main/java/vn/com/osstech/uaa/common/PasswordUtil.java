package vn.com.osstech.uaa.common;

import java.util.Random;
import org.springframework.stereotype.Component;

/**
 * @author : Truong Duong
 * @since : 12/03/2020, Thu.
 **/
@Component
public class PasswordUtil {

  public String alphaNumericString(int len) {
    String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    Random rnd = new Random();

    StringBuilder sb = new StringBuilder(len);
    for (int i = 0; i < len; i++) {
      sb.append(AB.charAt(rnd.nextInt(AB.length())));
    }
    return sb.toString();
  }

}
