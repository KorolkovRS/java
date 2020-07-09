package lesson7;

import lesson6.Cat;

/**
 * Домашний кот наследуется от кота в пакете lesson6 и реализует интерфейс Eatable, дающий ему возможность есть.
 * Ради интереса реализуется интерфейс Runnable.
 * Домашний кот обладает полями:
 *  private Bowl bowl - миска, из которой он может есть (может ее и не иметь);
 *  private boolean hungry - true - кот голоден, false - кот сыт;
 *  private int appetite - уровень сытости кота от 0 до 100, при значении 0 - кот голоден (hungry = true). при остальных значениях кот сыт (hungry = false);
 *  public boolean isDead - false - кот жив, true - мертв. Кот умерает от голода, если его не покормить 5 раз подряд.
 */

public class DomesticCat extends Cat implements Eatable, Runnable {
    private Bowl bowl;
    private boolean hungry;
    private int appetite;
    public boolean isDead;

    /**
     *Конструктор домашнего кота
     * @param name имя кота
     * @param appetite уровень сытости при создании домашнего кота.
     */

    public DomesticCat(String name, int appetite) {
        super(name);
        setAppetite(appetite);
    }

    /**
     * Сеттер уровня сытости. Проверяет кооректность уровня сытости прои создании кота
     * @param appetite уровень сытости домашнего кота.
     */
    private void setAppetite(int appetite) {
        if (appetite > 0) {
            this.appetite = appetite;
            hungry = false;
        }
        else if (appetite > 100) {
            this.appetite = 100;
            hungry = true;
        }
        else {
            appetite = 0;
            hungry = false;
        }
    }

    /**
     * Дать коту миску, чтобы он смог из нее есть.
     * @param bowl миска для домашнего кота.
     */
    public void getBowl(Bowl bowl) {
        this.bowl = bowl;
    }

    public void giveBowl() {
        bowl = null;
    }

    /**
     * Контракт интерфейса Eatable.
     * Домашний кот ест из своей миски. У нескольких котов может быть одна и таже миска.
     * Кот съедает столько еды, сколько может взять, до полной сытости. Если в миске недостаточно еды, до он съедает все, что есть.
     */
    @Override
    public void Eat() {
        if (hungry && !bowl.isEmpty()) {
            int temp = bowl.takeMeal(appetite);
            appetite -= temp;
            System.out.printf("Cat %s eat %d meal. %d servings left in the bowl\n", getName(), temp, bowl.getMeal());
        }
        hungry = false;
    }

    /**
     * Контракт интерфейса Eatable.
     * Домашний кот прости еду.
     */
    @Override
    public void askForFood() {
        System.out.printf("Cat %s say: \"Meow\"\n", getName());
    }

    /**
     * Контракт Runnable.
     * Если кот голоден и у него есть миска, он ест из нее, после чего чем-то занимается [50 * (100 - appetite)] миллисекунд.
     * Если у кота нет миски, или в ней отсутствует еда, он просит еду каждую секунду. Если кота не кормить 5 секунд, он умирает (isDead = true).
     */
    @Override
    public void run() {
        Thread current = Thread.currentThread();
        int i = 0;

        while (!current.isInterrupted()) {
            if (hungry) {
                if (bowl != null && !bowl.isEmpty()) {
                    Eat();
                    i = 0;
                }
                else {
                    askForFood();
                    i++;
                    if (i >= 5) {
                        isDead = true;
                        current.interrupt();
                    }
                }
            }
            try {
                if (hungry) {
                    Thread.sleep(1000);
                }
                else {
                    Thread.sleep(50 * (100 - appetite));
                    appetite = 100;
                    hungry = true;
                }
            } catch (InterruptedException e) {
                break;
            }
        }
        if (isDead) {
            System.out.printf("Cat %s is died :(\n", getName());
        }
    }
}
