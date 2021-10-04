package baseball.enums;

public enum ResultCode {

    NOT_NUMBER("[ERROR] 문자로 입력하셨습니다. 숫자로 입력해주세요."),
    NOT_VALID_NUMBER("[ERROR] 서로 다른 3자리의 숫자로 정확하게 입력해주세요."),
    NOT_VALID_RESTART_TYPE("[ERROR] 재시작 버튼은 1(시작), 2(종료)로 구성되어있습니다. 다시입력해주세요.");

    private String message;

    ResultCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
