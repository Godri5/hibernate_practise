package org.example.service;

import java.util.List;

public interface EntityService<E> {

    List<E> getAll();

    E save(E entity);

    E getById(Long id);

    void deleteById(Long id);
}
