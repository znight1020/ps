package lecture.section5_stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Remove_parenthesis_character {
    public String solution(String str){
        Stack<Character> s = new Stack<>();
        String sol = "";
        for(char c : str.toCharArray()){
            if(s.isEmpty() && !(c == '(' || c == ')')) {
                sol += c;
                continue;
            }

            if(s.isEmpty() && c == ')') return "incorrect";
            else if(c == ')' && s.peek() == '(') s.pop();
            else if(c == '(')s.push(c);
        }

        return sol;
    }

    public static void main(String[] args) throws IOException {
        Remove_parenthesis_character r = new Remove_parenthesis_character();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        System.out.println(r.solution(str));
    }
}
