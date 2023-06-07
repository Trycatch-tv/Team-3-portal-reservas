package com.reservas.booking;

import com.reservas.error.NullResponseNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@CrossOrigin(originPatterns = "*")
@RequestMapping("api/booking")
public class ControllerBooking {

    private final ServiceBooking serviceBooking;

    @GetMapping
    public ResponseEntity<List<Booking>> list(){
        return ResponseEntity.ok(this.serviceBooking.list());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Booking> show(@PathVariable Long id) throws NullResponseNotFoundException {
        return ResponseEntity.ok(this.serviceBooking.show(id));
    }

    @PostMapping
    public ResponseEntity<Booking> create(@RequestBody @Valid Booking booking){
        return ResponseEntity.ok(this.serviceBooking.create(booking));
    }

    @PutMapping
    public ResponseEntity<Booking> edit(@RequestBody Booking booking) throws NullResponseNotFoundException{
        return ResponseEntity.ok(this.serviceBooking.edit(booking));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws NullResponseNotFoundException {
            this.serviceBooking.delete(id);
        return ResponseEntity.ok("Delete confirm");
    }

}
