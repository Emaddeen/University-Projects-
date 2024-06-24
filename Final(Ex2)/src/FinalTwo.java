import java.security.PublicKey;

public class FinalTwo {
    public static void main(String[] args) {

        class Parent {
            private int d;
            private int e;

            public Parent() {
                d = 0;
                e = 0;
            }

            public Parent(int a, int b) {
                d = a;
                e = b;
            }

            public int getD() {
                return d;
            }

            public void setD(int a) {
                d = a;
            }

            public int getE() {
                return e;
            }

            public void setE(int b) {
                e = b;
            }
        }

         class Child extends Parent {
            private int f;

            public Child() {
                super();
                f = 0;
            }

            public Child(int a, int b, int c) {
                super(a,b);
                f = c;
            }

            public int getF() {
                return f;
            }

            public void setF(int c) {
                f = c;
            }
        }

         class test {
            public void main(String[] args) {
                Child c = new Child(1, 2, 3);
                System.out.println(c.getD());
                System.out.println(c.getE());
                System.out.println(c.getF());
            }
        }
        System.out.println("that's All Folks");
    }
}