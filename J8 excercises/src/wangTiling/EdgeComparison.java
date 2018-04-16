package wangTiling;

import java.util.*;

public class EdgeComparison implements Comparator<Edge> {

	@Override
	public int compare(Edge lhs, Edge rhs) {
		if (lhs.o == Orientation.H && rhs.o == Orientation.V) {
			return 1;
		}
		if (lhs.o == rhs.o) {
			if (lhs.i < rhs.i) {
				return 1;
			}
			if (lhs.i == rhs.i) {
				return (lhs.j < rhs.j) ? 1 : -1;
			}
		}
		return -1;
	}
}