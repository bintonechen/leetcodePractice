/**
 * Date: 2025/1/28 09:29
 * 454. 4Sum II
 */

package hashmap;

import java.util.HashMap;
import java.util.Map;

public class LC454 {
    class Solution {
        public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

            int result = 0;
            int n = nums1.length;
            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i<n; i++ ){
                for(int j = 0; j<n; j++){
                    map.put(nums1[i]+nums2[j],map.getOrDefault(nums1[i]+nums2[j],0)+1);
                }
            }

            for (int i = 0; i<n; i++ ){
                for(int j = 0; j<n; j++){
                    int sum = nums3[i]+nums4[j];
                    int complement = -sum;
                    if(map.containsKey(complement)){
                        result += map.get(complement);
                    }
                }
            }

            return result;
        }
    }
}
