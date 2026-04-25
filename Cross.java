import java.util.ArrayList;;

public class Cross {
    public ArrayList<double[]> points = new ArrayList<>();

    public Cross() {
        points.add(new double[]{0,0,0});
        points.add(new double[]{0,5,0});
        points.add(new double[]{0,-5,0});
        points.add(new double[]{5,0,0});
        points.add(new double[]{-5,0,0});
        points.add(new double[]{-2.5, 2.5, 0});
        points.add(new double[]{2.5, 2.5, 0});
        points.add(new double[]{-2.5, -2.5, 0});
        points.add(new double[]{2.5, -2.5, 0});

    }
}

