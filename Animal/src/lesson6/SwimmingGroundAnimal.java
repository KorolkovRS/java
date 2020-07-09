package lesson6;

public abstract class SwimmingGroundAnimal extends GroundAnimal {
    private int swimDistance;

    public SwimmingGroundAnimal(String name, int runDistance, int swimDistance, double jumpHight) {
        super(name, runDistance, jumpHight);
        setSwimDistance(swimDistance);
    }

    public int getSwimDistance() {
        return swimDistance;
    }

    private void setSwimDistance(int swimDistance) {
        if (swimDistance >= 0) {
            this.swimDistance = swimDistance;
        }
        else {
            System.out.println("Incorrect distance");
        }
    }

    public boolean swim(int distance) {
        if (distance <= this.swimDistance) {
            System.out.println(getName() + " swim " + distance + " meters");
            return true;
        }
        System.out.println(getName() + " can't swim " + distance + " meters");
        return false;
    }
}
