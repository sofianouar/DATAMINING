package part1;

public class Individu {
	private Integer Number;
	private Double A1;
	private Double A2;
	private Double A3;
	private Double A4;
	private Double A5;
	private Double A6;
	private Double A7;
	private Double classe;
	
	
	public Individu(Integer number, Double a1, Double a2, Double a3, Double a4, Double a5, Double a6, Double a7, Double classe) {
		super();
		Number = number;
		A1 = a1;
		A2 = a2;
		A3 = a3;
		A4 = a4;
		A5 = a5;
		A6 = a6;
		A7 = a7;
		this.classe = classe;
	}
	
	public Integer getNumber() {
		return Number;
	}

	public void setNumber(Integer number) {
		Number = number;
	}

	public Double getA1() {
		return A1;
	}

	public void setA1(Double a1) {
		A1 = a1;
	}

	public Double getA2() {
		return A2;
	}

	public void setA2(Double a2) {
		A2 = a2;
	}

	public Double getA3() {
		return A3;
	}

	public void setA3(Double a3) {
		A3 = a3;
	}

	public Double getA4() {
		return A4;
	}

	public void setA4(Double a4) {
		A4 = a4;
	}

	public Double getA5() {
		return A5;
	}

	public void setA5(Double a5) {
		A5 = a5;
	}

	public Double getA6() {
		return A6;
	}

	public void setA6(Double a6) {
		A6 = a6;
	}

	public Double getA7() {
		return A7;
	}

	public void setA7(Double a7) {
		A7 = a7;
	}

	public Double getClasse() {
		return classe;
	}

	public void setClasse(Double classe) {
		this.classe = classe;
	}

	public void display() {
		System.out.println(
				Number + " ," +
				this.getA1() + ", " +
				this.getA2() + ", " +
				this.getA3() + ", " +
				this.getA4() + ", " +
				this.getA5() + ", " +
				this.getA6() + ", " +
				this.getA7() + ", " +
				this.getClasse()
				);
	}
		
}
