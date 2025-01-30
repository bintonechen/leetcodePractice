/**
 * Date: 2025/1/27 09:03
 * 202. Happy Number
 */

package hashmap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC202 {

    // my approach
    class Solution1 {
        public boolean isHappy(int n) {

            List<Integer> sums= new ArrayList<Integer>();
            sums.add(n);

            while (true) {
                int sum = 0;

                // calculate the sum of squares of digits
                while (n > 0) {
                    int lastDigit = n % 10;
                    sum = sum + (lastDigit*lastDigit);
                    n = n /10;
                }

                // check if the number is happy
                if(sum == 1){
                    return true;
                }

                // check if entered a cycle
                if (sums.contains(sum)) {
                    return false;
                }

                // add the new sum to the list and continue
                sums.add(sum);
                n = sum;
            }
        }
    }

    // hashSet approach
    class Solution2 {
        public boolean isHappy(int n) {
            Set<Integer> seen = new HashSet<>();
            while (n!=1 && !seen.contains(n)){
                seen.add(n);
                n = getNext(n);
            }
            return n ==1;
        }

        public int getNext(int n){
            int totalSum = 0;
            while(n>0){
                int d = n%10;
                n = n/10;
                totalSum = totalSum + d*d;
            }
            return totalSum;
        }
    }

    // two-pointer approach
    class Solution3 {
        public boolean isHappy(int n) {
            int slowRunner = n;
            int fastRunner = getNext(n);

            while(fastRunner !=1 && slowRunner != fastRunner){
                slowRunner = getNext(slowRunner);
                fastRunner = getNext(getNext(fastRunner));
            }
            return fastRunner ==1;

        }

        public int getNext(int n){
            int totalSum = 0;
            while(n>0){
                int d = n%10;
                n = n/10;
                totalSum = totalSum + d*d;
            }
            return totalSum;
        }
    }




}
