package me.clementino.solid.interfacesegregation.crud;

public class SaveAuditing <T> implements ISave<T>{

    private final ISave<T> decoratedSave;

    public SaveAuditing(ISave<T> decoratedSave) {
        this.decoratedSave = decoratedSave;
    }

    @Override
    public void save(T entity) {
        // TODO: Here we must implement a save method with auditing features
        decoratedSave.save(entity);
    }
}
