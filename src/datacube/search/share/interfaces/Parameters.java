package datacube.search.share.interfaces;
/**
 * 
 * This class is used to define the max and and min values when creating {@link IDataCube}, {@link IDictionary} </br>
 *  
 * @author btdiem </br>
 *
 */
public class Parameters {
	
	//for data cube definition
	/**
	 * The minimum value for the size of {@link IDataCube} </br> 
	 */
	public final static int MIN_CUBE_SIZE = 3;
	/**
	 * The maximum value for the size of {@link IDataCube} </br>
	 */
	public final static int MAX_CUBE_SIZE = 1000;
	/**
	 * The threshold level to run parallel or sequence when creating a {@link IDataCube} </br>
	 */
	public final static int THRESHOLD_CUBE = 10;
	
	//for dictionary definition
	/**
	 * the minimum value for the size of {@link IDictionary} </br> 
	 */
	public final static int MIN_DICTIONARY_SIZE = 3;
	/**
	 * The maximum value for the size of {@link IDataCube} </br>
	 */
	public final static int MAX_DICTIONARY_SIZE = 1000;
	
	/**
	 * The minimum value for the length of words of a {@link IDictionary} </br> 
	 */
	public final static int MIN_WORD_LEN = 2;
	/**
	 * The maximum value for the length of words of a {@link IDictionary} </br> 
	 */
	public final static int MAX_WORD_LEN = 100;
	
	public static final byte [] LETTERS ={'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'E', 
			'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
			'U', 'V', 'S', 'W', 'T', 'X', 'Y', 'Z', 'a', 'b', 'c',
			'd', 'e', 'f', 'g', 'h', 'e', 'j', 'k', 'l', 'm', 'n', 
			'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 's', 'w', 't', 
			'x', 'y', 'z'};
}
