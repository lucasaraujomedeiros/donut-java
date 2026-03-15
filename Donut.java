import java.util.ArrayList;

public class Donut {
    public ArrayList<double[]> points;
    double circleRadius;
    double revolutionRadius;

    // theta -> circle angle interval, alpha -> revolution angle interval
    double theta;
    double alpha;
    

    public Donut(double circleRadius, double revolutionRadius,
                 double theta, double alpha) {
        double rotationAngle = 0;
        

        this.points = new ArrayList<double[]>();
        double x = 0;
        double y = 0;
        while (rotationAngle < 2* Math.PI) {
            points.add(new double[] {x,y,0});
            x = circleRadius * Math.cos(rotationAngle);
            y = circleRadius * Math.sin(rotationAngle);
            rotationAngle += theta;
        }
        
        double revolutionAngle = alpha;
        while (revolutionAngle < 2 * Math.PI) {
            double cos = Math.cos(revolutionAngle);
            double negSin = -1* Math.sin(revolutionAngle);

            for (double[] point : points) {
                double z = point[1] * negSin;
                x = point[0] * cos;
                points.add(new double[] {x, point[1], z});

            }

            revolutionAngle += alpha;
        }
        

    }

}
