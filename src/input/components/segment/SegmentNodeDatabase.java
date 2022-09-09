package input.components.segment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.text.html.HTMLDocument.Iterator;
import input.components.point.PointNode;
public class SegmentNodeDatabase {
	
	protected Map<PointNode, Set<PointNode>>_adjLists;
	public SegmentNodeDatabase() {
		_adjLists = new HashMap<PointNode, Set<PointNode>>();
	}
	public SegmentNodeDatabase(Map<PointNode, Set<PointNode>> initialMap) {
		_adjLists = initialMap;
	}
	
	/**
	 * @return the number of edges where both points point to each other
	 */
	public int numUndirectedEdges() {
		int numEdges = 0;
		for (Entry<PointNode, Set<PointNode>> e : _adjLists.entrySet()) {
			for (PointNode n : e.getValue()) {
				if (_adjLists.get(n).contains(e.getKey())) {
					numEdges++;
				}
			}
		}
		return numEdges / 2;
	}
	
	/**
	 * adds an edge going from startPoint to endPoint if it doesn't already exist
	 *
	 * @param startPoint
	 * @param endPoint
	 */
	private void addDirectedEdge(PointNode startPoint, PointNode endPoint) {
		
		if (_adjLists.containsKey(startPoint) && _adjLists.get(startPoint).contains(endPoint)) { return; }
		else if (_adjLists.containsKey(startPoint)) {
			_adjLists.get(startPoint).add(endPoint);
		}
		else {
			Set<PointNode> values = new LinkedHashSet<PointNode>();
			values.add(endPoint);
			_adjLists.put(startPoint, values);
		}
	}
	
	/**
	 * adds an undirected edge to the adjency map
	 *
	 * @param firstPoint
	 * @param secondPoint
	 */
	public void addUndirectedEdge(PointNode firstPoint, PointNode secondPoint) {
		this.addDirectedEdge(firstPoint, secondPoint);
		this.addDirectedEdge(secondPoint, firstPoint);
	}
	
	/**
	 * adds a point and its set of points where there's an
	 * edge between the points. Also adds the new point to all
	 * adjacency lists it is connected to
	 *
	 * @param point the new point that should be added to the map
	 * @param list the adjacency list of the new point
	 */
	public void addAdjacencyList(PointNode point, List<PointNode> list) {
		if (_adjLists.containsKey(point)) { return; }
		_adjLists.put(point, (new LinkedHashSet<PointNode>(list)));
		for (int i = 0; i < list.size(); i ++) {
			_adjLists.get(list.get(i)).add(point);
		}
	}
	
	/**
	 * @return a list containing all the segments in the adjacency list
	 */
	public List<SegmentNode> asSegmentList() {
		List<SegmentNode> segmentNodeList = new ArrayList<SegmentNode>();
		for (Entry<PointNode, Set<PointNode>> e : _adjLists.entrySet()) {
			for (PointNode n : e.getValue()) {
				segmentNodeList.add(new SegmentNode(e.getKey(), n));
			}
		}
		return segmentNodeList;
	}
	
	/**
	 * @return a list of all unique segments in the adjacency map
	 */
	public List<SegmentNode> asUniqueSegmentList()
	{
		List<SegmentNode> segments = new ArrayList<SegmentNode>();
		for (Map.Entry<PointNode, Set<PointNode>> entry : _adjLists.entrySet())
		{
			for (PointNode destination : entry.getValue())
			{
				SegmentNode seg = new SegmentNode(entry.getKey(), destination);
				if (!segments.contains(seg)) segments.add(seg);
			}
		}
		return segments;
	}
}