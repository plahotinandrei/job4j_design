package ru.job4j.ood.isp.foul;

/* Нарушает принцип ISP, так как хранилище только для чтения не поддерживает операции изменения */
public class ReadOnlyDataStore implements DataStore {

    @Override
    public void save(DataItem dataItem) {
        throw new UnsupportedOperationException("Save operation is not supported in read-only data store.");
    }

    @Override
    public DataItem load(String id) {
        System.out.println("Loading data...");
        return new DataItem();
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Delete operation is not supported in read-only data store.");
    }

    @Override
    public void update(String id, DataItem dataItem) {
        throw new UnsupportedOperationException("Update operation is not supported in read-only data store.");
    }
}
