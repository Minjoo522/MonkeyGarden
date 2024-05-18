import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] students = new int[N + 3];

        st = new StringTokenizer(reader.readLine());
        Set<Integer> sleepNums = new HashSet<>();
        for (int i = 0; i < K; i++) {
            sleepNums.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(reader.readLine());
        Set<Integer> receiveNums = new HashSet<>();
        for (int i = 0; i < Q; i++) {
            receiveNums.add(Integer.parseInt(st.nextToken()));
        }

        for (int num : receiveNums) {
            if (!sleepNums.contains(num)) {
                for (int i = num; i < N + 3; i += num) {
                    if (!sleepNums.contains(i)) {
                        students[i] = 1;
                    }
                }
            }
        }

        // 누적합
        int[] prefixSum = new int[N + 3];
        for (int i = 1; i < N + 3; i++) {
            prefixSum[i] = prefixSum[i - 1] + (students[i] == 0 ? 1 : 0);
        }

        StringBuilder results = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(reader.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            int result = prefixSum[E] - prefixSum[S - 1];
            results.append(result).append("\n");
        }

        System.out.print(results.toString());
    }
}
