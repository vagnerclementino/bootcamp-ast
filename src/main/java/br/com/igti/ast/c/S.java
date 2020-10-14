package br.com.igti.ast.c;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class S {
    private List<O> os = new ArrayList<>();

    public void addO(O o) {
        os.add(o);
    }

    public void removeO(O o) {
        os.remove(o);
    }

    public void notifyObservers() {
        Iterator<O> it = os.iterator();
        while (it.hasNext()) {
            O o = it.next();
            o.u(this);
        }
    }

}
