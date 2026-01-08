package subway.domain;

import subway.exception.ErrorMessage;

public enum MainCommand {
    FIND_PATH("1"),
    QUIT("Q");

    private final String value;

    MainCommand(String value) {
        this.value = value;
    }

    public static MainCommand fromString(String value) {
        for (MainCommand command : MainCommand.values()) {
            if (command.value.equals(value)) {
                return command;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.INVALID_COMMAND.getMessage());
    }
}
