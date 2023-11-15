package lecture.section9_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Person implements Comparable<Person>{
    int height, weight;
    public Person(int height, int weight){
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Person p) {
        return p.height - this.height;
    }
}

public class Wrestler {

    public int solution(ArrayList<Person> arr){
        int answer = 0;
        int max = Integer.MIN_VALUE;
        Collections.sort(arr);
        for(Person p : arr){
            if(p.weight > max) {
                max = p.weight;
                answer++;
            }
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        Wrestler w = new Wrestler();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Person> arr = new ArrayList<>();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            arr.add(new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        System.out.println(w.solution(arr));
    }
}
