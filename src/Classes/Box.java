import java.util.HashSet;
import java.util.Set;

public class Box {
	int x;		// [0,8]
	int y;		// [0,8]
	int grid;	// [0,8]
	int value;	// [1,9]
	Set<Integer> mergedSet = new HashSet<>();

	// Contructor
	public Box(int x, int y, int value){
		this.x		= x;
		this.y		= y;
		this.grid	= (3 * (x / 3)) + (y / 3);
		this.value	= value;
	}

	public void print_x_y_value (){
		// Adjust the beginning of the matrix adding 1
		int x_real	= this.x + 1;
		int y_real	= this.y + 1;
		System.out.println(x_real + "," + y_real + "," + this.value);
	}

	public void assign_value (int value) {
		this.value	= value;
	}

	// This methods add the value of the box into the correspondient (Row, Column, Grid)
	public void includeBox (Group myGroup){
		myGroup.myRows[this.x].addValue(this.value);
		myGroup.myColumns[this.y].addValue(this.value);
		myGroup.myGrids[this.grid].addValue(this.value);
	}

	// Join the Sets (Row, Column, Grid) associated with the Box
	public void joinSets (Group myGroup){
		this.mergedSet.addAll (myGroup.myRows[this.x].xSet);
		this.mergedSet.addAll (myGroup.myColumns[this.y].ySet);
		this.mergedSet.addAll (myGroup.myGrids[this.grid].gridSet);

	}

	public void printMerged (Group myGroup){
		if (this.mergedSet.size() == 8){
			System.out.println (this.x + "," + this.y + "	" + mergedSet );
		}
	}

	public void discoverUnique (Group myGroup, Box[][] boxMatrix){
		if (this.mergedSet.size() == 8 && this.value == 0){
			// Determine the missing number
			myGroup.universeSet.removeAll (this.mergedSet);
			this.value = myGroup.universeSet.iterator().next();

			// Add the value to correspondient groups (Row, Column, Grid)
			myGroup.myRows[this.x].addValue (this.value);
			myGroup.myColumns[this.y].addValue (this.value);
			myGroup.myGrids[this.grid].addValue (this.value);

			// Populate again the Universe Set
			myGroup.populateUniverse();
		}
	}

	// Getters
	public int getValue (){
		return value;
	}
}
