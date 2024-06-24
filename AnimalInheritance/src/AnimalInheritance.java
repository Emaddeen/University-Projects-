class Animal {
    public Animal() {
        System.out.println("A new animal has been created!");
    }

    public void sleep() {
        System.out.println("An animal sleeps...");
    }

    public void eat() {
        System.out.println("An animal eats...");
    }
}

class Cat extends Animal {
    public Cat() {
        super();
        System.out.println("A new cat has been created!");
    }

    public void sleep() {
        System.out.println("A cat sleeps...");
    }

    public void purr() {
        System.out.println("A cat purrs...");
    }

    public void eat() {
        System.out.println("An cat eats...");
    }

    public static void main(String args[]) {
        Cat demo = new Cat();
        demo.eat();
        demo.sleep();
        demo.purr();
    }
}

class Dog extends Animal {
    public Dog() {
        super();
        System.out.println("A new Dog has been created!");
    }

    public void run() {
        System.out.println("A dog run...");
    }

    public void barks() {
        System.out.println("A dog barks...");
    }

    public void chews() {
        System.out.println("An dog chews...");
    }

    public static void main(String args[]) {
        Dog demo = new Dog();
        demo.run();
        demo.barks();
        demo.chews();
    }
}