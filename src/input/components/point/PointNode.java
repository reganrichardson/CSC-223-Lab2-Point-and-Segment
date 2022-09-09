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
		//create hash code for node
		return Double.valueOf(_x).hashCode() + Double.valueOf(_y).hashCode();
	}
	/**
	 * checks if an object is the same node as one given
	 */
	@Override
	public boolean equals(Object obj)
	{
		//if object is null return false
		if (obj == null) return false;
		//check that object is in the class, if not return false
		if (this.getClass() != obj.getClass()) return false;
		//turn the obj into a point node
		PointNode P = (PointNode) obj;
		
		//if(P.getX()-this.getX() > MathUtilities.EPSILON || P.getX()-this.getX() < -MathUtilities.EPSILON) return false;
		//if(P.getY()-this.getY() > MathUtilities.EPSILON || P.getY()-this.getY() < -MathUtilities.EPSILON) return false;
		
		//If the x and y values are the same, return true
		if(MathUtilities.doubleEquals(P.getX(), this.getX()) && MathUtilities.doubleEquals(P.getY(), this.getY())) return true;
		//if they are not the same return false
		return false;
	}
	/**
	 * a method that will turn the node into a string (x,y)
	 */
	@Override
	public String toString()
	{
		//return node as a string
		return ( "(" + this.getX() + "," + this.getY() + ")");
	}
}
