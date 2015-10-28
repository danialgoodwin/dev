/**
 * Created by dan on 10/28/15.
 */
package com.anonsage.question;

/**
 * Suppose you are given a puzzle that is represented as a matrix with 0s and 1s, where a 0 indicates you’re allowed
 * to move into that position and 1 means you’re not allowed to move in that position. Write a function that given a
 * start position and an end position, returns a boolean value indicating if there exists a path from start to end.
 * you are only allowed to move up, left, right and down. Diagonal movement is not allowed.

 Example #1
 Input
 0 0 1 0 1
 0 0 0 0 0
 0 1 1 1 1
 0 1 1 0 0

 start: 4,1
 end 0,3

 Output - true

 Example #2
 Input
 0 0 1 1 1
 0 1 0 0 0
 1 1 1 1 1
 0 0 0 0 1

 start: 0,0
 end: 1,2

 Output - false

 More info: http://www.careercup.com/page?pid=amazon-interview-questions&job=software-engineer-interview-questions
 */
public class MatrixGraphTraverse {

    private static void log(String message) {
        System.out.println(message);
    }

    public static void main(String[] args) {
        int[][] matrix1 = {{0,0,1,0,1},
                           {0,0,0,0,0},
                           {0,1,1,1,1},
                           {0,1,1,0,0}};
        int startX = 1;
        int startY = 3;
        int stopX = 0;
        int stopY = 0;
        boolean isExists = isExistsPath(matrix1, startX, startY, stopX, stopY);
        log("isExists=" + isExists);

        int[][] matrix2 = {{0,0,1,1,1},
                           {0,1,0,0,0},
                           {1,1,1,1,1},
                           {0,0,0,0,1}};
        startX = 0;
        startY = 0;
        stopX = 1;
        stopY = 2;
        isExists = isExistsPath(matrix2, startX, startY, stopX, stopY);
        log("isExists2=" + isExists);
    }

    public static boolean isExistsPath(int[][] matrix, int startX, int startY, int stopX, int stopY) {
        log("matrix=" + matrix.length + "x" + matrix[0].length);
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        return isExistsPathHelper(matrix, startX, startY, stopX, stopY, visited);
    }

    private static boolean isExistsPathHelper(int[][] matrix, int startX, int startY, int stopX, int stopY, boolean[][] visited) {
        if (visited[startX][startY] || matrix[startX][startY] == 1) { return false; }
        log("isExistsPathHelper(matrix,startX=" + startX + ",startY=" + startY + ")");
        if (startX == stopX && startY == stopY) { return true; }

        visited[startX][startY] = true;
        boolean isExists = false;
        if (startX - 1 >= 0) {
            isExists = isExistsPathHelper(matrix, startX - 1, startY, stopX, stopY, visited);
            if (isExists) { return true; }
        }
        if (startX + 1 < matrix.length) {
            isExists = isExistsPathHelper(matrix, startX + 1, startY, stopX, stopY, visited);
            if (isExists) { return true; }
        }
        if (startY - 1 >= 0) {
            isExists = isExistsPathHelper(matrix, startX, startY - 1, stopX, stopY, visited);
            if (isExists) { return true; }
        }
        if (startY + 1 < matrix[0].length) {
            isExists = isExistsPathHelper(matrix, startX, startY + 1, stopX, stopY, visited);
        }
        return isExists;
    }

}
