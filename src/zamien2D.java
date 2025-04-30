import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class zamien2D {
    public static int[][] zamien(int[] arr, int row, int col){

        List<int[]> result = new ArrayList<>();

        for(int i=0;i<row;i++){
            if(arr.length-(i*col) < col){
                int[] temp = Arrays.copyOfRange(arr,i*col,arr.length);
                result.add(temp);
                break;
            }
            int[] temp = Arrays.copyOfRange(arr,i*col,i*col+col);
            result.add(temp);
        }

        return result.toArray(new int[0][]);
    }
}

