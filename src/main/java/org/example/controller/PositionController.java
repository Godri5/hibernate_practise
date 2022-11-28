package org.example.controller;

import org.example.model.Position;
import org.example.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/positions")
public class PositionController {

    @Autowired
    private PositionService positionService;

    @GetMapping("/list")
    public String listCustomers(Model model) {
        List<Position> positions = positionService.getAllPositions();
        model.addAttribute("position", positions);
        return "list-positions";
    }

    @GetMapping("/showForm")
    public String showFormForAdd(Model model) {
        Position position = new Position();
        model.addAttribute("position", position);
        return "positions-form";
    }

    @PostMapping("/savePosition")
    public String saveCustomer(@ModelAttribute("position") Position position) {
        positionService.savePosition(position);
        return "redirect:/positions/list";
    }

    @GetMapping("/updateForm")
    public String showFormForUpdate(@RequestParam("id") Long id, Model model) {
        Position position = positionService.getPositionById(id);
        model.addAttribute("position", position);
        return "position-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("id") Long id) {
        positionService.deletePosition(id);
        return "redirect:/position/list";
    }
}
