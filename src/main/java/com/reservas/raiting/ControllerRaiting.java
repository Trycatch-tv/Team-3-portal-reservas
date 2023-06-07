package com.reservas.raiting;

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
@RequestMapping("/api/raiting")
public class ControllerRaiting {

    private final ServiceRaiting serviceRaiting;
    @GetMapping
    public ResponseEntity<List<Raiting>> list(){
        return ResponseEntity.ok(this.serviceRaiting.list());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Raiting> show(@PathVariable Long id)throws NullResponseNotFoundException {
        return ResponseEntity.ok(this.serviceRaiting.show(id));
    }

    @PostMapping
    public ResponseEntity<Raiting> create(@RequestBody @Valid Raiting raiting){
        return ResponseEntity.ok(this.serviceRaiting.create(raiting));
    }

    @PutMapping
    public ResponseEntity<Raiting> edit(@RequestBody Raiting raiting) throws NullResponseNotFoundException{
        return ResponseEntity.ok(this.serviceRaiting.edit(raiting));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws NullResponseNotFoundException {
        this.serviceRaiting.delete(id);
        return ResponseEntity.ok("Raiting deleted");
    }
}
