package implementation.class2;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class S18110_solved_ac {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine());
        double sum = 0;

        ArrayList<Integer> numArr = new ArrayList<>();

        while(numArr.size() < size){
            int num = Integer.parseInt(br.readLine());
            numArr.add(num);
        }

        Arrays.sort(new ArrayList[]{numArr});

        // 위에서 15%, 아래에서 15%
        long remove = Math.round(size * 0.15);

        // 제외
        for(int i = 0; i < remove; i++){
            numArr.remove(0);
            numArr.remove(numArr.size() - 1);
        }

        for(int i = 0; i < numArr.size(); i++){
            sum += numArr.get(i);
        }
        sum = Math.round(sum / numArr.size());

        bw.write(String.valueOf((int)sum));
        bw.flush();
        bw.close();
    }
}
