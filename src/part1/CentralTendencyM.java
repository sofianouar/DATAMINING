package part1;

import java.util.ArrayList;

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
		for (int i = 0; i < attribute.size(); i++) {
			somme = somme + attribute.get(i);
		}

		return Math.round((1 / (double) attribute.size() * somme) * 1e2) / 1e2;
	}

	// trimmed moy
	public double GetTrMean(ArrayList<Double> attribute) {
		double somme = 0;
		for (int i = 1; i < attribute.size()-1; i++) {
			somme = somme + attribute.get(i);
			System.out.println(somme);
		}
		return Math.round((1 / (double) (attribute.size()-2) * somme) * 1e2) / 1e2;
	}

	// médiane
	public double GetMedian(ArrayList<Double> data) {
		data = ManipData.SortAttribute(data);
		if (data.size() % 2 == 0)
			return (data.get((data.size() / 2) - 1) + data.get(data.size() / 2)) / 2.0;

		return data.get(data.size() / 2);
	}

	// mode
	public ArrayList<Double> GetMode(ArrayList<Double> data) {
		int cmode=0;
		ArrayList<Double> mode = new ArrayList<>();
		data = ManipData.SortAttribute(data);

		// type de modalitee
		if (cmode== 1) //System.out.print("unimodal "+ 1);
			mode.add(1.0);
		
		if (cmode == 2) //System.out.print("bimodale "+2);
			mode.add(2.0);
		
		if (cmode == 3) //System.out.print("trimodale "+3);
			mode.add(3.0);
		
		else //System.out.print("pas de mode "+0);
			mode.add(0.0);
		
		return mode;
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
	public void DedSym(double mean, double median, double mode) {
		if(mean==median & median==mode)
			System.out.println("data is symetric");
		if(mode<median & median<mean)
			System.out.println("negatively skewed data ");
		if(mean<median & median<mode)
			System.out.println("positively skewed data ");
		return;
	}
}
