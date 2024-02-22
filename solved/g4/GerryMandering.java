package solved.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class GerryMandering {
    static ArrayList<Town> city = new ArrayList<>();
    static ArrayList<Integer>[] cityGraph;
    static boolean[] vtd;
    static boolean[] select;

    static ArrayList<Town> arr1 = new ArrayList<>();
    static ArrayList<Town> arr2 = new ArrayList<>();

    static int answer = Integer.MAX_VALUE;
    static int N;

    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        city.add(new Town(0, 0)); // 0 dummy

        int idx = 1;
        while(st.hasMoreTokens()) {
            city.add(new Town(idx, Integer.parseInt(st.nextToken())));
            idx++;
        }

        cityGraph = new ArrayList[N+1];
        vtd = new boolean[N+1];
        select = new boolean[N+1];

        for(int i = 0; i <= N; i++) cityGraph[i] = new ArrayList<>();

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            int iter = Integer.parseInt(st.nextToken());
            for(int j = 0; j < iter; j++){
                cityGraph[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        subset(1);

        if(answer == Integer.MAX_VALUE) System.out.print(-1);
        else System.out.println(answer);
    }

    static void subset(int idx){
        if(idx == city.size() - 1){
            vtd = new boolean[N+1];
            arr1.clear();
            arr2.clear();
            for(int i = 1; i < city.size(); i++){
                if(select[i]) arr1.add(city.get(i));
                else arr2.add(city.get(i));
            }

            if(arr1.isEmpty() || arr2.isEmpty()) return;

            int sum1 = arr1.stream().mapToInt(num -> num.people).sum();
            int sum2 = arr2.stream().mapToInt(num -> num.people).sum();
            if(Math.abs(sum1 - sum2) < answer && Acheck(arr1) && Bcheck(arr2)) answer = Math.min(Math.abs(sum1 - sum2), answer);

            return;
        }

        select[idx] = true;
        subset(idx+1);
        select[idx] = false;
        subset(idx+1);

    }

    static boolean Acheck(ArrayList<Town> arr){
        int cnt = 0;
        q.add(arr.get(0).data);
        while(!q.isEmpty()){
            int temp = q.poll();
            if(vtd[temp] || !select[temp]) continue;
            vtd[temp] = true;
            for(int i = 0; i < cityGraph[temp].size(); i++) q.add(cityGraph[temp].get(i));

            cnt++;
        }
        return cnt == arr.size();
    }

    static boolean Bcheck(ArrayList<Town> arr){
        int cnt = 0;
        q.add(arr.get(0).data);
        while(!q.isEmpty()){
            int temp = q.poll();
            if(vtd[temp] || select[temp]) continue;
            vtd[temp] = true;
            for(int i = 0; i < cityGraph[temp].size(); i++) q.add(cityGraph[temp].get(i));
            cnt++;
        }
        return cnt == arr.size();
    }

    static class Town{
        int data, people;

        public Town(int data, int people){
            this.data = data;
            this.people = people;
        }
    }
}
