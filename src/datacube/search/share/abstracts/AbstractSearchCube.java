package datacube.search.share.abstracts;

import java.util.List;
import java.util.concurrent.ForkJoinPool;

import datacube.search.parallel.SearchCubeParallel;
import datacube.search.sequence.SearchCubeSequence;
import datacube.search.share.impl.InvariantBroken;
import datacube.search.share.interfaces.HasInvariant;
import datacube.search.share.interfaces.IDataCube;
import datacube.search.share.interfaces.IDictionary;
import datacube.search.share.interfaces.Parameters;

/**
 * This class is an abstraction of {@link SearchCubeSequence} and {@link SearchCubeParallel} </br>
 * Search word by word of {@link IDictionary} into {@link IDataCube} </br>
 * The search process will stop without finishing if there is a word of {@link IDictionary} could not be found in {@link IDataCube} </br>
 * 
 * @author btdiem </br>
 *
 */
public abstract class AbstractSearchCube implements HasInvariant{

	protected IDataCube cube;
	protected IDictionary dictionary;
	
	public AbstractSearchCube(){};

	public AbstractSearchCube(IDataCube cube, IDictionary dictionary) {
		
		this.dictionary = dictionary;
		this.cube = cube;
		
	}
	
	public void setDictionary(IDictionary dictionary){
		this.dictionary = dictionary;
	}

	public void setCube(IDataCube cube) {
		this.cube = cube;
	}

	@Override
	public boolean invariant() throws InvariantBroken {
		return (this.cube != null && this.dictionary != null && cube.getSize() >= dictionary.getWordLength());
	}

	/**
	 * 
	 * Search process will executed in parallel or in sequence depending on particular implementation </br>
	 * @return true if all words in {@link IDictionary} are found in {@link IDataCube} </br>
	 * @throws InvariantBroken if input parameters are invalid</br>
	 */
	public boolean isAssociation() throws InvariantBroken {
		
		if (!invariant())
			throw new InvariantBroken("Input parameters are invalid.");
		
		byte [][][] threeD = cube.getValue();
		List<String> wordList = dictionary.getWordList();
		int processors = Runtime.getRuntime().availableProcessors();
		AbstractBase task = null;
		ForkJoinPool pool = null;
		
		for (String word : wordList){
			
			try {
				pool = new ForkJoinPool(processors);
				task = getExecutionTask(threeD, word);//
				//set for the current status is false (not found the result yet) 
				task.reset();
				//execute task
				pool.invoke(task);
				
			} catch (Exception e) {
				//{@link CancellationException} is thrown that means this word found and program will stop 
				//the current tasks and create a new search process
			}
			
			if (task != null && !task.getResult()) return false;
			
		}//for
		return true;
	}
	
	/**
	 * This method will return a {@link AbstractBase} that says search process will do
	 * in parallel or in sequence </br>
	 * 
	 * @param threeD 3D arrays of {@link Parameters#LETTERS} in {@link IDataCube} </br>
	 * @param word the given word is searched
	 * @return {@link AbstractBase} </br>
	 * @throws {@link InvariantBroken} if the input parameters are invalid </br>
	 */
	public abstract AbstractBase getExecutionTask(byte[][][] threeD, String word) throws InvariantBroken;
	
}
