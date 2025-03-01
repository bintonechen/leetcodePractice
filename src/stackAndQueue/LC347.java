/**
 * Date: 2025/3/1 14:22
 * 347. Top K Frequent Elements
 */

package stackAndQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LC347 {

    // approach 1: with Max-Heap (Priority Queue)
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {

            int[] answer = new int[k];

            // count the frequency of each element in the array
            Map<Integer, Integer> map = new HashMap<>();
            for(int num:nums){
                map.put(num, map.getOrDefault(num,0 )+1);
            }

            // create a Max-Heap to store elements based on frequency (descending order)
            PriorityQueue<int[]> pQue = new PriorityQueue<>((entry1, entry2) -> entry2[1] - entry1[1]);

            // add all <elements, frequencies>  to the priority queue
            for(Map.Entry<Integer, Integer> entry: map.entrySet()){
                int[] temp = {entry.getKey(), entry.getValue()};
                pQue.offer(temp);
            }

            // retrieve the first K elements from the priority queue
            for(int i = 0; i<k; i++){
                answer[i] = pQue.poll()[0];
            }
            return answer;
        }
    }

    // approach 2: with Min-Heap (Priority Queue)
    class Solution1 {
        public int[] topKFrequent(int[] nums, int k) {

            int[] answer = new int[k];

            Map<Integer, Integer> map = new HashMap<>();
            for(int num:nums){
                map.put(num, map.getOrDefault(num,0)+1);
            }

            // create a Min-Heap to store elements based on frequency (Ascending order)
            PriorityQueue<int[]> pQue = new PriorityQueue<>((entry1, entry2) -> entry1[1]-entry2[1]);

            // add elements to the Min-Heap
            for(Map.Entry<Integer, Integer> entry: map.entrySet()){
                int[] temp = {entry.getKey(), entry.getValue()};
                if(pQue.size()<k){ // add the first K entry
                    pQue.offer(temp);
                } else if(entry.getValue()>pQue.peek()[1]){ // from k+1, compare with the least frequent element before adding
                    pQue.poll(); // remove the least frequent element
                    pQue.offer(temp); // add the current element
                }
            }

            for(int i = 0; i<k; i++){
                answer[i] = pQue.poll()[0];
            }
            return answer;

        }
    }



}
