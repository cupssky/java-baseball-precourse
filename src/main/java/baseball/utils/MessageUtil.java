package baseball.utils;

import baseball.enums.ResultCode;

public class MessageUtil {

  public static void guideMessage(String message) {
    System.out.println(message);
  }

  public static void errorMessage(ResultCode resultCode) {
    System.out.println(resultCode.getMessage());
  }
}
