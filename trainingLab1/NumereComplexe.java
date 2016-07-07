package training1;

public class NumereComplexe {

	private float re, im;

	public NumereComplexe(float re, float im) {
		this.re = re;
		this.im = im;
	}
	public float getRe() {
		return re;
	}

	public void setRe(float re) {
		this.re = re;
	}

	public float getIm() {
		return im;
	}

	public void setIm(float im) {
		this.im = im;
	}

	public static void main(String[] args) {
		NumereComplexe nr1 = new NumereComplexe(5, 6);
		NumereComplexe nr2 = new NumereComplexe(4, 2);
		NumereComplexe res = Operatii.adunare(nr1, nr2);
		System.out.println(res.getRe() + " " + res.getIm());
	}
	
	
}
