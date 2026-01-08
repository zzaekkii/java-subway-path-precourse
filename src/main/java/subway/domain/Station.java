package subway.domain;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Station station = (Station) o;
        return Objects.equals(line, station.line) && Objects.equals(name, station.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(line, name);
    }
}
