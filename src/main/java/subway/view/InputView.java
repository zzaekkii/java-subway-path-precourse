package subway.view;

import java.util.Scanner;
import subway.exception.ErrorMessage;

public class InputView {

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
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
