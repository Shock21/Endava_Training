package trainingLab1;

import java.util.Scanner;

public class Carte {
	private String titlu;
	private String autor;
	private String editura;
	private Integer numarPagini;
	
	public Carte() {
		Scanner s = new Scanner(System.in);
		this.titlu = s.nextLine();
		this.autor = s.nextLine();
		this.editura = s.nextLine();
		this.numarPagini = Integer.parseInt(s.nextLine());		
		s.close();
	}
	
	public Carte(String titlu, String autor, String editura, Integer numarPagini) {
		this.titlu = titlu;
		this.autor = autor;
		this.editura = editura;
		this.numarPagini = numarPagini;	
	}
	
	public String getTitlu() {
		return titlu;
	}
	public void setTitlu(String titlu) {
		this.titlu = titlu;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getEditura() {
		return editura;
	}
	public void setEditura(String editura) {
		this.editura = editura;
	}
	public Integer getNumarPagini() {
		return numarPagini;
	}
	public void setNumarPagini(Integer numarPagini) {
		this.numarPagini = numarPagini;
	}
	
	@Override
	public String toString() {		
		return ("Title: " + this.titlu.toUpperCase() + " Author:" + this.autor + " Editor" + this.editura.toLowerCase() + " PageNr" + this.numarPagini);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj.getClass() != Carte.class)
			return false;
		if(this.autor != ((Carte)obj).autor)
			return false;
		if(this.editura != ((Carte)obj).editura)
			return false;
		if(this.titlu != ((Carte)obj).titlu)
			return false;
		
		return true;
	}
	
	public static void main(String[] args) {
		Carte carte1 = new Carte("A", "B", "C", 410);
		Carte carte2 = new Carte("A", "B", "C", 410);
		
		System.out.println(Verificari.isCopy(carte1, carte2));
		
		System.out.println(carte1);
	}
	
}
