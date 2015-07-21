package datacube.search.share.impl;

import datacube.search.parallel.DataCubeParallel;
import datacube.search.sequence.DataCubeSequence;
import datacube.search.share.interfaces.IDataCube;
import datacube.search.share.interfaces.IDictionary;
import datacube.search.share.interfaces.Parameters;
/**
 * 
 * This class serves for testing purpose </br>
 * Create testing data object such as {@link IDictionary} and {@link IDataCube} with their input parameters </br>
 * 
 * @author btdiem </br>
 *
 */
public class DataFactory {

	/**
	 * Create a {@link IDataCube} object and generate data for {@link IDataCube} in parallel </br>
	 * @param size the size of {@link IDataCube} </br>
	 * @return {@link IDataCube} </br>
	 * @throws {@link InvariantBroken} exception if the input parameter is invalid </br>
	 * @see {@link Parameters#MAX_CUBE_SIZE} </br>
	 * @see {@link Parameters#MIN_CUBE_SIZE} </br>  
	 */
	public static IDataCube createCubeParallel(int size) throws InvariantBroken{
		
		IDataCube cube = new DataCubeParallel(size);
		cube.generateData();
		return cube;
	}
	
	/**
	 * Create a {@link IDataCube} object and generate data for {@link IDataCube} in sequence </br>
	 * @param size the size of {@link IDataCube} </br>
	 * @return {@link IDataCube} </br>
	 * @throws {@link InvariantBroken} exception if the input parameter is invalid </br>
	 * @see {@link Parameters#MAX_CUBE_SIZE} </br>
	 * @see {@link Parameters#MIN_CUBE_SIZE} </br>  
	 */	
	public static IDataCube createCubeSequence(int size) throws InvariantBroken{
		
		IDataCube cube = new DataCubeSequence(size);
		cube.generateData();
		return cube;
		
	}
	
	/**
	 * This method creates {@link IDictionary} object </br>
	 * @param size the size of {@link IDictionary} </br>
	 * @param len the length of word of {@link IDictionary} </br>
	 * @return {@link IDictionary} </br>
	 * @throws {@link InvariantBroken} exception if two input parameters are invalid </br>
	 * @see {@link Parameters#MAX_DICTIONARY_SIZE} </br>
	 * @see {@link Parameters#MIN_DICTIONARY_SIZE} </br>
	 * @see {@link Parameters#MAX_WORD_LEN} </br>
	 * @see {@link Parameters#MIN_WORD_LEN} </br>
	 */
	public static IDictionary createDictionary(int size, int len) throws InvariantBroken{
		
		IDictionary dictionary = new Dictionary(size, len);
		dictionary.generateData();
		
		return dictionary;
	}
	
}
