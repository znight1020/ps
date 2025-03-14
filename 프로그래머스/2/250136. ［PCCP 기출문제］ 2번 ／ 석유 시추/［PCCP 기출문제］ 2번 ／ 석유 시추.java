import java.util.*;
import java.io.*;

class Solution {
    
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static int id = 2, n, m;
    static boolean[][] vtd;
    static Map<Integer, Integer> map = new HashMap<>();
    static Set<Integer> set;
    
    public int solution(int[][] land) {
        int answer = 0;
        n = land.length;
        m = land[0].length;
        vtd = new boolean[n][m];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!vtd[i][j] && land[i][j] == 1) {
                    expandArea(land, i, j, id);
                    id++;
                }
            }
        }
        
        for(int i = 0; i < m; i++) {
            int sum = 0;
            set = new HashSet<>();
            dig(land, i);
            for(int n : set) sum += map.get(n);
            
            answer = Math.max(answer, sum);
        }
        return answer;
    }
    
    static void dig(int[][] land, int row) {
        for(int col = 0; col < n; col++) {
            int temp = land[col][row];
            if(temp >= 2) set.add(temp);
        }
    }
    
    static void expandArea(int[][] land, int y, int x, int id) {
        int cnt = 0;
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(y, x, id));
        
        while(!q.isEmpty()) {
            Point p = q.poll();

            if(vtd[p.y][p.x]) continue;

            vtd[p.y][p.x] = true;
            land[p.y][p.x] = id;
            cnt++;

            for(int i = 0; i < 4; i++) {
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];
                if(ny < 0 || ny >= n || nx < 0 || nx >= m || land[ny][nx] == 0 || vtd[ny][nx]) continue;
                q.add(new Point(ny, nx, id));
            }
        }   
        map.put(id, cnt);
    }
    
    static class Point {
        int y, x, id;
        Point(int y, int x, int id) {
            this.y = y;
            this.x = x;
            this.id = id;
        }
    }
}