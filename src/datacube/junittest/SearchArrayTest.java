package datacube.junittest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.JUnit4;

import datacube.search.share.impl.SearchArray;

/**
 * 
 * Creates {@link JUnit4} test cases for {@link SearchArray} </br>
 * @author btdiem </br>
 *
 */

public class SearchArrayTest {

    byte [][] twoD = { {'t', 'a', 'c', 'w' }, 
						{'n', 'o', 'o', 'c' }, 
						{'d', 'o', 'g', 'x' },
						{'k', 'l', 'm', 'n'}};


	byte[][][] threeD = {{ {'A', 'B', 'C', 'D'}, {'e', 'f', 'g', 'h'}, {'a', 'b', 'c', 'd'}, {'E', 'F', 'G', 'H'} }, 
						   { {'K', 'L', 'M', 'N'}, {'k', 'l', 'm', 'n'}, {'O', 'P', 'Q', 'R'}, {'o', 'p', 'q', 'r'} }, 
						   { {'R', 'S', 'T', 'U'}, {'r', 's', 't', 'u'}, {'V', 'S', 'W', 'T'}, {'v', 's', 'w', 't'} },
						   { {'X', 'Y', 'Z', 'a'}, {'A', 'L', 'T', 'U'}, {'e', 'l', 'P', 'S'}, {'F', 'k', 'T', 'R'} }};
	
	String greaterThanLen = "tacwb";
	
	@Before
	public void setUp() throws Exception {
	}
	
	@After
	public void tearDown() throws Exception {
	
		twoD = null;
		threeD = null;
	}

	/**
	* search horizontally a string in 2D array from left to right </br>
	* the result will return true </br>
	* @see {@link SearchArray#contains(byte[][], String)} </br>
	*/
	@Test
	public void testSearchHorizonal1(){

		assertTrue(SearchArray.contains(twoD, "ooc"));
	}

	/**
	* search horizontally a string in 2D array from right to left </br>
	* the result will return true </br>
	* @see {@link SearchArray#contains(byte[][], String)} </br>
	*/
	@Test
	public void testSearchHorizonal2(){
	
		assertTrue(SearchArray.contains(twoD, "coon"));
	
	}



	/**
	* search vertically a string in 2D array from up to down </br>
	* the result will return true </br>
	* @see {@link SearchArray#contains(byte[][], String)} </br> 
	*/
	@Test
	public void testSearchVertical1(){
	
		assertTrue(SearchArray.contains(twoD, "aool"));
	
	
	}

	/**
	* search vertically a string in 2D array from down to up </br>
	* the result will return true </br>
	* @see {@link SearchArray#contains(byte[][], String)} </br>
	*/
	@Test
	public void testSearchVertical2(){
	
		assertTrue(SearchArray.contains(twoD, "looa"));
	
	}

	/**
	* search diagonally a string in 2D array from up to down </br>
	* the result will return true </br>
	* @see {@link SearchArray#contains(byte[][], String)} </br>
	*/
	@Test
	public void testSearchDiagonal1(){
	
		assertTrue(SearchArray.contains(twoD, "tog"));
		assertTrue(SearchArray.contains(twoD, "tog"));
	}

	/**
	* Search diagonally a string in 2D array from down to up </br>
	* The result will return true </br>
	* @see {@link SearchArray#contains(byte[][], String)} </br> 
	*/
	@Test
	public void testSearchDiagonal2(){
	
		assertTrue(SearchArray.contains(twoD, "mon"));
	}

	/**
	* Search diagonally a string in 2D array from any direction </br>
	* The result will return true </br>
	* @see {@link SearchArray#contains(byte[][], String, byte[], byte[])} </br> 
	*/
	@Test
	public void testSearchDiagonal3(){
	
		assertTrue(SearchArray.contains(twoD, "mon", new byte[]{-1,0,1}, new byte[]{-1,0,1}));
	}
	
