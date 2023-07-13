package ru.job4j.ood.isp.foul;

public interface DataStore {

    void save(DataItem dataItem);

    DataItem load(String id);

    void delete(String id);

    void update(String id, DataItem dataItem);
}
