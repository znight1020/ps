package lecture.section2_array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Mentoring {
    public int solution(int student, int test, int[][] arr) {
        int i, j, sol = 0, cnt = 1;
        boolean flag;
        ArrayList<Integer> temp;
        while(cnt <= student){
            temp = new ArrayList<>();
            for(i = 1; i <= student; i++){
                temp.add(i);
            }

            for(i = 0; i < test; i++){
                flag = false; // 각 테스트에서 자신을 지나칠때 flag = true
                for(j = 0; j < student; j++){
                    if(!flag && temp.contains(arr[i][j])) // 자신보다 높은 학생 삭제
                        temp.remove(temp.indexOf(arr[i][j]));

                    if(arr[i][j] == cnt)
                        flag = true; // 자신을 지나침
                        //System.out.print(" 자신을 지나침 arr[i][j] = " + arr[i][j] + ", 자신의 번호 = " + cnt);
                }
            }
            sol += temp.size();
            cnt++;
        }
        return sol;
    }
    public static void main(String[] args) throws IOException {
        Mentoring m = new Mentoring();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i, j;
        StringTokenizer st;
        String str = br.readLine();
        st = new StringTokenizer(str);

        int student = Integer.parseInt(st.nextToken());
        int test = Integer.parseInt(st.nextToken());
        int[][] arr = new int[test][student];

        for(i = 0; i < test; i++){
            str = br.readLine();
            st = new StringTokenizer(str);
            for(j = 0; j < student; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(m.solution(student, test, arr));
    }
}
