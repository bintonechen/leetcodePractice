/**
 * Date: 2025/1/16 15:47
 * 59. Spiral Matrix II
 */

package arrays;

public class LC59 {

    class Solution1 {
        public int[][] generateMatrix(int n) {
            int[][] result = new int[n][n];
            int current = 1;
            for(int layer = 0; layer <(n+1)/2; layer++){
                // direction 1 - top line
                for(int pointer = layer; pointer<n-layer; pointer++){
                    result[layer][pointer]= current;
                    current++;
                }
                // direction 2 - right line
                for(int pointer = layer+1; pointer<n-layer; pointer++){
                    result[pointer][n-layer-1] = current;
                    current++;
                }
                // direction 3 - bottom line
                for(int pointer =n-layer-2; pointer>=layer; pointer--){
                    result[n-layer-1][pointer] = current;
                    current++;
                }
                // direction 4- left line
                for(int pointer = n-layer-2; pointer>layer; pointer--){
                    result[pointer][layer]= current;
                    current++;
                }
            }
            return result;
        }
    }

    class Solution2 {
        public int[][] generateMatrix(int n) {
            int[][] result = new int[n][n];
            int num = 1, end = n*n;

            // initialize the boundaries for the current layer
            int top = 0, right= n-1, bottom = n-1, left = 0;

            while(num<=end){
                for(int pointer = left; pointer<=right; pointer++){
                    result[top][pointer] = num;
                    num++;
                }
                top++;
                for(int pointer = top; pointer<=bottom; pointer++){
                    result[pointer][right] = num;
                    num++;
                }
                right--;
                for(int pointer = right; pointer>=left; pointer--){
                    result[bottom][pointer] = num;
                    num++;
                }
                bottom--;
                for(int pointer = bottom; pointer>=top; pointer--){
                    result[pointer][left] = num;
                    num++;
                }
                left++;
            }
            return result;

        }
    }





}
