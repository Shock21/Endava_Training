package training1;

public class Operatii {
	
	public static NumereComplexe adunare(NumereComplexe nr1, NumereComplexe nr2) {
		return new NumereComplexe(nr1.getRe() + nr2.getRe(), nr1.getIm() + nr2.getIm());
	}
	
	public static NumereComplexe scadere(NumereComplexe nr1, NumereComplexe nr2) {
		return new NumereComplexe(nr1.getRe() - nr2.getRe(), nr1.getIm() - nr2.getIm());
	}
	
}
