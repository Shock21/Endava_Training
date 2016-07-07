package trainingLab1;

public class Verificari {
	
	public static boolean isCopy(Carte carte1, Carte carte2) {
		return carte1.equals(carte2);
	}
	
	public static Carte whichIsBigger(Carte carte1, Carte carte2) {		
		return (carte1.getNumarPagini() < carte2.getNumarPagini()) ? carte2 : carte1;
	}
}
