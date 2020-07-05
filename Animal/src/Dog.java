public class Dog extends Animal {
    public Dog(String name, int runDistance, int swimDistance, double jumpHight) {
        super("Dog " + name, runDistance, swimDistance, jumpHight);
    }

    public Dog() {
        super("Dog", 500, 10, 0.5);
    }

    public Dog(String name) {
        super("Dog " + name, 500, 10, 0.5);
    }
}
