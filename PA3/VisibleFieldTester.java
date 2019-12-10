import java.util.Arrays;

public class VisibleFieldTester {
    public static void main(String[] args) {
        boolean[][] testerMatrix = {
                {false, false, false, false},
                {true, false, false, false},
                {false, true, true, false},
                {false, true, false, true}
        };
        int rows = testerMatrix.length;
        int cols = testerMatrix[0].length;

        MineField test = new MineField(testerMatrix);
        VisibleField vf = new VisibleField(test);

        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i ++) {
            for (int j = 0; j < cols; j ++) {
                matrix[i][j] = test.numAdjacentMines(i, j);
            }
        }
        printNumAdjacentMinesTestResult(matrix);
        System.out.println();
        System.out.println(test);
        System.out.println();

        System.out.println("Constructor test: ");
        System.out.println(vf);

        System.out.println("NumMinesLeft test: ");
        System.out.println(vf.numMinesLeft() + " expect result: " + test.numMines());
        System.out.println();

        System.out.println("CycleGuess test: ");
        vf.cycleGuess(0, 0);
        vf.cycleGuess(2, 2);
        vf.cycleGuess(0, 0);
        vf.cycleGuess(0, 0);
        vf.cycleGuess(2, 2);
        vf.cycleGuess(2, 3);
        System.out.println(vf);
        System.out.println();

        System.out.println("ResetGameDisplay test: ");
        vf.resetGameDisplay();
        System.out.println(vf);

        vf.cycleGuess(1, 1);
        vf.cycleGuess(3, 3);
        System.out.println(vf);
        System.out.println(vf.uncover(1, 0));
        System.out.println(vf);

        vf.resetGameDisplay();
        System.out.println(vf.uncover(0, 0));
        System.out.println(vf.uncover(0, 1));
        System.out.println(vf.uncover(2, 3));
        System.out.println(vf.uncover(3, 2));
        System.out.println(vf);

        vf.resetGameDisplay();
        vf.uncover(0, 3);
        System.out.println(vf);

        vf.resetGameDisplay();
        vf.uncover(0, 3);
        System.out.println(vf.isGameOver());
        vf.uncover(0, 0);
        System.out.println(vf.isGameOver());
        System.out.println(vf);
        vf.cycleGuess(3,3);
        vf.cycleGuess(2,3);
        vf.uncover(1, 0);
        System.out.println(vf.isGameOver());
        System.out.println(vf);
    }
    private static void printNumAdjacentMinesTestResult(int[][] matrix) {
        for (int i = 0; i < matrix.length; i ++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
}