package wangTiling;

import java.util.*;

public class Plane
{
	private int m_width;
	private int m_height;
	private ArrayList<Integer> m_cells = new ArrayList<Integer>();
	public Plane(int width, int height)
	{
		this.m_width = width;
		this.m_height = height;
		this.m_cells = new ArrayList<Integer>(width * height);
	}


	public final int to_index(Pair<Integer, Integer> c)
	{
		return m_width * (int)c.second + (int)c.first;
	}


	public final Pair<Integer, Integer> from_index(int index)
	{
		int i = (int)(index % m_width);
		int j = (int)(index / m_width);
		return new Pair<Integer, Integer>(i, j);
	}


	public final boolean in_boundaries(Pair<Integer, Integer> c)
	{
		return (c.first >= 0 && c.first < (int)m_width && c.second >= 0 && c.second < (int)m_height);
	}

	public final void add_cell(Pair<Integer, Integer> c)
	{
		if (in_boundaries(c))
		{
			m_cells.set(to_index(c), 1);
		}
	}

	public final void add_cell(int i, int j)
	{
		add_cell(new Pair<Integer, Integer>(i, j));
	}


	public final boolean in_polygon(Pair<Integer, Integer> c)
	{
		if (in_boundaries(c))
		{
			return m_cells.get(to_index(c)) > 0;
		}
		return false;
	}


	public final boolean in_polygon(int i, int j)
	{
		return in_polygon(new Pair<Integer, Integer>(i, j));
	}

	public final ArrayList<Pair<Integer, Integer>> neighbors(Pair<Integer, Integer> c)
	{
		ArrayList<Pair<Integer, Integer>> n = new ArrayList<Pair<Integer, Integer>>();
		Pair<Integer, Integer>  topCell = new Pair<>(c.first, c.second + 1);
		Pair<Integer, Integer> leftCell = new Pair<>(c.first - 1, c.second);
		Pair<Integer, Integer> bottomCell = new Pair<Integer, Integer>(c.first, c.second - 1);
		Pair<Integer, Integer>  rightCell =new Pair<>(c.first + 1, c.second);

		if (in_polygon(topCell))
		{
			n.add(topCell);
		}
		if (in_polygon(leftCell))
		{
			n.add(leftCell);
		}
		if (in_polygon(bottomCell))
		{
			n.add(bottomCell);
		}
		if (in_polygon(rightCell))
		{
			n.add(rightCell);
		}
		return n;
	}


	public static Pair<Integer, Integer> first(Edge e)
	{
		return new Pair<Integer, Integer>(e.i, e.j);
	}

	public static Pair<Integer, Integer> second(Edge e)
	{
		switch (e.o)
		{
			case H:
				return new Pair<Integer, Integer>(e.i, e.j + 1);
			case V:
				return new Pair<Integer, Integer>(e.i + 1, e.j);
		}
		return null;
	}

	public final boolean is_boundary_edge(Edge e)
	{

		Pair<Integer, Integer> f =first(e);

		Pair<Integer, Integer> s = second(e);
		return (in_polygon(f) != in_polygon(s));
	}


	public final boolean is_interior_edge(Edge e)
	{

		return in_polygon(first(e)) && in_polygon(second(e));
	}

	public final void mark(Pair<Integer, Integer> c)
	{
		if (in_polygon(c) && m_cells.get(to_index(c)) % 2 == 1)
		{
			m_cells.set(to_index(c), m_cells.get(to_index(c)) + 1);
		}
	}


	public final boolean is_marked(Pair<Integer, Integer> c)
	{
		if (in_polygon(c))
		{
			return m_cells.get(to_index(c)) % 2 == 0;
		}
		return false;
	}

	public final void clean_marks()
	{
		for (int index = 0; index < m_width * m_height; ++index)
		{
			if (m_cells.get(index) > 0 && m_cells.get(index) % 2 == 0)
			{
				m_cells.set(index, m_cells.get(index) - 1);
			}
		}
	}

	public final void set_to_tiled(Pair<Integer, Integer> c)
	{
		if (in_polygon(c) && m_cells.get(to_index(c)) < 3)
		{
			m_cells.set(to_index(c), m_cells.get(to_index(c)) + 2);
		}
	}


	public final void vertex_iter(Action1Param<Pair<Integer, Integer>> f)
	{
		for (int index = 0; index < m_width * m_height; ++index)
		{
			if (m_cells.get(index) >= 1)
			{
				f.invoke(from_index(index));
			}
		}
	}


	public final void outside_vertex_iter(Action1Param<Pair<Integer, Integer>> f)
	{
		for (int index = 0; index < m_width * m_height; ++index)
		{
			if (m_cells.get(index) == 0)
			{
				f.invoke(from_index(index));
			}
		}
	}

	public final void edge_iter(Action1Param<Edge> f)
	{
		TreeSet<Edge> visited = new TreeSet<Edge>(new EdgeComparison());
		for (int index = 0; index < m_width * m_height; ++index)
		{
			if (m_cells.get(index) == 1)
			{
				for (Edge e : adjacent_edges(from_index(index)))
				{
					if (!visited.contains(e))
					{
						f.invoke(e);
						visited.add(e);
					}
				}
			}
		}
	}
	public static ArrayList<Edge> adjacent_edges(Pair<Integer, Integer> c)
	{
		ArrayList<Edge> e = new ArrayList<>();
		e.add(Edge.top(c));
		e.add(Edge.left(c));
		e.add(Edge.bottom(c));
		e.add(Edge.right(c));
		return e;
	}
	public static class EmptyBoard extends RuntimeException
	{
	}

	public final Pair<Integer, Integer> find_a_cell()
	{
		for (int index = 0; index < m_width * m_height; ++index)
		{
			if (m_cells.get(index) == 1)
			{
				return from_index(index);
			}
		}
		throw (new EmptyBoard());
	}


	public final int width()
	{
		return m_width;
	}

	public final int height()
	{
		return m_height;
	}

	

}