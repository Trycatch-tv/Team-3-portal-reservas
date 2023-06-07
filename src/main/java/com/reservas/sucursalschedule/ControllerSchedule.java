package com.reservas.sucursalschedule;

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
@RequestMapping("/api/schedule")
public class ControllerSchedule {

    private final ServiceSchedule serviceSchedule;
    @GetMapping
    public ResponseEntity<List<Schedule>> list(){
        return ResponseEntity.ok(this.serviceSchedule.list());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Schedule> show(@PathVariable Long id) throws NullResponseNotFoundException {
        return ResponseEntity.ok(this.serviceSchedule.show(id));
    }

    @PostMapping
    public ResponseEntity<Schedule> create(@RequestBody @Valid Schedule schedule){
        return ResponseEntity.ok(this.serviceSchedule.create(schedule));
    }

    @PutMapping
    public ResponseEntity<Schedule> edit(@RequestBody Schedule schedule) throws NullResponseNotFoundException {
        return ResponseEntity.ok(this.serviceSchedule.edit(schedule));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws NullResponseNotFoundException {
        this.serviceSchedule.delete(id);
        return ResponseEntity.ok("Schedule deleted");
    }
}
