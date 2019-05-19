package debug;

import static org.junit.Assert.*;

import org.junit.Test;

public class test1 {

	@Test
	public void test() {
		int[] A1 = {1,3};
		int[] B1 = {2};
		int[] A2 = {1,2};
		int[] B2 = {3,4};
		int[] A3 = {1,1,1};
		int[] B3 = {5,6,7};
		int[] A4 = {1,1};
		int[] B4 = {1,2,3};
		FindMedianSortedArrays find = new FindMedianSortedArrays();
		assertEquals(find.findMedianSortedArrays(A1, B1),2.0,0.0);
		assertEquals(find.findMedianSortedArrays(A2, B2),2.5,0.0);
		assertEquals(find.findMedianSortedArrays(A3, B3),3.0,0.0);
		assertEquals(find.findMedianSortedArrays(A4, B4),1.0,0.0);
	}

}
