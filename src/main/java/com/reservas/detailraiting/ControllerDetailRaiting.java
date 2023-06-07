package com.reservas.detailraiting;

import com.reservas.autority.Authority;
import com.reservas.autority.ServiceAuthority;
import com.reservas.error.NullResponseNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(originPatterns = "*")
@RequestMapping("api/detail-raiting")
public class ControllerDetailRaiting {

    private final ServiceDetailRaiting serviceDetailRaiting;

    @GetMapping("/{id}")
    public ResponseEntity<DetailRaiting> show(@PathVariable Long id) throws NullResponseNotFoundException {
        return ResponseEntity.ok(this.serviceDetailRaiting.show(id));
    }

    @GetMapping
    public ResponseEntity<List<DetailRaiting>> list(){

        return ResponseEntity.ok(this.serviceDetailRaiting.list());
    }

    @PostMapping
    public ResponseEntity<DetailRaiting> create(@RequestBody @Valid DetailRaiting detailRaiting){
        return ResponseEntity.ok(this.serviceDetailRaiting.create(detailRaiting));
    }

    public ResponseEntity<DetailRaiting> edit(@RequestBody DetailRaiting detailRaiting) throws NullResponseNotFoundException {
        return ResponseEntity.ok(this.serviceDetailRaiting.edit(detailRaiting));
    }

    public ResponseEntity<?> delete(@PathVariable Long id) throws NullResponseNotFoundException {
        this.serviceDetailRaiting.delete(id);
        return ResponseEntity.ok("Detail deleted");
    }
}
