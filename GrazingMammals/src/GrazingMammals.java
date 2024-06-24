import javax.swing.text.GapContent;

public class GrazingMammals {


    interface RuminantTester {
        void testIfRuminant();

        void chewsCud();

        void testHasMultipleStomachs();
    }


    abstract class Mammal {
        public void nursesYoung() {
            String className = this.getClass().getSimpleName();
            System.out.println("I am a " + className + ". I am nursing.");
        }
    }

    abstract class Ruminant extends GrazingMammal {


    }


    abstract class GrazingMammal extends Mammal implements RuminantTester {
        @Override
        public void testHasMultipleStomachs() {
            String className = this.getClass().getSimpleName();
            if (this instanceof Ruminant)
                System.out.println("I am a " + className + ". I have multiple stomachs.");
            else
                System.out.println("I am a " + className + ". I do not have multiple stomachs.");
        }

        @Override
        public void testIfRuminant() {
            String className = this.getClass().getSimpleName();
            if (this instanceof Ruminant)
                System.out.println("I am a " + className + ". I am a Ruminant.");
            else
                System.out.println("I am a " + className + ". I am not a Ruminant.");
        }

        public void grazes() {
            String className = this.getClass().getSimpleName();
            System.out.println("Im am a " + className + " I am grazing");
        }

        @Override
        public void chewsCud() {
            String className = this.getClass().getSimpleName();
            if (this instanceof Ruminant)
                System.out.println("I am a " + className + ". I am a chewing the Cud.");
            else
                System.out.println("I am a " + className + ". I am not chewing the Cud.");
        }


    }

    class Cow extends Ruminant {

    }

    class Goat extends Ruminant {

    }

    class Giraffe extends Ruminant {

    }

    class Sheep extends Ruminant {

    }

    class Donkey extends GrazingMammal {

    }

    class Horse extends GrazingMammal {

    }

    public void testGrazingMammals() {
        Cow cow = new Cow();
        cow.nursesYoung();
        cow.grazes();
        cow.testIfRuminant();
        cow.testHasMultipleStomachs();
        cow.chewsCud();
        System.out.println();

        Goat goat = new Goat();
        goat.nursesYoung();
        goat.grazes();
        goat.testIfRuminant();
        goat.testHasMultipleStomachs();
        goat.chewsCud();
        System.out.println();


        Giraffe giraffe = new Giraffe();
        giraffe.nursesYoung();
        giraffe.grazes();
        giraffe.testIfRuminant();
        giraffe.testHasMultipleStomachs();
        giraffe.chewsCud();
        System.out.println();


        Sheep sheep = new Sheep();
        sheep.nursesYoung();
        sheep.grazes();
        sheep.testIfRuminant();
        sheep.testHasMultipleStomachs();
        sheep.chewsCud();
        System.out.println();



        Donkey donkey = new Donkey();
        donkey.nursesYoung();
        donkey.grazes();
        donkey.testIfRuminant();
        donkey.testHasMultipleStomachs();
        System.out.println();


        Horse horse = new Horse();
        horse.nursesYoung();
        horse.grazes();
        horse.testIfRuminant();
        horse.testHasMultipleStomachs();
        System.out.println();



    }

    public static void main(String[] args) {
        GrazingMammals gm = new GrazingMammals();
        gm.testGrazingMammals();


    }
}
