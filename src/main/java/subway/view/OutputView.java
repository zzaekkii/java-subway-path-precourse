package subway.view;

import subway.domain.PathResult;
import subway.domain.Station;

public class OutputView {

    private static final String RESULT_PREFIX = "[INFO] ";

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void printMainCommandRequest() {
        System.out.println("## 메인 화면\n"
                + "1. 경로 조회\n"
                + "Q. 종료\n"
                + "\n"
                + "## 원하는 기능을 선택하세요.");
    }

    public void printFindCommandRequest() {
        System.out.println("\n"
                + "## 경로 기준\n"
                + "1. 최단 거리\n"
                + "2. 최소 시간\n"
                + "B. 돌아가기\n"
                + "\n"
                + "## 원하는 기능을 선택하세요.");
    }

    public void printDepartureStationRequest() {
        System.out.println("\n## 출발역을 입력하세요.");
    }

    public void printArrivalStationRequest() {
        System.out.println("\n## 도착역을 입력하세요.");
    }

    public void printResult(PathResult result) {
        System.out.println("\n## 조회 결과");
        System.out.println(RESULT_PREFIX + "---");
        System.out.println(RESULT_PREFIX + "총 거리: " + result.getTotalKilometers() + "Km");
        System.out.println(RESULT_PREFIX + "총 소요 시간: " + result.getTotalMinutes() + "분");
        System.out.println(RESULT_PREFIX + "---");
        for (Station station : result.getStations()) {
            System.out.println(RESULT_PREFIX + station.getName());
        }
        System.out.println();
    }
}
