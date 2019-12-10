// Name: Yaochun Li
// USC NetID: yaochunl
// CS 455 PA4
// Fall 2019

/**
    This class has information about how much each scrabble letter is worth.
    This class has information about Scrabble scores for scrabble letters and words.
    This class should work for both upper and lower case versions of the letters
 */


public class ScoreTable {

    private int[] score;

    /** Since the letters values are given , we decide use list to store their value
     *  The value are related to the index
     */
    public ScoreTable(){

        score = new int[26];
        for (int i = 0; i<26 ; i++ ){
            //*         (1 point)-A, E, I, O, U, L, N, S, T, R
            if(i == 0 || i == 4 || i == 8 || i == 14 || i == 20 ||
                    i == 11 || i == 13 || i == 18 || i == 19 || i == 17){
                score[i] = 1;
            }
            //*         (2 points)-D, G
            else if(i == 3 || i == 6){
                score[i] = 2;
            }
            //*         (3 points)-B, C, M, P
            else if (i == 1 || i == 2 || i == 12 || i == 15){
                score[i] = 3;
            }
            //*         (4 points)-F, H, V, W, Y
            else if (i == 5 || i == 7 || i == 21 || i == 22 || i == 24){
                score[i] = 4;
            }
            //*         (5 points)-K
            else if (i == 10){
                score[i] = 5;
            }
            //*         (8 points)- J, X
            else if (i == 9 || i== 23){
                score[i] = 8;
            }
            //*         (10 points)- Q, Z
            else if (i == 16 || i == 25){
                score[i] = 10;
            }
        }
    }

    /**
     * Use ScoreTable to calculate the word's score
     * Since the class should work for both upper and lower case versions of the letters
     * We transform word to lowerCase first to calculate
     * @param word
     * @return the score of the word
     */

    public int getScore(String word){
        /*      convert the string into lowercase to make it easier to calculate     */
        int score = 0;
        String lowerCase = word.toLowerCase();
        for (int i = 0 ; i < lowerCase.length() ; i++ ){
            score += this.score[lowerCase.charAt(i) - 'a'];
        }

        return score;

    }


}
