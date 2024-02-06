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

    static String solution(String[] string, int length){
        String returnString = "";
        Stack<String> stack = new Stack<>();
        int i = 1;
        int mdCnt = 0; // 곱셈, 나눗셈 연산 개수
        int bracket = 0; // 괄호연산 개수
        String oper, operand;

        stack.push(" " );
        stack.push(String.valueOf(string[0]));
        for(int s = 1; s < length; s++){
            if(string[s].charAt(0) == '*' || string[s].charAt(0) == '/') mdCnt++;
            else if(string[s].charAt(0) == '('){
                bracket++;
                while(string[s].charAt(0) != ')') s++;
            }

        }

        while(!stack.isEmpty() && i < string.length){
            String temp = String.valueOf(string[i]);

            // 닫는 괄호까지의 문자열을 전해줌
            if(temp.equals("(")) {
                System.out.println("괄호 in------");
                bracket--;
                int s = i+1;
                String[] tempString = new String[101];
                while(string[s].charAt(0) != ')') {
                    tempString[i] = string[s];
                    s++;
                }
                tempString[s] = ")";
                temp = solution(tempString,s - i);
                System.out.println("바뀐 temp: " + temp);
                for(String str : stack){
                    System.out.println(str);
                }
            }

            // 닫는 괄호 만나면 return
            else if(temp.equals(")")) {
                System.out.println("괄호 out------");
                return returnString;
            }

            // 이전 요소가 oper 일 경우
            else if(operArr.contains(stack.peek())){
                System.out.println("stack.peek(): " + stack.peek() + ", temp: " + temp);
                // 현재의 +, - 를 하기 위해서는 곱셈, 나눗셈, 괄호 연산이 먼저 이루어져야함
                System.out.println(mdCnt);
                System.out.println(bracket);
                System.out.println(temp);
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
                    mdCnt--;
                    i++;
                    continue;
                }
            }
            stack.push(temp); // 당장 할 일이 없는 요소는 스택에 넣는다.

            i++;

            System.out.println();
            System.out.println("Stack:");
            for(String str : stack){
                System.out.print(str+ " ");
            }
            System.out.println();
        }

        return returnString;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] string = br.readLine().toCharArray();
        String[] str = new String[string.length];
        for(int i = 0; i < str.length; i++){
            str[i] = String.valueOf(string[i]);
        }


        System.out.print(solution(str, str.length));
    }
}