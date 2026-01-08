package subway.domain;

import java.util.Map;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;

public class Subway {
    private final Map<PathType, DijkstraShortestPath> shortPaths;

    public Subway(Map<PathType, DijkstraShortestPath> shortPaths) {
        this.shortPaths = shortPaths;
    }
}
