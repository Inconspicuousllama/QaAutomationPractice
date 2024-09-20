package streamApi;

public class Animal {
    public final String animalName;
    public final Integer age;
    public final Classification classification;

    public Animal(String animalName, Integer age, Classification classification) {
        this.animalName = animalName;
        this.age = age;
        this.classification = classification;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "animalName='" + animalName + '\'' +
                ", age=" + age +
                ", classification=" + classification +
                '}';
    }

    public String getAnimalName() {
        return animalName;
    }

    public Integer getAge() {
        return age;
    }

    public Classification getClassification() {
        return classification;
    }
}
