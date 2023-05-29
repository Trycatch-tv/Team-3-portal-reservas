package com.reservas.sucursal;

import com.reservas.error.NullResponseNotFoundException;
import com.reservas.table.RepositoryTable;
import com.reservas.table.TableRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceSucursal {

    @Autowired
    private final RepositorySucursal repositorySucursal;

    @Autowired
    public ServiceSucursal(RepositorySucursal repositorySucursal){
        this.repositorySucursal = repositorySucursal;
    }

    public List<Sucursal> list(){ return this.repositorySucursal.findAll(); }

    public Sucursal show(Long id) throws NullResponseNotFoundException {
        Optional<Sucursal> sucursal = this.repositorySucursal.findById(id);
        if(!sucursal.isPresent()){
            throw new NullResponseNotFoundException("Data not available");
        }
        return sucursal.get(); }

    public Sucursal create(Sucursal sucursal){ return this.repositorySucursal.save(sucursal); }

    public Sucursal edit(Sucursal sucursal){ return this.repositorySucursal.save(sucursal); }

    public void delete(Long id){ this.repositorySucursal.deleteById(id); }
}
