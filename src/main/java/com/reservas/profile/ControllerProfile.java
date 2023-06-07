package com.reservas.profile;


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
@RequestMapping("/api/profile")
public class ControllerProfile {

    private final ServiceProfile serviceProfile;
    @GetMapping
    public ResponseEntity<List<Profile>> list(){
        return ResponseEntity.ok(this.serviceProfile.list());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Profile> show(@PathVariable Long id) throws NullResponseNotFoundException {
        return ResponseEntity.ok(this.serviceProfile.show(id));
    }

    @PostMapping
    public ResponseEntity<Profile> create(@RequestBody @Valid Profile profile){
        return ResponseEntity.ok(this.serviceProfile.create(profile));
    }

    @PutMapping
    public ResponseEntity<Profile> edit(@RequestBody Profile profile)throws NullResponseNotFoundException{
        return ResponseEntity.ok(this.serviceProfile.edit(profile));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws NullResponseNotFoundException{

        this.serviceProfile.delete(id);
        return ResponseEntity.ok("Profile deletd");
    }
}
