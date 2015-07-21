package datacube.junittest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.JUnit4;

import datacube.search.share.abstracts.AbstractDictionary;
import datacube.search.share.impl.Dictionary;
import datacube.search.share.impl.InvariantBroken;
import datacube.search.share.interfaces.IDictionary;
import datacube.search.share.interfaces.Parameters;
/**
 * 
 * Create {@link JUnit4} test cases for {@link IDictionary} </br>
 * 
 * @author btdiem </br>
 * 
 */
public abstract class AbstractDictionaryTest {

	private IDictionary dictionary;
	public int default_dictionary_size = 10;
	public int default_word_len = 5;
	
	@Before
	public void setUp() throws InvariantBroken{
		dictionary = getDefaultConstructor();
	}
	
	@After
	public void tearDown(){
		dictionary = null;
	}
	
	/**
	 * Test constructor without calling {@link IDictionary#generateData()} </br>
	 * @see {@link IDictionary#getSize() }</br>
	 * @see {@link IDictionary#getWordLength()} </br>
	 * @see {@link IDictionary#getWordList()} </br>
	 */
	@Test
	public void testConstructor(){
		
		assertEquals(dictionary.getSize(), default_dictionary_size);
		assertEquals(dictionary.getWordLength(), default_word_len);
		assertEquals(dictionary.getWordList().size(), 0);
		
	}

	/**
	 * Verify {@link IDictionary#invariant()} returning true after calling {@link IDictionary#generateData()} </br> 
	 * @throws {@link InvariantBroken} if the input parameter is invalid </br> 
	 * @see {@link IDictionary#generateData()} </br>
	 * @see {@link Dictionary#invariant()} </br>
	 */
	@Test
	public void testGenerateData() throws InvariantBroken{
		
		dictionary.generateData();
		assertTrue(dictionary.invariant());
	}
	
	/**
	 * Verify the value of {@link IDictionary#getOneWord(int)} with the valid indexes </br>
	 * @see {@link IDictionary#getOneWord(int)} </br>
	 */
	@Test
	public void testGetOneWord_OK(){
		
		dictionary.generateData();
		assertTrue(dictionary.getOneWord(0) != null);
		assertTrue(dictionary.getOneWord(0) instanceof String);

		assertTrue(dictionary.getOneWord(5) != null);
		assertTrue(dictionary.getOneWord(5) instanceof String);

		assertTrue(dictionary.getOneWord(9) != null);
		assertTrue(dictionary.getOneWord(9) instanceof String);
	}
	
	/**
	 * Throws {@link IllegalArgumentException} after calling {@link IDictionary#getOneWord(int)} with the invalid indexes </br>
	 * The input parameters are out of range ( less than 0 )</br>
	 * @see {@link IDictionary#getOneWord(int)} </br>
	 */
	@Test (expected=IllegalArgumentException.class)
	public void testGetOneWord_NOK1(){
		
		dictionary.generateData();
		
		assertTrue(dictionary.getOneWord(-1) != null);
		assertTrue(dictionary.getOneWord(-1) instanceof String);

	}
	
	/**
	 * Throws {@link IllegalArgumentException} after calling {@link IDictionary#getOneWord(int)} with the invalid indexes </br>
	 * The input parameters are out of range that are greater than {@link IDictionary#getSize()} </br>
	 * @see {@link IDictionary#getOneWord(int)} </br>
	 */
	@Test (expected=IllegalArgumentException.class)
	public void testGetOneWord_NOK2(){
		
		dictionary.generateData();
		
		assertTrue(dictionary.getOneWord(10) != null);
		assertTrue(dictionary.getOneWord(10) instanceof String);
	}
	
	
	/**
	 * Verify {@link IDictionary#setOneWord(int, String)} with a valid index </br>
	 * @throws {@link  InvariantBroken } if the input parameter is invalid</br>
	 * @see {@link AbstractDictionary#invariant()} </br>
	 * @see {@link IDictionary#setOneWord(int, String)} </br>
	 */
	@Test
	public void testSetOneWord_OK() throws InvariantBroken{
		
		dictionary.setOneWord(0, "aaa");
		assertTrue(dictionary.invariant());
		assertEquals(dictionary.getOneWord(0), "aaa");
	}
	
	/**
	 * Throws {@link IllegalArgumentException} exception with a invalid index </br>
	 * The input parameter is less than 0 </br>
	 * @see {@link IDictionary#getOneWord(int)} </br>
	 */
	@Test (expected=IllegalArgumentException.class)
	public void testSetOneWord_NOK1(){

		dictionary.setOneWord(-1, "aaa");

	}
	
	/**
	 * Throws {@link IllegalArgumentException} exception with a invalid index </br>
	 * The input parameter is greater than {@link IDictionary#getSize()} </br>
	 * @see {@link IDictionary#getOneWord(int)} </br>
	 */
	@Test (expected=IllegalArgumentException.class)
	public void testSetOneWord_NOK2(){

		dictionary.setOneWord(10, "aaa");
	}
	
	/**
	 * Create an instance of {@link IDictionary} with valid parameter </br>
	 * @return {@link IDictionary} </br>
	 * @throws {@link InvariantBroken} if the input is invalid </br>
	 * @see {@link AbstractDictionary#invariant()} </br>
	 */
	public abstract IDictionary getDefaultConstructor() throws InvariantBroken;
	
	/**
	 * Create a constructor with an invalid size that is less than {@link Parameters#MIN_DICTIONARY_SIZE}.  </br>
	 * Expect throwing {@link InvariantBroken} exception </br>
	 * @see {@link AbstractDictionary#invariant()} </br>
	 */
	@Test (expected=InvariantBroken.class)
	public abstract void testConstructor_NOK1() throws InvariantBroken;
	
	/**
	 * Create a constructor with an invalid size that is greater than {@link Parameters#MAX_DICTIONARY_SIZE}.  </br>
	 * Expect throwing {@link InvariantBroken} exception </br>
	 * @see {@link AbstractDictionary#invariant()} </br> 
	 */
	@Test (expected=InvariantBroken.class)
	public abstract void testConstructor_NOK2() throws InvariantBroken;
	
	/**
	 * Create a constructor with an invalid word length that is less than {@link Parameters#MIN_WORD_LEN}.  </br>
	 * Expect throwing {@link InvariantBroken} exception </br>
	 * @see {@link AbstractDictionary#invariant()} </br> 	
	 */
	@Test (expected=InvariantBroken.class)
	public abstract void testConstructor_NOK3() throws InvariantBroken;

	/**
	 * Create a constructor with an invalid word length that is greater than {@link Parameters#MAX_WORD_LEN}.  </br>
	 * Expect throwing {@link InvariantBroken} exception </br>
	 * @see {@link AbstractDictionary#invariant()} </br>
	 */
	@Test (expected=InvariantBroken.class)
	public abstract void testConstructor_NOK4() throws InvariantBroken;
	
}
