import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import input.components.point.PointNode;
import input.components.segment.SegmentNode;
import input.components.segment.SegmentNodeDatabase;
class SegmentNodeDatabaseTest
{
    public SegmentNodeDatabase build()
    {
    	//      A
    	//     / \
    	//    B___C
    	//   / \ / \
    	//  /   X   \
    	// D_________E
    	//
		//
    	PointNode a = new PointNode("A", 3, 6);
    	PointNode b = new PointNode("B", 2, 4);
    	PointNode c = new PointNode("C", 4, 4);
    	PointNode d = new PointNode("D", 0, 0);
    	PointNode e = new PointNode("E", 6, 0);
    	PointNode x = new PointNode("X", 3, 3);
    	SegmentNodeDatabase db = new SegmentNodeDatabase();
    	  	
    	db.addUndirectedEdge(a, b);
    	db.addUndirectedEdge(a, c);
    	db.addUndirectedEdge(b, c);
    	db.addUndirectedEdge(b, x);
    	db.addUndirectedEdge(b, d);
    	db.addUndirectedEdge(c, x);
    	db.addUndirectedEdge(c, e);
    	db.addUndirectedEdge(x, d);
    	db.addUndirectedEdge(x, e);
    	db.addUndirectedEdge(d, e);
    	
    	return db;
    }
	@Test
	void testNumUndirectedEdges()
	{
		SegmentNodeDatabase db = build();
		
		assertEquals(10, db.numUndirectedEdges());
	}
	
	@Test
	void testAddUnDirectedEdge()
	{
		SegmentNodeDatabase db = build();
		
		assertEquals(10, db.numUndirectedEdges());
		
		// adds edge that already exists so nothing should happen
		PointNode a = new PointNode("A", 3, 6);
    	PointNode b = new PointNode("B", 2, 4);
		db.addUndirectedEdge(a, b);
		assertEquals(10, db.numUndirectedEdges());
		
		// adds edge where the points exists but there is no existing edge between them
    	PointNode x = new PointNode("X", 3, 3);
    	db.addUndirectedEdge(x, a);
    	assertEquals(11, db.numUndirectedEdges());
    	
    	// adds edge where one of the points doesn't already exist
    	PointNode y = new PointNode("Y", 3, 1);
    	db.addUndirectedEdge(y, x);
    	assertEquals(12, db.numUndirectedEdges());
	}
	
	@Test
	void testAddAdjacencyList()
	{
		SegmentNodeDatabase db = build();
		PointNode y = new PointNode("Y", 3, 1);
		ArrayList<PointNode> adjList = new ArrayList<PointNode>();
		adjList.add(new PointNode("D", 0, 0));
    	adjList.add(new PointNode("E", 6, 0));
    	adjList.add(new PointNode("X", 3, 3));
    	
    	// testing to add an adjacency list which should add 3 edges
    	db.addAdjacencyList(y, adjList);
    	assertEquals(13, db.numUndirectedEdges());
    	
    	// tests to add an adjacency list of a point which already exists in the map
    	adjList.clear();
		adjList.add(new PointNode("B", 2, 4));
    	adjList.add(new PointNode("C", 4, 4));
    	adjList.add(new PointNode("X", 3, 3));
    	db.addAdjacencyList(new PointNode("A", 3, 6), adjList);
    	assertEquals(13, db.numUndirectedEdges());
	}
	
	@Test
	void testAsSegmentList()
	{
		SegmentNodeDatabase db = build();
		List<SegmentNode> segmentList = db.asSegmentList();
		
		// should contain 20 segments because there are 10 undirected edges
		assertEquals(20, segmentList.size());
		
		PointNode a = new PointNode("A", 3, 6);
		PointNode x = new PointNode("X", 3, 3);
		PointNode e = new PointNode("E", 6, 0);
    	db.addUndirectedEdge(x, a);
    	// segmentList should now contain 22 segments
    	segmentList = db.asSegmentList();
    	assertEquals(22, segmentList.size());
    	// should contain the newly added segments
    	assertTrue(segmentList.contains(new SegmentNode(x, a)));
    	// should not contain a segment that is not in the adjacency map
    	assertFalse(segmentList.contains(new SegmentNode(a, e)));
	}
	
	@Test
	void testAsUniqueSegmentList()
	{
		SegmentNodeDatabase db = build();
		List<SegmentNode> segList = db.asUniqueSegmentList();
		PointNode a = new PointNode("A", 3, 6);
		PointNode b = new PointNode("B", 2, 4);
		
		// should contain 10 unique segments
		assertEquals(10, segList.size());
		assertTrue(segList.contains(new SegmentNode(a, b)));
	}
}