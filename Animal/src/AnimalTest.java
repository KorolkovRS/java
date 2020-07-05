import java.util.ArrayList;

public class AnimalTest {
    public static void main(String[] args) {
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(new Dog("Shepherd",1000,30,1));
        animals.add(new Dog("Labrador",400,50,0.6));
        animals.add(new Dog("Spitz",150,10,0.2));
        animals.add(new Dog());
        animals.add(new Cat());
        animals.add(new Cat("Maine coon", 300, 3));

        System.out.printf("Total animals: %d\n\n", Animal.getAnimalCounter());

        for (Animal animal : animals) {
            System.out.println(animal);
            animal.run(200);
            animal.swim(20);
            animal.jump(0.6);
            System.out.println("****************");
        }
    }
}
