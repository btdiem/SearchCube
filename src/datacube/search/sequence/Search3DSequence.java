package datacube.search.sequence;

import java.util.List;

import datacube.search.share.abstracts.AbstractSearch3D;
import datacube.search.share.abstracts.AbstractBase;
import datacube.search.share.impl.InvariantBroken;
import datacube.search.share.interfaces.IDataCube;
import datacube.search.share.interfaces.IDictionary;

/**
 * 
 * This class is an implementation of {@link AbstractSearch3D} class </br>
 * Executes each search unit task in sequence to find the association between {@link IDictionary} and {@link IDataCube} </br> 
 * 
 * @author btdiem </br>
 *
 */
public class Search3DSequence extends AbstractSearch3D {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2062499635339174474L;

	public Search3DSequence(byte[][][] threeD, String word) throws InvariantBroken {
		
		super(threeD, word);
		
	}

	@Override
	protected void compute() {

		execute(searchXY());
		execute(searchXZ());
		execute(searchYZ());
		execute(searchParallelPlane());

	}

	/**
	 * Invoke task by task in the list. The next task only is invoked if the previous one is finished
	 * and the result has not found yet </br>
	 * 
	 * @param taskList List<AbstractBase> </br>
	 */
	public void execute(List<AbstractBase> taskList) {
		// TODO Auto-generated method stub
		for (AbstractBase task : taskList){
			//execute task
			//task.fork();
			//task.join();
			invokeAll(task);
			//wait until the task is finished.
			while (!task.isDone());
			//if (task.join())
			//if the given string is found, stop the search process.
			if (getResult()) break;
			
		}
	}



}
