package in.ravikalla.utils;

import java.util.Arrays;
import java.util.List;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Unit test for simple App.
 */
public class FindNumsForSumTest extends TestCase {
	public FindNumsForSumTest(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(FindNumsForSumTest.class);
	}

	public void testFindNumsForSum() {
		List<Integer> lstExpected0 = Arrays.asList(1, 2, 3, 4);
		List<Integer> lstExpected1 = Arrays.asList(1, 2, 7);
		List<Integer> lstExpected2 = Arrays.asList(1, 3, 6);
		List<Integer> lstExpected3 = Arrays.asList(1, 4, 5);
		List<Integer> lstExpected4 = Arrays.asList(1, 9);
		List<Integer> lstExpected5 = Arrays.asList(2, 3, 5);
		List<Integer> lstExpected6 = Arrays.asList(2, 8);
		List<Integer> lstExpected7 = Arrays.asList(3, 7);
		List<Integer> lstExpected8 = Arrays.asList(4, 6);

		int[] arrNum = {1,2,3,4,5,6,7,8,9};
		int intSum = 10;

		FindNumsForSum objFindNumsForSum = new FindNumsForSum(arrNum, intSum);
		List<List<Integer>> lstResults = objFindNumsForSum.findNumsForSum();

		Assert.assertEquals("Number of results should be as expected", 9, lstResults.size());
		assertThat(lstResults.get(0), is(lstExpected0));
		assertThat(lstResults.get(1), is(lstExpected1));
		assertThat(lstResults.get(2), is(lstExpected2));
		assertThat(lstResults.get(3), is(lstExpected3));
		assertThat(lstResults.get(4), is(lstExpected4));
		assertThat(lstResults.get(5), is(lstExpected5));
		assertThat(lstResults.get(6), is(lstExpected6));
		assertThat(lstResults.get(7), is(lstExpected7));
		assertThat(lstResults.get(8), is(lstExpected8));
	}

	public void testFindNumsForSum1() {
		List<Integer> lstExpected0 = Arrays.asList(1, 4);
		List<Integer> lstExpected1 = Arrays.asList(2, 3);
		List<Integer> lstExpected2 = Arrays.asList(5);

		int[] arrNum = {1,2,3,4,5,6,7,8,9};
		int intSum = 5;

		FindNumsForSum objFindNumsForSum = new FindNumsForSum(arrNum, intSum);
		List<List<Integer>> lstResults = objFindNumsForSum.findNumsForSum();

		Assert.assertEquals("Number of results should be as expected", 3, lstResults.size());
		assertThat(lstResults.get(0), is(lstExpected0));
		assertThat(lstResults.get(1), is(lstExpected1));
		assertThat(lstResults.get(2), is(lstExpected2));
//		lstResults.forEach(l -> {l.forEach(j -> {System.out.print(": " + j);});System.out.println("");});
	}
}
