package part1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ManipData {
	ArrayList<Double> row;
	ArrayList<ArrayList<Double>> data;

	/*
	 * constructor
	 */
	public ManipData() {
	}

	public ManipData(ArrayList<Double> row, ArrayList<ArrayList<Double>> data) {
		this.row = row;
		this.data = data;
	}

	/*
	 * getters and setters
	 */
	public ArrayList<Double> getRow() {
		return row;
	}

	public void setRow(ArrayList<Double> row) {
		this.row = row;
	}

	public ArrayList<ArrayList<Double>> getData() {
		return data;
	}

	public void setData(ArrayList<ArrayList<Double>> data) {
		this.data = data;
	}

	/*
	 * functions
	 */

	// getting the position of a certain line of data in all dataList
	public int GetRowPos(ArrayList<ArrayList<Double>> data, ArrayList<Double> row) {
		int pos = 0;
		return pos;
	}

	// verifies if a line of data exists in the dataList
	public boolean RowExists(ArrayList<ArrayList<Double>> data, ArrayList<Double> row) {
		boolean exist = false;

		return exist;
	}

	// open file data

	// add Data to dataList
	public ArrayList<ArrayList<Double>> addData(ArrayList<ArrayList<Double>> data, ArrayList<Double> row) {
		data.add(row);
		return data;
	}

	// drop data from dataList
	public ArrayList<ArrayList<Double>> DropData(ArrayList<ArrayList<Double>> data, ArrayList<Double> row) {
		int tmp = 0;
		if (RowExists(data, row)) {
			tmp = GetRowPos(data, row);
			data.remove(tmp);
		}
		return data;
	}

	// modify data having rowNumberN
	public ArrayList<ArrayList<Double>> AlterRowN(ArrayList<ArrayList<Double>> data, int rownumber, int numAtt,double value) {
		numAtt--;
		ArrayList<Double> tmpRow=new ArrayList<>();
		
			
			tmpRow=data.get(rownumber);
			
		
		return data;
	}

	// modify data having row dataR
	public ArrayList<ArrayList<Double>> AlterRowR(ArrayList<ArrayList<Double>> data, ArrayList<Double> row, int numAtt,
			double value) {
		numAtt--;

		return data;
	}

	// Sort Data ascendently
	public ArrayList<Double> SortAttribute(ArrayList<Double> row) {
		Collections.sort(row);
		return row;
	}
}