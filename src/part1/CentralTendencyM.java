package part1;

import java.util.ArrayList;
import java.text.DecimalFormat;

public class CentralTendencyM {
	public ArrayList<Double> data;
	public ArrayList<ArrayList<Double>> dataset;

	/*
	 * constructors
	 */
	public CentralTendencyM() {
	}

	public CentralTendencyM(ArrayList<Double> data) {
		this.data = data;
	}

	/*
	 * getters and setters
	 */
	public ArrayList<Double> getData() {
		return data;
	}

	public void setData(ArrayList<Double> data) {
		this.data = data;
	}

	/*
	 * functions
	 */

	// moyenne
	public double GetMean(ArrayList<Double> attribute) {
		double somme = 0;
		final DecimalFormat df = new DecimalFormat("0.00");
		for (int i = 0; i < attribute.size(); i++) {
			somme = somme + attribute.get(i);
			System.out.println(somme);
		}

		return Math.round((1 / (double) attribute.size() * somme) * 1e2) / 1e2;
	}

	// moyenne tronqué
	public double GetTrMean(ArrayList<Double> data) {

		return Math.round((3) * 1e2) / 1e2;
	}

	// médiane
	public double GetMedian(ArrayList<Double> data) {
		data = ManipData.SortAttribute(data);
		if (data.size() % 2 == 0)
			return (data.get((data.size() / 2) - 1) + data.get(data.size() / 2)) / 2.0;

		return Math.round((data.get(data.size() / 2)) * 1e2) / 1e2;
	}

	// mode
	public Double GetMode(ArrayList<Double> data) {
		int mode = 0;
		ArrayList<ArrayList<Double>> tmp = ManipData.GetFrequencies(data);
		ArrayList<Double> frequencies = new ArrayList<>();
		frequencies = ManipData.GetAttribute(tmp, 1);
		double maxVal = ManipData.GetMax(frequencies);

		// type de modalitee
		if (mode == 1)
			System.out.print(1);
		if (mode == 2)
			System.out.print(2);
		if (mode == 3)
			System.out.print(3);
		else
			System.out.print(0);
		return data.get(0);
	}

	// l'étendue
	public double GetEtendue(ArrayList<Double> data) {

		return ManipData.GetMax(data) - ManipData.GetMin(data);
	}

	// milieu de l'étendue
	public double GetMidRange(ArrayList<Double> data) {

		return (ManipData.GetMax(data) + ManipData.GetMin(data)) / 2.0;
	}

	// déduire les symétries
	public double DedSym(ArrayList<Double> data) {

		return 0;
	}
}
