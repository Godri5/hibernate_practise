package org.example.controller;

import io.swagger.annotations.Api;
import org.example.model.Position;
import org.example.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "position controller")
public class PositionController {

    @Autowired
    private EntityService<Position> positionService;

    @RequestMapping(value = "/positions/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<Position>> getAllPositions() {
        List<Position> positions = positionService.getAll();
        return new ResponseEntity<>(positions, HttpStatus.OK);
    }

    @RequestMapping(value = "/positions/{id}", method = RequestMethod.GET)
    public ResponseEntity<Position> getPositionById(@PathVariable Long id) {
        Position position = positionService.getById(id);
        return new ResponseEntity<>(position, HttpStatus.OK);
    }


    @RequestMapping(value = "/positions", method = RequestMethod.POST)
    public ResponseEntity<Position> addNewPosition(@RequestBody Position position) {
        Position added = positionService.save(position);
        return new ResponseEntity<>(added, HttpStatus.CREATED);
    }


    @RequestMapping(value = "/positions/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Position> deletePosition(@PathVariable Long id) {
        positionService.deleteById(id);
        return new ResponseEntity<>(positionService.getById(id), HttpStatus.NO_CONTENT);
    }
}
