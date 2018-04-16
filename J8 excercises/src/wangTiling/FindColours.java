package wangTiling;

import java.util.Random;

public class FindColours
{
private int b;
	Random rng;
	public FindColours(int seed, int bound)
	{
		rng = new Random(seed);
		this.b = bound;
	}


	public final int bound()
	{
		return b;
	}

	public final int pick_color()
	{
		return rng.nextInt(bound() - 1);
	}

	public final int pick_different_color(int c)
	{
		int r = rng.nextInt(bound() - 2);
		if (r < c)
		{
			return r;
		}
		return r + 1;
	}

	public final int pick_different_color(int c1, int c2)
	{
		int col1 = c1;
		int col2 = c2;
		if (c1 == c2)
		{
			return pick_different_color(c1);
		}
		if (c2 < c1)
		{
			col1 = c2;
			col2 = c1;
		}
		int r = rng.nextInt(bound() - 3);
		if (r < c1)
		{
			return r;
		}
		r += 1;
		if (r < c2)
		{
			return r;
		}
		return r + 1;
	}

	public final void complete_tile(int[] t)
	{
		int a = 0;
		int b = 1;
		int c = 2;
		int d = 3;
		if (t[a] == -1)
		{
			int temp;
			temp = a;
			a = c;
			c = temp;
		}
		if (t[b] == -1)
		{
			int temp = b;
			b=d;
			d = temp;
		}

		if (t[a] == -1 && t[b] > -1)
		{
			int temp = a;
			a = b;
			b = temp;
			temp = c;
			c = d;
			d = temp;
		}

		if (t[b] == -1 && t[c] > -1)
		{
			t[b] = pick_color();
			if (t[a] == t[c])
			{
				t[d] = pick_different_color(t[b]);
			}
			else
			{
				t[d] = t[b];
			}
			return;
		}

		if (t[c] == -1 && t[d] > -1)
		{
			int temp = a;
			a = b;
			b = temp;
			temp = c;
			c = d;
			d = temp;
		}


		if (t[a] == -1)
		{
			t[a] = pick_color();
		}
		if (t[b] == -1)
		{
			t[b] = pick_color();
		}

		if (t[c] == -1)
		{
			if (rng.nextDouble() > 0.5)
			{
				t[c] = t[a];
			}
			else
			{
				t[c] = pick_different_color(t[a]);
			}
		}

		if (t[d] == -1)
		{
			if (t[a] != t[c])
			{
				t[d] = t[b];
			}
			else
			{
				t[d] = pick_different_color(t[b]);
			}
		}
	}

	
}