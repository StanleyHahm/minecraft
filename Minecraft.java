/**
*  NAME: Stanley Hahm
*  ID: A14609365
*  EMAIL: sthahm@ucsd.edu
*
*  In this code below, we are trying to simulate certain aspects of
*  minecraft. Here we are trying to rotate tiles on the floor and
*  keep track of mobs that are infected so that we can keep track
*  of other mobs that might be infected. Two new concepts we're
*  utilizing are 2D arrays and ArrayLists. We use 2D arrays to look
*  through floor plans and to look through the parties of mobs.
*/

import java.util.ArrayList;

/**
*  This class uses multiples methods. The rotateFloorPlan uses
*  2D arrays and rotates them around 90 degrees clockwise. The
*  getMobsToTest sees which mob is infected and then checks each
*  party to see if it has the mob. If it has the mob, then the
*  method makes an arraylist of all mobs in each party to be tested.
*  It does not duplicate the type of mob though.
*/

public class Minecraft{

  /**
  *  Accepts 2D integer array and rotates it. It uses a new 2D int
  *  array to place that rotated array in.
  *
  *  @param originalFloorPlan this is the 2d integer array that has
  *  the original rectangle floor plan
  *  @return newFloorPlan this is a 2d integer array that is the
  *  rotated rectangle floor plan
  */
  public static int[][] rotateFloorPlan(int[][] originalFloorPlan){
    //if the whole array is null, then return null
    if (originalFloorPlan == null){
      return null;
    }

    //original floor plan row length is new column length
    int new_column = originalFloorPlan.length;
    //original floor plan column length is new row length
    int new_row = originalFloorPlan[0].length;

    //the new floor plan needs to be an int array
    int [][] newFloorPlan = new int[new_row][new_column];

    //this goes through each element of the originalFloorPlan
    //and puts them into the newFloorPlan in such a way that it
    //rotates the originalFloorPlan
    for(int i = 0; i < new_column; i++){
      for(int j = 0; j < new_row; j++){
        newFloorPlan[j][new_column - i - 1] = originalFloorPlan[i][j];
      }
    }


    return newFloorPlan;
  }

  /**
  *  Accepts a 2D string array and string. Checks if that string
  *  is in any of the rows of the 2D string array. If that string,
  *  or infected, is in the rows, then all of the mobs in that
  *  party are inserted into the output for mobs to test. The
  *  mobs to test aren't repeated though. It will output an
  *  arraylist.
  *
  *  @param groups this is a 2D string array that has parties of
  *  mobs in it.
  *  @param infected this is the infected mob
  *  @return mobs_to_test this is the arraylist of mobs to test
  *  because they were exposed to the infected mob
  */
  public static ArrayList<String> getMobsToTest(String[][] groups,
    String infected){
      //if any of the inputs are null, then return null
      if((groups == null) || (infected == null)){
        return null;
      }

      ArrayList<String> mobs_to_test = new ArrayList<String>();
      //the groups length is the amount of rows in the group
      int groups_rows = groups.length;

      //this adds all mobs if the party has the infected mob
      //this implies there will be duplicates
      for(int i = 0; i < groups_rows; i++){
        for(int j = 0; j < groups[i].length; j++){
          if(groups[i][j] == infected){
            for(int k = 0; k < groups[i].length; k++){
              if((groups[i][k] != infected) && (groups[i][k] != null)){
                mobs_to_test.add(groups[i][k]);
              }
            }
          }
          else{
            continue;
          }
        }
      }

      //this removes the duplicates in the mobs_to_test
      for(int m = 0; m < mobs_to_test.size(); m++){
        for(int n = m+1; n < mobs_to_test.size(); n++){
          if(mobs_to_test.get(m) == mobs_to_test.get(n)){
            mobs_to_test.remove(n);
          }
        }
      }

      return mobs_to_test;
    }

}
