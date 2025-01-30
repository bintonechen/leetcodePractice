/**
 * Date: 2025/1/27 22:22
 * 1. Two Sum
 */

package hashmap;

import java.util.HashMap;
import java.util.Map;

public class LC1 {

    class Solution {

        public int[] twoSum(int[] nums, int target) {

            Map<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i<nums.length; i++){
                map.put(nums[i],i);
            }

            for(int i = 0; i<nums.length; i++){
                int complement = target - nums[i];
                if(map.containsKey(complement) && map.get(complement)!=i){
                    return new int [] {i,map.get(complement)};
                }
            }

            return new int[0];
        }
    }




}
