/**
 * Date: 2025/3/3 12:33
 * Description:
 * Given a 2D array representing the schedule of meeting rooms,
 * where each row represents a room and each column represents a time slot (e.g., intervals[i] = [start_time, end_time]),
 * determine the minimum number of meeting rooms required to accommodate all meetings without overlapping.
 * Example Input:
 * intervals = [[0, 30], [5, 10], [15, 20]]
 * Example Output:
 * 2 (Two rooms are needed because the first and second meetings overlap.)
 */

package extraProblems;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms {
    public int minMeetingRooms(int[][] intervals){

        if(intervals == null || intervals.length == 0){
            return 0;
        }

        // sort intervals based on start time
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);

        // use a min-heap to tract the end time of meetings
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // add the first meeting's end time to the minHeap
        minHeap.offer(intervals[0][1]);

        for(int i = 1; i<intervals.length; i++){
            int currentStart = intervals[i][0];
            int earliestEnd = minHeap.peek();

            // if the current meeting can use the room after the earliest end time
            if (currentStart>=earliestEnd){
                minHeap.poll();
            }

            // add the current meeting's end time to the heap
            minHeap.offer(intervals[i][1]);
        }

        // the size of the heap is the number of rooms required
        return minHeap.size();
    }

    public static void main(String[] args) {
        MeetingRooms solution = new MeetingRooms();
        int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println(solution.minMeetingRooms(intervals)); // Output: 2
    }
}
