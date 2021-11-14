package part1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class ManipData {
	ArrayList<ArrayList<Double>> data;
	ArrayList<Double> row;
	/*
	 * constructor
	 */
	public ManipData() {
	}

	public ManipData(ArrayList<ArrayList<Double>> data) {
		this.data = data;
	}

	/*
	 * getters and setters
	 */

	public ArrayList<ArrayList<Double>> getData() {
		return this.data;
	}

	public ArrayList<Double> getRow() {
		return row;
	}

	public void setRow(ArrayList<Double> row) {
		this.row = row;
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
			}
			writer.write("\n");
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
		return this.data;
	}

	// verifies if a line of data exists in the dataList
	public boolean RowExists(int index) {
		return this.data.contains(data.get(index));
	}

	
	// getting the row data given the pos
	public ArrayList<Double> GetRow(int index) {
		index--;
		return this.data.get(index);
	}

	// add Data to dataList
	public ArrayList<ArrayList<Double>> addData(ArrayList<Double> row) {
		this.data.add(row);
		return this.data;
	}

	// drop data from dataList
	public ArrayList<ArrayList<Double>> DropData(int index) {
		index--;
		if (RowExists(index) ){
			data.remove(index);
		}
		return data;
	}

	// modify data having rowNumberN : NOTE : THE USER GIVES INDEXES STARTING FROM 1
	public ArrayList<ArrayList<Double>> AlterRow(int rownumber, int numAtt,double value) {
		numAtt--;
		ArrayList<Double> tmpRow = new ArrayList<>();

		this.data.get(rownumber).set(numAtt, value); /*
												 * the predefined set method replaces the index numAtt with value
												 */

		return this.data;
	}


	// Sort Data ascendently
	public ArrayList<Double> SortAttribute(int indexAtt) {
		Collections.sort(this.data.get(indexAtt));
		return this.data.get(indexAtt);
	}

	// returns all values of a certain attribute in an arrayList
	public ArrayList<Double> GetAttribute(int index) {
		ArrayList<Double> attribute = new ArrayList<>();
		for (int i = 0; i < this.data.size(); i++) {
			attribute.add(this.data.get(i).get(index));
		}
		return attribute;
	}

	// returns all values of att1 and att2 in an arrayList<arrayList> (index 0=att1,
	// index1=att2)
	public ArrayList<ArrayList<Double>> GetAttribute(int index1, int index2) {
		ArrayList<Double> attribute1 = new ArrayList<>();
		ArrayList<Double> attribute2 = new ArrayList<>();
		ArrayList<ArrayList<Double>> attributes = new ArrayList<>();

		attribute1 = GetAttribute(index1);
		attribute2 = GetAttribute(index2);

		attributes.add(attribute1);
		attributes.add(attribute2);

		return attributes;
	}

	// gets minimum of an arraylist
	public double GetMin(int indexAtt) {

		return Collections.min(this.data.get(indexAtt));
	}

	// gets max of an arraylist
	public double GetMax(int indexAtt) {

		return Collections.max(this.data.get(indexAtt));
	}

	// get frequence of all items : arraylist of vectors
	// {[value1,freq1],[value2],freq2}
	public ArrayList<ArrayList<Double>> GetFrequencies(int indexAtt) {
		ArrayList<Double> data = new ArrayList<>();
		data=GetAttribute(indexAtt);
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

	// resume of all values
	public ArrayList<Double> SetResume(double min, double q1, double q2, double q3, double max) {
		ArrayList<Double> list = new ArrayList<>();
		list.addAll(Arrays.asList(min, q1, q2, q3, max));
		return list;
	}

}