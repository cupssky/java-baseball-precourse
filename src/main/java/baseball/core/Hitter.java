package baseball.core;

import baseball.constants.Const;
import java.util.LinkedHashSet;
import java.util.Set;
import nextstep.utils.Randoms;

public class Hitter {

  private Set<Integer> swingInfo;

  public Hitter() {
    swingInfo = new LinkedHashSet<>();
  }

  public Set<Integer> swing() {
    while (swingInfo.size() < Const.MAX_NUMBER_SIZE) {
      int number = Randoms.pickNumberInRange(1, 9);
      swingInfo.add(number);
    }
    return swingInfo;
  }

}
