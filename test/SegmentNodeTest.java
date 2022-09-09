
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import input.components.point.PointNode;
import input.components.segment.*;

/**
 * Tests SegmentNode
 * @author ReganRichardson
 *
 */
class SegmentNodeTest {
	@Test
	void testSegmentNode() {
		PointNode node1 = new PointNode(3,14);
		PointNode node2 = new PointNode(4,12);
		SegmentNode S1 = new SegmentNode(node1, node2);
		assertTrue(S1.getPoint1().equals(node1));
		assertTrue(S1.getPoint2().equals(node2));
	}
	@Test
	void testEqualsObjectTrueInOrder() {
		PointNode node1 = new PointNode(3,14);
		PointNode node2 = new PointNode(4,12);
		SegmentNode S1 = new SegmentNode(node1, node2);
		PointNode node3 = new PointNode(3,14);
		PointNode node4 = new PointNode(4,12);
		SegmentNode S2 = new SegmentNode(node3, node4);
		
		assertTrue(S1.equals(S2));
	}
	
	@Test
	void testEqualsObjectTrueNotInOrder() {
		PointNode node1 = new PointNode(3,14);
		PointNode node2 = new PointNode(4,12);
		SegmentNode S1 = new SegmentNode(node1, node2);
		PointNode node4 = new PointNode(3,14);
		PointNode node3 = new PointNode(4,12);
		SegmentNode S2 = new SegmentNode(node3, node4);
		
		assertTrue(S1.equals(S2));
	}
	
	@Test
	void testEqualsObjectBothFalse() {
		PointNode node1 = new PointNode(3,14);
		PointNode node2 = new PointNode(4,12);
		SegmentNode S1 = new SegmentNode(node1, node2);
		PointNode node3 = new PointNode(12,1);
		PointNode node4 = new PointNode(3,2);
		SegmentNode S2 = new SegmentNode(node3, node4);
		
		assertFalse(S1.equals(S2));
	}
	
	@Test
	void testEqualsObjectFirstFalse() {
		PointNode node1 = new PointNode(3,14);
		PointNode node2 = new PointNode(4,12);
		SegmentNode S1 = new SegmentNode(node1, node2);
		PointNode node3 = new PointNode(5,1);
		PointNode node4 = new PointNode(4,12);
		SegmentNode S2 = new SegmentNode(node3, node4);
		
		assertFalse(S1.equals(S2));
	}
	
	@Test
	void testEqualsObjectSecondFalse() {
		PointNode node1 = new PointNode(3,14);
		PointNode node2 = new PointNode(4,12);
		SegmentNode S1 = new SegmentNode(node1, node2);
		PointNode node3 = new PointNode(3,14);
		PointNode node4 = new PointNode(5,1);
		SegmentNode S2 = new SegmentNode(node3, node4);
		
		assertFalse(S1.equals(S2));
	}
	
	
	@Test
	void testEqualsObjectNull() {
		PointNode node1 = new PointNode(3,14);
		PointNode node2 = new PointNode(4,12);
		SegmentNode S1 = new SegmentNode(node1, node2);
		assertFalse(S1.equals(null));
	}
	
	@Test
	void testToStringTrue() {
		PointNode node1 = new PointNode(3,14);
		PointNode node2 = new PointNode(4,12);
		SegmentNode S1 = new SegmentNode(node1, node2);
		assertTrue(S1.toString().equals("(3.0,14.0),(4.0,12.0)"));
	}
	
	@Test
	void testToStringFalse() {
		PointNode node1 = new PointNode(3,14);
		PointNode node2 = new PointNode(4,12);
		SegmentNode S1 = new SegmentNode(node1, node2);
		assertFalse(S1.toString().equals("(4.0,12.0),(14.0,3.0)"));
	}
}
