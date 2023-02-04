package _04_Maze_Maker;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class MazeMaker {

	private static int rows;
	private static int cols;

	private static Maze maze;

	private static Random randGen = new Random();
	private static Stack<Cell> uncheckedCells = new Stack<Cell>();

	public static Maze generateMaze(int r, int c) {
		rows = r;
		cols = c;
		maze = new Maze(rows, cols);

		// 1. Pick a random cell along the border and remove its exterior wall.
		// This will be the starting point. Then select a random cell along
		// the opposite wall and remove its exterior wall. This will be the
		// finish line.
		Random rand = new Random();
		// int rem = rand.nextInt((2*r) + (2*(c-2)));
		int x = rand.nextInt(2) * (r-1);
		int y = rand.nextInt(2) * (c-1);

		if (x == 0) {
			maze.getCell(x, y).setWestWall(false);
			//maze.getCell(x-1, y).setEastWall(false);
		} else if (x == r) {
			maze.getCell(x, y).setEastWall(false);
			//maze.getCell(x+1,y) .setWestWall(false);
		} else if (y == 0) {
			maze.getCell(x, y).setSouthWall(false);
			//maze.getCell(x, y-1).setNorthWall(false);
		} else if (y == c) {
			maze.getCell(x, y).setNorthWall(false);
			//maze.getCell(x, y-1).setSouthWall(false);
		}

		// 2. select a random cell in the maze to start
		int x2 = rand.nextInt(r);
		int y2 = rand.nextInt(c);
		Cell currentCell = maze.getCell(x2, y2);
		// 3. call the selectNextPath method with the randomly selected cell
		selectNextPath(currentCell);

		return maze;
	}

	// 4. Complete the selectNextPathMethod
	private static void selectNextPath(Cell currentCell) {
		// A. SET currentCell as visited
		currentCell.setBeenVisited(true);
		// B. check for unvisited neighbors using the cell
		ArrayList<Cell> neighbors = getUnvisitedNeighbors(currentCell);
		// C. if has unvisited neighbors,
		if (neighbors.size() > 0) {
			// C1. select one at random.
			Random rand = new Random();
			int randomVal = rand.nextInt(neighbors.size());
			Cell randCell = neighbors.get(randomVal);
			// C2. push it to the stack
			uncheckedCells.push(neighbors.get(randomVal));
			// C3. remove the wall between the two cells
			if (randCell.getRow() == currentCell.getRow() - 1) {
				currentCell.setNorthWall(false);
				randCell.setSouthWall(false);
			}
			if (randCell.getRow() == currentCell.getRow() + 1) {
				currentCell.setSouthWall(false);
				randCell.setNorthWall(false);
			}
			if (randCell.getCol() == currentCell.getCol() - 1) {
				currentCell.setWestWall(false);
				randCell.setEastWall(false);
			}
			if (randCell.getCol() == currentCell.getCol() + 1) {
				currentCell.setEastWall(false);
				randCell.setWestWall(false);
			}
			// C4. make the new cell the current cell and SET it as visited
			currentCell = randCell;
			currentCell.setBeenVisited(true);
			// C2. push i = currentCell;
			
			// C5. call the selectNextPath method with the current cell
			selectNextPath(currentCell);
		}
		// D. if all neighbors are visited
		if (neighbors.size() == 0) {
			// D1. if the stack is not empty
			if (uncheckedCells.isEmpty() == false) {
				// D1a. pop a cell from the stack
				Cell newCell = uncheckedCells.pop();
				// D1b. make that the current cell
				currentCell = newCell;
				// D1c. call the selectNextPath method with the current cell
				selectNextPath(currentCell);
			}
		}
	}

	// This method will check if c1 and c2 are adjacent.
	// If they are, the walls between them are removed.
	private static void removeWalls(Cell c1, Cell c2) {
		if (c1.getRow() == c2.getRow()) {
			if (c1.getCol() > c2.getCol()) {
				c1.setWestWall(false);
				c2.setEastWall(false);
			} else {
				c1.setEastWall(false);
				c2.setWestWall(false);
			}
		} else {
			if (c1.getRow() > c2.getRow()) {
				c1.setNorthWall(false);
				c2.setSouthWall(false);
			} else {
				c1.setSouthWall(false);
				c2.setNorthWall(false);
			}
		}
	}

	// This method returns a list of all the neighbors around the specified
	// cell that have not been visited. There are up to 4 neighbors per cell.
	// 1
	// 2 cell 3
	// 4
	private static ArrayList<Cell> getUnvisitedNeighbors(Cell c) {
		int row = c.getRow();
		int col = c.getCol();

		ArrayList<Cell> unvisitedNeighbors = new ArrayList<Cell>();

		if (row > 0 && !maze.getCell(row - 1, col).hasBeenVisited()) {
			unvisitedNeighbors.add(maze.getCell(row - 1, col));
		}

		if (col > 0 && !maze.getCell(row, col - 1).hasBeenVisited()) {
			unvisitedNeighbors.add(maze.getCell(row, col - 1));
		}

		if (row < rows - 1 && !maze.getCell(row + 1, col).hasBeenVisited()) {
			unvisitedNeighbors.add(maze.getCell(row + 1, col));
		}

		if (col < cols - 1 && !maze.getCell(row, col + 1).hasBeenVisited()) {
			unvisitedNeighbors.add(maze.getCell(row, col + 1));
		}

		return unvisitedNeighbors;
	}
}
