package part1;

import java.util.ArrayList;
import java.util.Collections;

public class CentralTendencyM {
	public ArrayList<Double> attribute;
	public ArrayList<ArrayList<Double>> dataset;

	/*
	 * constructors
	 */
	public CentralTendencyM() {
	}

	public CentralTendencyM(ArrayList<Double> data) {
		this.attribute = data;
	}

	/*
	 * getters and setters
	 */
	public ArrayList<Double> getAttribute() {
		return attribute;
	}

	public void setAttribute(ArrayList<Double> data) {
		this.attribute = data;
	}

	/*
	 * functions
	 */

	// moyenne
	public double GetMean() {
		
		double somme = 0;
		for (int i = 0; i < this.attribute.size(); i++) {
			somme = somme + this.attribute.get(i);
		}

		return Math.round((1 / (double) this.attribute.size() * somme) * 1e2) / 1e2;
	}

	// trimmed moy
	public double GetTrMean(int indexAtt, int pourcentage) {
		ArrayList<Double> attribute = new ArrayList<>();
		attribute = this.dataset.get(indexAtt);
		double somme = 0;
		// pourcentage=4, //4%
		int k = attribute.size() * pourcentage / 100; // nbre de val a supprimer de chaque extremite
		// System.out.println(k);
		Collections.sort(attribute);
		System.out.println(attribute);
		for (int i = k; i < attribute.size() - k; i++) {
			somme = somme + attribute.get(i);

		}
		return Math.round((1 / (double) (attribute.size() - 2 * k) * somme) * 1e2) / 1e2;
	}

	public ArrayList<ArrayList<Double>> getDataset() {
		return dataset;
	}

	public void setDataset(ArrayList<ArrayList<Double>> dataset) {
		this.dataset = dataset;
	}

	// médiane
	public double GetMedian(int indexAtt) {
		ArrayList<Double> data = new ArrayList<>();
		data = this.dataset.get(indexAtt);
		Collections.sort(data);
		if (data.size() % 2 == 0)
			return Math.round((data.get((data.size() / 2) - 1) + data.get(data.size() / 2)) / 2.0 * 1e2) / 1e2;
		;

		return Math.round(data.get(data.size() / 2) * 1e2) / 1e2;
	}

	// mode
	public ArrayList<Double> GetMode(int indexAtt) {
		int cmode = 0;
		ArrayList<Double> mode = new ArrayList<>();
		// attribute = ManipData.SortAttribute(attribute);

		// type de modalitee
		if (cmode == 1) // System.out.print("unimodal "+ 1);
			mode.add(1.0);

		if (cmode == 2) // System.out.print("bimodale "+2);
			mode.add(2.0);

		if (cmode == 3) // System.out.print("trimodale "+3);
			mode.add(3.0);

		else // System.out.print("pas de mode "+0);
			mode.add(0.0);

		return mode;
	}

	// l'étendue

	// milieu de l'étendue
	public double GetMidRange(int indexAtt) {
		ManipData m = new ManipData(this.dataset);
		//m.setRow(this.dataset.get(indexAtt));
		return (m.GetMax(indexAtt) + m.GetMin(indexAtt)) / 2.0;
	}

	// déduire les symétries
	public void DedSym(double mean, double median, double mode) {

		if (mean == median & median == mode)
			System.out.println("attribute is symetric");
		if (mode < median & median < mean)
			System.out.println("negatively skewed attribute ");
		if (mean < median & median < mode)
			System.out.println("positively skewed attribute ");
		return;
	}

	/************************
	 * fonctions questions 2
	 ******************************************************/

	// calcul five-number summary

//calcul q1*******************************************

	public double GetQ1(int indexAtt) {
		ArrayList<Double> data = new ArrayList<>();
		data = this.dataset.get(indexAtt);
		Collections.sort(data);
		// double q1 = attribute.size()/ 4;
		if (data.size() % 4 == 0) {

			double value = (data.get(Math.round(data.size() / 4) - 1));
			return Math.round(value * 1e2) / 1e2;

			// return Math.round((attribute.get((attribute.size() / 2) - 1) + attribute.get(attribute.size() /
			// 2)) / 2.0 * 1e2) / 1e2;;

		}

		else {
			double valuee = data.get(Math.round(data.size() / 4));

			return Math.round(valuee * 1e2) / 1e2;
		}

	}

//calcul q3********************************

	public double GetQ3(int indexAtt) {
		ArrayList<Double> data = new ArrayList<>();
		data = this.dataset.get(indexAtt);
		Collections.sort(data);
		// double q3 = attribute.size() * 3 / 4;

		if (data.size() * 3 % 4 == 0) {
			double value = data.get(Math.round(data.size() * 3 / 4) - 1);
			return Math.round(value * 1e2) / 1e2;

		}

		else {

			double valuee = data.get(Math.round(data.size() * 3 / 4));
			return Math.round(valuee * 1e2) / 1e2;
		}

	}

//calcul Q0 (min)*******************************
	public double GetQ0(int indexAtt) {
		ArrayList<Double> data = new ArrayList<>();
		data = this.dataset.get(indexAtt);
		Collections.sort(data);
		double q0 = data.get(0);
		return q0;

	}

//calcul Q4 (max)********************************
	public double GetQ4(int indexAtt) {
		ArrayList<Double> data = new ArrayList<>();
		data = this.dataset.get(indexAtt);
		Collections.sort(data);
		double q4 = data.get(data.size() - 1);

		return q4;

	}

//calcul Ecart interquartile*****************************
	public double GetIQR(int indexAtt) {
		double iqr;

		iqr = this.GetQ3(indexAtt) - this.GetQ1(indexAtt);
		return iqr;

	}

//calcul etendue*************************************
	public double GetEtendu(int indexAtt) {
		double et = this.GetQ4(indexAtt) - this.GetQ0(indexAtt);

		return et;

	}

//calcul outliers***********************************************************
	public double GetOutliersMax(int indexAtt) {

		// Q3 + 1. 5 * IQR

		double outMax = this.GetQ3(indexAtt) + (1.5 * this.GetIQR(indexAtt));

		return outMax;

	}

	public double GetOutliersMin(int indexAtt) {

		// Q1 - 1.5 * IQR
		double outMin = this.GetQ1(indexAtt) - (1.5 * this.GetIQR(indexAtt));

		return outMin;

	}

//calcul ecart type*********************************************************
	public double GetEcartType(int indexAtt) {
		ArrayList<Double> data = new ArrayList<>();
		ManipData man=new ManipData(this.dataset);
		man.setData(this.dataset);
		data = man.GetAttribute(indexAtt);
		
		Collections.sort(this.attribute);

		double ect = 0;
		double somme = 0;

		double mean = this.GetMean();
		for (int i = 0; i < data.size(); i++)

		{
			somme = somme + (Math.pow(data.get(i) - mean, 2.0));

			double tailleInv = 1 / data.size();
			ect = Math.sqrt(tailleInv * somme);
		}
		return Math.round(ect * 1e2) / 1e2;
	}

//calcul variance*******************************************
	public double GetVariance(int indexAtt) {

		return Math.round(Math.pow(this.GetEcartType(indexAtt), 2.0) * 1e2) / 1e2;

	}
}
