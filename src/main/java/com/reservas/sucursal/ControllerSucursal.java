package com.reservas.sucursal;


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
@RequestMapping("/api/sucursal")
public class ControllerSucursal {

    private final ServiceSucursal serviceSucursal;
    @GetMapping
    public ResponseEntity<List<Sucursal>> list(){
        return ResponseEntity.ok(this.serviceSucursal.list());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Sucursal> show(@PathVariable Long id)throws NullResponseNotFoundException {
        return ResponseEntity.ok(this.serviceSucursal.show(id));
    }

    @PostMapping
    public ResponseEntity<Sucursal> create(@RequestBody @Valid Sucursal sucursal){
        return ResponseEntity.ok(this.serviceSucursal.create(sucursal));
    }

    @PutMapping
    public ResponseEntity<Sucursal> edit(@RequestBody Sucursal sucursal)throws NullResponseNotFoundException{
        return ResponseEntity.ok(this.serviceSucursal.edit(sucursal));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id)throws NullResponseNotFoundException{
        this.serviceSucursal.delete(id);
        return ResponseEntity.ok("Sucursal deleted");
    }
}
