package lesson6;

public class Cat extends GroundAnimal {

    public Cat() {
        super("Cat", 200, 2);
    }

    public Cat(String name) {
        super(name, 200, 2);
    }

    public Cat(String name, int runDistance, double jumpHight) {
        super(name, runDistance, jumpHight);
    }

    @Override
    public String toString() {
        return String.format("A %s Cat can run %d meters, and jump %.1f meters high", getName(), getRunDistance(), getJumpHight());
    }
}
