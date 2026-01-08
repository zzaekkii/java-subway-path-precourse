package subway.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.exception.ErrorMessage;

public class Subway {
    private final Map<PathType, DijkstraShortestPath> shortPaths;

    public Subway() {
        Map<PathType, DijkstraShortestPath> paths = new HashMap<>();

        paths.put(PathType.SHORT_DISTANCE, initializePathsByDistance());
        paths.put(PathType.SHORT_TIME, initializePathsByTime());
        this.shortPaths = paths;
    }

    public PathResult findPath(PathType pathType, Station start, Station end) {
        if (start.equals(end)) {
            throw new IllegalArgumentException(ErrorMessage.SAME_STATIONS.getMessage());
        }

        shortPaths.get(pathType);

    }

    private DijkstraShortestPath initializePathsByDistance() {
        WeightedMultigraph<Station, DefaultWeightedEdge> paths = new WeightedMultigraph(DefaultWeightedEdge.class);

        for (Station station : StationRepository.stations()) {
            paths.addVertex(station);
        }

        for (Path path : PathRepository.paths()) {
            List<Station> stations = path.getStationsAsList();
            paths.setEdgeWeight(paths.addEdge(stations.get(0), stations.get(1)), path.getKiloMeters());
        }

        return new DijkstraShortestPath(paths);
    }

    private DijkstraShortestPath initializePathsByTime() {

        WeightedMultigraph<Station, DefaultWeightedEdge> paths = new WeightedMultigraph(DefaultWeightedEdge.class);

        for (Station station : StationRepository.stations()) {
            paths.addVertex(station);
        }

        for (Path path : PathRepository.paths()) {
            List<Station> stations = path.getStationsAsList();
            paths.setEdgeWeight(paths.addEdge(stations.get(0), stations.get(1)), path.getMinutes());
        }

        return new DijkstraShortestPath(paths);
    }
}
