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
		// islam modifs
		String currentDirectory = new File("").getAbsolutePath();
		int c = 0;
		String[] splitRow;
		ArrayList<Double> one_line = new ArrayList<>(); // contains all attributes of one specific line
		ArrayList<ArrayList<Double>> dataset = new ArrayList<>(); // list of one_line

		// reading the file seeds_data.txt
		// islam modifs
		// BufferedReader bf = new BufferedReader(new FileReader(currentDirectory + path));
		BufferedReader bf = new BufferedReader(new FileReader(path));

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

	// islam modifs	
	public void ListToFile(ArrayList<ArrayList<Double>> dataset,String  path) throws IOException {
		FileWriter writer = new FileWriter(path);
		for (int k = 0; k < dataset.size(); k++) {
			for (Double tmp : dataset.get(k)) {
				// writer.write(tmp + System.lineSeparator());
				writer.write(tmp + "\t");
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
	
	public Individu arrayToIndividu(ArrayList<Double> _array, int i) {
		Individu ind = new Individu(
				i,
				_array.get(0),
				_array.get(1),
				_array.get(2),
				_array.get(3),
				_array.get(4),
				_array.get(5),
				_array.get(6),
				_array.get(7))	
				;
		return ind;		
	}
	
	public ArrayList<Double> indToArray(Individu ind){
		ArrayList<Double> _array = new ArrayList<Double>();
		_array.add(ind.getA1());
		_array.add(ind.getA2());
		_array.add(ind.getA3());
		_array.add(ind.getA4());
		_array.add(ind.getA5());
		_array.add(ind.getA6());
		_array.add(ind.getA7());
		_array.add(ind.getClasse());
		return _array;
	}
	
	public ArrayList<Individu> arrayDatatoIndData(ArrayList<ArrayList<Double>> _array) {
		ArrayList<Individu> indArray = new ArrayList<Individu>();
		for(int i = 0 ; i < _array.size(); i++) {
			indArray.add(this.arrayToIndividu(_array.get(i), i+1));
		}
		return indArray;
	}
	
	public ArrayList<ArrayList<Double>> indDataToArrayData(ArrayList<Individu> indArray){
		ArrayList<ArrayList<Double>> _array = new ArrayList<ArrayList<Double>>();
		for(int i = 0 ; i < indArray.size(); i++) {
			_array.add(this.indToArray(indArray.get(i)));
		}
		return _array;
	}
	
	// data description
		public ArrayList<ArrayList<String>> DataDesc() {
			ArrayList<ArrayList<String>> output = new ArrayList<>();
			ArrayList<Double> attribute = new ArrayList<>();
			ArrayList<String> att = new ArrayList<>();
			att.add("zone A");
			att.add("p�rim�tre P");
			att.add("compacit� c");
			att.add("longueur du noyau");
			att.add("largeur du noyau");
			att.add("coefficient d'asym�trie");
			att.add(" longueur de la rainure du noyau");
	

			ArrayList<String> tmp;
			tmp = new ArrayList<>();
			tmp.add("Nombre d'instances = "+this.data.size());
			output.add(tmp);
			tmp = new ArrayList<>();
			tmp.add(("Nombre d'attributs = 7"));
			output.add(tmp);
			tmp = new ArrayList<>();
			tmp.add(("Types d'attributs : attributs � valeurs r�elles"));
			output.add(tmp);

			for (int i = 0; i < this.data.get(0).size()-1; i++) {

				attribute=GetAttribute(i+1);

				tmp = new ArrayList<>();
				Collections.sort(attribute);
				tmp.add("Attribute "+(i+1)+" : "+att.get(i));
				tmp.add(attribute.get(0).toString());
				tmp.add(attribute.get(attribute.size()-1).toString());
				tmp.add("variable quantitative continue ");
				output.add(tmp);
			
			}
			tmp = new ArrayList<>();
			tmp.add("Class ");
			tmp.add("1 : cama");
			tmp.add("2 : rosa");
			tmp.add("3  : canadian");
			tmp.add("variable qualitative discr�te ");
			output.add(tmp);
			return output;
		}

}