	/**
	* Search diagonally a string in 2D array from any direction </br>
	* The result will return false </br>
	* @see {@link SearchArray#contains(byte[][], String, byte[], byte[])} </br> 
	*/
	@Test
	public void testSearchDiagonal4(){
	
		assertFalse(SearchArray.contains(twoD, "anything", new byte[]{-1,0,1}, new byte[]{-1,0,1}));
	}


	/**
	* search vertically a string not exist in 2D array </br>
	* the result will return false </br>
	* @see {@link SearchArray#contains(byte[][], String)} </br>
	*/
	@Test
	public void testSearchReturnFalse(){
	
		assertFalse(SearchArray.contains(twoD, "anything"));
	}

	/**
	 * Test case will verify the size of element of 2D arrays after split from 3D </br>
	 * Test case will also verify the value of element in the returned value to make sure that </br>
	 * the result is value of X and Z of 3D arrays by using {@link SearchArray#contains(byte[][], String)} </br>
	 * @see {@link AbstractBase#compute3D_DimensionXZ(byte[][][])}
	 * 
	 * Plane 1:
	 * A, B, C, D
	 * K, L, M, N
	 * R, S, T, U
	 * X, Y, Z, a
	 * 
	 * Plane 2:
	 * e, f, g, h
	 * k, l, m, n
	 * r, s, t, u
	 * A, L, T, U
	 * 
	 * Plane 3:
	 * a, b, c, d
	 * O, P, Q, R
	 * V, S, W, T
	 * e, l, P, S
	 * 
	 * Plane 4:
	 * E, F, G, H
	 * o, p, q, r
	 * v, s, w, t
	 * F, k, T, R
	 * 
	 */
	@Test
	public void testCompute3D_DimensionXZ(){
		
		List<byte[][]> twoDList =  SearchArray.compute3D_DimensionXZ(threeD);
		assertEquals(twoDList.size(),4);
		//search horizontal, vertical and diagonal for the first plane
		assertTrue(SearchArray.contains(twoDList.get(0), "ABCD"));
		assertTrue(SearchArray.contains(twoDList.get(0), "DCBA"));
		assertTrue(SearchArray.contains(twoDList.get(0), "AKRX"));
		assertTrue(SearchArray.contains(twoDList.get(0), "XRKA"));
		assertTrue(SearchArray.contains(twoDList.get(0), "LTa"));
		assertTrue(SearchArray.contains(twoDList.get(0), "aTL"));

		//search horizontal, vertical and diagonal for the second plane
		assertTrue(SearchArray.contains(twoDList.get(1), "efgh"));
		assertTrue(SearchArray.contains(twoDList.get(1), "hgfe"));
		assertTrue(SearchArray.contains(twoDList.get(1), "flsL"));
		assertTrue(SearchArray.contains(twoDList.get(1), "Lslf"));
		assertTrue(SearchArray.contains(twoDList.get(1), "eltU"));
		assertTrue(SearchArray.contains(twoDList.get(1), "Utle"));
		
		//search horizontal, vertical and diagonal for the third plane
		assertTrue(SearchArray.contains(twoDList.get(2), "abcd"));
		assertTrue(SearchArray.contains(twoDList.get(2), "dcba"));
		assertTrue(SearchArray.contains(twoDList.get(2), "bPSl"));
		assertTrue(SearchArray.contains(twoDList.get(2), "lSPb"));
		assertTrue(SearchArray.contains(twoDList.get(2), "OSP"));
		assertTrue(SearchArray.contains(twoDList.get(2), "PSO"));

		//search horizontal, vertical and diagonal for the fourth plane
		assertTrue(SearchArray.contains(twoDList.get(3), "EFGH"));
		assertTrue(SearchArray.contains(twoDList.get(3), "HGFE"));
		assertTrue(SearchArray.contains(twoDList.get(3), "Fpsk"));
		assertTrue(SearchArray.contains(twoDList.get(3), "kspF"));
		assertTrue(SearchArray.contains(twoDList.get(3), "Fqt"));
		assertTrue(SearchArray.contains(twoDList.get(3), "tqF"));

		
	}

