package subway.controller;

import java.util.Arrays;
import java.util.HashSet;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Path;
import subway.domain.PathRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.domain.Subway;
import subway.domain.SubwayRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class SubwayController {
    private final InputView inputView;
    private final OutputView outputView;

    public SubwayController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Subway subway = initializeSubway();

    }


    private Subway initializeSubway() {
        initializeLines();
        initializeStations();
        initializePaths();
        SubwayRepository.addSubway(new Subway());
        return SubwayRepository.subway();
    }

    private void initializePaths() {
        try {
            PathRepository.addPath(new Path(new HashSet<>(
                    Arrays.asList(StationRepository.getFromName("교대역"), StationRepository.getFromName("강남역"))), 2, 3));
            PathRepository.addPath(new Path(new HashSet<>(
                    Arrays.asList(StationRepository.getFromName("강남역"), StationRepository.getFromName("역삼역"))), 2, 3));
            PathRepository.addPath(new Path(new HashSet<>(
                    Arrays.asList(StationRepository.getFromName("교대역"), StationRepository.getFromName("남부터미널역"))), 3,
                    2));
            PathRepository.addPath(new Path(new HashSet<>(
                    Arrays.asList(StationRepository.getFromName("남부터미널역"), StationRepository.getFromName("양재역"))), 6,
                    5));
            PathRepository.addPath(new Path(new HashSet<>(
                    Arrays.asList(StationRepository.getFromName("양재역"), StationRepository.getFromName("매봉역"))), 1, 1));
            PathRepository.addPath(new Path(new HashSet<>(
                    Arrays.asList(StationRepository.getFromName("강남역"), StationRepository.getFromName("양재역"))), 2, 8));
            PathRepository.addPath(new Path(new HashSet<>(
                    Arrays.asList(StationRepository.getFromName("양재역"), StationRepository.getFromName("양재시민의숲역"))), 10,
                    3));
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
        }
    }

    private void initializeStations() {
        try {
            for (String stationFor2 : Arrays.asList("교대역", "강남역", "역삼역")) {
                StationRepository.addStation(new Station(LineRepository.getLineFromName("2호선"), stationFor2));
            }
            for (String stationFor3 : Arrays.asList("교대역", "남부터미널", "양재역", "매봉역")) {
                StationRepository.addStation(new Station(LineRepository.getLineFromName("3호선"), stationFor3));
            }
            for (String stationForNew : Arrays.asList("강남역", "양재역", "양재시민의숲역")) {
                StationRepository.addStation(new Station(LineRepository.getLineFromName("신분당선"), stationForNew));
            }
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
        }
    }

    private void initializeLines() {
        for (String lineName : Arrays.asList("2호선", "3호선", "신분당선")) {
            LineRepository.addLine(new Line(lineName));
        }
    }
}
