package chap5_recursive;
import java.util.Stack;

public class MazeSolver {
    // Enum to represent directions
    enum Directions {
        N, NE, E, SE, S, SW, W, NW
    }

    // Offsets for each direction
    private static final int[][] MOVES = {
            {-1, 0}, {-1, 1}, {0, 1}, {1, 1},
            {1, 0}, {1, -1}, {0, -1}, {-1, -1}
    };

    private static final int WALL = 1;

    // Function to solve the maze
    public static void solveMaze(int[][] maze) {
        int m = maze.length;
        int p = maze[0].length;

        // Extend the maze with borders
        int[][] extendedMaze = new int[m + 2][p + 2];
        for (int i = 0; i < m + 2; i++) {
            for (int j = 0; j < p + 2; j++) {
                if (i == 0 || i == m + 1 || j == 0 || j == p + 1) {
                    extendedMaze[i][j] = WALL;
                } else {
                    extendedMaze[i][j] = maze[i - 1][j - 1];
                }
            }
        }

        // Stack to store the path
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{1, 1});  // Starting position

        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int x = current[0];
            int y = current[1];

            // Check if we reached the exit
            if (x == m && y == p) {
                System.out.println("Path found!");
                return;
            }

            // Explore all possible directions
            for (int i = 0; i < Directions.values().length; i++) {
                int newX = x + MOVES[i][0];
                int newY = y + MOVES[i][1];

                // Check if the new position is a valid move
                if (extendedMaze[newX][newY] == 0) {
                    stack.push(new int[]{newX, newY});
                    extendedMaze[newX][newY] = WALL;  // Mark the position as visited
                }
            }
        }

        System.out.println("No path found.");
    }

    public static void main(String[] args) {
        int[][] maze = {
        		{ 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1 },
				{ 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1 },
				{ 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1 },
				{ 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0 },
				{ 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
				{ 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1 },
				{ 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 },
				{ 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0 }
        };

        solveMaze(maze);
    }
}