	/**
	 * Test case will verify the size of element of 2D arrays after split from 3D </br>
	 * Test case will also verify the value of element in the returned value to make sure that </br>
	 * the result is value of Y and Z of 3D arrays by using {@link SearchArray#contains(byte[][], String)} </br>
	 * @see {@link AbstractBase#compute3D_DimensionYZ(byte[][][])}
	 * Plane 1:
	 *  A K R X
	 * 	e k r A
	 * 	a O V e
	 * 	E o v F
	 * Plane 2:
	 *  B L S Y
	 * 	f l s L
	 * 	b P S l
	 * 	F p s k
	 * Plane 3:
	 * 	C M T Z
	 * 	g m t T
	 * 	c Q W P
	 * 	G q w T
	 * Plane 4:
	 * 	D N U a
	 * 	h n u U
	 * 	d R T S
	 * 	H r t R
	 * 
	 */
	@Test
	public void testCompute3D_DimensionYZ(){
		
		List<byte[][]> twoDList =  SearchArray.compute3D_DimensionYZ(threeD);
		assertEquals(twoDList.size(),4);
		//search horizontal, vertical and diagonal for the first plane
		assertTrue(SearchArray.contains(twoDList.get(0), "AKRX"));
		assertTrue(SearchArray.contains(twoDList.get(0), "XRKA"));
		assertTrue(SearchArray.contains(twoDList.get(0), "XAeF"));
		assertTrue(SearchArray.contains(twoDList.get(0), "FeAX"));
		assertTrue(SearchArray.contains(twoDList.get(0), "AkVF"));
		assertTrue(SearchArray.contains(twoDList.get(0), "FVkA"));

		//search horizontal, vertical and diagonal for the second plane
		assertTrue(SearchArray.contains(twoDList.get(1), "bPSl"));
		assertTrue(SearchArray.contains(twoDList.get(1), "lSPb"));
		assertTrue(SearchArray.contains(twoDList.get(1), "YLlk"));
		assertTrue(SearchArray.contains(twoDList.get(1), "klLY"));
		assertTrue(SearchArray.contains(twoDList.get(1), "lSk"));
		assertTrue(SearchArray.contains(twoDList.get(1), "kSl"));
		
		//search horizontal, vertical and diagonal for the third plane
		assertTrue(SearchArray.contains(twoDList.get(2), "CMTZ"));
		assertTrue(SearchArray.contains(twoDList.get(2), "ZTMC"));
		assertTrue(SearchArray.contains(twoDList.get(2), "MmQq"));
		assertTrue(SearchArray.contains(twoDList.get(2), "qQmM"));
		assertTrue(SearchArray.contains(twoDList.get(2), "CmWT"));
		assertTrue(SearchArray.contains(twoDList.get(2), "TWmC"));

		//search horizontal, vertical and diagonal for the fourth plane
		assertTrue(SearchArray.contains(twoDList.get(3), "dRTS"));
		assertTrue(SearchArray.contains(twoDList.get(3), "STRd"));
		assertTrue(SearchArray.contains(twoDList.get(3), "DhdH"));
		assertTrue(SearchArray.contains(twoDList.get(3), "HdhD"));
		assertTrue(SearchArray.contains(twoDList.get(3), "auRH"));
		assertTrue(SearchArray.contains(twoDList.get(3), "HRua"));
	}

