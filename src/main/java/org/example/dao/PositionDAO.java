package org.example.dao;

import org.example.model.Employee;
import org.example.model.Position;

import java.util.List;

public interface PositionDAO {

    public List<Position> getAllPositions();

    public Position getPositionById(Long id);

    public void savePosition(Position position);

    public void deletePosition(Long id);
}
