package wangTiling;

import java.util.*;

public class Corner extends CellType {
	public Corner(int a, int b, Pair<Integer, Integer> pos, Edge input, Edge output) {
		
		super(pos, input, output);
		this.a = a;
		this.b = b;
	}

	@Override
	public final int propagate(FindColours g, int inc) {
		in_color = inc;
		if (a == in_color) {
			out_color = g.pick_different_color(b);
		} else {
			out_color = b;
		}
		return out_color;
	}

	@Override
	public final boolean is_pass() {
		return false;
	}

	@Override
	public final boolean is_straight() {
		return false;
	}

	public int a;
	public int b;
}