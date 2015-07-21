package datacube.junittest;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runners.JUnit4;

import datacube.search.share.abstracts.AbstractDataCube;
import datacube.search.share.abstracts.AbstractDictionary;
import datacube.search.share.impl.DataFactory;
import datacube.search.share.impl.InvariantBroken;
import datacube.search.share.interfaces.IDataCube;
import datacube.search.share.interfaces.IDictionary;
import datacube.search.share.interfaces.Parameters;

/**
 * Creates {@link JUnit4} test cases for {@link DataFactory} </br>
 * 
 * @author btdiem </br>
 *
 */
public class DataFactoryTest {

	/**
	 * Test a {@link IDataCube} is created by {@link DataFactory#createCubeParallel(int)} </br>
	 * Verify {@link IDataCube#invariant()} returning true </br>
	 * @throws {@ link InvariantBroken} if the input parameter is invalid </br>
	 * @see {@link AbstractDataCube#invariant()} <br>
	 */
	@Test
	public void testCreateCubeParallel_OK() throws InvariantBroken{
		
		IDataCube cube = DataFactory.createCubeParallel(100);
		assertEquals(cube.getSize(), 100);
		assertTrue(cube.invariant());
		
	}

	/**
	 * Test a {@link IDataCube} is created by {@link DataFactory#createCubeParallel(int)} </br>
	 * Throw an {@link InvariantBroken} exception because of invalid parameter size </br>
	 * Verify {@link IDataCube#invariant()} returning false </br>
	 * @throws {@ link InvariantBroken} if the input parameter is invalid </br>
	 * @see {@link AbstractDataCube#invariant()} <br>
	 */
	@Test (expected=InvariantBroken.class)
	public void testCreateCubeParallel_NOK1() throws InvariantBroken{
		
		IDataCube cube = DataFactory.createCubeParallel(2);
		assertEquals(cube.getSize(), 2);
		assertTrue(cube.invariant());
		
	}

	/**
	 * Test a {@link IDataCube} is created by {@link DataFactory#createCubeParallel(int)} </br>
	 * Throw an {@link InvariantBroken} exception because of invalid parameter size </br>
	 * Verify {@link IDataCube#invariant()} returning false </br>
	 * @throws {@ link InvariantBroken} if the input parameter is invalid </br>
	 * @see {@link AbstractDataCube#invariant()} <br>
	 */
	@Test (expected=InvariantBroken.class)
	public void testCreateCubeParallel_NOK2() throws InvariantBroken{
		
		IDataCube cube = DataFactory.createCubeParallel(10001);
		assertEquals(cube.getSize(), 10001);
		assertFalse(cube.invariant());
		
	}

	/**
	 * Tests a {@link IDataCube} is created by {@link DataFactory#createCubeSequence(int)} </br>
	 * Verify {@link IDataCube#invariant()} returning true </br>
	 * @throws {@ link InvariantBroken} if the input parameter is invalid </br>
	 * @see {@link AbstractDataCube#invariant()} <br>
	 */
	@Test
	public void testCreateCubeSequence_OK() throws InvariantBroken{
		
		IDataCube cube = DataFactory.createCubeSequence(100);
		assertEquals(cube.getSize(), 100);
		assertTrue(cube.invariant());
		
	}

	/**
	 * Test a {@link IDataCube} is created by {@link DataFactory#createCubeSequence(int)} </br>
	 * Expect throwing an {@link InvariantBroken} exception because of invalid parameter size </br>
	 * Verify {@link IDataCube#invariant()} returning false </br>
	 * @throws {@ link InvariantBroken} if the input parameter is invalid </br>
	 * @see {@link AbstractDataCube#invariant()} <br>
	 */
	@Test (expected=InvariantBroken.class)
	public void testCreateCubeSequence_NOK1() throws InvariantBroken{
		
		IDataCube cube = DataFactory.createCubeSequence(2);
		assertEquals(cube.getSize(), 2);
		assertTrue(cube.invariant());
		
	}

