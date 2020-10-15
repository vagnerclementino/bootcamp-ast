package br.com.igti.ast;

import java.util.ArrayList;
import java.util.List;

import br.com.igti.ast.a.A;
import br.com.igti.ast.b.B;
import br.com.igti.ast.c.C;
import br.com.igti.ast.c.C1;
import br.com.igti.ast.d.Base;
import br.com.igti.ast.d.D1;
import br.com.igti.ast.d.D2;
import br.com.igti.ast.d.P;

/**
 * Bootcampo Arquitetura de Software
 */
public final class App {
    private App() {
    }

    public static void main(String[] args) {
        // Código para o padrão A
        runPadraoA();

        // Código para o padrão A
        runPadraoB();

        // Código para o padrão A
        runPadraoC();

        // Código para o padrão A
        runPadraoD();
    }

    private static void runPadraoD() {
        List<Base> list = new ArrayList<>();
        list.add(new D1("D1.1"));
        list.add(new D2("D2.1"));
        list.add(new D1("D1.2"));
        list.add(new D2("D2.2"));

        P v = new P();
        for (Base base : list) {
            base.a(v);
        }
    }

    private static void runPadraoC() {
        C c = new C();
        c.addO(new C1());
        c.setAtributo(100.0);
    }

    private static void runPadraoB() {
        B b1 = B.getI();
        System.out.print("B1: ID=" + b1.hashCode());
        b1.m("b1");
        B b2 = B.getI();
        System.out.print("B2: ID=" + b2.hashCode());
        b2.m("b1");
    }

    private static void runPadraoA() {
        A a = new A.A1().setAtributo1("atributo1").setAtributo2("atributo2").setAtributo3("atributo3")
                .setAtributo4(2020).f();
        System.out.println("A: " + a.toString());
    }
}
