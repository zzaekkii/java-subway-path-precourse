package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class SubwayRepository {
    private static final List<Subway> subways = new ArrayList<>();

    public static Subway subway() {
        return subways.get(0);
    }

    public static void addSubway(Subway subway) {
        subways.add(subway);
    }

}