	/**
	 * Test a {@link IDataCube} is created by {@link DataFactory#createCubeSequence(int)} </br>
	 * Expect throwing an {@link InvariantBroken} exception because of invalid parameter size </br>
	 * Verify {@link IDataCube#invariant()} returning false </br>
	 * @throws {@ link InvariantBroken} if the input parameter is invalid </br>
	 * @see {@link AbstractDataCube#invariant()} <br>
	 */
	@Test (expected=InvariantBroken.class)
	public void testCreateCubeSequence_NOK2() throws InvariantBroken{
		
		IDataCube cube = DataFactory.createCubeSequence(10001);
		assertEquals(cube.getSize(), 10001);
		assertFalse(cube.invariant());
		
	}
	
	/**
	 * Test {@link IDictionary} is created by {@link DataFactory#createDictionary(int, int)} </br>
	 * Verify that {@link IDictionary#invariant()} returns true </br>
	 * @throws {@link InvariantBroken} if the input parameter is invalid </br>
	 * @see {@link AbstractDictionary#invariant()} <br>
	 */
	@Test
	public void testCreateDictionary_OK() throws InvariantBroken{
		
		IDictionary dictionary = DataFactory.createDictionary(100, 8);
		assertEquals(dictionary.getSize(), 100);
		assertEquals(dictionary.getWordLength(),8);
		assertTrue(dictionary.invariant());
	}
	
	/**
	 * Test {@link IDictionary} is created by {@link DataFactory#createDictionary(int, int)} </br>
	 * Expect throwing an {@link InvariantBroken} exception because of invalid input dictionary size </br>
	 * @see Parameters#MAX_DICTIONARY_SIZE </br>
	 * @throws {@link InvariantBroken} if the input parameter is invalid </br>
	 * @see {@link AbstractDictionary#invariant()} <br>
	 */
	@Test (expected=InvariantBroken.class)
	public void testCreateDictionary_NOK1() throws InvariantBroken{
		
		IDictionary dictionary = DataFactory.createDictionary(10001, 8);
		assertEquals(dictionary.getSize(), 1001);
		assertEquals(dictionary.getWordLength(),8);
		assertTrue(dictionary.invariant());
	}

	/**
	 * Test {@link IDictionary} is created by {@link DataFactory#createDictionary(int, int)} </br>
	 * Expect throwing an {@link InvariantBroken} exception because of invalid input dictionary size </br>
	 * @see Parameters#MIN_DICTIONARY_SIZE </br>
	 * @throws {@link InvariantBroken} if the input parameter is invalid </br>
	 * @see {@link AbstractDictionary#invariant()} <br>
	 */
	@Test (expected=InvariantBroken.class)
	public void testCreateDictionary_NOK2() throws InvariantBroken{
		
		IDictionary dictionary = DataFactory.createDictionary(2, 8);
		assertEquals(dictionary.getSize(), 2);
		assertEquals(dictionary.getWordLength(),8);
		assertTrue(dictionary.invariant());
	}
	
	/**
	 * Test {@link IDictionary} is created by {@link DataFactory#createDictionary(int, int)} </br>
	 * Expect throwing an {@link InvariantBroken} exception because of invalid input word length </br>
	 * @see Parameters#MIN_WORD_LEN </br>
	 * @throws {@link InvariantBroken} if the input parameter is invalid </br>
	 * @see {@link AbstractDictionary#invariant()} <br>

	 */
	@Test (expected=InvariantBroken.class)
	public void testCreateDictionary_NOK3() throws InvariantBroken{
		
		IDictionary dictionary = DataFactory.createDictionary(100, 1);
		assertEquals(dictionary.getSize(), 100);
		assertEquals(dictionary.getWordLength(),1);
		assertTrue(dictionary.invariant());
	}
	
	/**
	 * Test {@link IDictionary} is created by {@link DataFactory#createDictionary(int, int)} </br>
	 * Expect throwing an {@link InvariantBroken} exception because of invalid input word length </br>
	 * @see Parameters#MAX_WORD_LEN </br>
	 * @throws {@link InvariantBroken} if the input parameter is invalid </br>
	 * @see {@link AbstractDictionary#invariant()} <br>
	 */
	@Test (expected=InvariantBroken.class)
	public void testCreateDictionary_NOK4() throws InvariantBroken{
		
		IDictionary dictionary = DataFactory.createDictionary(100, 101);
		assertEquals(dictionary.getSize(), 100);
		assertEquals(dictionary.getWordLength(),101);
		assertTrue(dictionary.invariant());
	}

}
