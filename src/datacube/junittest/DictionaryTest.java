package datacube.junittest;

import org.junit.Test;
import org.junit.runners.JUnit4;

import datacube.search.share.impl.Dictionary;
import datacube.search.share.impl.InvariantBroken;
import datacube.search.share.interfaces.IDictionary;

/**
 * 
 * This class is an implementation of {@link AbstractDictionaryTest} </br>
 * Create {@link JUnit4} test cases for {@link Dictionary} </br>
 * 
 * @author btdiem </br>
 *
 */
public class DictionaryTest extends AbstractDictionaryTest {

	/*
	 * (non-Javadoc)
	 * @see datacube.junittest.AbstractDictionaryTest#getDefaultConstructor() </br>
	 * @throws {@link InvariantBroken} if the input parameters are invalid </br>
	 * @see {@link AbstractDictionary#invariant()} <br>
	 */
	@Override
	public IDictionary getDefaultConstructor() throws InvariantBroken {
		
		return new Dictionary(default_dictionary_size, default_word_len);
	}

	/*
	 * (non-Javadoc)
	 * @see datacube.test.AbstractDictionaryTest#testConstructor_NOK1() </br>
	 * @throws {@link InvariantBroken} if the input parameters are invalid </br>
	 * @see {@link AbstractDictionary#invariant()} <br>
	 */
	@Override
	@Test(expected = InvariantBroken.class)
	public void testConstructor_NOK1() throws InvariantBroken {
		new Dictionary(2, 5);
	}

	/*
	 * (non-Javadoc)
	 * @see datacube.test.AbstractDictionaryTest#testConstructor_NOK2() </br>
	 * @throws {@link InvariantBroken} if the input parameters are invalid </br>
	 * @see {@link AbstractDictionary#invariant()} <br>
	 */
	@Override
	@Test(expected = InvariantBroken.class)
	public void testConstructor_NOK2() throws InvariantBroken {
		
		new Dictionary(1001, 5);
	}

	/*
	 * (non-Javadoc)
	 * @see datacube.test.AbstractDictionaryTest#testConstructor_NOK3() </br>
	 * @throws {@link InvariantBroken} if the input parameters are invalid </br>
	 * @see {@link AbstractDictionary#invariant()} <br>
	 */
	@Override
	@Test(expected = InvariantBroken.class)
	public void testConstructor_NOK3() throws InvariantBroken {
		new Dictionary(10, 1);
	}

	/*
	 * (non-Javadoc)
	 * @see datacube.junittest.AbstractDictionaryTest#testConstructor_NOK4() </br>
	 * @throws {@link InvariantBroken} if the input parameters are invalid </br>
	 * @see {@link AbstractDictionary#invariant()} <br>
	 */
	@Override
	@Test(expected = InvariantBroken.class)
	public void testConstructor_NOK4() throws InvariantBroken {
		
		new Dictionary(10, 101);
	}


}
