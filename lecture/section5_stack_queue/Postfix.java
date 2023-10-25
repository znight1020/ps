package lecture.section5_stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Postfix {
    public int solution(String str){
        int num1, num2;
        Stack<Integer> s = new Stack<>();

        for(char c : str.toCharArray()){
            switch (c){
                case '+':
                    num2 = s.pop();
                    num1 = s.pop();
                    s.push(num1+num2);
                    break;
                case '-':
                    num2 = s.pop();
                    num1 = s.pop();
                    s.push(num1-num2);
                    break;
                case '*':
                    num2 = s.pop();
                    num1 = s.pop();
                    s.push(num1*num2);
                    break;
                case '/':
                    num2 = s.pop();
                    num1 = s.pop();
                    s.push(num1/num2);
                    break;
                default:
                    s.push(c-'0');
                    break;
            }
        }
        return s.get(0);
    }
    public static void main(String[] args) throws IOException {
        Postfix p = new Postfix();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        System.out.println(p.solution(str));
    }
}
