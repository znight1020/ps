package lecture.section9_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Time implements Comparable<Time>{
    int start, end;
    public Time(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Time o) {
        if(this.end == o.end) return this.start - o.start;
        else return this.end - o.end;
    }
}
public class Meeting_room_assignment {
    public int solution(ArrayList<Time> arr){
        int answer = 0, current = Integer.MIN_VALUE;
        Collections.sort(arr);
        for(Time t : arr){
            if(t.start >= current) {
                current = t.end;
                answer++;
            }
            //System.out.println("start: " + t.start + ", end: " + t.end);
        }
        //System.out.println();
        return answer;
    }
    public static void main(String[] args) throws IOException {
        Meeting_room_assignment m = new Meeting_room_assignment();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Time> arr = new ArrayList<>();
        StringTokenizer st;
        int start, end;
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            arr.add(new Time(start, end));
        }
        System.out.println(m.solution(arr));
    }
}
