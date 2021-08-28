/*
 * Click `Run` to execute the snippet below!
 */



/**

 Meeting Rooms

 Given a collection of meetings (each has a start time and an end time, positive integer type, start time is inclusive and end time is exclusive, input is always valid). Return how many meeting rooms are needed at least to hold all the meetings.


 meetings.add(new Meeting("m1", 8, 11)); // r1
 meetings.add(new Meeting("m2", 8, 9)); // r2
 meetings.add(new Meeting("m3", 8, 10)); // r3
 meetings.add(new Meeting("m4", 9, 10)); // r2
 meetings.add(new Meeting("m5", 10, 11)); // r2

 */
import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {

    static class Meeting {
        private final int start;
        private final int end;
        private final String name;

        public Meeting(String name, int start, int end) {
            this.name = name;
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

    }

//   public static void main(String[] args) {
//     ArrayList<String> strings = new ArrayList<String>();
//     strings.add("Hello, World!");
//     strings.add("Welcome to CoderPad.");
//     strings.add("This pad is running Java " + Runtime.version().feature());

//     for (String string : strings) {
//       System.out.println(string);
//     }
//     List<Meeting> meetings = new ArrayList<Meeting>();
//     meetings.add(new Meeting("m1", 8, 11)); // r1
//     meetings.add(new Meeting("m2", 8, 9)); // r2
//     meetings.add(new Meeting("m3", 8, 9)); // r3
//     meetings.add(new Meeting("m4", 9, 9)); // r2
//     meetings.add(new Meeting("m5", 9, 10)); // r2
//     meetings.add(new Meeting("m1", 8, 12)); // r1
//     meetings.add(new Meeting("m2", 10, 12)); // r2
//     meetings.add(new Meeting("m3", 11, 12)); // r3
//     meetings.add(new Meeting("m4", 1, 10)); // r2
//     meetings.add(new Meeting("m5", 20, 11));
//     System.out.println(findTotalRoom(meetings));
//   }

    //[1,6], [8,10], [11,20]
    //[2,7], [9,10], [25,30]
    //[2,6], [9,10]

    public static int findTotalRoom(List<Meeting> requests) {
        int result = 0;
        if (Objects.isNull(requests) || requests.size() == 0) {
            return result;
        }

        requests.sort((a, b) -> a.start - b.start);


        PriorityQueue<Integer> pq = new PriorityQueue<>(); //heap O(logn)
        pq.offer(requests.get(0).getEnd());
        for (int i = 1; i < requests.size(); i++) {
            int end_time = requests.get(i).getEnd();
            if (pq.peek() > requests.get(i).getStart()) {
                pq.offer(end_time);
                result = Math.max(result, pq.size());
            } else {
                pq.poll();
            }
        }

        return result;
    }



    public static void main(String[] args) {
        List<String> inventory = Arrays.asList(
                "Transformers One",
                "One World",
                "Idiots in Train",
                "One Two Three",
                "Three Idiots",
                "Transformers Two",
                "The Avengers",
                "Captain America",
                "World War Two"
        );

        System.out.println(findLongestMovieSet(inventory));
    }

    private static Map<String, List<String>> getInventoryMap(List<String> movieNames) {
        Map<String, List<String>> inventoryMap = new HashMap();
        movieNames.forEach(name -> {
            // We can assume movie titles are valid strings separated by space
            String firstWord = name.split(" ")[0];
            if (!inventoryMap.containsKey(firstWord)) {
                inventoryMap.put(firstWord, new ArrayList<>());
            }

            inventoryMap.get(firstWord).add(name);
        });

        return inventoryMap;
    }

    public static int findLongestMovieSet(List<String> movieNames) {
        Map<String, List<String>> inventoryMap = getInventoryMap(movieNames);
        int result = 0;

        Map<String, List<String>> graph = new HashMap<>();
        for (String name : movieNames) {
            List<String> nextMovies = graph.getOrDefault(name, new LinkedList<>());
            nextMovies.addAll(inventoryMap.get(name.split(" ")[0]));
            graph.put(name, nextMovies);
        }


        for (String movie : movieNames) {
            result = Math.max(result, dfs(graph, 0, movie));
        }

        return result;


    }

    //add addtional array to record each strings depth, to use dp to reduce calling of dfs
    private static int dfs(Map<String, List<String>> graph, int level, String name) {
        int result = level + 1;
        List<String> nextMovies = graph.get(name);
        if (Objects.isNull(nextMovies) || nextMovies.size() == 0) {
            return result;
        }
        for (String movie : nextMovies) {
            result = Math.max(result, dfs(graph, level + 1, movie));
        }

        return result;
    }

}





/**

 Write a function that, given an inventory of titles (say  movies), and a
 starting movie title, returns the longest list of titles (in which each title
 appears only once) where the first word of the next title in the list is equal
 to the last word of the preceding title

 Example:
 Inventory = (
 'Transformers One',
 'One World',
 'Idiots in Train',
 'One Two Three',
 'Three Idiots',
 'Transformers Two',
 'The Avengers',
 'Captain America',
 'World War Two'
 )

 Starting Movie = 'Transformers One'

 Longest List -> ['Transformers One', 'One Two Three', 'Three Idiots', 'Idiots in Train']

 */
