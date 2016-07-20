package training.collections;

import java.util.List;
import java.lang.Double;
import java.util.Optional;

public class Penguin implements Comparable {
	
	private String name;
	private PenguinRace race;
	private double age;
	private List<Penguin> matingPartners;
	
	public Penguin(String name, PenguinRace race, double age) {
		this.name = name;
		this.race = race;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public PenguinRace getRace() {
		return race;
	}

	public double getAge() {
		return age;
	}

	public List<Penguin> getMatingPartners() {
		return matingPartners;
	}

	public void setMatingPartners(List<Penguin> matingPartners) {
		this.matingPartners = matingPartners;
	}

    public Double getMatesAverageAge() {
        return matingPartners.stream().mapToDouble(Penguin::getAge).average().getAsDouble();
    }

    public Integer getNumberOfMates() {
        return matingPartners.size();
    }

	@Override
	public String toString() {
		return "Penguin{" +
				"name='" + name + '\'' +
				", race=" + race +
				", age=" + age +
				", numberOfPartners=" + getNumberOfMates()+
                ", averageAgeOfMates=" + getMatesAverageAge()+
				'}';
	}

	@Override
	public int compareTo(Object obj) {
		int c = race.compareTo(((Penguin)obj).race);

		if (c == 0) {
			c = Double.compare(age, ((Penguin)obj).age);
		}

		return c;
	}
}
