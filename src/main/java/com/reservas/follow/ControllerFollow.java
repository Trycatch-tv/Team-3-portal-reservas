package com.reservas.follow;

import com.reservas.error.NullResponseNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/api/follow")
public class ControllerFollow {

    private final ServiceFollow serviceFollow;
    @GetMapping
    public ResponseEntity<List<Follow>> list(){
        return ResponseEntity.ok(this.serviceFollow.list());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Follow> show(@PathVariable Long id)throws NullResponseNotFoundException {
        return ResponseEntity.ok(this.serviceFollow.show(id));
    }

    @PostMapping
    public  ResponseEntity<Follow> create(@RequestBody Follow follow){
        return ResponseEntity.ok(this.serviceFollow.create(follow));
    }

    @PutMapping
    public  ResponseEntity<Follow> edit(@RequestBody Follow follow) throws NullResponseNotFoundException{
        return ResponseEntity.ok(this.serviceFollow.edit(follow));
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<?> delete(@PathVariable Long id) throws NullResponseNotFoundException{
        this.serviceFollow.delete(id);
        return ResponseEntity.ok("Follow deleted");
    }
}
