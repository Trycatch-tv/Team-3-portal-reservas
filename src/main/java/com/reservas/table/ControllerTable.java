package com.reservas.table;

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
@RequestMapping("/api/table")
public class ControllerTable {

    private final ServiceTable serviceTable;
    @GetMapping
    public ResponseEntity<List<TableRest>> list(){
        return ResponseEntity.ok(this.serviceTable.list());
    }
    @GetMapping("/{id}")
    public ResponseEntity<TableRest> show(@PathVariable Long id)throws NullResponseNotFoundException {
        return ResponseEntity.ok(this.serviceTable.show(id));
    }

    @PostMapping
    public ResponseEntity<TableRest> create(@RequestBody @Valid TableRest tableRest){
        return  ResponseEntity.ok(this.serviceTable.create(tableRest));
    }

    @PutMapping
    public ResponseEntity<TableRest> edit(@RequestBody TableRest tableRest) throws NullResponseNotFoundException {

        return  ResponseEntity.ok(this.serviceTable.edit(tableRest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws NullResponseNotFoundException {
        this.serviceTable.delete(id);
        return  ResponseEntity.ok("Table deleted");
    }
}
