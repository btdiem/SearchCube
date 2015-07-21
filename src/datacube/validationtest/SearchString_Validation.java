package datacube.validationtest;

import java.util.concurrent.ThreadLocalRandom;

import datacube.search.parallel.SearchCubeParallel;
import datacube.search.sequence.SearchCubeSequence;
import datacube.search.share.impl.DataFactory;
import datacube.search.share.impl.InvariantBroken;
import datacube.search.share.interfaces.IDataCube;
import datacube.search.share.interfaces.IDictionary;
import datacube.search.share.interfaces.Parameters;

public class SearchString_Validation {

	/**
	 * args[0]: the type of search algorithm. For example :
	 *  <i> p: search in parallel
	 *  <i> s: search in sequence
	 *  <i> ps or sp : search in both parallel and sequence
	 * args[1] : the size of cube. The value should be greater than {@link Parameters#MAX_CUBE_SIZE} and less than {@link Parameters#MIN_CUBE_SIZE} </br>
	 * args[2] : the size of dictionary. The value should be between {@link Parameters#MAX_DICTIONARY_SIZE} and {@link Parameters#MIN_DICTIONARY_SIZE} </br>
	 * args[3] : the length of word in dictionary. The value should be between {@link Parameters#MAX_WORD_LEN} and {@link Parameters#MIN_WORD_LEN} </br>
	 * 
	 * If there is no parameter, the program will run with generating randomly parameters above </br>     
	 * @param args - the input parameter </br>
	 * @throws InvariantBroken </br>
	 */
	public static void main(String[] args) throws InvariantBroken {
		
		IDataCube cube = null;
		IDictionary dictionary = null;
		SearchCubeParallel searchParallel = new SearchCubeParallel();
		SearchCubeSequence searchSequence = new SearchCubeSequence();
		long start = 0;
		
		if (args.length == 4){
			
			String search = args[0];
			int cubeSize = Integer.parseInt(args[1]);
			int dictSize = Integer.parseInt(args[2]);
			int wordLength = Integer.parseInt(args[3]);
			cube = DataFactory.createCubeParallel(cubeSize);
			System.out.println("A Data cube is created");
			dictionary = DataFactory.createDictionary(dictSize, wordLength);
			System.out.println("A Dictionary is created");
			start = System.currentTimeMillis();
			
			if (search.equals("p")){
				
				System.out.println("Find an association between Cube and Dictionary in parallel......");
				searchParallel.setCube(cube);
				searchParallel.setDictionary(dictionary);
				System.out.println("Have an association in parallel search ? " + searchParallel.isAssociation() + " during " + (System.currentTimeMillis() - start));
				
			}else if (search.equals("s")){
				
				System.out.println("Find an association between Cube and Dictionary in sequence.......");
				searchSequence.setCube(cube);
				searchSequence.setDictionary(dictionary);
				System.out.println("Have an association in parallel search ? " + searchSequence.isAssociation() + " during " + (System.currentTimeMillis() - start));
				
			}else if (search.equals("ps") || search.equals("sp")){
				
				System.out.println("Find an association between Cube and Dictionary in parallel and sequence......");
				
				searchParallel.setCube(cube);
				searchParallel.setDictionary(dictionary);
				System.out.println("Have an association in parallel search ? " + searchParallel.isAssociation() + " during " + (System.currentTimeMillis() - start));
				
				start = System.currentTimeMillis();
				searchSequence.setCube(cube);
				searchSequence.setDictionary(dictionary);
				System.out.println("Have an association in sequence search ? " + searchSequence.isAssociation() + " during " + (System.currentTimeMillis() - start));
				
			}else {
				
				System.out.println(search + " Unsupported yet.");
			}
		}else{
			
			//search with default
			System.out.println("Search in parallel first and sequence later with randomly generating parameter");
			int csize = ThreadLocalRandom.current().nextInt(Parameters.MIN_CUBE_SIZE, Parameters.MAX_CUBE_SIZE);
			int dsize = ThreadLocalRandom.current().nextInt(Parameters.MIN_DICTIONARY_SIZE, Parameters.MAX_DICTIONARY_SIZE);
			int wordLen = 0;//this value should not greater than the size of dictionary
			if (csize <= Parameters.MAX_WORD_LEN){
				wordLen = ThreadLocalRandom.current().nextInt(Parameters.MIN_WORD_LEN, csize); 
			}else{
				wordLen = ThreadLocalRandom.current().nextInt(Parameters.MIN_WORD_LEN, Parameters.MAX_WORD_LEN);
			}
			
			
			System.out.println("Create a Data Cube size " + csize + " ....");
			cube = DataFactory.createCubeParallel(csize);
			System.out.println("Create s Dictionary size " + dsize + " with word length " + wordLen + " ....");
			dictionary = DataFactory.createDictionary(dsize, wordLen);
			
			
			start = System.currentTimeMillis();
			searchParallel.setCube(cube);
			searchParallel.setDictionary(dictionary);
			System.out.println("Have an association in parallel search ? " + searchParallel.isAssociation() + " during " + (System.currentTimeMillis() - start));
			
			start = System.currentTimeMillis();
			searchSequence.setCube(cube);
			searchSequence.setDictionary(dictionary);
			System.out.println("Have an association in sequence search ? " + searchSequence.isAssociation() + " during " + (System.currentTimeMillis() - start));
			
		}
		
		
	}
}
