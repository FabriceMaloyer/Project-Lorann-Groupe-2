package controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import contract.ControllerOrder;

public class ControllerTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testOrderPerform(final ControllerOrder controllerOrder) throws InterruptedException {
		System.out.println("Please keep pressing the Z key");
		Thread.sleep(2000);
		Assert.assertEquals(controllerOrder, contract.ControllerOrder.Z);
		System.out.println("Release the key");
		Thread.sleep(1000);
		
		System.out.println("Please keep pressing the Q key");
		Thread.sleep(2000);
		Assert.assertEquals(controllerOrder, contract.ControllerOrder.Q);
		System.out.println("Release the key");
		Thread.sleep(1000);

		System.out.println("Please keep pressing the S key");
		Thread.sleep(2000);
		Assert.assertEquals(controllerOrder, contract.ControllerOrder.S);
		System.out.println("Release the key");
		Thread.sleep(1000);

		System.out.println("Please keep pressing the D key");
		Thread.sleep(2000);
		Assert.assertEquals(controllerOrder, contract.ControllerOrder.D);
		System.out.println("Release the key");
		Thread.sleep(1000);
		fail("It doesn't work");
	}

}
