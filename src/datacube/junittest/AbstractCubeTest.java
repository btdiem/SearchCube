package datacube.junittest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.JUnit4;

import datacube.search.share.abstracts.AbstractDataCube;
import datacube.search.share.impl.InvariantBroken;
import datacube.search.share.interfaces.IDataCube;
import datacube.search.share.interfaces.Parameters;
/**
 * 
 * Create {@link JUnit4} test cases for {@link IDataCube} </br>
 * 
 * @author btdiem </br>
 *
 */
public abstract class AbstractCubeTest {

	IDataCube cube;
	public int default_cube_size = 200;
	
	@Before
	public void setUp() throws Exception {
		cube = getDefaultConstructor();
	}

	@After
	public void tearDown() throws Exception {
		cube = null;
	}

	/**
	 * Create an instance of {@link IDataCube} with the valid input parameter </br>
	 * @return {@link IDataCube} </br>
	 * @throws {@link  InvariantBroken } if the input parameter is invalid </br>
	 * @see {@link AbstractDataCube#invariant()} </br>
	 */
	public abstract IDataCube getDefaultConstructor() throws InvariantBroken;
	
	/**
	 * Verify that {@link IDataCube#invariant()} returns true </br>
	 * Verify that {@link IDataCube#getValue()} is initialized </br>
	 * Verify that {@link IDataCube#getSize()} returning the same with the expected value </br>
	 * @throws {@link  InvariantBroken } if the input parameter is invalid </br>
	 * @see {@link AbstractDataCube#invariant()} </br>
	 */
	@Test
	public void testDefaultConstructor() throws InvariantBroken{
		assertTrue(cube.invariant());
		assertEquals(cube.getSize(), default_cube_size);
		assertNotNull(cube.getValue());
	}
	/**
	 * Create an {@link IDataCube} object with invalid size </br>
	 * The input parameter is less than {@link Parameters#MIN_CUBE_SIZE} </br>
	 * @throws {@link  InvariantBroken } if the input parameter is invalid </br>
	 * @see {@link AbstractDataCube#invariant()} </br>
	 */
	@Test(expected=InvariantBroken.class)
	public abstract void testConstructor_NOK1() throws InvariantBroken;
	/**
	 * Create an {@link IDataCube} object with invalid size </br>
	 * The input parameter is greater than {@link Parameters#MAX_CUBE_SIZE} </br>
	 * @throws {@link  InvariantBroken } if the input parameter is invalid </br>
	 * @see {@link AbstractDataCube#invariant()} </br>
	 */
	@Test(expected=InvariantBroken.class)
	public abstract void testConstructor_NOK2() throws InvariantBroken;
	

	/**
	 * Verify that {@link IDataCube#invariant()} still returns true after calling {@link IDataCube#generateData()} </br>
	 * @see {@link IDataCube#generateData()} </br>
	 * @throws {@link  InvariantBroken } if the input parameter is invalid </br>
	 * @see {@link AbstractDataCube#invariant()} </br>
	 */
	@Test
	public void testGenerateData() throws InvariantBroken{
		cube.generateData();
		assertTrue(cube.invariant());
	}
	
	/**
	 * Verify {@link IDataCube#getValue(int, int, int)} returns values with the valid indexes </br>
	 * @see {@link IDataCube#getValue(int, int, int)} </br> 
	 * @throws {@link  InvariantBroken } if the input parameter is invalid </br>
	 * @see {@link AbstractDataCube#invariant()} </br>
	 */
	@Test
	public void testGetValue_OK() throws IllegalArgumentException{
		cube.generateData();
		assertNotNull(cube.getValue(0, 0, 0));
		assertNotNull(cube.getValue(10, 20, 60));
		assertNotNull(cube.getValue(199, 199, 199));
	}
	
	/**
	 * Verify {@link IDataCube#getValue(int, int, int)} throws {@link IllegalArgumentException} exception with an invalid index </br>
	 * The input parameter is less than 0 </br>
	 * @see {@link IDataCube#getValue(int, int, int)} </br> 
	 * @throws {@link IllegalArgumentException } if the input is invalid</br>
	 */
	@Test (expected=IllegalArgumentException.class)
	public void testGetValue_NOK1() throws IllegalArgumentException{
		assertNotNull(cube.getValue(-1, -1, 0));
	}
	
	/**
	 * Verify {@link IDataCube#getValue(int, int, int)} throws {@link IllegalArgumentException} 
	 * exception with an invalid index </br>
	 * The input parameter is greater than {@link IDataCube#getSize()} </br>
	 * @see {@link IDataCube#getValue(int, int, int)} </br> 
	 * @throws {@link IllegalArgumentException } if the input is invalid</br>
	 */
	@Test (expected=IllegalArgumentException.class)
	public void testGetValue_NOK2() throws IllegalArgumentException{
		assertNotNull(cube.getValue(201, 200, 300));
	}
	
	/**
	 * Verify {@link IDataCube#setValue(int, int, int, byte)} works properly without an exception </br>
	 * @see {@link IDataCube#setValue(int, int, int, byte)} </br> 
	 * @throws {@link IllegalArgumentException } if the input is invalid</br>
	 * @throws {@link  InvariantBroken } if the input parameter is invalid </br>
	 * @see {@link AbstractDataCube#invariant()} </br>
	 * 
	 */
	@Test
	public void testSeValue_OK() throws IllegalArgumentException, InvariantBroken{

		cube.setValue(0, 1, 1, (byte)'A');
		assertTrue(cube.invariant());
		assertEquals(cube.getValue(0, 1, 1), 'A');
	}
	
	/**
	 * Verify {@link IDataCube#setValue(int, int, int, byte)} throws {@link IllegalArgumentException} exception with an invalid index </br>
	 * The input parameter is less than 0 </br>
	 * @see {@link IDataCube#setValue(int, int, int, byte)} </br> 
	 * @throws {@link IllegalArgumentException } if the input is invalid</br>
	 */
	@Test (expected=IllegalArgumentException.class)
	public void testSetValue_NOK1() throws IllegalArgumentException{
		cube.setValue(0, -1, 0, (byte)'A');
	}
	
	/**
	 * Verify {@link IDataCube#setValue(int, int, int, byte)} throws {@link IllegalArgumentException} exception with an invalid index </br>
	 * The input parameter is greater than {@link IDataCube#getSize()} </br>
	 * @see {@link IDataCube#setValue(int, int, int, byte)} </br> 
	 * @throws {@link IllegalArgumentException } if the input parameter is invalid</br>
	 */
	@Test (expected=IllegalArgumentException.class)
	public void testSetValue_NOK2() throws IllegalArgumentException{
		cube.setValue(0, 201, 1, (byte)'A');
	}


}
