import java.util.ArrayList;

import javafx.scene.image.Image;

public class ChocolateCandyBomb extends Candy {
	private static final String[] imageDirectory = new String[] {"chocolaCandyBomb.png"};
	private static ArrayList<Image> imgList = new ArrayList<Image>();


	public ChocolateCandyBomb() {
		super();
	}
		
	

	public ChocolateCandyBomb(int color) {
		
		super(color);
	}

	public ArrayList<Coordinate> specialExplode(Coordinate curCoor) {
		ArrayList<Coordinate> list = new ArrayList<>();
		int i = curCoor.getRow();
		int j = curCoor.getColumn();
		for(i=0; i<Main.getNumberofrow();i++)
			for ( j = 0; j < Main.getNumberofcolumn(); ++j)
				if ((i != curCoor.getRow() || j != curCoor.getColumn()) && checkInside(i, j))
					list.add(new Coordinate(i, j));
		
		return list;
	}

	private boolean checkInside(int curRow, int curCol) {
		if (0 <= curRow && curRow < Main.getNumberofrow() && 0 <= curCol && curCol < Main.getNumberofcolumn())
			return true;
		return false;
	}
	
	
	public String[] getImageDirectory() {
		return imageDirectory;
	}

	
	public ArrayList<Image> getImgList() {
		return imgList;
	}
}
