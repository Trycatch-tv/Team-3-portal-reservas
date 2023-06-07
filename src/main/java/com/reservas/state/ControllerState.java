package com.reservas.state;


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
@CrossOrigin(origins = "*")
@RequestMapping("/api/states")
public class ControllerState {

    private final ServiceState serviceState;
    @GetMapping
    public ResponseEntity<List<States>> list(){

        return ResponseEntity.ok(this.serviceState.list());
    }
    @GetMapping("/{id}")
    public ResponseEntity<States> show(@PathVariable Long id)throws NullResponseNotFoundException {
        return ResponseEntity.ok(this.serviceState.show(id));
    }

    @PostMapping
    public  ResponseEntity<States> create(@RequestBody @Valid States states){
        return ResponseEntity.ok(this.serviceState.create(states));
    }

    @PutMapping
    public  ResponseEntity<States> edit(@RequestBody States states) throws NullResponseNotFoundException {
        return ResponseEntity.ok(this.serviceState.edit(states));
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<?> delete(@PathVariable Long id) throws NullResponseNotFoundException{
        this.serviceState.delete(id);
        return ResponseEntity.ok("State deleted");
    }
}
