package lecture.section9_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Schedule implements Comparable<Schedule>{
    int earn, deadline;
    public Schedule(int earn, int deadline){
        this.earn = earn;
        this.deadline = deadline;
    }

    @Override
    public int compareTo(Schedule s) {
        if(s.deadline == this.deadline) return s.earn - this.earn;
        else return s.deadline - this.deadline;
    }
}
public class Maximum_earnings_schedule {
    public int solution(ArrayList<Schedule> arr, int max){
        int answer = 0;
        PriorityQueue<Integer> pr = new PriorityQueue<>(Collections.reverseOrder());
        Collections.sort(arr);

        int j = 0;
        for(int i = max; i >= 1; i--){
            for(; j < arr.size(); j++){
                if(arr.get(j).deadline < i) break;
                else pr.add(arr.get(j).earn);
            }
            if(!pr.isEmpty()) answer += pr.poll();
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        Maximum_earnings_schedule m = new Maximum_earnings_schedule();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        ArrayList<Schedule> arr = new ArrayList<>();
        int max = Integer.MIN_VALUE;

        int n = Integer.parseInt(br.readLine());
        int earn, deadline;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            earn = Integer.parseInt(st.nextToken());
            deadline = Integer.parseInt(st.nextToken());
            arr.add(new Schedule(earn, deadline));

            if(max < deadline) max = deadline;
        }

        System.out.println(m.solution(arr, max));
    }
}
