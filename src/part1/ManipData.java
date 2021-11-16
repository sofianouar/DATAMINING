package part1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class ManipData {
	ArrayList<ArrayList<Double>> data;

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

	public void setData(ArrayList<ArrayList<Double>> data) {
		this.data = data;
	}

	/*
	 * functions
	 */

	public ArrayList<ArrayList<Double>> OpenTxtFile(String path) throws IOException {
		// Decalarations
		String currentDirectory = new File("").getAbsolutePath();
		int c = 0;
		String[] splitRow;
		ArrayList<Double> one_line = new ArrayList<>(); // contains all attributes of one specific line
		ArrayList<ArrayList<Double>> dataset = new ArrayList<>(); // list of one_line

		// reading the file seeds_data.txt
		BufferedReader bf = new BufferedReader(new FileReader(currentDirectory + path));

		// reading all data lines : 1 2 3 4 5 6 7 8, 1 2 3 4 5 6 7 8 ....
		String tmp_line = bf.readLine();

		/*
		 * spliting a specific line to separate the attributes :
		 * one_line=[1,2,3,4,5,6,7,8] parsing one_line's values to double :
		 * [1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0] adding one_line to list_data :
		 * [[1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0],[1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0]....]
		 */

		while (tmp_line != null) {
			splitRow = tmp_line.split("\t+");
			one_line = new ArrayList<>();

			for (String s : splitRow) {
				one_line.add(Double.parseDouble(s));
			}

			dataset.add(one_line);
			c++;
			tmp_line = bf.readLine();

		}

		// printing list
		System.out.print(dataset);
		this.setData(dataset);
		return dataset;
	}

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

	// open different types of files data
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
		this.setData(data);
		return this.data;
	}

	// drop data from dataList
	public ArrayList<ArrayList<Double>> DropData(int index) {
		index--;
		if (RowExists(index)) {
			data.remove(index);
		}
		return data;
	}

	// modify data having rowNumberN : NOTE : THE USER GIVES INDEXES STARTING FROM 1
	public ArrayList<ArrayList<Double>> AlterRow(int rownumber, int numAtt, double value) {
		numAtt--;
		ArrayList<Double> tmpRow = new ArrayList<>();

		this.data.get(rownumber).set(numAtt,
				value); /*
						 * the predefined set method replaces the index numAtt with value
						 */

		return this.data;
	}

	// returns all values of a certain attribute in an arrayList
	public ArrayList<Double> GetAttribute(int index) {
		index--;
		ArrayList<Double> attribute = new ArrayList<>();
		for (int i = 0; i < this.data.size(); i++) {
			attribute.add(this.data.get(i).get(index));
		}
		return attribute;
	}

	// returns all values of att1 and att2 in an arrayList<arrayList> (index
	// 0=att1,index1=att2)
	public ArrayList<ArrayList<Double>> GetAttribute(int index1, int index2) {
		index1--;
		index2--;
		ArrayList<Double> attribute1 = new ArrayList<>();
		ArrayList<Double> attribute2 = new ArrayList<>();
		ArrayList<ArrayList<Double>> attributes = new ArrayList<>();

		attribute1 = this.GetAttribute(index1);
		attribute2 = this.GetAttribute(index2);

		attributes.add(attribute1);
		attributes.add(attribute2);

		return attributes;
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

	// resume of all values
	public ArrayList<Double> SetResume(double min, double q1, double q2, double q3, double max) {
		ArrayList<Double> list = new ArrayList<>();
		list.addAll(Arrays.asList(min, q1, q2, q3, max));
		return list;
	}

}