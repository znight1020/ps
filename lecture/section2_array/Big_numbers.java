package lecture.section2_array;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Big_numbers {
    public ArrayList<Integer> solution(ArrayList<Integer> numArr){
        int i = 0;

        ArrayList<Integer> solArr = new ArrayList<>();
        solArr.add(numArr.get(0));

        while(i < numArr.size() - 1){
            if(numArr.get(i+1) > numArr.get(i)){
                solArr.add(numArr.get(i + 1));
            }
            i++;
        }
        return solArr;
    }
    public static void main(String[] args) throws IOException {
        Big_numbers b = new Big_numbers();
        Scanner scan = new Scanner(System.in);
        int num = (scan.nextInt()), i;
        ArrayList<Integer> numArr = new ArrayList<>();
        for(i = 0; i < num; i++){
            numArr.add(scan.nextInt());
        }
        numArr = b.solution(numArr);

        for(i = 0; i < numArr.size(); i++){
            System.out.print(numArr.get(i) + " ");
        }
    }
}
