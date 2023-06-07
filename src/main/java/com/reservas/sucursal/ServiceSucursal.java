package com.reservas.sucursal;

import com.reservas.error.NullResponseNotFoundException;
import com.reservas.table.RepositoryTable;
import com.reservas.table.TableRest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServiceSucursal {

    private final RepositorySucursal repositorySucursal;
    public List<Sucursal> list(){ return this.repositorySucursal.findAll(); }

    public Sucursal show(Long id) throws NullResponseNotFoundException {
        Optional<Sucursal> sucursal = this.repositorySucursal.findById(id);
        if(!sucursal.isPresent()){
            throw new NullResponseNotFoundException("Data not available");
        }
        return sucursal.get(); }

    public Sucursal create(Sucursal sucursal){ return this.repositorySucursal.save(sucursal); }

    public Sucursal edit(Sucursal sucursal)throws NullResponseNotFoundException{
        Optional<Sucursal> sucursale = this.repositorySucursal.findById(sucursal.getId());
        if(!sucursale.isPresent()){
            throw new NullResponseNotFoundException("Data not available");
        }
        //Validar entrada
        return this.repositorySucursal.save(sucursale.get()); }

    public void delete(Long id)throws NullResponseNotFoundException{
        Optional<Sucursal> sucursal = this.repositorySucursal.findById(id);
        if(!sucursal.isPresent()){
            throw new NullResponseNotFoundException("Data not available");
        }
        this.repositorySucursal.deleteById(id); }
}
