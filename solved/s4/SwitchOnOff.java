package solved.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Student{
    int sex;
    int num;

    Student(int sex, int num){
        this.sex = sex;
        this.num = num;
    }
}
public class SwitchOnOff {
    static int[] switchArr;
    static ArrayList<Student> stuArr = new ArrayList<>();

    static void convert(int n){
        if(switchArr[n] == 1) switchArr[n] = 0;
        else switchArr[n] = 1;
    }
    static void solution(){

        int tempNum;
        for(int i = 0; i < stuArr.size(); i++){
            if(stuArr.get(i).sex == 1) { // 남학생의 경우 배수의 스위치 번호 바꾼다.
                tempNum = stuArr.get(i).num;
                for(int j = 1; j < switchArr.length; j++) if(j % tempNum == 0) convert(j);
            } else{
                tempNum = stuArr.get(i).num;
                int left = tempNum - 1, right = tempNum + 1;
                if(left >= 1 && right < switchArr.length){
                    if(switchArr[left] == switchArr[right]){ // 주변 상태가 같다면 같은 스위치 모두 바꿈
                        convert(left);
                        convert(right);
                        left--;
                        right++;
                        while(left >= 1 && right < switchArr.length && switchArr[left] == switchArr[right]){
                            convert(left);
                            convert(right);
                            left--;
                            right++;
                        }
                    }
                    convert(tempNum); // 주변 상태가 다르므로 자신의 스위치 상태만 바꿈
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        switchArr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            switchArr[i] = Integer.parseInt(st.nextToken());
        }

        int students = Integer.parseInt(br.readLine());
        // 남학생 1, 여학생 2
        for(int i = 0; i < students; i++){
            st = new StringTokenizer(br.readLine());
            stuArr.add(new Student(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        switchArr[0] = -1999;
        solution();

        for(int i = 1; i < switchArr.length; i++){
            System.out.print(switchArr[i] + " ");
            if(i > 1 && i % 20 == 0) System.out.println();
        }

    }
}
