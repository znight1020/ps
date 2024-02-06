package solved.g2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class PostfixNotation {
    static ArrayList<String> operArr = new ArrayList<>(Arrays.asList("+", "-", "*", "/"));

    static StringBuilder answer = new StringBuilder();

    // ( 만나면 재귀 시작, ) 만나면 return

    static String solution(char[] string){
        String returnString = new String();
        Stack<String> stack = new Stack<>();
        int i = 1;
        int mdCnt = 0; // 곱셈, 나눗셈 연산 개수
        int bracket = 0; // 괄호연산 개수
        String oper, operand;

        stack.push(" " );
        stack.push(String.valueOf(string[0]));
        for(int s = 1; s < string.length; s++){
            if(string[s] == '*' || string[s] == '/') mdCnt++;
            else if(string[s] == '('){
                bracket++;
                while(string[s] != ')') s++;
            }

        }

        while(!stack.isEmpty() && i < string.length){
            String temp = String.valueOf(string[i]);

            // 닫는 괄호까지의 문자열을 전해줌
            if(temp.equals("(")) {
                System.out.println("괄호 in------");
                bracket--;
                int s = i+1;
                String tempString = "";
                while(string[s] != ')') {
                    tempString += string[s];
                    s++;
                }
                tempString += ')';
                solution(tempString.toCharArray());
                i += s+1;
                continue;
            }

            // 닫는 괄호 만나면 return
            else if(temp.equals(")")) {
                System.out.println("괄호 out------");
                return returnString;
            }

            // 이전 요소가 oper 일 경우
            else if(operArr.contains(stack.peek())){
                // 현재의 +, - 를 하기 위해서는 곱셈, 나눗셈, 괄호 연산이 먼저 이루어져야함
                if( bracket == 0 && mdCnt == 0 && (stack.peek().equals("+")) || stack.peek().equals("-")){
                    oper = stack.pop();
                    operand = stack.pop();

                    returnString += operand;
                    returnString += temp;
                    returnString += oper;
                    i++;
                    continue;
                }
                // 곱셈, 나눗셈 연산
                else if(stack.peek().equals("*") || stack.peek().equals("/")){
                    oper = stack.pop();
                    operand = stack.pop();
                    returnString += operand;
                    returnString += temp;
                    returnString += oper;
                    i++;
                    continue;
                }
            }
            stack.push(temp); // 당장 할 일이 없는 요소는 스택에 넣는다.

            i++;
        }
        return returnString;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] string = br.readLine().toCharArray();

        solution(string);
        System.out.print(answer);
    }
}