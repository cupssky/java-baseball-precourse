package baseball.core;

import baseball.constants.Const;
import java.util.LinkedHashSet;
import java.util.Set;
import nextstep.utils.Randoms;

public class Hitter {

  private Set<Integer> hitterSwing;

  public Hitter() {
    hitterSwing = new LinkedHashSet<>();
  }

  public Set<Integer> swing() {
    while (hitterSwing.size() < Const.MAX_NUMBER_SIZE) {
      int number = Randoms.pickNumberInRange(1, 9);
      hitterSwing.add(number);
    }
    return hitterSwing;
  }

}
