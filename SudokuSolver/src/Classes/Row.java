import java.util.HashSet;
import java.util.Set;

public class Row {
	int x;
	Set<Integer> xSet = new HashSet<>();

	public void addRow (int x, Box[][] boxMatrix){
		this.x = x;
		for (int i = 0; i < 9; i++){
			int value = boxMatrix[x][i].getValue();
			
			if ( value != 0){
				xSet.add( value );
			}
		}
	}

	public void addValue (int value){
		xSet.add(value);
	}

	public void printRow ( Box[][] boxMatrix){
		System.out.println( "Row " + (this.x+1) + "	" + xSet );
	}

	
}
