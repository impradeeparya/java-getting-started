//Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).
//
//The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
//
//You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).

package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Pradeep Arya
 */
public class KClosestPointsToOrigin {
    class Coordinate {
        int x;
        int y;
        double distance;

        public Coordinate(int x, int y, double distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }

        public double getDistance() {
            return this.distance;
        }

        @Override
        public String toString() {
            return "Coordinate{" +
                    "x=" + x +
                    ", y=" + y +
                    ", distance=" + distance +
                    '}';
        }
    }

    private void insert(List<Coordinate> kCoordinates, int k, Coordinate coordinate) {
        int index = 0;
        if ((kCoordinates.size() < k) || coordinate.getDistance() <= kCoordinates.get(0).getDistance()) {
            boolean isInserted = false;
            while (index < kCoordinates.size()) {
                Coordinate kCoordinate = kCoordinates.get(index);
                if (kCoordinate.getDistance() < coordinate.getDistance()) {
                    kCoordinates.add(index, coordinate);
                    isInserted = true;
                    break;
                }
                index++;
            }
            if (!isInserted) {
                kCoordinates.add(coordinate);
            }
        }

        if (kCoordinates.size() > k) {
            kCoordinates.remove(0);
        }
    }

    public int[][] kClosest(int[][] points, int k) {

        List<Coordinate> kCoordinates = new LinkedList<>();
        int[][] output = new int[k][2];

        for (int index = 0; index < points.length; index++) {
            int[] coordinates = points[index];
            int x = coordinates[0];
            int y = coordinates[1];

            double distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
            insert(kCoordinates, k, new Coordinate(x, y, distance));
//            System.out.println("x : " + x + " y : " + y + " distance : " + distance + " kCoordinates : " + kCoordinates);
        }
//        kCoordinates.sort(Comparator.comparingDouble(o -> o.distance));
        for (int index = 0; index < k; index++) {
            Coordinate coordinate = kCoordinates.get(index);
            int[] coordinates = {coordinate.x, coordinate.y};
            output[index] = coordinates;
        }
        return output;
    }

    private static StringBuilder print(int[][] output) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int index = 0; index < output.length; index++) {
            stringBuilder.append("[" + output[index][0] + " " + output[index][1] + "] ");
        }
        return stringBuilder;
    }

    public static void main(String[] args) {
        System.out.println("output [[3,3],[-2,4]] " + print(new KClosestPointsToOrigin().kClosest(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2)));
        System.out.println("output [[-2,2]] " + print(new KClosestPointsToOrigin().kClosest(new int[][]{{1, 3}, {-2, 2}}, 1)));
        System.out.println("output [[17,7],[-2,-42],[53,20],[-36,-57],[-69,-8]] " + print(new KClosestPointsToOrigin().kClosest(new int[][]{{-95, 76}, {17, 7}, {-55, -58}, {53, 20}, {-69, -8}, {-57, 87}, {-2, -42}, {-10, -87}, {-36, -57}, {97, -39}, {97, 49}}, 5)));
    }
}
