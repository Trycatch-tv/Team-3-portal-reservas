package com.reservas.client;

import com.reservas.error.NullResponseNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/client")
public class ControllerClient {

    @Autowired
    private final ServiceClient serviceClient;

    @Autowired
    public ControllerClient(ServiceClient serviceClient){ this.serviceClient = serviceClient; }

    @GetMapping
    public List<Client> list(){ return this.serviceClient.list(); }

    @GetMapping("/{id}")
    public Client show(@PathVariable Long id)throws NullResponseNotFoundException { return this.serviceClient.show(id); }

    @PostMapping
    public Client create(@RequestBody @Valid Client client) {
        System.out.println(client.toString());
        return this.serviceClient.create(client); }

    @PutMapping
    public Client edit(@RequestBody Client client) { return this.serviceClient.edit(client); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { this.delete(id); }

}
