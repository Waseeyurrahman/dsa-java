class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return result;
       int n = matrix.length;
       int m = matrix[0].length;
       int srow=0,scol=0,erow=n-1,ecol=m-1;

       while(srow<=erow && scol<=ecol){

for(int j=scol;j<=ecol;j++){
    result.add(matrix[srow][j]);
}

for(int i=srow+1;i<=erow;i++){
    result.add(matrix[i][ecol]);
}

for(int j=ecol-1;j>=scol;j--){
    if(srow==erow){
        break;
    }
    result.add(matrix[erow][j]);
}

for(int i=erow-1;i>=srow+1;i--){
    if(scol==ecol){
        break;
    }
        result.add(matrix[i][scol]);
}
srow++;ecol--;erow--;scol++;
       }
       return result;
    }
}