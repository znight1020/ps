package lecture.section2_array;

import java.util.Scanner;

public class Visible_student {
    public int solution(int[] numArr) {
        int max = numArr[0], sum = 1;
        max = numArr[0];
        for(int i = 0; i < numArr.length; i++){
            if(numArr[i] > max){
                sum += 1;
                max = numArr[i];
            }
        }

        return sum;
    }
    public static void main(String[] args) {
        Visible_student v = new Visible_student();
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt(), i;
        int[] numArr = new int[num];
        for(i = 0; i < num; i++){
            numArr[i] = scan.nextInt();
        }

        int sum = v.solution(numArr);
        System.out.println(sum);
    }
}
