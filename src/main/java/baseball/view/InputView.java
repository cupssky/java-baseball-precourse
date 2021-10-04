package baseball.view;

import nextstep.utils.Console;
import baseball.config.GameMessage;

public class InputView {

    public static final String INPUT_MESSAGE = GameMessage.INPUT_MESSAGE;

    /**
     * 입력값 받아오기
     * @return String
     */
    public String inputValue() {
        System.out.print(INPUT_MESSAGE);
        return Console.readLine();
    }
}
