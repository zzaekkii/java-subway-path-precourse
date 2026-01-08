package subway.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import subway.exception.ErrorMessage;

public class PathRepository {
    private static final List<Path> paths = new ArrayList<>();

    public static List<Path> paths() {
        return Collections.unmodifiableList(paths);
    }

    public static void addPath(Path path) {
        paths.add(path);
    }

    public static Path getPath(Station a, Station b) {
        Set<Station> stations = new HashSet<>(Arrays.asList(a, b));
        for (Path path : paths) {
            if (path.getStations().equals(stations)) {
                return path;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.PATH_NOT_FOUND.getMessage());
    }
}
