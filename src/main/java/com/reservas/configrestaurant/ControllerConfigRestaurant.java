package com.reservas.configrestaurant;

import com.reservas.error.NullResponseNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("api/restaurant")
public class ControllerConfigRestaurant {

    private final ServiceConfigRestaurant serviceConfigRestaurant;


    @GetMapping
    public ResponseEntity<List<ConfigRestaurant>> list(){
        return ResponseEntity.ok(this.serviceConfigRestaurant.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConfigRestaurant> show(@PathVariable Long id)throws NullResponseNotFoundException {
        return ResponseEntity.ok(this.serviceConfigRestaurant.show(id));
    }

    @PostMapping
    public ResponseEntity<ConfigRestaurant> create(@RequestBody @Valid ConfigRestaurant configRestaurant){
        return ResponseEntity.ok(this.serviceConfigRestaurant.create(configRestaurant));
    }

    @PutMapping
    public ResponseEntity<ConfigRestaurant> edit(@RequestBody ConfigRestaurant configRestaurant)throws NullResponseNotFoundException {
        return ResponseEntity.ok(this.serviceConfigRestaurant.edit(configRestaurant));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws NullResponseNotFoundException {
        this.serviceConfigRestaurant.delete(id);
       return ResponseEntity.ok("Restaurant deleted");
    }

}
