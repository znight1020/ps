package solved.s5;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Stick { // 막대기
    static int currentStick = 0;
    static int cnt = 0;
    static int X;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int stick = 64;
        X = Integer.parseInt(br.readLine());
        
        solution(stick);

        System.out.print(cnt);
    }

    static void solution(int stick){
        if(currentStick == X || stick == 0) return;
        
        
        if(currentStick + stick <= X){
            currentStick += stick;
            cnt++;
        }
        solution(stick/2);
    }
}
