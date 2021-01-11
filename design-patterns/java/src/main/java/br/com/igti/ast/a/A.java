package br.com.igti.ast.a;

public class A {
    private String atributo1;
    private String atributo2;
    private String atributo3;
    private int atributo4;

    private A(String atributo1, String atributo2, String atributo3, int atributo4) {
        this.atributo1 = atributo1;
        this.atributo2 = atributo2;
        this.atributo3 = atributo3;
        this.atributo4 = atributo4;
    }

    public String toString() {
        return atributo1 + ". " + atributo2 + "," + atributo3 + "," + atributo4;
    }

    public static class A1 {
        private String atributo1;
        private String atributo2;
        private String atributo3;
        private int atributo4;

        public A1 setAtributo1(String nome) {
            this.atributo1 = nome;
            return this;
        }

        public A1 setAtributo2(String autores) {
            this.atributo2 = autores;
            return this;
        }

        public A1 setAtributo3(String editora) {
            this.atributo3 = editora;
            return this;
        }

        public A1 setAtributo4(int atributo4) {
            this.atributo4 = atributo4;
            return this;
        }

        public A f() {
            return new A(atributo1, atributo2, atributo3, atributo4);
        }
    }
}