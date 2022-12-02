package org.example.service.impl;

import org.example.dao.EntityDAO;
import org.example.model.Position;
import org.example.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PositionServiceImpl implements EntityService<Position> {

    @Autowired
    private EntityDAO<Position> positionDAO;

    @Override
    @Transactional
    public List<Position> getAll() {
        return positionDAO.getAll();
    }

    @Override
    @Transactional
    public Position save(Position entity) {
        return positionDAO.save(entity);
    }

    @Override
    @Transactional
    public Position getById(Long id) {
        return positionDAO.getById(id);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        positionDAO.deleteById(id);
    }
}
