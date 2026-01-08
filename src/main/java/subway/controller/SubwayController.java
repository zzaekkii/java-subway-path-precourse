package subway.controller;

import static subway.domain.MainCommand.FIND_PATH;
import static subway.domain.MainCommand.QUIT;

import java.util.Arrays;
import java.util.HashSet;
import subway.domain.FindCommand;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.MainCommand;
import subway.domain.Path;
import subway.domain.PathRepository;
import subway.domain.PathType;
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
        initializeSubway();
        while (true) {
            MainCommand mainCommand = getMainCommand();
            if (mainCommand.equals(FIND_PATH)) {
                findPath();
            }

            if (mainCommand.equals(QUIT)) {
                break;
            }
        }
    }

    private void findPath() {
        while (true) {
            try {
                FindCommand findCommand = getFindCommand();
                if (findCommand.equals(FindCommand.BACK)) {
                    return;
                }

                Station start = getDepartureStation();
                Station end = getArrivalStation();
                if (findCommand.equals(FindCommand.SHORT_DISTANCE)) {
                    outputView.printResult(SubwayRepository.subway().findPath(PathType.SHORT_DISTANCE, start, end));
                }

                if (findCommand.equals(FindCommand.SHORT_TIME)) {
                    outputView.printResult(SubwayRepository.subway().findPath(PathType.SHORT_TIME, start, end));
                }
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private Station getDepartureStation() {
        while (true) {
            outputView.printDepartureStationRequest();
            try {
                return inputView.readStation();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private Station getArrivalStation() {
        while (true) {
            outputView.printArrivalStationRequest();
            try {
                return inputView.readStation();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private MainCommand getMainCommand() {
        while (true) {
            outputView.printMainCommandRequest();
            try {
                return inputView.readMainCommand();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }


    private FindCommand getFindCommand() {
        while (true) {
            outputView.printFindCommandRequest();
            try {
                return inputView.readFindCommand();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void initializeSubway() {
        initializeLines();
        initializeStations();
        initializePaths();
        SubwayRepository.addSubway(new Subway());
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
