/**
 * Date: 2025/3/3 12:37
 * Description:
 * You are given a list of servers, each with a unique ID and a status (e.g., "active" or "inactive").
 * When a server fails (becomes inactive), you need to find a replacement server based on specific rules
 * (e.g., the next available server with the lowest ID).
 * Implement a function to handle server replacements efficiently.
 * Example Input:
 * servers = [{"id": 1, "status": "active"}, {"id": 2, "status": "inactive"}, {"id": 3, "status": "active"}]
 * Example Output:
 * If server 1 fails, the replacement could be server 3 (the next available server with the lowest ID).
 */

package extraProblems;

import java.util.PriorityQueue;

public class ServerReplacement {

    // define a server class
    static class Server{
        int id;
        String status;

        Server(int id, String status){
            this.id = id;
            this.status = status;
        }
    }

    // method to find a replacement server for the failed server
    public int findReplacementServer(Server[] servers, int failedServerID){

        // use a PriorityQueue to store active server IDs in ascending order
        PriorityQueue<Integer> activeServers = new PriorityQueue<>();

        // iterate through servers and add active ones to the priority queue
        for(Server server: servers){
            if(server.status.equals("active") && server.id!=failedServerID){
                activeServers.offer(server.id);
            }
        }

        // if no active servers are found, return -1
        if(activeServers.isEmpty()){
            return -1;
        } else {
            // return the server with the smallest ID (front of the priority queue)
            return activeServers.poll();
        }
    }

    public static void main(String[] args){
        ServerReplacement solution = new ServerReplacement();
        Server[] servers = {
                new Server(1, "active"),
                new Server(2, "inactive"),
                new Server(3, "active")
        };

        int failedServerID = 1;
        System.out.println(solution.findReplacementServer(servers, failedServerID));
    }

}
