package baseball.utils;

import baseball.enums.ResultCode;

public class MessageUtil {

    public static void guideMessage(String message) {
        System.out.println(message);
    }

    public static void errorMessage(ResultCode resultCode) {
        System.out.println(resultCode.getMessage());
    }

    public static void resultMessage(int strike, int ball) {
        hintMessage(strike, ball);
        if (strike == 3) {
            closeMessage();
        }
    }

    private static void hintMessage(int strike, int ball) {
        StringBuilder sb = new StringBuilder();
        if (strike > 0) sb.append(strike).append("스트라이크 ");
        if (ball > 0) sb.append(ball).append("볼");
        if (strike == 0 && ball == 0) sb.append("낫싱");

        System.out.println(sb);
    }

    private static void closeMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
    }
}
