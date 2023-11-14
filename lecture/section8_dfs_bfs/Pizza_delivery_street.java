package lecture.section8_dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Coordinate{
    int x, y;
    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Pizza_delivery_street {
    static int n, m, size, answer = Integer.MAX_VALUE;
    static int[] com;

    static ArrayList<Coordinate> house = new ArrayList<>();
    static ArrayList<Coordinate> pizza = new ArrayList<>();

    public void DFS(int L, int s) {
        if(L == m){
            int sum = 0;
            for(Coordinate c : house){
                int distance = Integer.MAX_VALUE;
                for(int index : com){
                    distance = Math.min(Math.abs(c.x - pizza.get(index).x) + Math.abs(c.y - pizza.get(index).y), distance);
                }
                sum += distance;
            }
            answer = Math.min(sum, answer);
        }
        else{
            for(int i = s; i < size; i++){
                com[L] = i;
                DFS(L+1, i+1);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        Pizza_delivery_street p = new Pizza_delivery_street();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int temp;

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        com = new int[m];

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++){
                temp = Integer.parseInt(st.nextToken());
                if(temp == 1) house.add(new Coordinate(i, j));
                else if(temp == 2) pizza.add(new Coordinate(i, j));
            }
        }
        size = pizza.size();

        p.DFS(0,0);
        System.out.println(answer);
    }
}
