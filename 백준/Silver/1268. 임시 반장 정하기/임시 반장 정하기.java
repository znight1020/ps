import java.util.*;
import java.io.*;

public class Main {

  static int N, answer = 0, max = 0;
  static List<Student> students = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    for(int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int c1 = Integer.parseInt(st.nextToken());
      int c2 = Integer.parseInt(st.nextToken());
      int c3 = Integer.parseInt(st.nextToken());
      int c4 = Integer.parseInt(st.nextToken());
      int c5 = Integer.parseInt(st.nextToken());
      Student student = new Student(i+1, List.of(c1,c2,c3,c4,c5));
      students.add(student);
    }

    for(int i = 0; i < N; i++) {
      Student s = students.get(i);
      for(int j = 0; j < 5; j++) {
        int standard = s.classroom.get(j);

        for(int k = 0; k < N; k++) {
          Student comparison = students.get(k);
          if(standard == comparison.classroom.get(j)) {
            s.classmate.add(comparison.num);
          }
        }
      }
    }

    for(int i = 0; i < N; i++) {
      Student s = students.get(i);
      int size = s.classmate.size();
      if(size > max) {
        max = size;
        answer = s.num;
      }
    }

    System.out.println(answer);
  }

  static class Student {
    int num;
    List<Integer> classroom;
    Set<Integer> classmate;

    Student(int num, List<Integer> classroom) {
      this.num = num;
      this.classroom = classroom;
      this.classmate = new HashSet<>();
    }
  }
}
