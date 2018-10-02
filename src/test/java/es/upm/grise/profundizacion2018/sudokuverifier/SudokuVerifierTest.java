package es.upm.grise.profundizacion2018.sudokuverifier;

import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {
    
	//Invalid string length: 79 characters
	@Test
	public void invalidStringLength() {
    	SudokuVerifier sudokuVerifier = new SudokuVerifier();
		assertEquals(-1, sudokuVerifier.verify("5555555555555555555555555555555555555555555555555555555555555555555555555555555"));
    }
	
	//Invalid string format: contains a non-positive digit (0)
	@Test
	public void invalidStringDigit() {
    	SudokuVerifier sudokuVerifier = new SudokuVerifier();
		assertEquals(-1, sudokuVerifier.verify("055555555555555555555555555555555555555555555555555555555555555555555555555555555"));
    }
	
	//Invalid string format: contains letter (B)
		@Test
		public void invalidStringFormat() {
	    	SudokuVerifier sudokuVerifier = new SudokuVerifier();
			assertEquals(-1, sudokuVerifier.verify("B55555555555555555555555555555555555555555555555555555555555555555555555555555555"));
	    }
	
	//Invalid subgrid
	@Test
	public void invalidSubgrid() {
    	SudokuVerifier sudokuVerifier = new SudokuVerifier();
		assertEquals(-2, sudokuVerifier.verify("278539164524216987916874352783452691149687523625193748452761839897325416361948275"));
    }
	
	//Invalid row
	@Test
	public void invalidRow() {
    	SudokuVerifier sudokuVerifier = new SudokuVerifier();
		assertEquals(-3, sudokuVerifier.verify("532678912674195348198342567859761423426853791713924856961537284287419635345286179"));
    }
	
	//Invalid column
	@Test
	public void invalidColumn() {
	    SudokuVerifier sudokuVerifier = new SudokuVerifier();
		assertEquals(-4, sudokuVerifier.verify("534678912627195348198342567859761423426853791713924856961537284287419635345286179"));
	}
	
	//Valid sudoku string
	@Test
	public void validSudoku() {
	    SudokuVerifier sudokuVerifier = new SudokuVerifier();
		assertEquals(0, sudokuVerifier.verify("524163897791854263683729154412976385857341926369582741976235418248617539135498672"));
	}
}
