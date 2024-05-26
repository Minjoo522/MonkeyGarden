import java.io.*;

public class Main {
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static int[] findValue(int[][] snail, int value) {
        int N = snail.length;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (snail[r][c] == value) {
                    return new int[]{r + 1, c + 1};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int find = Integer.parseInt(br.readLine());

        int[][] snail = new int[N][N];
        int r = 0, c = 0, d = 0;

        for (int num = N * N; num > 0; num--) {
            snail[r][c] = num;

            int nr = r + dr[d], nc = c + dc[d];

            if (nr < 0 || nr >= N || nc < 0 || nc >= N || snail[nr][nc] != 0) {
                d = (d + 1) % 4;
                nr = r + dr[d];
                nc = c + dc[d];
            }

            r = nr;
            c = nc;
        }

        for (int[] row : snail) {
            for (int num : row) {
                bw.write(num + " ");
            }
            bw.newLine();
        }

        int[] coords = findValue(snail, find);
        if (coords != null) {
            bw.write(coords[0] + " " + coords[1]);
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
