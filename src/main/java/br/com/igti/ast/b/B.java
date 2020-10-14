package br.com.igti.ast.b;

public class B {
    private B() {
    }

    private static B i;

    public static B getI() {
        if (i == null) {
            i = new B();
        }
        return i;
    }

    public void m(String msg) {
        System.out.println(msg);
    }

}
