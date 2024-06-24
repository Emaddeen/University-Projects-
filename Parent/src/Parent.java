public static void main(String[]args){

class Parent {
    private int x;
    private int y;

    public Parent() {
        x = 0;
        y = 0;
    }

    public Parent(int a, int b) {
        x = a;
        y = b;
    }

    public int getX() {
        return x;
    }

    public void setX(int a) {
        x = a;
    }

    public int getY() {
        return y;
    }

    public void setY(int b) {
        y = b;
    }
}

public class Child extends Parent {
    private int z;

    public Child() {
        super();
        z = 0;
    }

    public Child(int a, int b, int c) {
        super(a, b);
        z = c;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int c) {
        z = c;
    }
}

public class test {
    public void main(String[] args) {
        Child c = new Child(1, 2, 3);
        System.out.println(c.getX());
        System.out.println(c.getY());
        System.out.println(c.getZ());
    }
}
}