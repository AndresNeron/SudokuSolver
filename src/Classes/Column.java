import java.util.HashSet;
import java.util.Set;

public class Column {
	int y;
	Set<Integer> ySet = new HashSet<>();

	public void addColumn (int y, Box[][] boxMatrix){
		this.y = y;
		for (int i = 0; i < 9; i++){
			int value = boxMatrix[i][y].getValue();
			
			if ( value != 0){
				ySet.add( value );
			}
		}
	}

	public void addValue (int value){
		ySet.add(value);
	}

	public void printColumn ( Box[][] boxMatrix){
		System.out.println( "Column " + (this.y+1) + "	" + ySet );
	}

}
