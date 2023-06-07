package com.reservas.sucursalmap;

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
@RequestMapping("/api/map")
public class ControllerMap {

    private final ServiceMap serviceMap;
    @GetMapping
    public ResponseEntity<List<Maps>> list(){

        return ResponseEntity.ok(this.serviceMap.list());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Maps> show(@PathVariable Long id) throws NullResponseNotFoundException {
        return ResponseEntity.ok(this.serviceMap.show(id));
    }

    @PostMapping
    public ResponseEntity<Maps> create(@RequestBody @Valid Maps maps){
        return ResponseEntity.ok(this.serviceMap.create(maps)) ;
    }

    @PutMapping
    public ResponseEntity<Maps> edit(@RequestBody Maps maps) throws NullResponseNotFoundException {
        return ResponseEntity.ok(this.serviceMap.edit(maps));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws NullResponseNotFoundException  {
        this.serviceMap.delete(id);
        return ResponseEntity.ok("Map deleted");
    }
}
