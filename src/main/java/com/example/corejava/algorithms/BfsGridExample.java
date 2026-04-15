package com.example.corejava.algorithms;

import java.util.ArrayDeque;
import java.util.Queue;


/**
 * Demonstrates breadth-first search with a queue over a two-dimensional grid.
 *
 * <p>Interview questions answered: How does BFS visit nearest cells first? Why do we need
 * a visited structure?</p>
 *
 * <p>Real-life use: finding reachable map cells, flood fill areas, or shortest paths in
 * unweighted grids.</p>
 */
public class BfsGridExample {
    private BfsGridExample() {
    }
    /**
     * Runs this example directly from the command line.
     *
     * @param args command-line arguments; ignored by this example
     */
    public static void main(String[] args) {
        run();
    }

    /**
     * Executes the example logic used by {@code DemoRunner} and tests.
     */
    public static void run() {
        // Walkthrough:
        // 1. Put the starting cell in a queue and mark it visited immediately.
        // 2. Remove one cell at a time and inspect its four neighbors.
        // 3. Add only in-bounds, walkable, unseen neighbors so each cell is processed once.
        int[][] grid = {
                {1, 1, 0},
                {0, 1, 1},
                {0, 0, 1}
        };
        System.out.println("Reachable cells from top-left: " + countReachableCells(grid));
        // Time: O(rows * cols), Space: O(rows * cols)
    }

    private static int countReachableCells(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});
        visited[0][0] = true;
        int count = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            count++;
            for (int[] direction : directions) {
                int row = cell[0] + direction[0];
                int col = cell[1] + direction[1];
                if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length
                        && grid[row][col] == 1 && !visited[row][col]) {
                    visited[row][col] = true;
                    queue.add(new int[]{row, col});
                }
            }
        }
        return count;
    }
}
