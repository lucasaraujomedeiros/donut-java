import java.util.ArrayList;

public class ConsoleBuffer {
    String[][] matrix;
    int frameTimeNs = 166666666;

    public ConsoleBuffer() {
        String[][] matrix = new String[21][42];
        for (int i = 0; i < matrix.length; i ++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = " ";
            }
        }
        this.matrix = matrix;
    }
    public static void main(String[] args) {
        ConsoleBuffer cb = new ConsoleBuffer();
        //Donut donut = new Donut(5, 11, 0.17, 0.17);
        Cross donut = new Cross();
       
        while (true) {
            cb.drawPoints(donut.points);
            cb.printPoints();
            for (double[] point : donut.points) {
                //cb.rotateY(point, 0.3);
                cb.rotate(point, 0.1, 0.1);
            }
            try {
                Thread.sleep(200); 
            } catch (InterruptedException e) {
                // Handle the exception if the sleep is interrupted
                Thread.currentThread().interrupt();
            }
            clearScreen();
        }
    

    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush(); 
    }

    public void drawPoints(ArrayList<double[]> points) {
        for (int i = 0; i < matrix.length; i ++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = " ";
            }
        }
        for (double[] point : points) {
            matrix[y(point[1])][x(point[0])] = ".";
        }
        System.out.println("\n");
    }


    int x(double xPoint) {
        return (int) xPoint + 20;
    }

    int y(double yPoint) {
        return (int) yPoint + 9;
    }

    void printPoints() {
        for (String[] strArray : this.matrix) {
            for (String str : strArray) {
                System.out.print(str);
            }
            System.out.print("\n");
        }

    }

    String getPointCoordinates() {
        String out = "";

        for (int i = 0; i < matrix.length; i ++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j].equals(".")) {
                    out = out + "Ponto (" + i + ", " + j + ")\n";
                }
            }
        }
        return out;

    }


    void rotateY(double[] point, double angleYRotation) {
        double sinA = Math.sin(angleYRotation);
        double cosA = Math.cos(angleYRotation);

        double x = point[0];
        double y = point[1];
        double z = point[2];
        
        point[0] = x * cosA + z * sinA;
        point[2] = -x * sinA + z * cosA;
    }


    void rotate(double[] point, double angleXRotation, double angleZRotation) {
        double sinA = Math.sin(angleXRotation);
        double cosA = Math.cos(angleXRotation);
        double sinB = Math.sin(angleZRotation);
        double cosB = Math.cos(angleZRotation);

        double x = point[0];
        double y = point[1];
        double z = point[2];
        
        point[0] = x * cosB - y * sinB;
        point[1] = x * cosA * sinB + y * cosA * cosB - z * sinA;
        point[2] = x * sinA * sinB + y * sinA * cosB + z * cosA;
    }
// matrix 21 arrays contendo 42 caracteres
// matrix [y][x]

}
