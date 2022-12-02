package org.example.dao;

import java.util.List;

public interface EntityDAO<E> {

    List<E> getAll();

    E getById(Long id);

    E save(E entity);

    void deleteById(Long id);
}
