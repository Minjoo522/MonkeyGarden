import java.io.*;

public class Main {
    static String quack = "quack";
    static int cnt = 0;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sound = br.readLine();
        visited = new int[sound.length()];

        if (!sound.startsWith("q") || !sound.endsWith("k") || sound.length() % 5 != 0) {
            System.out.println(-1);
            System.exit(0);
        }

        findQuack(sound);

        if (cnt == 0 || !allVisited()) {
            System.out.println(-1);
        } else {
            System.out.println(cnt);
        }
    }

    static void findQuack(String sound) {
        for (int i = 0; i < sound.length(); i++) {
            findQuackHelper(sound, i);
        }
    }

    static void findQuackHelper(String sound, int start) {
        int idx = 0;
        boolean flag = true;
        for (int i = start; i < sound.length(); i++) {
            if (sound.charAt(i) == quack.charAt(idx) && visited[i] == 0) {
                visited[i] = 1;
                if (quack.charAt(idx) == 'k') {
                    if (flag) {
                        cnt++;
                        flag = false;
                    }
                    idx = 0;
                } else {
                    idx++;
                }
            }
        }
    }

    static boolean allVisited() {
        for (int visit : visited) {
            if (visit == 0) return false;
        }
        return true;
    }
}
