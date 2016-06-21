package model.database;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ManageDBTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testconnectToDataBase() {
		Assert.assertNotNull(ManageDB.getterConnection());
	}
	
	@Test
	public void testExtractMapData() {
		Assert.assertEquals(ManageDB.getTheMapString(), 
				"QSSSSSSSSSSSQHE,SXXXXXOXXXXXOLP,OXXXXXOXXXXXOAB,OXXXXXOXXXXXOYZ,OXXXXXOXXXXXO@#,OXXXXXQXXXXXOXX,OXXXXXXXXXXXOXX,OXXXXXXXXXXXOXX,OXXXXXXXCXXXOXX,QSSSSSSSSSSSQXX");
	}

}
