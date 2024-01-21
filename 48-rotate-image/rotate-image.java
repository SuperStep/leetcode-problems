class Solution {
    public void rotate(int[][] matrix) {
//transpose the matrix
    int row=matrix.length;
    int col=matrix[0].length;

    for(int i=0;i<row;i++){
        for(int j=i;j<col;j++){
            int temp=0;
            temp=matrix[i][j];
            matrix[i][j]=matrix[j][i];
            matrix[j][i]=temp;
        }
    }

    for(int i=0;i<row;i++){
        for(int j=0;j<col/2;j++){
            int temp=matrix[i][j];
            matrix[i][j]=matrix[i][col-1-j];
            matrix[i][col-1-j]=temp;
        }
    }

        // 0,0 -> 0,2
        // 0,1 -> 1,2
        // 0,2 -> 2,2

        // 1,0 -> 0,2
        // 1,1 -> 1,1
        // 1,2 -> 2,1


    }
}