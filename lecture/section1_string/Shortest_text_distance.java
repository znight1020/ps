package lecture.section1_string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Shortest_text_distance {
    public ArrayList<Integer> solution(String str){
        String[] strArr = str.split(" ");
        str = strArr[0];
        char c = strArr[1].charAt(0);
        int i;

        int distance1, distance2;

        ArrayList<Integer> targetIndexArr = new ArrayList<>();
        ArrayList<Integer> disArr = new ArrayList<>();

        for(i = 0; i < str.length(); i++){
            if(str.charAt(i) == c) targetIndexArr.add(i);
        }

        i = 0;

        while(i < str.length()){
            if(targetIndexArr.size() >= 2){
                distance1 = Math.abs(i - targetIndexArr.get(0));
                distance2 = Math.abs(i - targetIndexArr.get(1));
                disArr.add(Math.min(distance1, distance2));
                if(i > (targetIndexArr.get(0) + targetIndexArr.get(1)) / 2)
                    targetIndexArr.remove(0);
            } else {
                distance1 = Math.abs(i - targetIndexArr.get(0));
                disArr.add(distance1);
            }
            i++;
        }



        return disArr;
    }
    public static void main(String[] args) throws IOException {
        Shortest_text_distance s = new Shortest_text_distance();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        ArrayList<Integer> disArr;
        disArr = s.solution(str);

        for(int i = 0; i < disArr.size(); i++){
            System.out.print(disArr.get(i) + " ");
        }
    }
}
