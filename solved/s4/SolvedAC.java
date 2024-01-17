package s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class SolvedAC {

    public int solution(ArrayList<Integer> suggests, int size){
        // 15% 구하기
        double a = (double)size * (15.0 / 100.0);
        int except = (int)Math.round(a);
        Collections.sort(suggests);

        double sum = 0;

        for(int i = except; i < size-except; i++){
            sum += suggests.get(i);
        }
        int aver = (int) Math.round(sum / (size - (2 * except)));
        
        return aver;
    }

    public static void main(String[] args) throws IOException {
        SolvedAC s = new SolvedAC();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine()); // 의견의 개수
        
        ArrayList<Integer> suggests = new ArrayList<>();

        for(int i = 0; i < size; i++){
            suggests.add(Integer.parseInt(br.readLine()));
        }

        System.out.println(s.solution(suggests, size));
    }
}
