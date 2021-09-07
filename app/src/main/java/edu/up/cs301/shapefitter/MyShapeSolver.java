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
        matchShape:
        //-----Reference-----
        //Log.d("SOLVE", "This is a test for the console");
        //display(3, 4, Orientation.ROTATE_CLOCKWISE);
        //loop through the entire world array with each orientation of the shape
        for (int i = 0; i <= this.world.length - this.shape.length; i++){
            for (int j = 0; j <= this.world.length - this.shape.length; j++) {
                Log.d("Coord", "("+i+","+j+")");
                //assume that this will be a match
                //loop through the shape object and match each pixel
                //(i,j) is a shifting point in the world
                //(k,l) is top left corner of shape
                boolean match = true;
                for (int k = 0; k < this.shape.length; k++) {
                    for (int l = 0; l < this.shape.length; l++) {
                        Log.d("SOLUTION", ""+this.shape[k][l] + ":" + this.world[i + k][j + l]);
                        if (this.shape[k][l] != this.world[i + k][j + l]) {
                            match = false;
                        }
                    }
                }
                display(i, j, Orientation.ROTATE_NONE);
                if (match == true){
                    break matchShape;
                }
                undisplay();
            }
        }


        //Step 1: get input from the array



        //Step 2: loop through the entire array looking for a match
        //Step 3: rotate clockwise and repeat for all orientations and mirrors
        //Step 4: if no match, call undisplay();
    }

    /**
     * Checks if the shape is well-formed: has at least one square, and has all squares connected.
     *
     * @return whether the shape is well-formed
     */
    public boolean check() {
        return Math.random() < 0.5;
    }

}
