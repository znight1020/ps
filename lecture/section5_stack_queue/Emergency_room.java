package lecture.section5_stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Patient{
    int index;
    int weight;
    Patient(int index, int weight){
        this.index = index;
        this.weight = weight;
    }

}
public class Emergency_room {
    public int solution(int target, Queue<Patient> patients){
        int sol = 0;
        Patient patient;
        while(!patients.isEmpty()){
            patient = patients.poll();

            for(Patient p : patients){
                if(p.weight > patient.weight){
                    patients.offer(patient);
                    patient = null;
                    break;
                }
            }

            if(patient != null) {
                if(patient.index == target){
                    sol++;
                    return sol;
                } else sol++;
            }
        }


        return sol;
    }
    public static void main(String[] args) throws IOException {
        Emergency_room e = new Emergency_room();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Patient p;

        st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        Queue<Patient> patients = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < size; i++){
            p = new Patient(i, Integer.parseInt(st.nextToken()));
            patients.offer(p);
        }

        System.out.println(e.solution(target, patients));
    }
}
