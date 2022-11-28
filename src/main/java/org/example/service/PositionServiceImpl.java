package org.example.service;

import org.example.dao.PositionDAO;
import org.example.model.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService{

    @Autowired
    private PositionDAO positionDAO;

    @Override
    public List<Position> getAllPositions() {
        return positionDAO.getAllPositions();
    }

    @Override
    public Position getPositionById(Long id) {
        return positionDAO.getPositionById(id);
    }

    @Override
    public void savePosition(Position position) {
        positionDAO.savePosition(position);
    }

    @Override
    public void deletePosition(Long id) {
        positionDAO.deletePosition(id);
    }
}
