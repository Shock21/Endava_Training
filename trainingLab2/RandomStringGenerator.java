package trainingLab2;

import java.util.Random;

public class RandomStringGenerator {
	
	private Integer size;
	private String alphabet;
	private Random generator;
	
	public RandomStringGenerator(Integer size, String alphabet) {
		this.size = size;
		this.alphabet = alphabet;
		generator = new Random();
	}
	
	public String next() {
		char[] characters = new char[this.size];
		
		for(int i = 0; i < this.size; i++) {
			int pos = generator.nextInt(alphabet.length());
			characters[i] = alphabet.charAt(pos);
		}
		
		return new String(characters);
	}
	
	
	
	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public String getAlphabet() {
		return alphabet;
	}

	public void setAlphabet(String alphabet) {
		this.alphabet = alphabet;
	}

	public static void main(String[] args) {
		RandomStringGenerator randomString = new RandomStringGenerator(5, "abcdef");
		System.out.println(randomString.next() + " " + randomString.next());
	}
}
