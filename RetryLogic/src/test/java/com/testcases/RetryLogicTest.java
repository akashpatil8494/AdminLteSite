package com.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryLogicTest {
	
	@Test
	public void test1() {
		Assert.assertEquals(true, false);
	}
	
	@Test
	public void test2() {
		Assert.assertEquals(true, false);
	}
	
	@Test
	public void test3() {
		Assert.assertEquals(true, false);
	}

}
