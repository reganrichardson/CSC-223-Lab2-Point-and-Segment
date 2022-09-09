package input.components.point;


import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


/**
 * A method to perform a variety of tasks on a 
 * set of point nodes where each node has an associated x,y coordinate
 * as well as a name.
 * @author Sally Stahl
 * @version September 8, 2022
 */

public class PointNodeDatabase {
	
	
	/**
	 * A set of points with (x,y) coordinates
	 */
	protected Set<PointNode> _points;
	
	
	
	/**
	 * Initializes the instance variable.
	 */
	public PointNodeDatabase() {
		//Initialize the instance variable
		_points = new LinkedHashSet<PointNode>();
		
	}
	
	/**
	 * Initializes the instance variable.
	 * @param List of values to add to the set of points
	 */
	public PointNodeDatabase(List<PointNode> list) {
		
		//initialize the set of points
		_points = new LinkedHashSet<PointNode>();
		//add the list of point nodes into the set of points
		_points.addAll(list);
	}
	
	
	
	/**
	 * Will add a node to the set nodes
	 * @param node to add to list
	 */
	public void put(PointNode node) {
	
		//add the point
		_points.add(node);
		
		
	}
	
	
	/**
	 * Checks if a node with the x and y coordinates exists 
	 * in the set already.
	 * @param X an x-coordinate
	 * @param Y a y-coordinate
	 * @return boolean
	 */
	public boolean contains(double x , double y) {
		
		//loop through the set of items
		for(PointNode item: _points) {
			//is the x and y coordinates both align
			if(x ==item.getX() && y ==item.getY()) {
				//return true
				return true;
			
			}
		}

		//else return false
		return false;
	}
	
	
	
	/**
	 * Checks if a node exists within the set of nodes
	 * @param node 
	 * @return boolean
	 */
	
	public boolean contains(PointNode node) {
		
		//loop through the items in the set
		for( PointNode item: _points) {
			//if item exists
			if(item.equals(node)) {
			//return true
				return true;
			}
		}
		
		return false;
	}
	
	
	/**
	 * Gets the name of the node from input
	 * @param node you are getting the name from
	 * @return String- the name of the node
	 */
	public String getName(PointNode node) {
		//check if the node is in the set
		if(_points.contains(node)) {
			//return string
			return (node.getName()).toString();
			
		}
		//if the node is not in the set
		//return null
		return null;
	}
	
	
	
	/**
	 * Gets the name of the node from x and y coordinates
	 * @param x coordinate you are getting the name from
	 * @param y coordinate you are getting the name from 
	 * @return String- the name of the node
	 */
	public String getName(double x , double y) {
		
		//create a new node with the x and y values
		for(PointNode item: _points) {
			if(x ==item.getX() && y ==item.getY()) {
				return(item.getName().toString());
			}
		}
		return null;
	}
	
	
	/**
	 * Gets the node from the set of points
	 * @param the node you are returning
	 * @return the node from input
	 */
	public PointNode getPoint(PointNode node) {
		
		//check if the node is in the set of points
		if(_points.contains(node)) {
			return node;
		}
		
		//if it isn't in the set then return null
		return null;
	}
	
	
	/**
	 * Gets the node from the set of points using the x,y coordinates
	 * @param the x and y coordinates of the node you are returning
	 * @return node
	 */
	public PointNode getPoint(double x , double y) {
		
		//create a new node 
		PointNode newNode = new PointNode(x, y);
		
		//if the node exists in the set of points
		if(_points.contains(newNode)) {
			return newNode;	
		}
		
		//if it doesn't exist in the set return null
		return null;
	}
	
	
}




