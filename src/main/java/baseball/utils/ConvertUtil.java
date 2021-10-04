package baseball.utils;

import java.util.LinkedHashSet;
import java.util.Set;

public class ConvertUtil {

  public static Set<Integer> convertStringToSet(String value) {
    Set<Integer> set = new LinkedHashSet<>();
    for (char numberValue : value.toCharArray()) {
      set.add(numberValue - '0');
    }
    return set;
  }
}
