/**
 * Date: 2025/1/17 19:06
 * 54. Spiral Matrix
 */

package arrays;

import java.util.ArrayList;
import java.util.List;

public class LC54 {
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {

            // check whether the List is empty
            List<Integer> result = new ArrayList<Integer>();
            if(matrix==null || matrix.length == 0 || matrix[0].length ==0){
                return result;
            }

            int rows = matrix.length;
            int columns = matrix[0].length;
            int left = 0, top = 0, right = columns-1, bottom = rows-1;
            int lastNum = matrix.length * matrix[0].length;

            while(result.size()<lastNum){
                for(int i = left; i<=right && result.size()<lastNum; i++){
                    result.add(matrix[top][i]);
                }
                top++;
                for(int i = top; i<=bottom && result.size()<lastNum; i++){
                    result.add(matrix[i][right]);
                }
                right--;
                for(int i = right; i>=left && result.size()<lastNum; i--){
                    result.add(matrix[bottom][i]);
                }
                bottom--;
                for(int i = bottom; i>=top && result.size()<lastNum; i--){
                    result.add(matrix[i][left]);
                }
                left++;
            }
            return result;
        }
    }
}
