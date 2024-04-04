import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static ArrayList<Integer> numList = new ArrayList<>();
    static Queue<Integer> tempQ = new LinkedList<>();
    static ArrayList<Character> operList = new ArrayList<>();
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i = 0, cnt = 0;
        boolean flag = false;

        String str = "+" + br.readLine();
        char[] sliceStr = str.toCharArray();

        while(i < sliceStr.length){
            if(0 <= sliceStr[i] - '0' && sliceStr[i] - '0' <= 9) { 
                tempQ.add((sliceStr[i] - '0'));
                cnt++;
            }
            else{ 
                operList.add(sliceStr[i]);
                if(i != 0) makeNum(cnt);
                cnt = 0;
            }
            i++;
        }
        makeNum(cnt);

        for(int iter = 0; iter < operList.size(); iter++){
            if(!flag && operList.get(iter) == '-') flag = true;

            if(flag) answer -= numList.get(iter);
            else answer += numList.get(iter);
        }
        System.out.print(answer);
    }

    static void makeNum(int cnt){
        int sum = 0;
        while(!tempQ.isEmpty()){
            sum += tempQ.poll() * (int) Math.pow(10, cnt-1);
            cnt--;
        }
        numList.add(sum);
    }
}
