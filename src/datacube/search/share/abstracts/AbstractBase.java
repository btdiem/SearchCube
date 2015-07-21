package datacube.search.share.abstracts;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

import datacube.search.share.interfaces.IDictionary;

/**
 * This is a base class that shares searched result  among search units </br>
 * 
 * @author btdiem </br>
 *
 */
public abstract class AbstractBase extends RecursiveAction{

	protected static  boolean found = false;
	private static final long serialVersionUID = -5891885241830661659L;

	public boolean getResult(){
		
		return found;
	}
	
	/**
	 * This method should be called when a search process starts </br> 
	 * Because found is static variable and it is shared among Threads (Task) </br>
	 * So when a search process is created, call this method to initialize the original value </br>
	 */
	public void reset(){
		
		found = false;
	}
	
	/**
	 * 
	 * If a word in the {@link IDictionary} is found by one task, 
	 * update found variable and stop all the other search process to start a new search process with a new word</br>
	 * In case @param isFound is true, there is an exception {@link CancellationException} thrown 
	 * because {@link ForkJoinPool} is shutdown when threads are running </br>  
	 * @param isFound The value returned for each search unit </br>
	 */
	public void updateResult(boolean isFound){
		
		if (isFound){
			
			found = true;
			
			if (getPool() !=null) getPool().shutdownNow();
		}
		

	}
	

}
