package subway.view;

import java.util.Scanner;
import subway.domain.FindCommand;
import subway.domain.MainCommand;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.exception.ErrorMessage;

public class InputView {

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public MainCommand readMainCommand() {
        String input = readAndValidate();
        validateCommandFormat(input);
        return MainCommand.fromString(input);
    }

    public FindCommand readFindCommand() {
        String input = readAndValidate();
        validateCommandFormat(input);
        return FindCommand.fromString(input);
    }

    public Station readStation() {
        String input = readAndValidate();
        return StationRepository.getFromName(input);
    }

    private static void validateCommandFormat(String input) {
        if (!input.matches("^[1-9A-Q]")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_FORMAT.getMessage());
        }
    }

    private String readAndValidate() {
        String input = readLine();

        nullCheck(input);

        input = input.trim();
        return input;
    }

    private String readLine() {
        return scanner.nextLine();
    }

    private static void nullCheck(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.getMessage());
        }
    }
}
