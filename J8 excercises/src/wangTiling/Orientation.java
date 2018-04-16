package wangTiling;

import java.util.*;

public enum Orientation
{
	H,
	V;

	public int getValue()
	{
		return this.ordinal();
	}

	public static Orientation forValue(int value)
	{
		return values()[value];
	}
}