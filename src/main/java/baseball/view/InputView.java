package baseball.view;

import nextstep.utils.Console;
import baseball.config.GameMessage;

public class InputView {

    /**
     * Player의 랜덤 숫자 입력값 받아오기
     * @return String
     */
    public String inputValue() {
        System.out.print(GameMessage.INPUT_MESSAGE);
        return Console.readLine();
    }

    /**
     * 재시작 질문에 대한 답변 입력값 받아오기
     * @return String
     */
    public String inputRestartQuestionAsk() {
        System.out.println(GameMessage.GAME_RESTART_QUESTION_MESSAGE);
        return Console.readLine();
    }
}
