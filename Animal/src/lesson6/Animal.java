package lesson6;

public abstract class Animal {
    private static int animalCounter;

    private String name;
    private int runDistance;
    private double jumpHight;

    public Animal(String name, int runDistance, double jumpHight) {
        setName(name);
        setRunDistance(runDistance);
        setJumpHight(jumpHight);
        animalCounter++;
    }

    public String getName() {
        return name;
    }

    public int getRunDistance() {
        return runDistance;
    }

    public double getJumpHight() {
        return jumpHight;
    }

    public static int getAnimalCounter() {
        return animalCounter;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void setRunDistance(int runDistance) {
        if (runDistance >= 0) {
            this.runDistance = runDistance;
        }
        else {
            System.out.println("Incorrect distance");
        }
    }

    private void setJumpHight(double jumpHight) {
        if (jumpHight >= 0) {
            this.jumpHight = jumpHight;
        }
        else {
            System.out.println("Incorrect hight");
        }
    }

    public boolean run(int distance) {
        if (distance <= this.runDistance) {
            System.out.println(name + " run " + distance + " meters");
            return true;
        }
        System.out.println(name + " can't run " + distance + " meters");
        return false;
    }

    public boolean jump(double hight) {
        if (hight <= this.jumpHight) {
            System.out.println(name + " jump " + hight + " meters");
            return true;
        }
        System.out.println(name + " can't jump " + hight + " meters");
        return false;
    }
}
