package CSSE220;

public class Maze {
    private Cell[][] grid;
    private int rows;
    private int cols;
    private Player player;

    public Maze(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.grid = new Cell[rows][cols];

        // Generate the maze structure using MazeGenerator
        boolean[][] wallMap = MazeGenerator.generateMaze(rows, cols);

        // Fill the grid with Cells based on wallMap
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                grid[r][c] = new Cell(wallMap[r][c], r, c);
            }
        }

        // Set up the player at a non-wall start location
        this.player = new Player("Player 1", "🙂", getFirstOpenCell());
        this.player.setCurrentCell(getFirstOpenCell());
    }

    private Cell getFirstOpenCell() {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (!grid[r][c].isWall()) {
                    return grid[r][c];
                }
            }
        }
        return null; // fallback if all are walls (shouldn't happen with valid maze)
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public Cell getCellAt(int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return null;
        }
        return grid[row][col];
    }

    public Player getPlayer() {
        return player;
    }
}
