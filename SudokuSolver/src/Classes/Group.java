import java.util.HashSet;
import java.util.Set;

public class Group {

	Set<Integer> universeSet = new HashSet<>();
	Row[] myRows = new Row[9];
	Column[] myColumns = new Column[9];
	Grid[] myGrids = new Grid[9];

	public Group (){
		for (int i = 0; i < 9; i++){
			myRows[i] = new Row();
		}
		for (int i = 0; i < 9; i++){
			myColumns[i] = new Column();
		}
		for (int i = 0; i < 9; i++){
			myGrids[i] = new Grid();
		}
	}
	
	public void populateUniverse () {
		universeSet.add(1);
		universeSet.add(2);
		universeSet.add(3);
		universeSet.add(4);
		universeSet.add(5);
		universeSet.add(6);
		universeSet.add(7);
		universeSet.add(8);
		universeSet.add(9);
	}

	// Assign the 9 Rows with their respective values
	public void addingRows (Box[][] boxMatrix) {
		for (int i = 0; i < 9; i++){
			myRows[i].addRow(i, boxMatrix);
			//myRows[i].printRow(boxMatrix);
		}
	}
	
	// Assign the 9 Columns with their respective values
	public void addingColumns (Box[][] boxMatrix) {
		for (int i = 0; i < 9; i++){
			myColumns[i].addColumn(i, boxMatrix);
			//myColumns[i].printColumn(boxMatrix);
		}
	}
	
	// Assign the 9 Grids with their respective values
	public void addingGrids (Box[][] boxMatrix) {
		for (int i = 0; i < 9; i++){
			myGrids[i].addGrid(i, boxMatrix);
			//myGrids[i].printGrid(boxMatrix);
		}
	}
	
}
