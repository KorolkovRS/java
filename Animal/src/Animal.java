public abstract class Animal {
    private static int animalCounter;

    private String name = "No name";
    private int runDistance;
    private int swimDistance;
    private double jumpHight;

    public Animal(String name, int runDistance, int swimDistance, double jumpHight) {
        setName(name);
        setRunDistance(runDistance);
        setSwimDistance(swimDistance);
        setJumpHight(jumpHight);
        animalCounter++;
    }

    public String getName() {
        return name;
    }

    public int getRunDistance() {
        return runDistance;
    }

    public int getSwimDistance() {
        return swimDistance;
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

    private void setSwimDistance(int swimDistance) {
        if (swimDistance >= 0) {
            this.swimDistance = swimDistance;
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
            System.out.println(this + " run " + distance + " meters");
            return true;
        }
        System.out.println(this + " can't run " + distance + " meters");
        return false;
    }

    public boolean swim(int distance) {
        if (distance <= this.swimDistance) {
            System.out.println(this + " swim " + distance + " meters");
            return true;
        }
        System.out.println(this + " can't swim " + distance + " meters");
        return false;
    }

    public boolean jump(double hight) {
        if (hight <= this.jumpHight) {
            System.out.println(this + " jump " + hight + " meters");
            return true;
        }
        System.out.println(this + " can't jump " + hight + " meters");
        return false;
    }

    @Override
    public String toString() {
        return name;
    }
}
