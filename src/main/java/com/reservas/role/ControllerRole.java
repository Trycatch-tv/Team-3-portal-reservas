package com.reservas.role;

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
@RequestMapping("/api/role")
public class ControllerRole {

    private final ServiceRole serviceRole;
    @GetMapping
    public ResponseEntity<List<Roles>> list(){
        return ResponseEntity.ok(this.serviceRole.list());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Roles> show(@PathVariable Long id)throws NullResponseNotFoundException {
        return ResponseEntity.ok(this.serviceRole.show(id));
    }

    @PostMapping
    public ResponseEntity<Roles> create(@RequestBody @Valid Roles roles){
        return ResponseEntity.ok(this.serviceRole.create(roles));
    }

    @PutMapping
    public ResponseEntity<Roles> edit(@RequestBody Roles roles)throws NullResponseNotFoundException{
        return ResponseEntity.ok(this.serviceRole.edit(roles));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id)throws NullResponseNotFoundException{
        this.serviceRole.delete(id);
        return ResponseEntity.ok("Role deleted");
    }
}
