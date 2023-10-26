package lecture.section5_stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Curriculum_design {
    public String solution(String necessary, String lecture){
        Queue<Character> q = new LinkedList<>();
        for(char c : necessary.toCharArray()){
            q.offer(c);
        }

        for(char c : lecture.toCharArray()){
            if(!q.isEmpty() && q.peek() == c) q.poll();
        }
        if(q.size() > 0) return "NO";
        else return "YES";
    }

    public static void main(String[] args) throws IOException {
        Curriculum_design c = new Curriculum_design();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String necessary = br.readLine();
        String lecture = br.readLine();

        System.out.println(c.solution(necessary, lecture));
    }
}
