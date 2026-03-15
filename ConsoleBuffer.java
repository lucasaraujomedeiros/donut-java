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
        Donut donut = new Donut(5, 5, 0.17, 0.17);

        cb.drawPoints(donut.points);
        for (String[] strArray : cb.matrix) {
            for (String str : strArray) {
                System.out.print(str);
            }
            System.out.print("\n");
        }

        System.out.println(cb.getPointCoordinates());


    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush(); 
    }

    public void drawPoints(ArrayList<double[]> points) {
        for (double[] point : points) {
            matrix[y(point[1])][x(point[0])] = ".";
        }
    }


    int x(double xPoint) {
        return (int) xPoint + 20;
    }

    int y(double yPoint) {
        return (int) yPoint + 9;
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
    
// matrix 21 arrays contendo 42 caracteres
// matrix [y][x]

}
