/**
 * Date: 2025/1/30 16:07
 * 18. 4Sum
 */

package hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC18 {
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {

            Arrays.sort(nums);
            List<List<Integer>> result = new ArrayList<>();

            // Iterate through to get A
            for(int i = 0; i<nums.length; i++){

                if(nums[i]> target && nums[i]>=0){
                    break;
                }


                // skip duplicate A
                if(i>0 && nums[i]==nums[i-1]){
                    continue;
                }

                // Iterate through to get B
                for(int j = i+1; j< nums.length; j++ ){

                    if(nums[i]+nums[j]>target && nums[i]+ nums[j]>=0){
                        break;
                    }
                    
                    // skip duplicate B
                    if(j>i+1 && nums[j]==nums[j-1]){
                        continue;
                    }

                    long complement = (long) target - nums[i]-nums[j];
                    int pointer1 = j+1;
                    int pointer2 = nums.length-1;

                    while(pointer1<pointer2){

                        long sum = (long)nums[pointer1] + nums[pointer2];

                        if(sum==complement){
                            List<Integer> quadruplet = new ArrayList<>();
                            quadruplet.add(nums[i]);
                            quadruplet.add(nums[j]);
                            quadruplet.add(nums[pointer1]);
                            quadruplet.add(nums[pointer2]);
                            result.add(quadruplet);

                            while(pointer1<pointer2 && nums[pointer1]==nums[pointer1+1]) pointer1++;
                            while(pointer1<pointer2 && nums[pointer2]==nums[pointer2-1]) pointer2--;

                            pointer1++;
                            pointer2--;

                        } else if (sum<complement){
                            pointer1++;
                        } else { // nums[pointer1]+nums[pointer2]>complement
                            pointer2--;
                        }
                    }
                }
            }
            return result;
        }
    }
}
