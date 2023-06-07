package com.reservas.client;

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
@RequestMapping("api/client")
public class ControllerClient {

    private final ServiceClient serviceClient;

    @GetMapping
    public ResponseEntity<List<Client>> list(){
        return ResponseEntity.ok(this.serviceClient.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> show(@PathVariable Long id)throws NullResponseNotFoundException {
        return ResponseEntity.ok(this.serviceClient.show(id));
    }

    @PostMapping
    public ResponseEntity<Client> create(@RequestBody @Valid Client client) {
        return ResponseEntity.ok(this.serviceClient.create(client));
    }

    @PutMapping
    public ResponseEntity<Client> edit(@RequestBody Client client)throws NullResponseNotFoundException {
        return ResponseEntity.ok(this.serviceClient.edit(client)); }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws NullResponseNotFoundException{
        return ResponseEntity.ok("Client deleted"); }

}
