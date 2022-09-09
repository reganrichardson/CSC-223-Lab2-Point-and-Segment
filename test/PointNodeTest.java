
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import input.components.point.PointNode;
import utilities.math.MathUtilities;
/**
 * Tests PointNode Class
 * @author ReganRichardson
 *
 */
class PointNodeTest {
	@Test
	void testPointNodeDoubleDouble() {
		PointNode node1 = new PointNode(3,14);
		assertTrue(node1.getX() - 3 < MathUtilities.EPSILON);
		assertTrue(node1.getY() - 14 < MathUtilities.EPSILON);
	}
	@Test
	void testPointNodeStringDoubleDouble() {
		String nodeA = "node1";
		PointNode node1 = new PointNode(nodeA, 3, 14);
		assertTrue(node1.getX() - 3 < MathUtilities.EPSILON);
		assertTrue(node1.getY() - 14 < MathUtilities.EPSILON);
	}
	@Test
	void testEqualsObjectIsTrueExact() {
		PointNode node1 = new PointNode(3,14);
		PointNode node2 = new PointNode(3,14);
		
		assertTrue(node1.equals(node2));
	}
	
	@Test
	void testEqualsObjectIsNull() {
		PointNode node1 = new PointNode(3,14);
		
		assertFalse(node1.equals(null));
	}
	
	@Test
	void testEqualsObjectIsTrueNotExact() {
		PointNode node1 = new PointNode(3.000000001,14.000000000001);
		PointNode node2 = new PointNode(3.0,14.0);
		
		assertTrue(node1.equals(node2));
	}
	@Test
	void testEqualsObjectIsBothFalse() {
		PointNode node1 = new PointNode(3,14);
		PointNode node2 = new PointNode(4,14.05);
		
		assertFalse(node1.equals(node2));
	}
	
	@Test
	void testEqualsObjectXFalse() {
		PointNode node1 = new PointNode(3,14);
		PointNode node2 = new PointNode(7,14);
		
		assertFalse(node1.equals(node2));
	}
	
	@Test
	void testEqualsObjectYFalse() {
		PointNode node1 = new PointNode(3,14);
		PointNode node2 = new PointNode(3,16);
		
		assertFalse(node1.equals(node2));
	}
	
	@Test
	void testToStringTrue() {
		PointNode node1 = new PointNode(3,14);
		assertTrue(node1.toString().equals("(3.0,14.0)"));
	}
	
	@Test
	void testToStringFalse() {
		PointNode node1 = new PointNode(3,14);
		assertFalse(node1.toString().equals("(14.0,3.0)"));
	}
}