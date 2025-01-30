/**
 * Date: 2025/01/13
 * 904. Fruit Into Baskets
 */

package arrays;

import java.util.HashMap;
import java.util.Map;

public class LC904 {

    // sliding window approach
    class Solution {
        public int totalFruit(int[] fruits) {
            int n = fruits.length-1;
            Map<Integer,Integer> count = new HashMap<Integer, Integer>();

            int left = 0;
            int answer = 0;

            for(int right = 0; right<=n; right++){

                // add the current fruit type to the HashMap or update its count
                count.put(fruits[right],count.getOrDefault(fruits[right],0)+1);

                // when there are more than 2 types of fruits in the window
                while(count.size()>2){

                    // decrease the count of the fruit type at the `left` pointer
                    count.put(fruits[left],count.get(fruits[left])-1);

                    if(count.get(fruits[left])==0){
                        count.remove(fruits[left]);
                    }

                    // shrink the window
                    left++;
                }

                // calculate the size of the current window and update the maximum
                answer=Math.max(answer, right-left+1);

            }
            return answer;
        }

    }



}
