package lesson6;

public class Dog extends SwimmingGroundAnimal {

    public Dog() {
        super("Dog", 500, 10, 0.5);
    }

    public Dog(String name) {
        super(name, 500, 10, 0.5);
    }

    public Dog(String name, int runDistance, int swimDistance, double jumpHight) {
        super(name, runDistance, swimDistance, jumpHight);
    }

    @Override
    public String toString() {
        return String.format("A %s dog can run %d meters, swim %d meters, and jump %.1f meters high", getName(), getRunDistance(), getSwimDistance(), getJumpHight());
    }
}
