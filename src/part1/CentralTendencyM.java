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

	public ArrayList<ArrayList<Double>> getDataset() {
		return this.dataset;
	}

	public void setDataset(ArrayList<ArrayList<Double>> dataset) {
		this.dataset = dataset;
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

		return Math.round((1 / (double) this.attribute.size() * somme) * 1e3) / 1e3;
	}

	// trimmed moy
	public double GetTrMean(int pourcentage) {

		double somme = 0;
		// pourcentage=4, //4%
		int k = this.attribute.size() * pourcentage / 100; // nbre de val a supprimer de chaque extremite
		// System.out.println(k);
		Collections.sort(this.attribute);
		System.out.println(this.attribute);
		for (int i = k; i < this.attribute.size() - k; i++) {
			somme = somme + this.attribute.get(i);

		}
		return Math.round((1 / (double) (this.attribute.size() - 2 * k) * somme) * 1e3) / 1e3;
	}

	// médiane
	public double GetMedian() {
		ArrayList<Double> data = new ArrayList<>();
		data = this.attribute;
		Collections.sort(data);
		if (data.size() % 2 == 0)
			return Math.round((data.get((data.size() / 2) - 1) + data.get(data.size() / 2)) / 2.0 * 1e3) / 1e3;
		;

		return Math.round(data.get(data.size() / 2) * 1e3) / 1e3;
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
	public double GetMidRange() {
		return (this.GetQ4() + this.GetQ0()) / 2.0;
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

	public double GetQ1() {
		double value, valuee;
		Collections.sort(this.attribute);
		// double q1 = attribute.size()/ 4;
		if (this.attribute.size() % 4 == 0) {

			value = (this.attribute.get(Math.round(this.attribute.size() / 4) - 1));
			return Math.round(value * 1e3) / 1e3;

		}

		else {
			valuee = this.attribute.get(Math.round(this.attribute.size() / 4));

			return Math.round(valuee * 1e3) / 1e3;
		}

	}

//calcul q3********************************

	public double GetQ3() {
		double valuee,value ;

		Collections.sort(this.attribute);
		// double q3 = attribute.size() * 3 / 4;
		if (this.attribute.size() * 3 % 4 == 0) {
			value = this.attribute.get(Math.round(this.attribute.size() * 3 / 4) - 1);
			return Math.round(value * 1e3) / 1e3;
		}

		else {
			valuee = this.attribute.get(Math.round(this.attribute.size() * 3 / 4));
			return Math.round(valuee * 1e3) / 1e3;
		}

	}

//calcul Q0 (min)*******************************
	public double GetQ0() {
		Collections.sort(this.attribute);
		return this.attribute.get(0);
	}

//calcul Q4 (max)********************************
	public double GetQ4() {
		Collections.sort(this.attribute);

		return (this.attribute.get(this.attribute.size() - 1));
	}

//calcul Ecart interquartile*****************************
	public double GetIQR() {
		return (this.GetQ3() - this.GetQ1());
	}

//calcul etendue*************************************
	public double GetEtendu() {
		return (this.GetQ4() - this.GetQ0());
	}

//calcul outliers***********************************************************
	public double GetOutliersMax() {
		// Q3 + 1. 5 * IQR
		double outMax = this.GetQ3() + (1.5 * this.GetIQR());

		return Math.round(outMax * 1e3) / 1e3;

	}

	public double GetOutliersMin() {
		// Q1 - 1.5 * IQR
		double outMin = this.GetQ1() - (1.5 * this.GetIQR());

		return Math.round(outMin * 1e3) / 1e3;

	}

//calcul ecart type*********************************************************
	public double GetEcartType() {

		Collections.sort(this.attribute);

		double ect;
		double somme = 0;
		double mean = this.GetMean();
		
		for (int i = 0; i < this.attribute.size(); i++) {
			somme = somme + (Math.pow(this.attribute.get(i) - mean, 2));
		}
		ect = Math.sqrt((1 / (double) this.attribute.size()) * somme);
		return Math.round(ect * 1e3) / 1e3;
	}

//calcul variance*******************************************
	public double GetVariance() {

		return Math.round(Math.pow(this.GetEcartType(), 2) * 1e3) / 1e3;

	}
}
