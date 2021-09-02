//On an infinite plane, a robot initially stands at (0, 0) and faces north. The robot can receive one of three instructions:
//
//"G": go straight 1 unit;
//"L": turn 90 degrees to the left;
//"R": turn 90 degrees to the right.
//The robot performs the instructions given in order, and repeats them forever.
//
//Return true if and only if there exists a circle in the plane such that the robot never leaves the circle.

package leetcode;

/**
 * @author Pradeep Arya
 */
public class RobotBoundedInCircle {

//    public boolean isRobotBounded(String instructions) {
//
//        boolean isBoundedCircle = false;
//
//        OptionalInt reduce = instructions.chars().filter(character -> ('L' == character) || ('R' == character)).reduce((first, second) -> second);
//        if (reduce.isPresent()) {
//            isBoundedCircle = (reduce.getAsInt() == 76) || (reduce.getAsInt() == 82);
//        }
//
//        return isBoundedCircle;
//
//    }

    private Character updateDirection(Character currentDirection, Character newDirection) {

        switch (currentDirection) {
            case 'U':
                currentDirection = newDirection;
                break;
            case 'D':
                currentDirection = newDirection == 'L' ? 'R' : 'L';
                break;
            case 'L':
                currentDirection = newDirection == 'L' ? 'D' : 'U';
                break;
            case 'R':
                currentDirection = newDirection == 'R' ? 'D' : 'U';
                break;
        }


        return currentDirection;
    }

    private void move(int[] coordinates, Character currentDirection) {
        switch (currentDirection) {
            case 'U':
                coordinates[1] = coordinates[1] + 1;
                break;
            case 'D':
                coordinates[1] = coordinates[1] - 1;
                break;
            case 'L':
                coordinates[0] = coordinates[0] - 1;
                break;
            case 'R':
                coordinates[0] = coordinates[0] + 1;
                break;
        }
    }

    public boolean isRobotBounded(String instructions) {

        boolean isBoundedCircle = false;
        Character currentDirection = 'U';
        int[] coordinates = {0, 0};
        for (Character character : instructions.toCharArray()) {

            if (character == 'L' || character == 'R') {
                currentDirection = updateDirection(currentDirection, character);
            } else {
                move(coordinates, currentDirection);
            }

        }

        if ((coordinates[0] == 0 && coordinates[1] == 0) || !currentDirection.equals('U')) {
            isBoundedCircle = true;
        }

        return isBoundedCircle;

    }


    public static void main(String[] args) {
        System.out.println("output true " + new RobotBoundedInCircle().isRobotBounded("GGLLGG"));
        System.out.println("output false " + new RobotBoundedInCircle().isRobotBounded("GG"));
        System.out.println("output true " + new RobotBoundedInCircle().isRobotBounded("GL"));
        System.out.println("output true " + new RobotBoundedInCircle().isRobotBounded("GR"));
        System.out.println("output true " + new RobotBoundedInCircle().isRobotBounded("LLGRL"));
    }
}
