package lesson6;

public class AnimalTest {
    public static void main(String[] args) {
        Animal[] animals = new Animal[6];
        animals[0] = new Dog("Shepherd", 1000, 30, 1);
        animals[1] = (new Dog("Labrador", 400, 50, 0.6));
        animals[2] = (new Dog("Spitz", 150, 10, 0.2));
        animals[3] = (new Dog());
        animals[4] = (new Cat());
        animals[5] = (new Cat("Maine coon", 300, 3));


        System.out.printf("Total animals: %d\n\n", Animal.getAnimalCounter());

        for (int i = 0; i < animals.length; i++) {
            System.out.println(animals[i].getName());
            animals[i].run(200);

            if (animals[i] instanceof SwimmingGroundAnimal) {
                ((SwimmingGroundAnimal) animals[i]).swim(20);
            }

            animals[i].jump(0.6);
            System.out.println("****************");
        }
    }
}
