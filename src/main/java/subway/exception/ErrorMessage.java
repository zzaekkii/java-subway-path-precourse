package subway.exception;

public enum ErrorMessage {
    EMPTY_INPUT("빈 값을 입력할 수 없습니다."),
    INVALID_FORMAT("잘못된 형식을 입력하였습니다."),
    NOT_POSITIVE_NUMBER("양수를 입력해야 합니다."),
    ETC("작업 중 오류가 발생했습니다.");


    private static final String PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = PREFIX + message;
    }

    public String getMessage() {
        return message;
    }
}
