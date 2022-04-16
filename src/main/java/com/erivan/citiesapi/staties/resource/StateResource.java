package com.erivan.citiesapi.staties.resource;

import com.erivan.citiesapi.cities.entities.City;
import com.erivan.citiesapi.staties.entities.State;
import com.erivan.citiesapi.staties.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/staties")
public class StateResource {

    @Autowired
    private StateRepository repository;

    @GetMapping
    public List<State> staties() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable Long id){
        Optional<State> optional = repository.findById(id);

        if(optional.isPresent()){
            return ResponseEntity.ok().body(optional.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
