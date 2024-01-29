package solved.s5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GroupWordChecker {
    static int answer = 0;
    static void solution(String str){
        char[] charArr = str.toCharArray();

        ArrayList<Character> checked = new ArrayList<>();
        boolean flag = false;
        for(int i = 0; i < charArr.length; i++){
            if(i+1 < charArr.length && charArr[i] == charArr[i+1]) continue;
            if(!checked.contains(charArr[i])) checked.add(charArr[i]);
            else {
                flag = true;
                break;
            }
        }

        if(!flag) answer++;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str;
        for(int t = 0; t < N; t++){
            str = br.readLine();
            solution(str);
        }

        System.out.print(answer);
    }
}
