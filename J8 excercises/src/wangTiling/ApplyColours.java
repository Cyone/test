package wangTiling;

import java.util.TreeMap;

public class ApplyColours  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static int getColor(TreeMap<Edge, Integer> c, Edge e) {
		
		int result;
		try {
			result = c.get(e);
		} catch (Exception e1) {
			result = -1;
		}
		return result;
	}

	public static void setColor(TreeMap<Edge, Integer> c, Edge e, int color) {
		c.put(e, color);
	}

	public static int[] getTile(TreeMap<Edge, Integer> c, Pair<Integer, Integer> current) {
		int[] t = { getColor(c, Edge.top(current)), getColor(c, Edge.left(current)), getColor(c, Edge.bottom(current)),
				getColor(c, Edge.right(current)) };
		return t;
	}

	public static void set_tile(TreeMap<Edge, Integer> c, Pair<Integer, Integer> current, int[] t) {
		setColor(c, Edge.top(current), t[0]);
		setColor(c, Edge.left(current), t[1]);
		setColor(c, Edge.bottom(current), t[2]);
		setColor(c, Edge.right(current), t[3]);
	}
}