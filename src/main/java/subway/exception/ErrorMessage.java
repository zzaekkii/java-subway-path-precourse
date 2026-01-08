package subway.exception;

public enum ErrorMessage {
    EMPTY_INPUT("빈 값을 입력할 수 없습니다."),
    INVALID_FORMAT("잘못된 형식을 입력하였습니다."),
    INVALID_COMMAND("잘못된 입력입니다."),
    LINE_NOT_FOUND("존재하지 않는 노선입니다."),
    STATION_NOT_FOUND("존재하지 않는 역입니다."),
    PATH_NOT_FOUND("두 역 사이의 경로가 존재하지 않습니다."),
    SAME_STATIONS("출발역과 도착역이 동일합니다."),
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
