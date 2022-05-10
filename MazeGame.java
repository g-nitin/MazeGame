/*
Nitin Gupta
Class example 2/22/22
 */

import java.util.Random;

public class MazeGame {

    public static final int MAZE_SIZE = 10; // for the square board (rows or columns)
    public static final int OBSTACLE_AMT = (MAZE_SIZE * MAZE_SIZE) / 10; // A TENTH OF THE SIZE

    private char[][] maze; // the board // index 0 - y // index 1 - x
    public static final char EMPTY = '_';
    public static final char OBSTACLE = 'X';
    public static final char PLAYER = 'O';
    public static final char PATH = '#';

    public static final String NORTH = "Go North";
    public static final String EAST = "Go East";
    public static final String SOUTH = "Go South";
    public static final String WEST = "Go West";
    public static final String BACK = "Go BACK";

    private StackI< int[] > locations; // index 0 - y // index 1 - x
    private int[] currLoc; // index 0 - y // index 1 - x

    public MazeGame()
    {
        init();
    }
    private void init()
    {
        maze = new char[MAZE_SIZE][MAZE_SIZE];

        // empty the board...
        for (int i = 0; i< maze.length; i++)
            for (int j = 0; j<maze[i].length; j++)
                maze[i][j] = EMPTY;

        this.addObstacles();
        maze[0][0] = PLAYER;
        currLoc = new int[] {0, 0};
        locations = new LLStack< int[] >();
    }

    private void addObstacles()
    {
        Random r = new Random();

        for (int i = 0; i<OBSTACLE_AMT; i++)
        {
            int x = r.nextInt(MAZE_SIZE);
            int y = r.nextInt(MAZE_SIZE);

            if (maze[y][x] != EMPTY ||
                    (x == 0 && y == 0) ||
                    (x == MAZE_SIZE-1 && y == MAZE_SIZE-1))
                continue; // i++ does not run when continue is called

            maze[y][x] = OBSTACLE;
        }
    }

    public void printFullMaze()
    {
        for (int i = 0; i< maze.length; i++)
        {
            for (int j = 0; j<maze[i].length; j++)
            {
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
    }

}
