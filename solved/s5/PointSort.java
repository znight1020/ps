package s5;

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
        if(this.y == o.y) return this.x - o.x;
        else return this.y - o.y;
    }
}

public class PointSort {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Point p;
        ArrayList<Point> arr = new ArrayList<>();

        int pointNum = Integer.parseInt(br.readLine());

        for(int i = 0; i < pointNum; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            p = new Point(x, y);
            arr.add(p);
        }

        Collections.sort(arr);

        for(Point point : arr){
            sb.append(point.x + " "  + point.y + "\n");
        }

        System.out.print(sb);
    }
}
