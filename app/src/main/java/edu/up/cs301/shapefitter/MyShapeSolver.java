package edu.up.cs301.shapefitter;

import android.util.Log;

/**
 * Solver: finds fit for a shape; completed solution by Vegdahl.
 *
 * @author Cory Marleau
 * @version September 6 2021
 */
public class MyShapeSolver extends ShapeSolver {

    /**
     * Creates a solver for a particular problem.
     *
     * @param parmShape the shape to fit
     * @param parmWorld the world to fit it into
     * @param acc to send notification messages to
     */
    public MyShapeSolver(boolean[][] parmShape, boolean[][] parmWorld, ShapeSolutionAcceptor acc) {
        // invoke superclass constructor
        super(parmShape, parmWorld, acc);
    }

    /**
     * Solves the problem by finding a fit, if possible. The last call to display tells where
     * the fit is. If there is no fit, no call to display should be made--alternatively, a call to
     * undisplay can be made.
     */
    public void solve() {
        //cropShape(this.shape);
        if (match(Orientation.ROTATE_NONE)){
            return;
        }
        rotateCW(this.shape);
        if (match(Orientation.ROTATE_CLOCKWISE)) {
            return;
        }
        rotateCW(this.shape);
        if (match(Orientation.ROTATE_180)){
            return;
        }
        rotateCW(this.shape);
        if(match(Orientation.ROTATE_COUNTERCLOCKWISE)){
            return;
        }
        rotateCW(this.shape);
        reverseArray(this.shape);
        if (match(Orientation.ROTATE_NONE_REV)){
            return;
        }
        rotateCW(this.shape);
        if (match(Orientation.ROTATE_COUNTERCLOCKWISE_REV)) {
            return;
        }
        rotateCW(this.shape);
        if (match(Orientation.ROTATE_180_REV)){
            return;
        }
        rotateCW(this.shape);
        if(match(Orientation.ROTATE_CLOCKWISE_REV)){
            return;
        }
        undisplay();

    }
    /**
     * Crops the empty space out of the array
     *
     * @param shape the boolean[][] to be cropped
     */

    /**
     * Determines if a match is found between the shape and the world
     *
     * @param or the orientation to be displayed if a match is found
     * @return whether a match is found
     */
    public boolean match(Orientation or){

        //loop through the world array
        for (int i = 0; i <= this.world.length - this.shape.length; i++){
            for (int j = 0; j <= this.world.length - this.shape.length; j++) {
                //assume that this will be a match
                boolean match = true;
                //find first true value in shape
                //loop through the shape object and compare each pixel to the world
                //(i,j) is the starting point being compared to in the world
                //(k,l) is top left corner of shape
                for (int k = 0; k < this.shape.length; k++) {
                    for (int l = 0; l < this.shape.length; l++) {
                        Log.d("SOLUTION", "" + this.shape[k][l] + ":" + this.world[i + k][j + l]);
                        if (this.shape[k][l] && this.world[i + k][j + l]) {
                            match = false;
                        }
                    }
                }
                display(i, j, or);
                if (match) {
                    return true;
                }
            }
        }
        return false;
    }

    public void cropShape(boolean shape[][]){
        /*int minRow = shape.length;
        int maxRow = 0;
        int minCol = shape.length;
        int maxCol = 0;

        for (int row = 0; row < shape.length; row++) {
            for (int col = 0; col < shape.length; col++){
                if (shape[row][col] == true){
                    if (row < minRow){
                        minRow = row;
                    }
                    if (row > maxRow) {
                        maxRow = row;
                    }
                    if (col < minCol) {
                        minCol = col;
                    }
                    if (col > maxCol){
                        maxCol = col;
                    }
                }
            }
        }

        boolean[][] cropped = new boolean[maxRow - minRow + 1][maxCol - minCol + 1];
        for (int row = minRow; row <= maxRow; row++) {
            for (int col = minCol; col <= maxCol; col++) {
                int croppedRow = row - minRow;
                int croppedCol = col - minCol;

                cropped[croppedRow][croppedCol] = this.shape[row][col];
            }
        }

        this.shape = cropped;
        */
    }
    /**
     * Rotates a boolean[][] clockwise
     * This method was adapted from:
     * https://www.geeksforgeeks.org/rotate-a-matrix-by-90-degree-in-clockwise-direction-without-using-any-extra-space/
     *
     * @param shape the boolean[][] to be rotated
     */
    static void rotateCW(boolean shape[][]) {
        // Traverse each cycle
        for (int i = 0; i < shape.length / 2; i++)
        {
            for (int j = i; j < shape.length - i - 1; j++)
            {
                // Swap elements of each cycle
                // in clockwise direction
                boolean temp = shape[i][j];
                shape[i][j] = shape[shape.length - 1 - j][i];
                shape[shape.length - 1 - j][i] = shape[shape.length - 1 - i][shape.length - 1 - j];
                shape[shape.length - 1 - i][shape.length - 1 - j] = shape[j][shape.length - 1 - i];
                shape[j][shape.length - 1 - i] = temp;
            }
        }
    }
    /**
     * reverses/mirrors a boolean[][] over the y axis
     * This method was adapted from:
     * https://www.geeksforgeeks.org/program-to-reverse-the-rows-in-a-2d-array/
     *
     * @param shape the boolean[][] to be reversed
     */
    static void reverseArray(boolean shape[][]) {

        // Traverse each row of shape[][]
        for (int i = 0; i < shape.length; i++) {

            // Initialise start and end index
            int start = 0;
            int end = shape.length - 1;

            // Till start < end, swap the element
            // at start and end index
            while (start < end) {

                // Swap the element
                boolean temp = shape[i][start];
                shape[i][start] = shape[i][end];
                shape[i][end] = temp;

                // Increment start and decrement
                // end for next pair of swapping
                start++;
                end--;
            }
        }
    }
    /**
     * Checks if the shape is well-formed: has at least one square, and has all squares connected.
     *
     * @return whether the shape is well-formed
     */
    public boolean check() {
        //stretch goal
        /*
        for (int i = 0; i < this.shape.length; i++) {
            for (int j = 0; j < this.shape.length; j++) {
                if () {

                }
            }
        }*/
        return Math.random() < 0.5;

    }

}
