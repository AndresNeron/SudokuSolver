import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) {

		BoxMatrix Board = new BoxMatrix();
		Board.setPath("/media/Kali/home/grimaldi/School/TEC/Semestre2/POO/SudokuSolver/templates/samples/sample_1.csv");
		Board.initMatrix(); // Populate the Board.boxMatrix[n][m] with the values

		
		// Declare the Group instance. This generates all the Set for Rows, Columns and Grids
		Group myGroup = new Group();
		myGroup.populateUniverse();

		// Populate the Rows, Columns and Grids sets
		myGroup.addingRows		(Board.boxMatrix);
		myGroup.addingColumns	(Board.boxMatrix);
		myGroup.addingGrids		(Board.boxMatrix);

		// Solve the Sudoku Board	
		Board.SolveSudoku (myGroup);
		Board.printMatrix();


	}
}
