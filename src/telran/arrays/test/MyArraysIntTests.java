package telran.arrays.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import static telran.arrays.MyArraysInt.*;

class MyArraysIntTests {

	@Test
	void testAddNumber() {
		int array[] = { 1, 2, 3 };
		int expected1[] = { 1, 2, 3, 4 };
		int expected2[] = { 1, 2, 3, 4, 12 };
		assertArrayEquals(expected1, addNumber(array, 4));
		assertArrayEquals(expected2, addNumber(expected1, 12));
		// I don't know how i can test this method, yet
	}

	@Test
	void testRemoveNumber() {
		int array[] = { 1, 2, 3, 4, 5 };
		int expected1[] = { 1, 2, 4, 5 };
		int expected2[] = { 2, 3, 4, 5 };
		assertArrayEquals(array, removeNumber(array, 8));
		assertArrayEquals(array, removeNumber(array, -1));
		assertArrayEquals(expected2, removeNumber(array, 0));
		assertArrayEquals(expected1, removeNumber(array, 2));
	}

	@Test
	void testInsertNumber() {
		int array[] = { 1, 2, 4, 5 };
		int expected1[] = { 1, 2, 3, 4, 5 };
		int expected2[] = { 1, 2, 4, 5, 6 };
		int expected3[] = { 0, 1, 2, 4, 5 };
		assertArrayEquals(expected1, insertNumber(array, 2, 3));
		assertArrayEquals(expected2, insertNumber(array, 4, 6));
		assertArrayEquals(expected3, insertNumber(array, 0, 0));
		assertArrayEquals(array, insertNumber(array, 8, 7));
		assertArrayEquals(array, insertNumber(array, -3, 0));
	}

	@Test
	void testBinarySearchInt() {
		int array[] = { 2, 3, 5, 1, 4 };
		int array1[] = { 5, 1, 4, 2, 5, 2, 0 };
		Arrays.sort(array);
//		Arrays.sort(array1);
		assertEquals(2, Arrays.binarySearch(array, 3));
		assertEquals(3, Arrays.binarySearch(array1, 2));
		assertEquals(-6, Arrays.binarySearch(array, 8));
		assertEquals(-1, Arrays.binarySearch(array, 0));
	}

	@Test
	void testCopyOf() {
		int array[] = { 1, 2, 3 };
		int expected1[] = { 1, 2, 3 };
		int expected2[] = { 1 };
		int expected3[] = { 1, 2, 3, 0, 0, 0 };
		assertArrayEquals(expected1, Arrays.copyOf(array, array.length));
		assertArrayEquals(expected2, Arrays.copyOf(array, 1));
		assertArrayEquals(expected3, Arrays.copyOf(array, 6));
	}

	@Test
	void testArraycopy() {
		int array[] = { 1, 2, 3 };
		int expected[] = { 5, 10, 1, 2, 20 };
		int arrayDest[] = new int[5];
		int array1[] = { 2, 5, 10 };
		System.arraycopy(array, 0, arrayDest, 2, 2);
		System.arraycopy(array1, 1, arrayDest, 0, 2);
		arrayDest[4] = 20;
		assertArrayEquals(expected, arrayDest);
	}

}
