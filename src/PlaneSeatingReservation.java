
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PlaneSeatingReservation {

    public static int Solution(int N, String str) {
        Map<Integer, Set<Character>> reserved = new HashMap<>();

        String[] reservedSeats = str.split(" ");

        for (String seat : reservedSeats) {
            char seatCharacter = seat.charAt(seat.length() - 1);

            int row = Integer.parseInt(seat.substring(0, seat.length() - 1));

            if (!reserved.containsKey(row)) {
                reserved.put(row, new HashSet<>());
            }

            reserved.get(row).add(seatCharacter);

        }

        int result = 0;

        for (int row = 1; row <= N; row++) {
            if (!reserved.containsKey(row)) {
                result += 3;
                continue;
            }

            Set<Character> set = reserved.get(row);

            if (!set.contains('A') && !set.contains('B') && !set.contains('C')) {
                result++;
            }

            boolean defFree = !set.contains('D') && !set.contains('E') && !set.contains('F');
            boolean efgFree = !set.contains('E') && !set.contains('F') && !set.contains('G');
            if (defFree || efgFree) {
                result++;
            }

            if (!set.contains('H') && !set.contains('J') && !set.contains('K')) {
                result++;
            }
        }

        return result;

    }

    public static void main(String[] args) {
        String S = "1A 2F 1C 5A 4G 2A";
        int N = 6;
        System.out.println(Solution(N, S));
    }
}
