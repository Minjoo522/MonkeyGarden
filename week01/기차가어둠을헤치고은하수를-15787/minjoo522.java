import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();
        scanner.nextLine();

        List<List<Integer>> trains = new ArrayList<>(N + 1);
        for (int i = 0; i <= N; i++) {
            List<Integer> train = new ArrayList<>(Collections.nCopies(20, 0));
            trains.add(train);
        }

        for (int i = 0; i < M; i++) {
            String[] command = scanner.nextLine().split(" ");
            int type = Integer.parseInt(command[0]);
            int train = Integer.parseInt(command[1]);

            switch (type) {
                case 1:
                    int seat1 = Integer.parseInt(command[2]) - 1;
                    trains.get(train).set(seat1, 1);
                    break;
                case 2:
                    int seat2 = Integer.parseInt(command[2]) - 1;
                    trains.get(train).set(seat2, 0);
                    break;
                case 3:
                    trains.get(train).remove(19);
                    trains.get(train).add(0, 0);
                    break;
                case 4:
                    trains.get(train).add(0);
                    trains.get(train).remove(0);
                    break;
                default:
                    break;
            }
        }

        Set<List<Integer>> selected = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            selected.add(Collections.unmodifiableList(trains.get(i)));
        }

        System.out.println(selected.size());
    }
}
