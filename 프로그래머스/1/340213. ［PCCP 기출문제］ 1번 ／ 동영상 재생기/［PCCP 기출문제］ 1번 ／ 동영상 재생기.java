import java.util.*;
import java.io.*;

class Solution {
    
    static int[] opening = new int[2];
    static int total, current;
    
    public String solution(
        String video_len, String pos, 
        String op_start, String op_end, String[] commands
    ) {
        String answer = "";
        
        String[] a = video_len.split(":");
        total = Integer.parseInt(a[0]) * 60 + Integer.parseInt(a[1]);
        
        String[] b = pos.split(":");
        current = Integer.parseInt(b[0]) * 60 + Integer.parseInt(b[1]);
        
        String[] c = op_start.split(":");
        opening[0] = Integer.parseInt(c[0]) * 60 + Integer.parseInt(c[1]);
        
        String[] d = op_end.split(":");
        opening[1] = Integer.parseInt(d[0]) * 60 + Integer.parseInt(d[1]);
        skip();
        
        for(String str : commands) {    
            if(str.equals("next")) moveFront();
            else moveBack();
            skip();
        }
        
        String min = String.valueOf(current / 60);
        String sec = String.valueOf(current % 60);
        
        if(min.length() < 2) min = "0" + min;
        if(sec.length() < 2) sec = "0" + sec;
        
        answer = min + ":" + sec;
        return answer;
    }
    
    static void moveBack() {
        current -= 10;
        if(current < 0) current = 0;
    }
    
    static void moveFront() {
        current += 10;
        if(current > total) current = total;
    }
    static void skip() {
        if(current >= opening[0] && current <= opening[1]) current = opening[1];
    }
}