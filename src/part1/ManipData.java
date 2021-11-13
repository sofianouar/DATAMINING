package part1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

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
	public void ListToFile(ArrayList<ArrayList<Double>> dataset) throws IOException {
		FileWriter writer = new FileWriter("output.txt");
		for (int k = 0; k < dataset.size(); k++) {
			for (Double tmp : dataset.get(k)) {
				writer.write(tmp + System.lineSeparator());
			} writer.write("\n");
		}
		writer.close();
		return;
	}

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

	// gets minimum of an arraylist
	public double GetMin(ArrayList<Double> data) {

		return Collections.min(data);
	}

	// gets max of an arraylist
	public double GetMax(ArrayList<Double> data) {

		return Collections.max(data);
	}

	// get frequence of all items : arraylist of vectors
	// {[value1,freq1],[value2],freq2}
	public ArrayList<ArrayList<Double>> GetFrequencies(ArrayList<Double> data) {

		ArrayList<ArrayList<Double>> frequencies = new ArrayList<>();
		ArrayList<Double> tuple = new ArrayList<Double>();
		int freq;

		for (int i = 0; i < data.size(); i++) {

			freq = Collections.frequency(data, data.get(i));
			tuple = new ArrayList<Double>();
			tuple.add(data.get(i));
			tuple.add(Double.valueOf(freq));
			frequencies.add((ArrayList<Double>) (tuple));
		}

		Set<ArrayList<Double>> set = new LinkedHashSet<ArrayList<Double>>(frequencies);
		// ArrayList<ArrayList<Double>> l = new ArrayList<>(set);

		return new ArrayList<>(set);
	}

}