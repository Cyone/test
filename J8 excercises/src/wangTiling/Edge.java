package wangTiling;

import java.util.*;

public class Edge {
	public Orientation o;
	public int i;
	public int j;

	public Edge(Orientation o, int i, int j) {
		this.o = o;
		this.i = i;
		this.j = j;
	}

	public static Edge top(Pair<Integer, Integer> c) {
		return new Edge(Orientation.H, c.first, c.second);
	}

	public static Edge left(Pair<Integer, Integer> c) {
		return new Edge(Orientation.V, c.first - 1, c.second);
	}

	public static Edge bottom(Pair<Integer, Integer> c) {
		return new Edge(Orientation.H, c.first, c.second - 1);
	}

	public static Edge right(Pair<Integer, Integer> c) {
		return new Edge(Orientation.V, c.first, c.second);
	}

	public static Edge edge_between(Pair<Integer, Integer> cin, Pair<Integer, Integer> cout) throws Exception {
		if (Math.abs(cin.first - cout.first) + Math.abs(cin.second - cout.second) != 1) {
			throw new Exception("No Edge");
		}

		if (cin.first + 1 == cout.first) {
			return new Edge(Orientation.V, cin.first, cin.second);
		} else if (cin.first - 1 == cout.first) {
			return new Edge(Orientation.V, cout.first, cout.second);
		} else if (cin.second + 1 == cout.second) {
			return new Edge(Orientation.H, cin.first, cin.second);
		} else {
			return new Edge(Orientation.H, cout.first, cout.second);
		}
	}

}