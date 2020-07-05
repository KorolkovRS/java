public class Cat extends Animal {
    public Cat(String name, int runDistance, double jumpHight) {
        super("Cat " + name, runDistance, 0, jumpHight);
    }

    public Cat() {
        super("Cat", 500, 0, 0.5);
    }

    public Cat(String name) {
        super("Cat " + name, 500, 0, 0.5);
    }

    @Override
    public boolean swim(int distance) {
        System.out.println("Cats not swim");
        return false;
    }
}
