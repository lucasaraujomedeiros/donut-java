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
        Donut donut = new Donut(2, 2, 0.17, 0.17);
        cb.drawPoints(donut.points);
        clearScreen();
        for (String[] strArray : cb.matrix) {
            for (String str : strArray) {
                System.out.print(str);
            }
            System.out.print("\n");
        }

        for (double[] point : donut.points) {
            System.out.println ("ponto: " + point[0] + point[1]);
        }


    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush(); 
    }

    public void drawPoints(ArrayList<double[]> points) {
        for (double[] point : points) {
            matrix[x(point[0])][y(point[1])] = ".";
        }
    }

    int x(double xPoint) {
        return (int) xPoint + 10;
    }

    int y(double yPoint) {
        return (int) yPoint + 20;
    }
    


}
