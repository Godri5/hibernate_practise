package org.example.service;

import org.example.model.Position;

import java.util.List;

public interface PositionService {

    public List<Position> getAllPositions();

    public Position getPositionById(Long id);

    public void savePosition(Position position);

    public void deletePosition(Long id);
}
