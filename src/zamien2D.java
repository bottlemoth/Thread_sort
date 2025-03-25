public class zamien2D {
    public static int[][] zamien(int[] arr, int row, int col){
        if(arr.length!=row*col){
            throw new IllegalArgumentException("Nieprawidłowe wymiary");
        }
        int[][] result = new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                result[i][j] = arr[i*col+j];

            }
        }
        return result;
    }
}
