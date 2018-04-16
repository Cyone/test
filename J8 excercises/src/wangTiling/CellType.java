package wangTiling;

import java.util.*;

public abstract class CellType {
	public abstract boolean is_pass();

	public abstract boolean is_straight();


	public Pair<Integer, Integer> pos = new Pair<Integer, Integer>();
	public Edge input;
	public Edge output;
	public int in_color;
	public int out_color;
	public abstract int propagate(FindColours g, int in_color);

	public CellType(Pair<Integer, Integer> pos, Edge input, Edge output) {
		this.pos = pos;
		this.input = input;
		this.output = input;
		this.in_color = -1;
		this.out_color = -1;
	}

	
}