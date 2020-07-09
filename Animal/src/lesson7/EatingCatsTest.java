package lesson7;

/**
 * 1. Расширить задачу про котов и тарелки с едой
 * 2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды (например, в миске 10 еды, а кот пытается покушать 15-20)
 * 3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту удалось покушать (хватило еды), сытость = true
 * 4. Считаем, что если коту мало еды в тарелке, то он ее просто не трогает, то есть не может быть наполовину сыт (это сделано для упрощения логики программы)
 * 5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и потом вывести информацию о сытости котов в консоль
 * 6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку
 */

public class EatingCatsTest {
    public static void main(String[] args) throws InterruptedException {
        Human human = new Human();
        Thread threadHuman = new Thread(human);
        Bowl bowl = new Bowl();

        DomesticCat[] cats = new DomesticCat[5];

        cats[0] = new DomesticCat("cat1", 5);
        cats[1] = new DomesticCat("cat2", 50);
        cats[2] = new DomesticCat("cat3", 100);
        cats[3] = new DomesticCat("cat4", 90);
        cats[4] = new DomesticCat("cat5", 0);

        for (int i = 0; i < cats.length; i++) {
            cats[i].getBowl(bowl);
        }

        human.takeBowl(bowl);
        bowl.putMeal(300);

        Thread[] threads = new Thread[5];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(cats[i]);
            threads[i].start();
        }

        threadHuman.start();
        Thread.sleep(10000);

        for (int i = 0; i < threads.length; i++) {
                threads[i].interrupt();
        }

        threadHuman.interrupt();
        System.out.println("**************************");

        for (int i = 0; i < cats.length; i++) {
            if (!cats[i].isDead) {
                System.out.printf("Cat %s is alive\n", cats[i].getName());
            }
            else {
                System.out.printf("Cat %s is died\n",cats[i].getName());
            }
        }
    }
}
