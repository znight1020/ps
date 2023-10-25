package lecture.section5_stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Iron_bar {

    public int solution(String str){
        int sol = 0;
        char oldC = '0';
        Stack<Character> s = new Stack<>();

        // 이전의 괄호와 비교하여 ) 바로 앞에 || 1. '( 오면 레이저' 2. ')가 왔으면 막대기의 끝'
        for(char c : str.toCharArray()){
            if(c == '(') s.push(c);
            else {
                s.pop();
                if(oldC == '('){
                    sol += s.size();
                }
                else sol++;
            }
            oldC = c;
        }
        return sol;
    }
    public static void main(String[] args) throws IOException {
        Iron_bar iron = new Iron_bar();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        System.out.println(iron.solution(str));
    }
}
