package br.com.igti.ast.c;

public class C1 implements O {
    public void u(S s) {
        double a = ((C) s).getAtributo();
        System.out.println("Atributo: " + a);
    }
}
