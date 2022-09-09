package input.components.point;
import utilities.math.MathUtilities;
/**
 * creates a 2-D point, (x,y)
 *
 */
public class PointNode
{
	protected static final String ANONYMOUS = "__UNNAMED";
	protected double _x;
	public double getX() { return this._x; }
	protected double _y;
	public double getY() { return this._y; }
	protected String _name;
	public String getName() { return _name; }
	/**
	 * Create a new Point with the specified coordinates.
	 * @param x The X coordinate
	 * @param y The Y coordinate
	 */
	public PointNode(double x, double y)
	{
		this(ANONYMOUS,x,y);
	}
	/**
	 * Create a new Point with the specified coordinates.
	 * @param name -- The name of the point. (Assigned by the UI)
	 * @param x -- The X coordinate
	 * @param y -- The Y coordinate
	 */
	public PointNode(String name, double x, double y)
	{
		_x = x;
		_y = y;
		_name = name;
	}
	@Override
	public int hashCode()
	{
		return Double.valueOf(_x).hashCode() + Double.valueOf(_y).hashCode();
	}
	@Override
	public boolean equals(Object obj)
	{
		if (obj == null) return false;
		if (this.getClass() != obj.getClass()) return false;
		PointNode P = (PointNode) obj;
		
		//if(P.getX()-this.getX() > MathUtilities.EPSILON || P.getX()-this.getX() < -MathUtilities.EPSILON) return false;
		//if(P.getY()-this.getY() > MathUtilities.EPSILON || P.getY()-this.getY() < -MathUtilities.EPSILON) return false;
		
		if(MathUtilities.doubleEquals(P.getX(), this.getX()) && MathUtilities.doubleEquals(P.getY(), this.getY())) return true;
		return false;
	}
	@Override
	public String toString()
	{
		
		return ( "(" + this.getX() + "," + this.getY() + ")");
	}
}
