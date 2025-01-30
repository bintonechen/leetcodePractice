/**
 * Date: 2025/1/20
 * https://kamacoder.com/problempage.php?pid=1070
 */

package arrays;

import java.util.Scanner;

public class KamaCoder58 {

    public class solution{
        public static void main (String[] args){
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int [] element = new int [n];
            int [] preSum = new int[n];

            int tempSum = 0;
            for (int i = 0; i <n; i++){
                element[i] = sc.nextInt();
                tempSum = tempSum +element[i];
                preSum[i] = tempSum;
            }

            while (sc.hasNextInt()){
                int start = sc.nextInt();
                int end = sc.nextInt();

                int result;

                if(start == 0 ){
                    result = preSum[end];
                } else {
                    result = preSum[end] - preSum[start-1];
                }
                System.out.println(result);
            }

            sc.close();
        }
    }




}
