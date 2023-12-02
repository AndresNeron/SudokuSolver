public class BoxMatrix {
	int rows	= 9;
	int columns	= 9;
	boolean hasZero = false;
	String filePath;

	// Create a Matrix of Box objects (this is an attribute)
	Box[][] boxMatrix = new Box[rows][columns];

	// Set filePath
	public void setPath (String filePath){
		this.filePath	=	filePath;
	}

	// Populate the matrix with Box instances
	public void initMatrix (){
		for (int n = 0; n < rows; n++) {
			for (int m = 0; m < columns; m++){
				this.boxMatrix[n][m] = new Box(n,m,1);
			}
		}
		CustomCSVReader myCSV	=	new CustomCSVReader();
		myCSV.read_CSV(this.filePath, this.boxMatrix);
	}

	// Prints the contents of all the boxes
	public void printMatrix (){
		for (int n = 0; n < rows; n++) {
			for (int m = 0; m < columns; m++){
				this.boxMatrix[n][m].print_x_y_value();
			}
		}
	}

	public void SolveSudoku (Group myGroup){
		do {
			this.hasZero = false;
			for (int n = 0; n < rows; n++) {
				for (int m = 0; m < columns; m++){
					this.boxMatrix[n][m].joinSets (myGroup);
					this.boxMatrix[n][m].discoverUnique (myGroup, this.boxMatrix);

					// Check if any value is zero; then sets the flag
					if (this.boxMatrix[n][m].getValue() == 0){
						this.hasZero = true;
					}
				}
			}
		} while (this.hasZero);
	}

}
