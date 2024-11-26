import java.util.*;
import java.io.*;

public class Main
{
    static int[] students;
    static int steps;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		
		for(int i = 1; i <= T; i++) {
		    st = new StringTokenizer(br.readLine());
		    students = new int[21];
		    steps = 0;
		    
		    int trash = Integer.parseInt(st.nextToken());
		    
		    int iter = 0;
		    while(st.hasMoreTokens()) {
		        students[iter] = Integer.parseInt(st.nextToken());
		        if (iter != 0) swap(iter);
		        iter++;
		    }
		    sb.append(i).append(" ").append(steps).append("\n");
		}
		System.out.print(sb);
	}
	
	static void swap(int size) {
	    int standard = students[size];
	    for(int i = size-1; i >= 0; i--) {
	        if (standard < students[i]) steps++;
	    }
	}
}
