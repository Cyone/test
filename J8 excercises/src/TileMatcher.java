import java.util.Set;

public class TileMatcher {
	Tile[][] plane;

	public TileMatcher(int x, int y) {
		plane = new Tile[x][y];
	}

	public Tile[][] fillPlane(Set<Tile> tiles) {
		plane[0][0] = (Tile) tiles.toArray()[0];

		// Top Line
		for (int i = 1; i < plane[0].length; i++) {
			checkTile: for (Tile t : tiles) {
//				System.out.println(t.toString());
//				System.out.println(plane[i-1][0].toString()+"\n"+"\n");
				if (plane[0][i-1].getRight() == t.getLeft()) {
					plane[0][i] = t;
					break checkTile;
				}
				
			}
		}
		for (int j = 1; j < plane.length; j++) {
			horizontal: for (int i = 0; i < plane[j].length; i++) {
				System.out.println(j+"-"+i);
				 for (Tile t : tiles) {
					if (i==0&&plane[j-1][i].getBot() == t.getTop()) {
						plane[j][i] = t;
						continue horizontal;
					}
					if (plane[j-1][i].getBot() == t.getTop()) {
						if (plane[j][i-1].getRight() == t.getLeft()) {
							plane[j][i] = t;
							continue horizontal;
						}
					}

				}
			}
		}
		return plane;
	}
}
