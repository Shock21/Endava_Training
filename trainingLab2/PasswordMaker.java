package trainingLab2;

public class PasswordMaker {
	
	private final Integer MAGIC_NUMBER = 25;
	private final String MAGIC_STRING;
	private RandomStringGenerator generator;
	
	private String firstName;
	private String lastName;
	private Integer age;
	
	public PasswordMaker(String firstName, String lastName, Integer age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		generator = new RandomStringGenerator(20, "abcdefghiklmnop1234567890");
		MAGIC_STRING = generator.next();
	}
	
	public String getPassword() {
		Integer size = age % 3;
		Integer start = firstName.length() - size;		
		String first = firstName.substring(start);
		
		generator.setSize(10);
		generator.setAlphabet(MAGIC_STRING);
		
		generator.setAlphabet(generator.next());
		generator.setSize(MAGIC_NUMBER);
		
		String second = generator.next();
		
		String last = String.valueOf(age + lastName.length());
		
		System.out.println(first + " " + second + " " + last);
		
		return first.concat(second).concat(last);
	}
	
	public static void main(String[] args) {
		PasswordMaker newPasswordMaker = new PasswordMaker("Tiberiu", "Vasile", 22);
		System.out.println(newPasswordMaker.getPassword());
	}
}
