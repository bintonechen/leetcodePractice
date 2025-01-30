/**
 * Date: 2025/1/26 08:54
 * 349. Intersection of Two Arrays
 */

package hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class LC349 {

    // HashSet Approach
    class Solution1 {
        public int[] intersection(int[] nums1, int[] nums2) {

            if(nums1.length == 0 || nums2.length == 0 || nums1 == null || nums2 == null ){
                return new int[0];
            }

            HashSet<Integer> set1 = new HashSet<>();
            HashSet<Integer> results = new HashSet<>();

            for (int num: nums1){
                set1.add(num);
            }

            for(int num: nums2){
                if(set1.contains(num)){
                    results.add(num);
                }
            }

            // method 1 to convert the HashSet into an integer array
            int[] toReturn = results.stream().mapToInt(x ->x).toArray();

            // method 2
            int[] toReturn2 = new int[results.size()];
            int j = 0;
            for (int num: results){
                toReturn2[j] = num;
                j++;
            }
            return toReturn;
        }
    }


    // Counting Array Approach
    class Solution2 {
        public int[] intersection(int[] nums1, int[] nums2) {

            // create hash arrays to covers range 0 to 1000
            int[] hash1 = new int[1001];
            int[] hash2 = new int[1001];

            for(int i:nums1) hash1[i]++;
            for(int i:nums2) hash2[i]++;

            // to create a list to store the intersection of nums1 and nums2
            List<Integer> list = new ArrayList<>();
            for(int i =0; i<1001; i++){
                if(hash1[i]>0 && hash2[i]>0){
                    list.add(i);
                }
            }

            // covert the list ro an array
            int result[] = new int[list.size()];
            int index = 0;
            for(int i: list) {
                result[index] = i;
                index++;
            }
            return result;
        }
    }

    // Two Pointer approach
    class Solution3 {
        public int[] intersection(int[] nums1, int[] nums2) {

            // sort both arrays
            Arrays.sort(nums1);
            Arrays.sort(nums2);

            // initialize two pointers
            int p1 = 0;
            int p2 = 0;

            List<Integer> list = new ArrayList<>();

            while(p1<nums1.length && p2<nums2.length){
                if(nums1[p1]==nums2[p2]){
                    if (list.isEmpty() || list.get(list.size() - 1) != nums1[p1]) {
                        list.add(nums1[p1]); // Add the number only if it's not already in the list
                    }
                    p1++;
                    p2++;
                } else if(nums1[p1]<nums2[p2]){
                    p1++;
                } else {
                    p2++;
                }
            }

            return list.stream().mapToInt(x -> x).toArray();
        }
    }

}