	/**
	 * 
	 * Test case will verify the size of element of 2D arrays after split from 3D </br>
	 * Test case will also verify the value of element in the returned value to make sure that </br>
	 * the result is value of Y and Z of 3D arrays by using {@link SearchArray#contains(byte[][], String)} </br>
	 * @see {@link AbstractBase#compute3D_DimensionXY(byte[][][])}

	 * Plane 1:
	 * 	A B C D
	 *	e f g h
	 *	a b c d
	 *	E F G H
	 * Plane 2:
	 *  K L M N
	 * 	k l m n
	 * 	O P Q R
	 * 	o p q r
	 * Plane 3:
	 * 	R S T U
	 * 	r s t u
	 * 	V S W T
	 * 	v s w t
	 * Plane 4:
	 * 	X Y Z a
	 * 	A L T U
	 * 	e l P S
	 * 	F k T R
	 * 
	 */
	@Test
	public void testCompute3D_DimensionXY(){
		
		List<byte[][]> twoDList =  SearchArray.compute3D_DimensionXY(threeD);
		assertEquals(twoDList.size(),4);
		assertTrue(SearchArray.contains(twoDList.get(0), "ABCD"));
		assertTrue(SearchArray.contains(twoDList.get(0), "DCBA"));
		assertTrue(SearchArray.contains(twoDList.get(0), "AeaE"));
		assertTrue(SearchArray.contains(twoDList.get(0), "EaeA"));
		assertTrue(SearchArray.contains(twoDList.get(0), "DgbE"));
		assertTrue(SearchArray.contains(twoDList.get(0), "EbgD"));

		//search horizontal, vertical and diagonal for the second plane
		assertTrue(SearchArray.contains(twoDList.get(1), "klmn"));
		assertTrue(SearchArray.contains(twoDList.get(1), "nmlk"));
		assertTrue(SearchArray.contains(twoDList.get(1), "NnRr"));
		assertTrue(SearchArray.contains(twoDList.get(1), "rRnN"));
		assertTrue(SearchArray.contains(twoDList.get(1), "nQp"));
		assertTrue(SearchArray.contains(twoDList.get(1), "pQn"));
		
		//search horizontal, vertical and diagonal for the third plane
		assertTrue(SearchArray.contains(twoDList.get(2), "RSTU"));
		assertTrue(SearchArray.contains(twoDList.get(2), "UTSR"));
		assertTrue(SearchArray.contains(twoDList.get(2), "SsSs"));
		assertTrue(SearchArray.contains(twoDList.get(2), "sSsS"));
		assertTrue(SearchArray.contains(twoDList.get(2), "UtSv"));
		assertTrue(SearchArray.contains(twoDList.get(2), "vStU"));

		//search horizontal, vertical and diagonal for the fourth plane
		assertTrue(SearchArray.contains(twoDList.get(3), "ALTU"));
		assertTrue(SearchArray.contains(twoDList.get(3), "UTLA"));
		assertTrue(SearchArray.contains(twoDList.get(3), "ZTPT"));
		assertTrue(SearchArray.contains(twoDList.get(3), "TPTZ"));
		assertTrue(SearchArray.contains(twoDList.get(3), "FlTa"));
		assertTrue(SearchArray.contains(twoDList.get(3), "aTlF"));

		
	}
	
	/**
	 * Test case will return true if the given string matches with the planes of 3D array having the coordinator: </br>
	 * x = x0 + 1, y = y0 - 1, z = z0 + 1 </br>
	 * Search from the top to the bottom, from the right to the left </br>
	 * @see {@link SearchArray#compute3D_ParallelPlane1(byte[][][], String)} </br>
	 */
	@Test
	public void testSearchParallelPlane1(){
		
		
		assertTrue(SearchArray.compute3D_ParallelPlane1(threeD, "DmSF"));
		assertTrue(SearchArray.compute3D_ParallelPlane1(threeD, "ClV"));
		assertTrue(SearchArray.compute3D_ParallelPlane1(threeD, "Bk"));
		assertTrue(SearchArray.compute3D_ParallelPlane1(threeD, "hQs"));
		assertTrue(SearchArray.compute3D_ParallelPlane1(threeD, "dq"));
		
	}
	
