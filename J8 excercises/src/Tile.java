import java.util.Arrays;

import javafx.scene.paint.Color;

public class Tile {
	int[] sideInt;

	public Tile(int[] side) {
		sideInt = side;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(sideInt);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tile other = (Tile) obj;
		if (!Arrays.equals(sideInt, other.sideInt))
			return false;
		return true;
	}

	public int[] getSides() {
		return sideInt;
	}

	private Color whatColor(int i) {
		switch (i) {
		case 0:
			return Color.BLUE;
		case 1:
			return Color.YELLOW;
		case 2:
			return Color.RED;
		case 3:
			return Color.GREEN;
		}
		return null;
	}

	public Color getTop() {
		return whatColor(sideInt[0]);
	}

	public Color getBot() {
		return whatColor(sideInt[2]);
	}

	public Color getRight() {
		return whatColor(sideInt[1]);
	}

	public Color getLeft() {
		return whatColor(sideInt[3]);
	}

	@Override
	public String toString() {
		String a = "";
		for (int i : sideInt) {
			a += whatColorString(whatColor(i)) + "-";
		}
		return a.substring(0, a.length()-1);
	}

	private String whatColorString(Color col) {
		if (col.equals(Color.BLUE))
			return "Blue";
		if (col.equals(Color.YELLOW))
			return "Yellow";
		if (col.equals(Color.RED))
			return "Red";
		if (col.equals(Color.GREEN))
			return "Green";

		return null;
	}
}
