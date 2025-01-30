import java.util.*;
import java.io.*;

public class Main {

	static List<Chocolate> cList = new ArrayList<>();
	static char[] src = {'H', 'T', 'C', 'K', 'G'};

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int total = 0;
		for(int i = 0; i < 5; i++) {
			int amount = Integer.parseInt(st.nextToken());
			total += amount;
			cList.add(new Chocolate(src[i], amount));
		}

		int N = Integer.parseInt(br.readLine());
		for(int t = 0; t < N; t++) {
			int old = total;
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 5; i++) {
				int amount = Integer.parseInt(st.nextToken());
				total -= amount;

				for(int iter = 0; iter < 5; iter++) {
					Chocolate current = cList.get(iter);
					if(current.initial == src[i]) {
						current.quantity = current.quantity - amount;
						break;
					}
				}
			}
			Collections.sort(cList);

			int base = old % 10;
			if(base == 1 || base == 0) sb.append(total);
			else {
				int num = total;
				StringBuilder form = new StringBuilder();
				if(num == 0) {
					sb.append(0);
				} else {
					while(num > 0) {
						form.append(num % base);
						num /= base;
					}
				}
				sb.append(form.reverse());
			}
			sb.append("7H").append("\n");

			if(total == 0)
				sb.append("NULL");
			else {
				for(int i = 0; i < 5; i++) {
					Chocolate temp = cList.get(i);
					if(temp.quantity == 0) continue;
					sb.append(cList.get(i).initial);
				}
			}

			sb.append("\n");
		}

		System.out.print(sb);
	}

	static class Chocolate implements Comparable<Chocolate>{
		char initial;
		int quantity;
		Chocolate(char i, int q){
			this.initial = i;
			this.quantity = q;
		}

		@Override
		public int compareTo(Chocolate o) {
			if(this.quantity == o.quantity) return this.initial - o.initial;
			return o.quantity - this.quantity;
		}
	}
}
