package lecture.section2_array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Temporary_class_leader {
    public int solution(int num, int[][] arr){
        int i, j, k, leader = 0, leader_cnt = 0;
        ArrayList<Integer> tempArr;
        for(i = 0; i < num; i++){
            tempArr = new ArrayList<>();
//            System.out.print((i+1) + "번 학생: ");
            for(j = 0; j < 5; j++){
                k = 0;
                while(k < num){
                    if(tempArr.contains(k)) {
                    } else{
                        if (arr[i][j] == arr[k][j] && k != i) tempArr.add(k);
                    }
                    k++;
                }
            }
//            for(int n = 0; n < tempArr.size(); n++){
//                System.out.print((tempArr.get(n) + 1) + "번 학생과 같은반, ");
//            }
//            System.out.println();
            if(tempArr.size() > leader_cnt) {
                leader = i;
                leader_cnt = tempArr.size();
            }
        }
        return leader + 1;
    }
    public static void main(String[] args) throws IOException {
        Temporary_class_leader t = new Temporary_class_leader();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i, j, num = Integer.parseInt(br.readLine());
        int[][] students = new int[num][5];
        String str;
        StringTokenizer st;
        for(i = 0; i < num; i++){
            str = br.readLine();
            st = new StringTokenizer(str);
            for(j = 0; j < 5; j++){
                students[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(t.solution(num, students));
    }
}
