import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Set<String> set = new HashSet<>();
		String str = new BufferedReader(new InputStreamReader(System.in)).readLine();
		for(int i = 0; i < str.length(); i++) for(int j = i+1; j < str.length()+1; j++) set.add(str.substring(i, j));
		System.out.print(set.size());
	}
}
