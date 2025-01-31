/**
 * Date: 2025/1/28 16:41
 * 3Sum
 */

package hashmap;

import java.lang.reflect.Array;
import java.util.*;


public class LC15 {

    // HashMap approach
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {

            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(nums);

            // select nums[i] as the first element (a)
            for(int i = 0; i < nums.length; i++){

                if(nums[i]>0){
                    return result;
                }

                // Skip duplicate values for nums[i] to avoid duplicate triplets
                if(i>0 && nums[i] == nums[i-1]){
                    continue;
                }

                HashSet<Integer> seenNumbers = new HashSet<>();

                for(int j = i+1; j< nums.length; j++){
                    if(j>i+2 && nums[j] == nums[j-1] && nums[j-1]==nums[j-2]){
                        continue;
                    }

                    int c = -nums[i]-nums[j];
                    if(seenNumbers.contains(c)){
                        result.add(Arrays.asList(nums[i], nums[j],c));
                        seenNumbers.remove(c);
                    } else {
                        seenNumbers.add(nums[j]);
                    }
                }

            }
        return result;
        }
    }

    // two pointer approach
    class Solution2 {
        public List<List<Integer>> threeSum(int[] nums) {
            int n = nums.length;
            Arrays.sort(nums);
            List<List<Integer>> answer = new ArrayList<List<Integer>>();

            // Iterate through to get A
            for(int first = 0; first<n; first++){

                // skip duplicate elements to avoid duplicate triplets
                if(first >0 && nums[first] == nums[first-1]){
                    continue;
                }

                int third = n-1;
                int target = -nums[first];

                // Iterate through to get B
                for(int second = first+1; second <n; second++){
                    // skip duplicate elements to avoid duplicate triplets
                    if(second > first+1 && nums[second] ==nums[second -1]){
                        continue;
                    }
                    while(second<third && nums[second]+nums[third]>target) {
                        third--;
                    }

                    if(second == third){
                        break;
                    }

                    if(nums[second]+nums[third]==target){
                        List<Integer> triplet = new ArrayList<>();
                        triplet.add(nums[first]);
                        triplet.add(nums[second]);
                        triplet.add(nums[third]);

                        answer.add(triplet);
                    }
                }
            }
            return answer;
        }
    }
}
