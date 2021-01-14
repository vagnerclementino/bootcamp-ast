package br.com.igti.ast;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.igti.ast.a.A;
import br.com.igti.ast.b.B;
import br.com.igti.ast.c.C;
import br.com.igti.ast.c.C1;
import br.com.igti.ast.d.Base;
import br.com.igti.ast.d.D1;
import br.com.igti.ast.d.D2;
import br.com.igti.ast.d.P;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
class AppTest {
    /**
     * Rigorous Test.
     */
    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;
    private static final PrintStream originalErr = System.err;

    @BeforeEach
    public static void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public static void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    void testPadraoA() {
        A a = new A.A1().setAtributo1("atributo1").setAtributo2("atributo2").setAtributo3("atributo3")
                .setAtributo4(2020).f();
        assertEquals("atributo1. atributo2,atributo3,2020", a.toString());
    }

    @Test
    void testPadraoB() {
        B b1 = B.getI();
        B b2 = B.getI();
        assertEquals(b1.hashCode(), b2.hashCode());
    }

    @Test
    void testPadraoC() {
        C c = new C();
        c.addO(new C1());
        c.setAtributo(100.0);
        assertEquals("Atributo: 100.0\n", outContent.toString());
    }

    @Test
    void testPadraoD() {
        List<Base> list = new ArrayList<>();
        list.add(new D1("D1.1"));
        list.add(new D2("D2.1"));
        list.add(new D1("D1.2"));
        list.add(new D2("D2.2"));

        P v = new P();
        for (Base base : list) {
            base.a(v);
        }
        assertEquals("Tipo D1: D1.1\nTipo D2: D2.1\nTipo D1: D1.2\nTipo D2: D2.2\n", outContent.toString());
    }
}
