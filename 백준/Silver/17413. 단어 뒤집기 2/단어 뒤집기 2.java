import java.util.*;
import java.io.*;

public class Main {

  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    
    StringBuilder sb = new StringBuilder();
    StringBuilder temp = new StringBuilder();
    boolean flag = false;
    
    for(int i = 0; i < str.length(); i++){
      char c = str.charAt(i);
      
      if(c == '<') {
        sb.append(temp.reverse());
        temp = new StringBuilder();
        flag = true;
        temp.append(c);
      }
      
      else if(c == '>'){
        flag = false;
        temp.append(c);
        sb.append(temp);
        
        temp = new StringBuilder();
      } else if(!flag && c == ' '){
        sb.append(temp.reverse()).append(' ');
        temp = new StringBuilder();
      } else {
        temp.append(c);
      }
    }
    
    if(temp.length() > 0) sb.append(temp.reverse());
    
    System.out.println(sb);
    
  }

}