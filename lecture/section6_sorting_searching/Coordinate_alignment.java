package lecture.section6_sorting_searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


class Point implements Comparable<Point>{
    int x;
    int y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        /** 해당 메소드에서
            return 값이 음수인 경우, 오름차순 정렬이
            return 값이 양수인 경우, 내림차순 정렬이 된다. */
        if(this.x == o.x) return this.y - o.y;
        else return this.x - o.x;
    }
}
public class Coordinate_alignment {
    public static void main(String[] args) throws IOException {
        Coordinate_alignment c = new Coordinate_alignment();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Point p;
        int x, y;
        ArrayList<Point> arr = new ArrayList<>();
        int size = Integer.parseInt(br.readLine());


        for(int i = 0; i < size; i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            p = new Point(x,y);
            arr.add(p);
        }
        // Colletions.sort 호출 시 Comparable의 compareTo 메소드를 통해 정렬이 실행되므로,
        // 위 Point class에서 오버라이딩한 Point를 Param으로 받는 compareTo 메소드가 실행된다.
        Collections.sort(arr);

        for(Point point : arr){
            System.out.println(point.x + " " + point.y);
        }
    }
}
