package subway.domain;

public final class Station {
    private final Line line;
    private final String name;

    public Station(Line line, String name) {
        this.line = line;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
}
