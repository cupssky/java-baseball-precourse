package baseball.enums;

public enum ResultCode {

    NOT_NUMBER("[ERROR] 문자로 입력하셨습니다. 숫자로 입력해주세요."),
    NOT_VALID_NUMBER("[ERROR] 서로 다른 3자리의 숫자로 정확하게 입력해주세요.");

    private String message;

    ResultCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
