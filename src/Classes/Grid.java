import java.util.HashSet;
import java.util.Set;

public class Grid {
	int x;
	int y;
	int grid;
	Set<Integer> gridSet = new HashSet<>();

	public void addGrid (int grid, Box[][] boxMatrix){
		this.grid = grid;

		x = 3 * (this.grid / 3);
		y = 3 * (this.grid % 3 );

		//System.out.println("(x,y):	" + x + " " + y);

		for (int i = x; i < (x+3); i++ ){
			for (int j = y; j < (y+3); j++){
				//System.out.println(i + " " + j);

				int value = boxMatrix[i][j].getValue();

				if ( value != 0){
					gridSet.add( value );
				}
			}
		}
	}

	public void addValue (int value){
		gridSet.add(value);
	}

	public void printGrid ( Box[][] boxMatrix ){
		System.out.println( "Grid " + (this.grid+1) + "		" + gridSet );
	}
}
