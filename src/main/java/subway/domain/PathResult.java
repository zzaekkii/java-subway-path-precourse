package subway.domain;

import java.util.List;

public class PathResult {
    private final int totalKilometers;
    private final int totalMinutes;
    private final List<Station> stations;

    public PathResult(int totalKilometers, int totalMinutes, List<Station> stations) {
        this.totalKilometers = totalKilometers;
        this.totalMinutes = totalMinutes;
        this.stations = stations;
    }

    public int getTotalKilometers() {
        return totalKilometers;
    }

    public int getTotalMinutes() {
        return totalMinutes;
    }

    public List<Station> getStations() {
        return stations;
    }
}
