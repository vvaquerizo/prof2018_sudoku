package es.upm.grise.profundizacion2018.sudokuverifier;

public class SudokuVerifier 
{
	private final int SUDOKU_SIDE_SIZE = 9;
	private final int SUBGRID_SIDE_SIZE = 3;
	
	private String sudokuString;
	private String[] sudokuStringArray;
	private int [][] sudoku = new int [9][9];
	
	public int verify (String candidateSolution)
    {
		this.sudokuString = candidateSolution;
		
		string2stringArray();
		
		if (!isValidString()) {
			return -1;
		}
		
		string2matrix();
		
		if (!areValidSubgrids()) {
			return -2;
		}
		
		if (!areValidRows()) {
			return -3;
		}
		
		if (!areValidColumns()) {
			return -4;
		}
		
        return 0;
    }
	
	private void string2stringArray() {
		sudokuStringArray = sudokuString.split("");
	}
	
	private boolean isValidString() {
		if (sudokuStringArray.length != 81) {
			return false;
		}
		
		for (int i = 0; i < sudokuStringArray.length; i++) {
			if (!(sudokuStringArray[i].matches("^[1-9]$"))) {
				return false;
			}
		}
		return true;
	}
	
	private void string2matrix() {
		for (int row = 0; row < SUDOKU_SIDE_SIZE; row++) {
			for (int column = 0; column < SUDOKU_SIDE_SIZE; column++) {
				sudoku[row][column] = Integer.parseInt(sudokuStringArray[row*SUDOKU_SIDE_SIZE + column]);
			}
		}
	}
	
	private boolean areValidSubgrids() {
		for (int startRow = 0; startRow < SUDOKU_SIDE_SIZE; startRow = startRow + SUBGRID_SIDE_SIZE) {
			for (int startColumn = 0; startColumn < SUDOKU_SIDE_SIZE; startColumn = startColumn + SUBGRID_SIDE_SIZE) {
				if (hasDuplicatedElements(obtainSubgridArray(startRow,startColumn))) {
					return false;
				}
			}
		}
		return true;
	}
	
	private Integer[] obtainSubgridArray(int startRow, int startColumn) {
		Integer[] subgridStringArray = new Integer[9];
		for (int row = startRow; row < (startRow + SUBGRID_SIDE_SIZE); row++) {
			for (int column = startColumn; column < (startColumn + SUBGRID_SIDE_SIZE); column++) {
				subgridStringArray[(row - startRow)*SUBGRID_SIDE_SIZE + (column - startColumn)] = sudoku[row][column];
			}
		}
		return subgridStringArray;
	}
	
	private boolean hasDuplicatedElements(Integer[] integerArray) {
		for (int i = 0; i < integerArray.length; i++) {
			for (int j = 0; j < integerArray.length; j++) {
				if (i != j) {
					if (integerArray[i].equals(integerArray[j])) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	private boolean areValidRows() {
		for (int row = 0; row < SUDOKU_SIDE_SIZE; row++) {
			if (hasDuplicatedElements(obtainRow(row))) {
				return false;
			}
		}
		return true;
	}
	
	private Integer[] obtainRow(int row) {
		Integer[] rowArray = new Integer[SUDOKU_SIDE_SIZE];
		for (int i = 0; i < SUDOKU_SIDE_SIZE; i++) {
			rowArray[i] = sudoku[row][i];
		}
		return rowArray;
	}
	
	private boolean areValidColumns() {
		for (int column = 0; column < SUDOKU_SIDE_SIZE; column++) {
			if (hasDuplicatedElements(obtainColumn(column))) {
				return false;
			}
		}
		return true;
	}
	
	private Integer[] obtainColumn(int column) {
		Integer[] columnArray = new Integer[SUDOKU_SIDE_SIZE];
		for (int i = 0; i < SUDOKU_SIDE_SIZE; i++) {
			columnArray[i] = sudoku[i][column];
		}
		return columnArray;
	}
}