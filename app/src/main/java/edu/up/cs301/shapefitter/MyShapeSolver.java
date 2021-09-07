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

        // ****dummied up****
        // always "finds" a solution at row 3, column 4, with a 90-degree clockwise orientation
        //Log.d("SOLVE", "This is a test for the console");
        //loop through the entire world array with each orientation of the shape
        for (int i = 0; i < 40; i++){
            for (int j = 0; j < 40; j++){
                for (Orientation or : Orientation.values()) {
                    display(i,j,or);
                    Log.d("Object", "Test: " + or.toString());
                }
            }

        }
        //display(3, 4, Orientation.ROTATE_CLOCKWISE);

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
