package subway.controller;

import subway.domain.Subway;
import subway.view.InputView;
import subway.view.OutputView;

public class SubwayController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Subway subway;

    public SubwayController(InputView inputView, OutputView outputView, Subway subway) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.subway = subway;
    }

    public void run() {

    }
}
