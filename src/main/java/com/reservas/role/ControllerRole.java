package com.reservas.role;

import com.reservas.error.NullResponseNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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
    public ResponseEntity<List<Roless>> list(){
        return ResponseEntity.ok(this.serviceRole.list());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Roless> show(@PathVariable Long id)throws NullResponseNotFoundException {
        return ResponseEntity.ok(this.serviceRole.show(id));
    }

    @PostMapping
    public ResponseEntity<Roless> create(@RequestBody @Valid Roless roles) throws NullResponseNotFoundException {
        return ResponseEntity.ok(this.serviceRole.create(roles));
    }

    @PutMapping
    public ResponseEntity<Roless> edit(@RequestBody Roless roles)throws NullResponseNotFoundException{
        return ResponseEntity.ok(this.serviceRole.edit(roles));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id)throws NullResponseNotFoundException{
        this.serviceRole.delete(id);
        return ResponseEntity.ok("Role deleted");
    }
}
