package br.com.igti.ast.c;

public class C extends S {
    private double atributo;

    public double getAtributo() {
        return atributo;
    }

    public void setAtributo(double atributo) {
        this.atributo = atributo;
        notifyObservers();
    }
}
