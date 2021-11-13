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

	public ManipData(ArrayList<ArrayList<Double>> data) {
		this.data = data;
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

	// open file data
	public ArrayList<ArrayList<Double>> openFile(String Otype) {
		// not yet
		switch (Otype) {
		case "url":
			// code block
			break;
		case "txtfile":
			// code block
			break;
		case "csvfile":
			// code block
			break;
		default:
			// code block
		}
		return data;
	}

	// verifies if a line of data exists in the dataList
	public boolean RowExists(ArrayList<ArrayList<Double>> data, ArrayList<Double> row) {
		return data.contains(row);
	}

	// getting the position of a certain line of data , NOTE : value returned STARTS
	// FROM 0
	public int GetPos(ArrayList<ArrayList<Double>> data, ArrayList<Double> row) {

		return data.indexOf(row);
	}

	// getting the row data given the pos
	public ArrayList<Double> GetRow(ArrayList<ArrayList<Double>> data, int index) {
		return data.get(index);
	}

	// add Data to dataList
	public ArrayList<ArrayList<Double>> addData(ArrayList<ArrayList<Double>> data, ArrayList<Double> row) {
		data.add(row);
		return data;
	}

	// drop data from dataList
	public ArrayList<ArrayList<Double>> DropData(ArrayList<ArrayList<Double>> data, ArrayList<Double> row) {
		int tmp = 0;
		if (RowExists(data, row)) {
			tmp = GetPos(data, row);
			data.remove(tmp);
		}
		return data;
	}

	// modify data having rowNumberN : NOTE : THE USER GIVES INDEXES STARTING FROM 1
	public ArrayList<ArrayList<Double>> AlterRowN(ArrayList<ArrayList<Double>> data, int rownumber, int numAtt,
			double value) {
		numAtt--;
		ArrayList<Double> tmpRow = new ArrayList<>();

		data.get(rownumber).set(numAtt, value); /*
												 * the predefined set method replaces the index numAtt with value
												 */

		return data;
	}

	// modify data having row dataR : NOTE : THE USER GIVES INDEXES STARTING FROM 1
	public ArrayList<ArrayList<Double>> AlterRowR(ArrayList<ArrayList<Double>> data, ArrayList<Double> row, int numAtt,
			double value) {
		numAtt--;
		// not yet
		return data;
	}

	// Sort Data ascendently
	public ArrayList<Double> SortAttribute(ArrayList<Double> row) {
		Collections.sort(row);
		return row;
	}

	// returns all values of a certain attribute in an arrayList
	public ArrayList<Double> GetAttribute(ArrayList<ArrayList<Double>> data, int index) {
		ArrayList<Double> attribute = new ArrayList<>();
		for (int i = 0; i < data.size(); i++) {
			attribute.add(data.get(i).get(index));
		}
		return attribute;
	}

	// returns all values of att1 and att2 in an arrayList<arrayList> (index 0=att1,
	// index1=att2)
	public ArrayList<ArrayList<Double>> GetAttribute(ArrayList<ArrayList<Double>> data, int index1, int index2) {
		ArrayList<Double> attribute1 = new ArrayList<>();
		ArrayList<Double> attribute2 = new ArrayList<>();
		ArrayList<ArrayList<Double>> attributes = new ArrayList<>();

		attribute1 = GetAttribute(data, index1);
		attribute2 = GetAttribute(data, index2);

		attributes.add(attribute1);
		attributes.add(attribute2);

		return attributes;
	}
}