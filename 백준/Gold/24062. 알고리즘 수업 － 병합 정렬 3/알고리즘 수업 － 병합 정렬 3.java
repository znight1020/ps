import java.util.*;
import java.io.*;

public class Main {

  static boolean flag = false;
  static int[] A, B, tmp;
  static int N, idx;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());
    A = new int[N];
    B = new int[N];
    tmp = new int[N];

    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < N; i++) B[i] = Integer.parseInt(st.nextToken());

    if(Arrays.equals(A, B)) flag = true;
    else mergeSort(A, 0, A.length-1);
    System.out.print(flag ? 1 : 0);
  }

  static void mergeSort(int[] arr, int p, int r) {
    if(p < r) {
      int q = (p+r) / 2;
      mergeSort(arr, p, q);
      mergeSort(arr, q+1, r);
      merge(arr, p, q, r);
    }
  }

  static void merge(int[] arr, int p, int q, int r) {
    int i = p, j = q+1, t = 0;
    while(i <= q && j <= r) {
      if(A[i] <= A[j]) tmp[t++] = arr[i++];
      else tmp[t++] = arr[j++];
    }

    while(i <= q) tmp[t++] = arr[i++];
    while(j <= r) tmp[t++] = arr[j++];

    i = p; t = 0;
    while(i <= r) {
      arr[i++] = tmp[t++];
      if (!flag) {
        while (true) {
          if (A[idx] == B[idx]) {
            if (idx == A.length-1) {
              flag = true;
              break;
            }
            idx++;
          } else break;
        }
      }
    }
  }
}
