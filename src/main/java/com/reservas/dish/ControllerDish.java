package com.reservas.dish;


import com.reservas.booking.Booking;
import com.reservas.booking.ServiceBooking;
import com.reservas.error.NullResponseNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/api/dish")
public class ControllerDish {

    private final ServiceDish serviceDish;
    @GetMapping
    public ResponseEntity<List<Dish>> list(){
        return ResponseEntity.ok(this.serviceDish.list());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Dish> show(@PathVariable Long id)throws NullResponseNotFoundException  {
        return ResponseEntity.ok(this.serviceDish.show(id));
    }

    @PostMapping
    public ResponseEntity<Dish> create(@RequestBody @Valid Dish dish){
        return ResponseEntity.ok(this.serviceDish.create(dish));
    }

    @PutMapping
    public ResponseEntity<Dish> edit(@RequestBody Dish dish) throws NullResponseNotFoundException{
        return ResponseEntity.ok(this.serviceDish.edit(dish));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id)throws NullResponseNotFoundException{
        this.serviceDish.delete(id);
        return ResponseEntity.ok("Dish deleted");
    }
}