	/**
	 * Test case will return true if the given string matches with the planes of 3D array having the coordinator: </br>
	 * x = x0 + 1, y = y0 - 1, z = z0 + 1 </br>
	 * Search from the top to the bottom, from the right to the left </br>
	 * @see {@link SearchArray#compute3D_ParallelPlane1(byte[][][], String)} </br>
	 */
	@Test
	public void testSearchParallelPlane_NOK(){
		
		assertFalse(SearchArray.compute3D_ParallelPlane1(threeD, greaterThanLen));
		assertFalse(SearchArray.compute3D_ParallelPlane2(threeD, greaterThanLen));
		assertFalse(SearchArray.compute3D_ParallelPlane3(threeD, greaterThanLen));
		assertFalse(SearchArray.compute3D_ParallelPlane4(threeD, greaterThanLen));
		assertFalse(SearchArray.compute3D_ParallelPlane1(threeD, "Lal"));
	}

	/**
	 * Test case will return true if the given string matches with the planes of 3D array having the coordinator: </br>
	 * x = x0 + 1, y = y0 + 1, z = z0 + 1 </br>
	 * Search from the top to the bottom, from the left to the right </br>
	 * @see {@link SearchArray#compute3D_ParallelPlane2(byte[][][], String)} </br>
	 */
	@Test
	public void testSearchParallelPlane2(){
		
		assertTrue(SearchArray.compute3D_ParallelPlane2(threeD, "AlWR"));
		assertTrue(SearchArray.compute3D_ParallelPlane2(threeD, "BmT"));
		assertTrue(SearchArray.compute3D_ParallelPlane2(threeD, "Cn"));
		assertTrue(SearchArray.compute3D_ParallelPlane2(threeD, "ePw"));
		assertTrue(SearchArray.compute3D_ParallelPlane2(threeD, "ap"));
		
		assertFalse(SearchArray.compute3D_ParallelPlane2(threeD, "ABCD"));
		assertFalse(SearchArray.compute3D_ParallelPlane2(threeD, "dfjs"));
		
	}

	/**
	 * Test case will return true if the given string matches with the planes of 3D array having the coordinator: </br>
	 * x = x0 + 1, y = y0 - 1, z = z0 - 1 </br>
	 * Search from the top to the bottom, from the right to the left </br>
	 * @see {@link SearchArray#compute3D_ParallelPlane2(byte[][][], String)} </br>
	 */

	@Test
	public void testSearchParallelPlane3(){
		
		assertTrue(SearchArray.compute3D_ParallelPlane3(threeD, "atPE"));
		assertTrue(SearchArray.compute3D_ParallelPlane3(threeD, "ZsO"));
		assertTrue(SearchArray.compute3D_ParallelPlane3(threeD, "Yr"));
		assertTrue(SearchArray.compute3D_ParallelPlane3(threeD, "UWp"));
		assertTrue(SearchArray.compute3D_ParallelPlane3(threeD, "Sw"));
	}
	
	/**
	 * Test case will return true if the given string matches with the planes of 3D array having the coordinator: </br>
	 * x = x0 + 1, y = y0 + 1, z = z0 - 1 </br>
	 * Search from the top to the bottom, from the left to the right </br>
	 * @see {@link SearchArray#compute3D_ParallelPlane4(byte[][][], String)} </br>
	 */
	@Test
	public void testSearchParallelPlane4(){
		
		assertTrue(SearchArray.compute3D_ParallelPlane4(threeD, "XsQH"));
		assertTrue(SearchArray.compute3D_ParallelPlane4(threeD, "YtR"));
		assertTrue(SearchArray.compute3D_ParallelPlane4(threeD, "Zu"));
		assertTrue(SearchArray.compute3D_ParallelPlane4(threeD, "ASq"));
		assertTrue(SearchArray.compute3D_ParallelPlane4(threeD, "es"));
	}


}
