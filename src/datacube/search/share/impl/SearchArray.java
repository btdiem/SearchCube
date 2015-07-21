package datacube.search.share.impl;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * This class implements search functions and methods to separate and collect 2D arrays from 3D arrays </br> 
 * Some search functions refers to {@link http://www.kosbie.net/cmu/fall-08/15-100/handouts/notes-two-dimensional-arrays.html#deepToString} </br>
 * 
 * @author btdiem </br>
 *
 */
public class SearchArray {

	/**
	 * Return true if the given board contains the given string. </br>
	 * Test every possible starting location. </br>
	 * Source reference: {@link http://www.kosbie.net/cmu/fall-08/15-100/handouts/notes-two-dimensional-arrays.html#deepToString} </br>
	 * @param board 2D array byte </br>
	 * @param s searched string </br>
	 * @return Boolean </br>
	 */
	  public static boolean contains(byte[][] board, String s) {
	    int rows = board.length;
	    int cols = board[0].length;
	    for (int row=0; row < rows; row++)
	      for (int col=0; col<cols; col++)
	        if (contains(board,s,row,col))
	          return true;
	    return false;
	  }

	  /** 
	   * Returns true if the given board contains the given string,
	   * starting from the given startRow and startCol location.
	   * Tests every possible direction from there, where a direction
	   * is determined by drow,dcol (the change in rows and cols). </br>
	   * Source reference: {@link http://www.kosbie.net/cmu/fall-08/15-100/handouts/notes-two-dimensional-arrays.html#deepToString} </br>
	   * @param board 2D array byte </br>
	   * @param s searched string </br>
	   * @param startRow row index of 2D array </br>
	   * @param startCol column index of 2D array </br>
	   * @return Boolean </br>
	   */
	  public static boolean contains(byte[][] board, String s,
	                                 int startRow, int startCol) {
	    for (int dRow=-1; dRow<=1; dRow++)
	      for (int dCol=-1; dCol<=1; dCol++)
	        if (((dRow != 0) || (dCol != 0)) &&
	            (contains(board, s, startRow, startCol, dRow, dCol)))
	          return true;
	    return false;
	  }

	  /** 
	   *  Returns true if the given board contains the given string,
	   *  starting from the given startRow and startCol location.
	   *  Tests every possible direction from there, where a direction
	   *  is determined by drow, dcol (the change in rows and cols). </br>
	   * 
	   * @param board 2D array byte </br>
	   * @param s searched string </br>
	   * @param dRows array of row direction. Possible values are -1, 0, 1 </br>
	   * @param dCols array of column direction. Possible values are -1, 0, 1 </br>
	   * @param startRow row index of 2D array </br>
	   * @param startCol column index of 2D array </br>
	   * @return Boolean </br>
	   */
	  public static boolean contains(byte[][] board, String s,
	                                 byte[] dRows, byte[] dCols) {
	    int rows = board.length;
	    int cols = board[0].length;
	    for (int row=0; row < rows; row++)
	      for (int col=0; col<cols; col++){
	    	  for (int dRow : dRows)
	  	      for (int dCol : dCols)
	  	        if (((dRow != 0) || (dCol != 0)) &&
	  	            (contains(board, s, row, col, dRow, dCol)))
	  	          return true;
  
	      }
	    return false;

	  }

	  
	  /**
	   * Returns true if the given board contains the given string,
	   * starting from the given startRow and startCol location,
	   * heading in the given drow, dcol direction. </br>
	   * Source reference: {@link http://www.kosbie.net/cmu/fall-08/15-100/handouts/notes-two-dimensional-arrays.html#deepToString} </br>
	   * @param board 2D array byte </br>
	   * @param s searched string </br>
	   * @param dRows array of row direction </br>
	   * @param dCols array of column direction </br>
	   * @param startRow row index of 2D array </br>
	   * @param startCol column index of 2D array </br>
	   * @return Boolean </br>
	   */
	  public static boolean contains(byte [][] board, String s,
	                                 int startRow, int startCol,
	                                 int dRow, int dCol) {
	    int rows = board.length;
	    int cols = board[0].length;
	    for (int i=0; i<s.length(); i++) {
	      int row = startRow + i*dRow;
	      int col = startCol + i*dCol;
	      if ((row < 0) || (row >= rows) || (col < 0) || (col >= cols))
	        // we're off the board, so we did not match
	        return false;
	      if (board[row][col] != s.charAt(i))
	        // we're on the board, but we don't match
	        return false;
	    }
	    return true;
	  }

	    /**
	     * Select all planes that are perpendicular to Z dimensions </br>
	     * Values of these planes are on the X and Y dimension of 3D array </br>
	     *  
	     * @param threeD 3D array byte </br>
	     * @return List of 2D array byte </br>
	     */
		public static List<byte[][]> compute3D_DimensionXY(byte[][][] threeD){
			
			List<byte[][]> ret = new ArrayList<byte[][]>();
			int n = threeD.length;
			for (int i=0; i < n ; i++){
				  ret.add(threeD[i]);
			}
			return ret;
			
		}
		
	    /**
	     * Select all planes that are perpendicular to Z dimensions </br>
	     * Values of these planes are on the X and Y dimension of 3D array </br>
	     * 
	     * @param threeD 3D array byte
	     * @return List of 2D array byte
	     */
		public static List<byte[][]> compute3D_DimensionYZ(byte[][][] threeD){
			
			List<byte[][]> ret = new ArrayList<byte[][]>();
		    int n = threeD.length;
		    
			  for (int col = 0; col < n; col++){
				  byte[][] c = new byte[n][n];
				  for (int row = 0; row < n ; row++){
					  for (int i=0; i<n; i++){
						  c[row][i] = threeD[i][row][col];
					  }
				  }
				  ret.add(c);
			  }
			return ret;
		}

	    /**
	     * Select all planes that are perpendicular to Y dimensions </br>
	     * Values of these planes are on the X and Z dimension of 3D array </br>
	     * 
	     * @param threeD 3D array byte
	     * @return List of 2D array byte
	     */
		
		public static List<byte[][]> compute3D_DimensionXZ(byte[][][] threeD){
		
			  int n = threeD.length;
			  List<byte[][]> ret = new ArrayList<byte[][]>();
			  for (int row = 0; row < n ; row++){
				  byte [][] b = new byte[n][n];
				  for (int col = 0; col < n; col++){
					  for (int i=0; i<n; i++){
						  b[i][col] = threeD[i][row][col];
					  }
				  }
				  ret.add(b);
			  }
		
			  return ret;
		}//for x

		/**
		 * Search given string in  all planes of 3D array that their values are in : 
		 * x = x0 + 1, y = y0 - 1, z = z0 + 1 </br>
		 * To avoid a duplication position, only search in diagonal dimension</br>
		 * Returns true if the given 3D array contains the given string </br>
		 * 
		 */
		public static boolean compute3D_ParallelPlane1(byte[][][] threeD, String word){
			
			int n=threeD.length;
			int len = word.length();
			for (int row=0; row <=(n-len); row ++){
				for (int col=n-1; col >= 0; col --){
					int z=0;
					boolean seek = true;
					for (int k=0; (k < len) && (row+k < n) && (col-k >=0) && (seek==true); k++){
						//System.out.println((char)threeD[z+k][row+k][col-k]);
						seek = seek && (word.charAt(k) == threeD[z+k][row+k][col-k]);
					}//for word
					if (seek) return true;
				}//for col
			}//for row
			return false;
		}

		/**
		 * Search given string in  all planes of 3D array that their values are in : 
		 * x = x0 + 1, y = y0 + 1, z = z0 + 1 </br>
		 * To avoid a duplication position, only search in diagonal dimension</br>
		 * Search from the top to the bottom, from left to right </br>
		 * Returns true if the given 3D array contains the given string </br>
		 * 
		 * @param threeD 3D array byte </br>
		 * @param word searched string </br>
		 * @return Boolean </br>
		 */
		public static boolean compute3D_ParallelPlane2(byte[][][] threeD, String word){

			int n=threeD.length;
			int len = word.length();
			for (int row=0; row <= (n-len) ; row ++){
				//System.out.println();
				for (int col=0; col <= (n-len) ; col ++){
					int z=0;
					boolean seek = true;
					for (int k=0; (k < len) && (row+k < n) && (col+k < n) && (seek==true); k++){
						
						//System.out.print((char)threeD[z+k][row+k][col+k]);
						seek = seek && (word.charAt(k) == threeD[z+k][row+k][col+k]);
						
					}//for word
					if (seek) return true;
				}//for col
				//System.out.println();
			}//for row
			return false;
		}
 
		/**
		 * Search given string in  all planes of 3D array that their values are in :
		 * x = x0 + 1, y = y0 - 1, z = z0 - 1 </br>
		 * To avoid a duplication position, only search in diagonal dimension</br>
		 * Search from the top to the bottom, right to left </br>
		 * Returns true if the given 3D array contains the given string </br>
		 * 
		 * @param threeD 3D array byte </br>
		 * @param word searched string </br>
		 * @return Boolean </br>
		 */
		public static boolean compute3D_ParallelPlane3(byte[][][] threeD, String word){
		
			int n=threeD.length;
			int len = word.length();

			for (int row=0; row <= (n-len) ; row ++){
				
				for (int col=n-1; col >= 0; col --){
					
					int z=n-1;
					boolean seek = true;
					
					for (int k=0; (k < len) && (row+k < n) && (col-k >=0) && (seek==true); k++){
						
						//System.out.print((char)threeD[z-k][row+k][col-k]);	
						seek = seek && (word.charAt(k) == threeD[z-k][row+k][col-k]);
						
					}//for word
					
					//System.out.println();
					if (seek) return true;
				}//for col
				
			}//for row		
			return false;
		}
		
		/**
		 * Search the given string in  all planes of 3D array that their values are in : 
		 * x = x0 + 1, y = y0 + 1, z = z0 - 1 </br>
		 * To avoid a duplication position, only search in diagonal dimension</br>
		 * Returns true if the given 3D array contains the given string </br>
		 * 
		 * @param threeD 3D array byte </br>
		 * @param word searched string </br>
		 * @return Boolean </br>
		 */
		public static boolean compute3D_ParallelPlane4(byte[][][] threeD, String word){
			
			int n=threeD.length;
			int len = word.length();
			
			for (int row=0; row <= (n-len); row ++){
				
				for (int col=0; col <= (n-len); col++){
					int z=n-1;
					boolean seek = true;
					for (int k=0; (k < len) && (row+k < n) && (col+k < n) && (seek==true); k++){
						//System.out.println((char)threeD[z-k][row+k][col+k]);
						seek = seek && (word.charAt(k) == threeD[z-k][row+k][col+k]); 
					}//for word
					
					if (seek) return true;

				}//for col
				
			}//for row
			
			return false;
		}

}
