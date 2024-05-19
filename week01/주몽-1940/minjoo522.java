import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        int M = Integer.parseInt(reader.readLine());

        int[] materials = new int[N];
        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; i++) {
            materials[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(materials);

        int left = 0;
        int right = N - 1;
        int cnt = 0;

        while (left < right) {
            int currentSum = materials[left] + materials[right];

            if (currentSum == M) {
                cnt++;
                left++;
                right--;
            } else if (currentSum < M) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(cnt);
    }
}
