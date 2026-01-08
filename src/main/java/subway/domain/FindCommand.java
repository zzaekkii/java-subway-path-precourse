package subway.domain;

import subway.exception.ErrorMessage;

public enum FindCommand {
    SHORT_DISTANCE("1"),
    SHORT_TIME("2"),
    BACK("B");

    private final String value;

    FindCommand(String value) {
        this.value = value;
    }

    public static FindCommand fromString(String value) {
        for (FindCommand command : FindCommand.values()) {
            if (command.value.equals(value)) {
                return command;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.INVALID_COMMAND.getMessage());
    }
}
