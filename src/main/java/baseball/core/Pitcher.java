package baseball.core;

import baseball.utils.ConvertUtil;
import baseball.utils.MessageUtil;
import baseball.utils.ValidateUtil;
import java.util.Set;
import nextstep.utils.Console;

public class Pitcher {

  public Set<Integer> pitch() {
    String pitchValue;
    do {
      MessageUtil.guideMessage("숫자를 입력해주세요 : ");
      pitchValue = Console.readLine();
    } while (!ValidateUtil.isValidInput(pitchValue));

    return ConvertUtil.convertStringToSet(pitchValue);
  }
}
