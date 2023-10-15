package lecture.section2_array;

import java.util.Scanner;

public class Rock_paper_scissors {
    public char[] solution(int num, int[] a, int[] b){
        int i;
        char[] vArr = new char[num];
        for(i = 0; i < num; i++){
            if(a[i] == b[i]) vArr[i] = 'D';
            else if((a[i] == 1 && b[i] == 2) || (a[i] == 2 && b[i] == 3) || (a[i] == 3 && b[i] == 1)) vArr[i] = 'B';
            else if((a[i] == 1 && b[i] == 3) || (a[i] == 2 && b[i] == 1) || (a[i] == 3 && b[i] == 2)) vArr[i] = 'A';
        }
        return vArr;
    }
    public static void main(String[] args) {
        Rock_paper_scissors r = new Rock_paper_scissors();
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt(), i;
        int[] a = new int[num], b = new int[num];
        char[] vArr;
        for(i = 0; i < num; i++){
            a[i] = scan.nextInt();
        }
        for(i = 0; i < num; i++){
            b[i] = scan.nextInt();
        }

        vArr = r.solution(num, a, b);
        for(i = 0; i < num; i++){
            System.out.println(vArr[i]);
        }


    }
}
