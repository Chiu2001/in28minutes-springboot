package com.in28minutes.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyMathTest {
	
	private MyMath math = new MyMath();

	@Test
	void CalculateSum_ThreeMemberArray() {
		int result = math.calculateSum(new int[] {1, 2, 3});	
		System.out.println(result);
		int expectedResult = 6;
		assertEquals(expectedResult, result);
		//Absence of failure is success
		//Test Condiition or assert
	}
	
	@Test
	void ZeroLengthArray() {
		int result = math.calculateSum(new int[] {});	
		System.out.println(result);
		int expectedResult = 0;
		assertEquals(expectedResult, result);
		//Absence of failure is success
		//Test Condiition or assert
	}

}
