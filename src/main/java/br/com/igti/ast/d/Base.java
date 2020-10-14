package br.com.igti.ast.d;

public abstract class Base {
    private String atributoBase;

    public Base(String atributo) {
        this.atributoBase = atributo;
    }

    public String getAtributo() {
        return atributoBase;
    }

    public abstract void a(V v);
}
