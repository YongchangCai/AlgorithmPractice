import java.util.HashMap;
import java.util.Map;

public class RobotBoundCircle {
    /**
     * On an infinite plane, a robot initially stands at (0, 0) and faces north. The robot can receive one of three instructions:
     *
     * "G": go straight 1 unit;
     * "L": turn 90 degrees to the left;
     * "R": turn 90 degrees to the right.
     * The robot performs the instructions given in order, and repeats them forever.
     *
     * Return true if and only if there exists a circle in the plane such that the robot never leaves the circle.
     */
    public boolean isRobotBounded(String instructions) {
        int[][] movement = {{0,1}, {1,0}, {0, -1}, {-1,0}};
        int[] location = {0,0};
        int direction = 0;
        for(int i =0; i < 4; i++) {
            for (int j = 0; j < instructions.length(); j++) {
                switch (instructions.charAt(j)) {
                    case 'G':
                        location[0] += movement[direction][0];
                        location[1] += movement[direction][1];
                        break;
                    case 'L':
                        direction = (direction-1)%4;
                        break;
                    case 'R':
                        direction = (direction+1)%4;
                        break;
                    default:
                        break;
                }
            }
        }

        Map<String, String> newMap = new HashMap<>();
        newMap.put()
        return location[0] == 0 && location[1] == 0;
    }
}
