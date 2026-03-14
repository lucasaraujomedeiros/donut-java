import java.util.ArrayList;

public class Donut {
    public ArrayList<double[]> points;
    double circleRadius;
    double revolutionRadius;

    // theta -> circle angle interval, alpha -> revolution angle interval
    double theta;
    double alpha;
    

    public Donut(double circleRadius, double revolutionRadius,
                double[] center, double theta, double alpha) {
        double rotationAngle = theta;
        double[] vector = center;

        this.points = new ArrayList<double[]>();
        while (rotationAngle < 2* Math.PI) {
            vector[0] = vector[0] + vector[0] * circleRadius * Math.cos(theta);
            vector[1] = vector[1] + vector[1] * circleRadius * Math.sin(theta);
            points.add(vector);
            rotationAngle += theta;
        }
        
        double revolutionAngle = alpha;
        while (revolutionAngle < 2 * Math.PI) {
            double cos = Math.cos(revolutionAngle);
            double negSin = -1* Math.sin(revolutionAngle);

            for (double[] point : points) {
                point[2] = point[1] * negSin;
                point[0] = point[0] * cos;
            }

            revolutionAngle += alpha;
        }
        

    }

}
/* 

class Point {
    double[] vector;
    double x;
    double y;
    double z;
    

    Point(double[] vector) {
        this.vector = vector;
       
    }
}
*/