import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int multi = 1;
		
		char[] charList = str.toCharArray();
		char pre = charList[0];
		
		for(int i = 0; i< charList.length; i++) {
		    int numOperand = 10;
		    int charOperand = 26;
		    
		    if (i !=0 && pre == charList[i] && charList[i] == 'd') numOperand--;
		    else if (i !=0 && pre == charList[i] && charList[i] == 'c') charOperand--;
		    
		    if (charList[i] == 'd') multi *= numOperand;
		    else multi *= charOperand;
		    
		    pre = charList[i];
		}
		System.out.println(multi);
	}
}
