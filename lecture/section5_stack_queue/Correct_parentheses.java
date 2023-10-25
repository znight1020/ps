package lecture.section5_stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Correct_parentheses {
    public String solution(String str){
        Stack<Character> s = new Stack<>();
        for(char c : str.toCharArray()){
            if(s.isEmpty() && c == ')') return "NO";
            else if(c == ')' && s.peek() == '(') s.pop();
            else s.push(c);
        }

        if(s.isEmpty()) return "YES";
        else return "NO";
    }

    public static void main(String[] args) throws IOException {
        Correct_parentheses c = new Correct_parentheses();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        System.out.println(c.solution(str));
    }
}
