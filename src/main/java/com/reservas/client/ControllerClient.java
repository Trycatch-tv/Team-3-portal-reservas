package com.reservas.client;

import com.reservas.error.NullResponseNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("api/client")
public class ControllerClient {

    private final ServiceClient serviceClient;

    @GetMapping
    public ResponseEntity<List<Clientes>> list(){
        return ResponseEntity.ok(this.serviceClient.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Clientes> show(@PathVariable Long id)throws NullResponseNotFoundException {
        return ResponseEntity.ok(this.serviceClient.show(id));
    }

    @PostMapping
    public ResponseEntity<Clientes> create(@RequestBody @Valid Clientes client) throws NullResponseNotFoundException {
        return ResponseEntity.ok(this.serviceClient.create(client));
    }

    @PutMapping
    public ResponseEntity<Clientes> edit(@RequestBody Clientes client)throws NullResponseNotFoundException {
        return ResponseEntity.ok(this.serviceClient.edit(client)); }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws NullResponseNotFoundException{
        return ResponseEntity.ok("Client deleted"); }

}
