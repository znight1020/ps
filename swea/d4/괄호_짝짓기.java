package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class 괄호_짝짓기 {

    static ArrayDeque<Character> dq;
    static int solution(int n, char[] c){
        for(int i = 0; i < n; i++){
            if(c[i] == '(' || c[i] == '[' || c[i] == '{' || c[i] == '<' ){
                dq.push(c[i]);
            } else {
                if(c[i] == ')' && dq.peek() == '(') dq.pop();
                else if(c[i] == ']' && dq.peek() == '[') dq.pop();
                else if(c[i] == '}' && dq.peek() == '{') dq.pop();
                else if(c[i] == '>' && dq.peek() == '<') dq.pop();

                else break;
            }
        }

        if(dq.isEmpty()) return 1;
        else return 0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = 1; t <= 10; t++){
            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();
            dq = new ArrayDeque<>();

            System.out.println("#" + t + " " + solution(n, str.toCharArray()));
        }
    }
}
