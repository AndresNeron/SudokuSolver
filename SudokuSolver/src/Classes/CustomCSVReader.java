import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CustomCSVReader {

	// Attributes
	String filePath;

	// Getters and Setters
    public void get_Path() {
        System.out.println(this.filePath);
    }

	public void set_Path(String filePath){
		this.filePath = filePath;
	}

	// This method reads a CSV file and save the content in a Box[][]
	public void read_CSV (String filePath, Box[][] boxMatrix){
		BufferedReader reader = null;	
		String line = "";
		int[] array = new int[3];

		try {
			reader = new BufferedReader (new FileReader(filePath));
			while ((line = reader.readLine()) != null){
				String[] row = line.split(",");

				for (int i = 0; i < 3; i++){
					// Cast the String and Convert it into a integer value
					array[i]	=	Integer.parseInt(row[i]);
				}
				int x = array[0]-1;
				int y = array[1]-1;
				int value = array[2];

				// Assigns the three values to each box
				boxMatrix[x][y] = new Box(x,y,value);
			}
		} catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
	}

}
