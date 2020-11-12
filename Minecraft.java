import java.util.ArrayList;

//just using this for testing in main
import java.util.Arrays;
import java.util.List;

public class Minecraft{
  public static int[][] rotateFloorPlan(int[][] originalFloorPlan){
    if (originalFloorPlan == null){
      return null;
    }

    //original floor plan row length is new column length
    int new_column = originalFloorPlan.length;
    //original floor plan column length is new row length
    int new_row = originalFloorPlan[0].length;

    int [][] newFloorPlan = new int[new_row][new_column];


    for(int i = 0; i < new_column; i++){
      for(int j = 0; j < new_row; j++){
        newFloorPlan[j][new_column - i - 1] = originalFloorPlan[i][j];
      }
    }


    return newFloorPlan;
  }

  public static void main(String[] args){
    /*
    int [][] originalFloorPlan = {{4,1},
                                  {4,1},
                                  {4,1},
                                  {4,8},
                                  {7,7}};
    System.out.println(Arrays.deepToString(rotateFloorPlan(originalFloorPlan)));
    */

    String[][] groups = {
                          {"Zombie", "Cow", "Creeper", "Guardian", null, "Slime"},
                          {"Sheep", "Iron Golem","", "Cow"},
                          {"Sheep"},
                          {"Cow", "Pufferfish", "", "Squid", "Sheep"}
                        };
    String infected = "";

    System.out.println(getMobsToTest(groups, infected));
  }

  public static ArrayList<String> getMobsToTest(String[][] groups,
    String infected){
      if((groups == null) || (infected == null)){
        return null;
      }

      ArrayList<String> mobs_to_test = new ArrayList<String>();
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
