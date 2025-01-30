/**
 * Date: 2025/1/20 09:32
 * https://kamacoder.com/problempage.php?pid=1044
 */

package arrays;

import java.util.Scanner;

public class KamaCoder44 {

        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int m = sc.nextInt();

            int [][] land = new int [n][m];

            // input for land matrix
            for (int i = 0; i<n; i++){
                for(int j = 0; j<m; j++){
                    land[i][j] =sc.nextInt();
                }
            }

            // row and column sums
            int [] rowSum = new int [n];
            int [] columnSum = new int [m];

            for (int i = 0; i<n; i++){
                for (int j = 0; j<m; j++){
                    rowSum[i]+= land[i][j];
                    columnSum[j] += land[i][j];
                }
            }

            // find the minimum difference by dividing horizontally
            int totalRowSum = 0;
            for (int sum:rowSum){
                totalRowSum += sum;
            }
            int minDifference = Integer.MAX_VALUE;
            int topSum = 0;
            for(int i = 0; i< n-1; i++){
                topSum += rowSum[i];
                int bottomSum = totalRowSum - topSum;
                minDifference = Math.min(minDifference, Math.abs(topSum - bottomSum));

            }

            // find the minimum difference by dividing vertically
            int totalColSum = totalRowSum;

            int leftSum = 0;
            for (int j = 0; j<m-1; j++){
                leftSum +=columnSum[j];
                int rightSum = totalColSum - leftSum;
                minDifference = Math.min(minDifference, Math.abs(leftSum- rightSum));
            }

            // Output the result
            System.out.println(minDifference);
            sc.close();

        }
}


