// Name:Yaochun Li
// USC NetID: 8555684098
// CS 455 PA3
// Fall 2019


import java.util.Random;

/**
   MineField
      class with locations of mines for a game.
      This class is mutable, because we sometimes need to change it once it's created.
      mutators: populateMineField, resetEmpty
      includes convenience method to tell the number of mines adjacent to a location.
 */
public class MineField {

    private int rowsNum ,colsNum , minesNum , leftMinesNum ;
    private boolean[][] mineField;
    private Random random = new Random();

   // <put instance variables here>



   /**
      Create a minefield with same dimensions as the given array, and populate it with the mines in the array
      such that if mineData[row][col] is true, then hasMine(row,col) will be true and vice versa.  numMines() for
      this minefield will corresponds to the number of 'true' values in mineData.
    * @param mineData  the data for the mines; must have at least one row and one col.
    */
   public MineField(boolean[][] mineData) {
       //*  Input data to create field *//
       minesNum = 0;
       rowsNum = mineData.length;
       colsNum = mineData[0].length;
       mineField = new boolean[rowsNum][colsNum];

       //* Use loop to assign the mineData to mineField in case data be modified *//
       int count = 0;
       for (int i = 0 ; i < rowsNum ; i++ ){
           for (int j = 0 ; j < colsNum ; j ++ ){
               mineField[i][j] = mineData[i][j];
               if (mineField[i][j]) count++;
           }
       }
       minesNum = count;
   }


   /**
      Create an empty minefield (i.e. no mines anywhere), that may later have numMines mines (once
      populateMineField is called on this object).  Until populateMineField is called on such a MineField,
      numMines() will not correspond to the number of mines currently in the MineField.
      @param numRows  number of rows this minefield will have, must be positive
      @param numCols  number of columns this minefield will have, must be positive
      @param numMines   number of mines this minefield will have,  once we populate it.
      PRE: numRows > 0 and numCols > 0 and 0 <= numMines < (1/3 of total number of field locations).
    */
   public MineField(int numRows, int numCols, int numMines) {
       //* Use parameter to create MineField *//
       colsNum = numCols;
       rowsNum = numRows;
       minesNum = numMines;
       mineField = new boolean[colsNum][rowsNum];
   }


   /**
      Removes any current mines on the minefield, and puts numMines() mines in random locations on the minefield,
      ensuring that no mine is placed at (row, col).
      @param row the row of the location to avoid placing a mine
      @param col the column of the location to avoid placing a mine
      PRE: inRange(row, col)
    */
   public void populateMineField(int row, int col) {
       //* Reset the game and mine location *//
       resetEmpty();
       leftMinesNum = numMines();
       while ( leftMinesNum > 0 ){
           int rowI = random.nextInt(numRows());
           int colI = random.nextInt(numCols());
           if ( !mineField[rowI][colI] && rowI != row && colI != col ){
               mineField[rowI][colI] = true;
               leftMinesNum --;
           }
       }

   }


   /**
      Reset the minefield to all empty squares.  This does not affect numMines(), numRows() or numCols()
      Thus, after this call, the actual number of mines in the minefield does not match numMines().
      Note: This is the state the minefield is in at the beginning of a game.
    */
   public void resetEmpty() {
       //* Reset it to empty *//
      mineField = new boolean[numRows()][numCols()];
   }


  /**
     Returns the number of mines adjacent to the specified mine location (not counting a possible
     mine at (row, col) itself).
     Diagonals are also considered adjacent, so the return value will be in the range [0,8]
     @param row  row of the location to check
     @param col  column of the location to check
     @return  the number of mines adjacent to the square at (row, col)
     PRE: inRange(row, col)
   */
   public int numAdjacentMines(int row, int col) {
       //* Check if there exist adjacent mines *//
      int adjacentMines = 0 ;
       //* Search 8 directions by loop *//
      for( int i = -1 ; i < 2 ; i ++ ){
          for (int j = -1 ; j < 2 ;j ++ ){
              if ( i == 0 && j ==0 ) continue;
              int newRow = row + i , newCol = col + j ;
              if (inRange(newRow,newCol) && mineField[newRow][newCol]) adjacentMines++;
          }
      }
      return adjacentMines;
   }


   /**
      Returns true iff (row,col) is a valid field location.  Row numbers and column numbers
      start from 0.
      @param row  row of the location to consider
      @param col  column of the location to consider
      @return whether (row, col) is a valid field location
   */
   public boolean inRange(int row, int col) {
       //* Check if coordinates is valid *//
      if( row<0 || row>= numRows() || col<0 || col >= numCols() ) return false;
      else  return true;
   }


   /**
      Returns the number of rows in the field.
      @return number of rows in the field
   */
   public int numRows() {
      return rowsNum;
   }


   /**
      Returns the number of columns in the field.
      @return number of columns in the field
   */
   public int numCols() {
      return colsNum;
   }


   /**
      Returns whether there is a mine in this square
      @param row  row of the location to check
      @param col  column of the location to check
      @return whether there is a mine in this square
      PRE: inRange(row, col)
   */
   public boolean hasMine(int row, int col) {
      return mineField[row][col];
   }


   /**
      Returns the number of mines you can have in this minefield.  For mines created with the 3-arg constructor,
      some of the time this value does not match the actual number of mines currently on the field.  See doc for that
      constructor, resetEmpty, and populateMineField for more details.
    * @return
    */
   public int numMines() {
      return minesNum;
   }


   // <put private methods here>


}

