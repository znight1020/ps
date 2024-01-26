package s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.

    X가 3으로 나누어 떨어지면, 3으로 나눈다.
    X가 2로 나누어 떨어지면, 2로 나눈다.
    1을 뺀다.
    정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.
    
    입력값 1 < n < 1,000,000
*/
public class MakeOne {
    static final int INF = 1000000;
    static int answer = Integer.MAX_VALUE;
    static ArrayList<Integer> vtd;
    void DFS(int num, int cnt){
        int n1, n2, temp;
        if(num == 1) {
            answer = Math.min(answer, cnt);
            return;
        } else if(num == INF) return;
        else{
            if(!vtd.contains(num) && num > 1){
                if(devideThree(num) > subDevideThree(num)) n1 = subDevideThree(num);
                else n1 = devideThree(num);
                
                if(devideTwo(num) > subDevideTwo(num)) n2 = subDevideTwo(num);
                else n2 = devideTwo(num);
                
                temp = Math.min(n1, n2);
                if(temp == devideThree(num) || temp == devideTwo(num)) cnt++;
                else cnt += 2;

                vtd.add(num);
                //System.out.println("temp: " + temp + ", cnt " + cnt);
                DFS(n1, cnt);
                DFS(n2, cnt);
                DFS(sub(n1), cnt);
                DFS(sub(n2), cnt);
                DFS(temp, cnt++);
            } 
            else return;
        }
    }


    int devideThree(int num){
        if(num % 3 == 0) return num / 3;
        else return INF;
    }

    int devideTwo(int num){
        if(num % 2 == 0) return num / 2;
        else return INF;
    }
    
    int subDevideThree(int num){
        num -= 1;
        if(num % 3 == 0) return num / 3;
        else return devideThree(num+1);
    }

    int subDevideTwo(int num){
        num -= 1;
        if(num % 2 == 0) return num / 2;
        else return devideTwo(num+1);
    }

    int sub(int num){
        return num--;
    }

    public static void main(String[] args) throws IOException{
        MakeOne m = new MakeOne();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        vtd = new ArrayList<>();

        m.DFS(num, 0);

        System.out.println(answer);
        

    }
    
}
