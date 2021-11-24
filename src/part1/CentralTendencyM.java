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

	// get mean with index
	public double GetMean(int index) {
		double somme = 0;
		ArrayList<Double> attribute = new ArrayList<>();
		ManipData man = new ManipData(this.dataset);
		attribute = man.GetAttribute(index);
		for (int i = 0; i < attribute.size(); i++) {
			somme = somme + attribute.get(i);
		}

		return Math.round((1 / (double) attribute.size() * somme) * 1e3) / 1e3;
	}

	// trimmed moy
	public double GetTrMean(int pourcentage) {

		double somme = 0;
		// pourcentage=4 = 4%
		int k = this.attribute.size() * pourcentage / 100; // nbre de val a supprimer de chaque extremite
		Collections.sort(this.attribute);
		for (int i = k; i < this.attribute.size() - k; i++) {
			somme = somme + this.attribute.get(i);

		}
		return Math.round((1 / (double) (this.attribute.size() - 2 * k) * somme) * 1e3) / 1e3;
	}

	// m�diane
	public double GetMedian() {
		ArrayList<Double> data = new ArrayList<>();
		data = this.attribute;
		Collections.sort(data);
		if (data.size() % 2 == 0)
			return Math.round((data.get((data.size() / 2) - 1) + data.get(data.size() / 2)) / 2.0 * 1e3) / 1e3;

		return Math.round(data.get(data.size() / 2) * 1e3) / 1e3;
	}

	// mode :{values, freq}
	public ArrayList<Double> GetMode() {
		int count = 0;
		double maxFreq = 0.0;
		ArrayList<Double> mode = new ArrayList<>();
		ManipData m = new ManipData();
		ArrayList<ArrayList<Double>> freq = new ArrayList<>();
		freq = m.GetFrequencies(this.attribute);

		for (int i = 0; i < freq.size(); i++) {
			if (freq.get(i).get(1) >= maxFreq) {
				maxFreq = freq.get(i).get(1);
			}
		}
		for (int i = 0; i < freq.size(); i++) {
			if (freq.get(i).get(1) == maxFreq) {
				count = count + 1;
				mode.add(freq.get(i).get(0));
			}
		}

		// type de modalitee
		if (count == 1) {// System.out.print("unimodal "+ 1);
			mode.add((double) count);
			System.out.print("Type de modalit� : unimodal \n");
		}

		if (count == 2) { // System.out.print("bimodale "+2);
			mode.add((double) count);
			System.out.print("Type de modalit� : bimodal \n");
		}
		if (count == 3) { // System.out.print("trimodale "+3);
			mode.add((double) count);
			System.out.print("Type de modalit� : trimodal \n");
		}
		if (count > 3) { // System.out.print("pas de mode "+0);
			mode.add((double) count);
			System.out.print("Type de modalit� : pas de mode \n");
		}

		return mode;
	}

	// l'�tendue

	// milieu de l'�tendue
	public double GetMidRange() {
		return Math.round(((this.GetQ4() + this.GetQ0()) / 2.0) * 1e3) / 1e3;
	}

	// d�duire les sym�tries
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
		double valuee, value;

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
		return Math.round((this.GetQ3() - this.GetQ1()) * 1e3) / 1e3;
	}

//calcul etendue*************************************
	public double GetEtendu() {
		return Math.round((this.GetQ4() - this.GetQ0()) * 1e3) / 1e3;
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
		System.out.println(this.GetQ1() + " | " + this.GetIQR());
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

//calcul eart type avec index
	public double GetEcartType(int index) {
		ArrayList<Double> attribute = new ArrayList<>();
		ManipData man = new ManipData(this.dataset);
		attribute = man.GetAttribute(index);
		Collections.sort(attribute);

		double ect;
		double somme = 0;
		double mean = this.GetMean();

		for (int i = 0; i < attribute.size(); i++) {
			somme = somme + (Math.pow(attribute.get(i) - mean, 2));
		}
		ect = Math.sqrt((1 / (double) attribute.size()) * somme);
		return Math.round(ect * 1e3) / 1e3;
	}

//calcul variance*******************************************
	public double GetVariance() {

		return Math.round(Math.pow(this.GetEcartType(), 2) * 1e3) / 1e3;

	}

	// calcul covariance*******************************************
	public double GetCoVariance(int i, int j) {
		ManipData man = new ManipData(this.dataset);
		ArrayList<Double> att1 = man.GetAttribute(i);
		ArrayList<Double> att2 = man.GetAttribute(j);
		double somme = 0.0;
		double tmp;
		double moy1 = GetMean(i);
		double moy2 = GetMean(j);
		for (int k = 0; k < att1.size(); k++) {
			tmp = (att1.get(k) - moy1) * (att2.get(k) - moy2);
			somme = somme + (tmp / (double) att1.size());
		}
		return Math.round(somme * 1e3) / 1e3;
	}

	// calcul covariance*******************************************
	public ArrayList<String> GetCorrelation(int i, int j) {
		ArrayList<String> res = new ArrayList<>();
		ManipData man = new ManipData(this.dataset);
		ArrayList<Double> att1 = man.GetAttribute(i);
		ArrayList<Double> att2 = man.GetAttribute(j);
		double somme = 0.0;
		for (int k = 0; k < att1.size(); k++) {
			somme = somme + (att1.get(k)) * (att2.get(k));
		}
		double tmp = att1.size() * GetMean(i) * GetMean(j);
		double correlation = (somme - tmp) / (double) ((att1.size() - 1) * GetEcartType(i) * GetEcartType(j));
		res.add("" + (Math.round(correlation * 1e3) / 1e3));
		if (correlation < 0 && correlation > -1) {
			res.add("correlation negative");
		}
		if (correlation > 0 && correlation < 1) {
			if (correlation <= 0.4) {
				res.add("correlation faible");
			}
			if (correlation > 0.4 && correlation < 0.8) {
				res.add("correlation moyenne");
			}
			if (correlation >= 0.8 && correlation <= 1) {
				res.add("correlation forte");
			}
		} 
		if(correlation>1 && correlation<-1){
			res.add("pas de correlation");
		}
		return res;
	}

}
