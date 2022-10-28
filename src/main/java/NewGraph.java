import java.util.*;

public class NewGraph {
    public static void main(String[] args) {
        ArrayList<String> rooms = new ArrayList<String>();
        // LinkedList<String> vertexes = new LinkedList<String>();
        HashMap<String, Integer> vertexMap = new HashMap<String, Integer>();
        HashMap<String, Integer> vertexCombinationsMap = new HashMap<String, Integer>();
        Scanner in = new Scanner(System.in);
        int roomsValue;

        roomsValue = in.nextInt();
        for (int i = 0; i < roomsValue; i++) {
            rooms.add(in.next());
        }
        in.close();

        for (String rooms_iterator : rooms) {
            for (int i = 0; i < rooms_iterator.length() - 2; i++) {
                vertexMap.put(rooms_iterator.substring(i, i + 3), 1);
            }
        }

        System.out.println(vertexMap.size());

        for (String rooms_iterator : rooms) {
            for (int i = 0; i < rooms_iterator.length() - 3; i++) {
                if (vertexCombinationsMap.get(
                        rooms_iterator.substring(i, i + 3) + " " + rooms_iterator.substring(i + 1, i + 4)) == null) {
                    vertexCombinationsMap
                            .put(rooms_iterator.substring(i, i + 3) + " " + rooms_iterator.substring(i + 1, i + 4), 1);
                } else {
                    vertexCombinationsMap
                            .put(rooms_iterator.substring(i, i + 3) + " " + rooms_iterator.substring(i + 1, i + 4),
                                    vertexCombinationsMap.get(
                                            rooms_iterator.substring(i, i + 3) + " "
                                                    + rooms_iterator.substring(i + 1, i + 4))
                                            + 1);
                }
            }
        }
        System.out.println(vertexCombinationsMap.size());

        Set<Map.Entry<String, Integer>> blabla = vertexCombinationsMap.entrySet();
        for (Map.Entry<String, Integer> me : blabla) {
            System.out.print(me.getKey() + " " + me.getValue());
            System.out.println();
        }
    }
}