import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        // preTemp 는 이전 대각선에서 몇번째 분수까지 있는지 확인하는 변수
        // curCount 는 현재 대각선에서의 분자+분모, temp는 몇번째 분수까지 해당 대각선에 있는지
        long preTemp = 0, curCount = 1, temp = 0;
        if(N==1) System.out.print("1/1");
        else{
            curCount = (long) Math.sqrt(N);
            while(temp < N){
                temp = (curCount * (curCount+1)) / 2;
                if(temp >= N) preTemp = temp - curCount + 1;
                curCount++;
            }
            long bottom, top;
            long interval = N - preTemp;

            // curCount가 짝수인 경우 위에서 아래로
            if(curCount % 2 == 0){
                bottom = 1; top = curCount-1;
                top -= interval;
                bottom += interval;
            }
            else{
                // curCount가 홀수인 경우 아래에서 위로
                bottom = curCount-1; top = 1;
                top += interval;
                bottom -= interval;
            }
            System.out.print(top + "/" + bottom);
        }


    }
}
