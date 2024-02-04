package solved.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

class TownTime{
    int end, time;
    TownTime(int end, int time){
        this.end = end;
        this.time = time;
    }
}
public class Party {
    static ArrayList< ArrayList<TownTime>> graph = new ArrayList<>();
    static ArrayList< ArrayList<HashMap<Integer, Integer>>> mapGraph = new ArrayList<>();
    static int N, M, X;

    static int max = Integer.MIN_VALUE;

    static void DFS(int start, int timeSum){
        if(start == X) {
            System.out.println("했니?");
            max = Math.max(max, timeSum);
            return;
        }

        for(int i = start; i <= N; i++){
            if(i == X) continue;

            if(mapGraph.get(i).get(0).containsKey(X) && mapGraph.get(i).get(0).get(X) > timeSum) {
                System.out.println("start: " + start + " 들어간다!");
                DFS(X, timeSum + mapGraph.get(i).get(0).get(X)); // target 마을에 바로 갈 수 있는 경우
            }
            else{
                if(i+1 == 2) i++;
                //DFS( mapGraph.get(i+1).get(0)., timeSum + mapGraph.get(i).get(0).get( )); // target 마을에 바로 갈 수 없는 경우
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken()); // target

        for(int i = 0; i < N+1; i++){ // N의 수 만큼 ArrayList 생성
            graph.add( new ArrayList<>() );
            mapGraph.get(i).add(new HashMap<>());
        }

        for(int i = 0; i < M; i++){ // 그래프 초기화
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            graph.get(start).add(new TownTime(end, time));

            mapGraph.get(start).get(0).put(end, time);
        }

        for(int i = 0; i < graph.size(); i++){
            System.out.println("ArrayList " + i + "번");
            for(TownTime t :graph.get(i)){
                System.out.println(t.end + " " + t.time + "\t");
            }
            System.out.println();
        }

        DFS(1, 0);
        System.out.println(max);
    }
}
