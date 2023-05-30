package com.reservas.sucursal;


import com.reservas.booking.Booking;
import com.reservas.booking.ServiceBooking;
import com.reservas.error.NullResponseNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/sucursal")
public class ControllerSucursal {
    @Autowired
    private final ServiceSucursal serviceSucursal;
    @Autowired
    public ControllerSucursal(ServiceSucursal serviceSucursal) {
        this.serviceSucursal = serviceSucursal;
    }

    @GetMapping
    public List<Sucursal> list(){
        return this.serviceSucursal.list();
    }
    @GetMapping("/{id}")
    public Sucursal show(@PathVariable Long id)throws NullResponseNotFoundException {
        return this.serviceSucursal.show(id);
    }

    @PostMapping
    public Sucursal create(@RequestBody @Valid Sucursal sucursal){
        return this.serviceSucursal.create(sucursal);
    }

    @PutMapping
    public Sucursal edit(@RequestBody Sucursal sucursal){
        return this.serviceSucursal.edit(sucursal);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        this.serviceSucursal.delete(id);
    }
}
