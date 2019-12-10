public class MineFieldTester {

    private static boolean[][] smallMineField = {{false, false, false, false}, {true, false, false, false},
            {false, true, true, false}, {false, true, false, true}};

    private static boolean[][] emptyMineField = {{false, false, false, false}, {false, false, false, false},
            {false, false, false, false}, {false, false, false, false}};

    private static boolean[][] almostEmptyMineField = {{false, false, false, false}, {false, false, false, false},
            {false, false, false, false}, {false, true, false, false}};

    public static void main(String[] args) {
        int rows = 7;
        int cols = 7;
        int numofmines = 9;
        MineField test = new MineField(rows, cols, numofmines);
        test.populateMineField(5, 5);
//        MineField test = new MineField(almostEmptyMineField);
        test.toString();
        if (test.hasMine(3, 1)) {
            System.out.println("There is a mine");
        }
        System.out.println("Adjacent: " + test.numAdjacentMines(2, 1));
        test.resetEmpty();
        test.toString();
        test.populateMineField(1, 1);
        test.toString();
        if (test.hasMine(2, 2)) {
            System.out.println("There is a mine");
        }
    }
}