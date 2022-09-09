import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import input.components.point.PointNode;
import input.components.point.PointNodeDatabase;
/**
 * Runs Junit tests on the methods to ensure
 * capability and works on a variety of test cases.
 * @author Sally Stahl
 * @version September 8, 2022
 */
class PointNodeDatabaseTest {
	
	/**
	 * Uses jUnit testing to test the the put method will add a
	 * node to the database.
	 */
	@Test
	void testPut() {
		//create a new test database
		PointNodeDatabase testNodeDatabase = new PointNodeDatabase();
		
		//create a test node
		PointNode testNode1 = new PointNode("Node1", 1 ,1);
		PointNode testNode2 = new PointNode("Node2", 2, 2);
		
		
		//check that the element is not in the database
		assertFalse(testNodeDatabase.contains(testNode1));
		assertFalse(testNodeDatabase.contains(1,1));
	
		
		//put an element in the database
		testNodeDatabase.put(testNode1);
		
		
		//check if node is in the database
		assertTrue(testNodeDatabase.contains(testNode1));
		assertTrue(testNodeDatabase.contains(1,1));
		
		
		//put another node in the database
		testNodeDatabase.put(testNode2);
		
		
		//check that the node is in database
		assertTrue(testNodeDatabase.contains(testNode2));
		assertTrue(testNodeDatabase.contains(2,2));
		assertFalse(testNodeDatabase.contains(1,2));
		
		
		
	}
	
	
	/**
	 * Uses jUnit testing to check if a node with an associated x,y coordinate
	 * exists within the database.
	 */
	
	@Test
	void testContainsXY() {
		
		//create a test database
		PointNodeDatabase testNodeDatabase = new PointNodeDatabase();
		//create a test node
		PointNode testNode1 = new PointNode("Node1", 1, 1);
		PointNode testNode2 = new PointNode("Node2", 2, 2);
		
		
		//test on the empty database
		assertFalse(testNodeDatabase.contains(1 , 1));
		assertFalse(testNodeDatabase.contains(testNode1));
		
		
		//test by adding a node
		testNodeDatabase.put(testNode1);
		
		
		//check if the node is in the database
		assertTrue(testNodeDatabase.contains(1,1));
		assertFalse(testNodeDatabase.contains(1,2));
		assertFalse(testNodeDatabase.contains(1,2));
		
		
		//add another node to database
		testNodeDatabase.put(testNode2);
		
		
		//test that second node is in database
		assertTrue(testNodeDatabase.contains(2,2));
		
		
		//test values that are not in the database
		assertFalse(testNodeDatabase.contains(1,2));
		assertFalse(testNodeDatabase.contains(3,2));
		assertFalse(testNodeDatabase.contains(3, 3));
	}
	
	
	
	/**
	 * Uses jUnit testing to check if a node exists within the
	 * database.
	 */
	
	@Test
	void testContainsNode() {
		
		//create a test database
		PointNodeDatabase testNodeDatabase = new PointNodeDatabase();
		
		//create test nodes
		PointNode testNode1 = new PointNode("Node1", 1.0 , 1.0);
		PointNode testNode2 = new PointNode("Node2", 2, 2);
		PointNode testNode3 = new PointNode("Node3", 3, 3);
		PointNode testNode4 = new PointNode("Node2", 4, 4);
		
		//test on an empty database
		assertFalse(testNodeDatabase.contains(testNode1));
	
	
		testNodeDatabase.put(testNode1);
			
		//check if the node is in the database
		assertTrue(testNodeDatabase.contains(testNode1));
		assertFalse(testNodeDatabase.contains(testNode2));
				
		//add another node to database
		testNodeDatabase.put(testNode2);
		
		//test that second node is in database
		assertTrue(testNodeDatabase.contains(testNode2));
		assertTrue(testNodeDatabase.contains(testNode1));
		
		
		//check for nodes that are not in the database
		assertFalse(testNodeDatabase.contains(testNode3));
		assertFalse(testNodeDatabase.contains(testNode4));
		
	}
	
	
	
	
	/**
	 * Uses jUnit testing to get the name of the node
	 * by searching with the node itself.
	 */
	
	@Test
	void testGetNameNode() {
		
		//create a test database
		PointNodeDatabase testNodeDatabase = new PointNodeDatabase();
		
		//create test nodes
		PointNode testNode1 = new PointNode("Node1", 1, 1);
		PointNode testNode2 = new PointNode("Node2", 2, 2);
		PointNode testNode3 = new PointNode("Node3", 3, 3);
		PointNode testNode4 = new PointNode("Node4", 4, 4);
		
		//test the method on an empty database
		assertEquals(null, testNodeDatabase.getName(testNode1));
		assertFalse(testNodeDatabase.contains(testNode1));
		
		
		//add a node to the database
		testNodeDatabase.put(testNode1);
		//check that the node is in the database			
		assertTrue(testNodeDatabase.contains(testNode1));
		
		
		//call the method on the node
		assertEquals("Node1", testNodeDatabase.getName(testNode1));
		
		//add a second node
		testNodeDatabase.put(testNode2);
		
		//check that the node is in the database
		assertTrue(testNodeDatabase.contains(testNode2));
		
		//call the method on the second node
		assertEquals("Node2", testNodeDatabase.getName(testNode2));
		
		
		
		//check for nodes that are not in the database
		assertEquals(null, testNodeDatabase.getName(testNode3));
		assertEquals(null, testNodeDatabase.getName(testNode4));
	}
	
	
	
	
	/**
	 * Uses jUnit testing to get the name of the node
	 * using its x and y coordinates.
	 */
	
	@Test
	void testGetNameXY() {
		
		//create a test database
		PointNodeDatabase testNodeDatabase = new PointNodeDatabase();
		
		//create test nodes
		PointNode testNode1 = new PointNode("Node1", 1, 1);
		PointNode testNode2 = new PointNode("Node2", 2, 2);
		
		
		//test the method on an empty database
		assertEquals(null, testNodeDatabase.getName(1, 1));
		assertFalse(testNodeDatabase.contains(1, 1));
				
				
		//add a node to the database
		testNodeDatabase.put(testNode1);
		//check that the node is in the database			
		assertTrue(testNodeDatabase.contains(testNode1));
				
				
		//call the method on the node
		assertEquals("Node1", testNodeDatabase.getName(1, 1));
				
		//add a second node
		testNodeDatabase.put(testNode2);
				
		//check that the node is in the database
		assertTrue(testNodeDatabase.contains(testNode2));
		//call the method on the second node
		assertEquals("Node2", testNodeDatabase.getName(2, 2));
		
		
		//check for an element that is not in the database
		assertFalse(testNodeDatabase.contains(3,3));
		assertEquals(null, testNodeDatabase.getName(3,3));
		assertEquals(null, testNodeDatabase.getName(1,2));
			
		
	}
	
}
