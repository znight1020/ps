import java.util.*;

class Solution {
    // row, col 상하 이동을 먼저하기
    Map<Integer, Integer> map = new HashMap<>();
    List<List<int[]>> timelines = new ArrayList<>();
    
    public int solution(int[][] points, int[][] routes) {
        int answer = 0, rId = routes.length, rR = routes[0].length;
        for(int i = 0; i < 1_000_001; i++) timelines.add(new ArrayList<>());
        
        for(int i = 0; i < rId; i++) {
            int sId = routes[i][0] - 1, time = 0;
            Robot robot = new Robot(points[sId][0], points[sId][1]);
            timelines.get(time).add(new int[]{robot.r, robot.c});
            
            for(int j = 1; j < rR; j++) {
                sId = routes[i][j] - 1;
                int[] target = new int[2];
                int targetR = points[sId][0];
                int targetC = points[sId][1];
                
                boolean flag = false;
                
                while(!flag) {
                    time++;
                    if(robot.r != targetR) moveR(robot, targetR);
                    else if(robot.c != targetC) moveC(robot, targetC);
                    timelines.get(time).add(new int[]{robot.r, robot.c});
                    if(robot.r == targetR && robot.c == targetC) flag = true;
                }
            }
        }
        
        for(List<int[]> seconds : timelines) {
            Map<Integer, Integer> map = new HashMap<>();
            for(int[] p : seconds) {
                int key = 100*p[0] + p[1];
                map.put(key, map.getOrDefault(key,0)+1);
            }

            for(int n : map.values()) if(n >= 2) answer++;
        }
        return answer;
    }
    
    static void moveR(Robot robot, int targetR) {
        int v = robot.r - targetR;
        if(v < 0) robot.r++;
        else robot.r--;
    }
    
    static void moveC(Robot robot, int targetC) {
        int v = robot.c - targetC;
        if(v < 0) robot.c++;
        else robot.c--;
    }
    
    static class Robot {
        int r, c;
        Robot(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}