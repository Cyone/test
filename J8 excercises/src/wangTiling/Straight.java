package wangTiling;

import java.util.*;

public class Straight extends CellType
{
	public int a;
	public int b;
	public Straight(int a, int b, Pair<Integer, Integer> pos, Edge input, Edge output)
	{
		
		super(pos, input, output);
		this.a = a;
		this.b = b;
	}

	@Override
	public final int propagate(FindColours g, int inc)
	{
		in_color = inc;
		if (a == b)
		{
			out_color = g.pick_different_color(inc);
		}
		else
		{
			out_color = inc;
		}
		return out_color;
	}

	@Override
	public final boolean is_pass()
	{
		return a != b;
	}

	@Override
	public final boolean is_straight()
	{
		return true;
	}

	

}