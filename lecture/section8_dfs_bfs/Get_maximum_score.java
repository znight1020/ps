package lecture.section8_dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Problem{
    int point;
    int time;
    Problem(int point, int time){
        this.point = point;
        this.time = time;
    }
}

public class Get_maximum_score {
    // 최적화하려면 Comparable 오버라이딩하여 problem의 time 별로 정렬 후 DFS를 돌리고, timeSum이 timeLimit 넘어가면 return 해야될거같음
    static int timeLimit;
    static int answer = Integer.MIN_VALUE;
    public void DFS(int index, int timeSum, int pointSum, ArrayList<Problem> arr){
        if(arr.size() <= index) return;
        timeSum += arr.get(index).time;
        pointSum += arr.get(index).point;

        if(answer < pointSum && timeSum <= timeLimit ) answer = pointSum;
        DFS(index+1, timeSum, pointSum, arr);
        DFS(index+1, timeSum - arr.get(index).time, pointSum - arr.get(index).point, arr);

    }
    public static void main(String[] args) throws IOException {
        Get_maximum_score g = new Get_maximum_score();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        ArrayList<Problem> arr = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        int problems = Integer.parseInt(st.nextToken());
        timeLimit = Integer.parseInt(st.nextToken());

        for(int i = 0; i < problems; i++){
            st = new StringTokenizer(br.readLine());
            arr.add(new Problem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        g.DFS(0,0,0, arr);
        System.out.println(answer);
    }
}
