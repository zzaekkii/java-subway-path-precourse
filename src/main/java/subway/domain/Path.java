package subway.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Path {
    private final Set<Station> stations;
    private final int kiloMeters;
    private final int minutes;

    public Path(Set<Station> stations, int kiloMeters, int minutes) {
        this.stations = stations;
        this.kiloMeters = kiloMeters;
        this.minutes = minutes;
    }

    public Set<Station> getStations() {
        return stations;
    }

    public List<Station> getStationsAsList() {
        return new ArrayList<>(stations);
    }

    public int getKiloMeters() {
        return kiloMeters;
    }

    public int getMinutes() {
        return minutes;
    }
}
