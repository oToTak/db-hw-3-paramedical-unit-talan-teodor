package com.example.paramedical.controller;

import com.example.paramedical.model.Ambulance;
import com.example.paramedical.repository.AmbulanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class AmbulanceController {

    @Autowired
    private AmbulanceRepository ambulanceRepository;

    // Step 8.1: Get all ambulances
    @GetMapping("/ambulances")
    public List<Ambulance> getAllAmbulances() {
        return ambulanceRepository.findAll();
    }

    // Step 7.1: Add new ambulance
    @PostMapping("/ambulances")
    public Ambulance createAmbulance(@RequestBody Ambulance ambulance) {
        return ambulanceRepository.save(ambulance);
    }

    // Step 7.2: Update fuel level
    @PutMapping("/ambulances/{id}")
    public Ambulance updateFuel(@PathVariable String id, @RequestBody Integer newFuelLevel) {
        Optional<Ambulance> ambulance = ambulanceRepository.findById(id);
        if (ambulance.isPresent()) {
            Ambulance updated = ambulance.get();
            updated.setFuelLevel(newFuelLevel);
            return ambulanceRepository.save(updated);
        }
        return null;
    }

    // Step 7.3: Delete ambulance
    @DeleteMapping("/ambulances/{id}")
    public void deleteAmbulance(@PathVariable String id) {
        ambulanceRepository.deleteById(id);
    }

    // Step 8.2: Report for Low Fuel (< 30)
    @GetMapping("/reports/low-fuel")
    public List<Ambulance> getLowFuel() {
        return ambulanceRepository.findAll().stream()
                .filter(a -> a.getFuelLevel() != null && a.getFuelLevel() < 30)
                .collect(Collectors.toList());
    }

    // Step 8.3: Report for total count
    @GetMapping("/reports/count")
    public String getCount() {
        long count = ambulanceRepository.count();
        return "Total ambulances in fleet: " + count;
    }
}