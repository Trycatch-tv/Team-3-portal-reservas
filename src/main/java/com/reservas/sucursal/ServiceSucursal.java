package com.reservas.sucursal;

import com.reservas.error.NullResponseNotFoundException;
import com.reservas.table.RepositoryTable;
import com.reservas.table.TableRest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServiceSucursal {

    private final RepositorySucursal repositorySucursal;

    @Transactional(readOnly = true)
    public List<Sucursal> list(){ return this.repositorySucursal.findAll(); }

    @Transactional(readOnly = true)
    public Sucursal show(Long id) throws NullResponseNotFoundException {
        Optional<Sucursal> sucursal = this.repositorySucursal.findById(id);
        if(!sucursal.isPresent()){
            throw new NullResponseNotFoundException("Data not available");
        }
        return sucursal.get(); }

    @Transactional
    public Sucursal create(Sucursal sucursal){ return this.repositorySucursal.save(sucursal); }

    @Transactional
    public Sucursal edit(Sucursal sucursal)throws NullResponseNotFoundException{
        Optional<Sucursal> sucursale = this.repositorySucursal.findById(sucursal.getId());
        if(!sucursale.isPresent()){
            throw new NullResponseNotFoundException("Data not available");
        }

        if(sucursal.getName() != null && !sucursal.getName().isEmpty()){
            sucursale.get().setName(sucursal.getName());
        }

        if(sucursal.getObservation() != null && !sucursal.getObservation().isEmpty()){
            sucursale.get().setObservation(sucursal.getObservation());
        }

        if(sucursal.getAddress() != null && !sucursal.getAddress().isEmpty()){
            sucursale.get().setAddress(sucursal.getAddress());
        }

        if(sucursal.getLocation() != null && !sucursal.getLocation().isEmpty()){
            sucursale.get().setLocation(sucursal.getLocation());
        }

        if(sucursal.getPostalCode() != null && !sucursal.getPostalCode().isEmpty()){
            sucursale.get().setPostalCode(sucursal.getPostalCode());
        }

        if(sucursal.getPhone() != null && !sucursal.getPhone().isEmpty()){
            sucursale.get().setPhone(sucursal.getPhone());
        }

        if(sucursal.getTimeSeat() != null && sucursal.getTimeSeat().isAfter(LocalTime.of(0,30,0)) && sucursal.getTimeSeat().isBefore(LocalTime.of(23,59,50))){
            sucursale.get().setTimeSeat(sucursal.getTimeSeat());
        }

        if(sucursal.getMaxWaiting() != null && sucursal.getMaxWaiting().isAfter(LocalTime.of(0,30,0)) && sucursal.getMaxWaiting().isBefore(LocalTime.of(23,59,50))){
            sucursale.get().setMaxWaiting(sucursal.getMaxWaiting());
        }
        //Validar si llega valor boolean, terraza, overBooking,status
        if(sucursal.getSmoking() != null && (sucursal.getSmoking().equals(true) ||sucursal.getSmoking().equals(false) )){
            sucursale.get().setSmoking(sucursal.getSmoking());
        }
        if(sucursal.getTerraza() != null && (sucursal.getTerraza().equals(true) ||sucursal.getTerraza().equals(false) )){
            sucursale.get().setTerraza(sucursal.getTerraza());
        }
        if(sucursal.getOverBooking() != null && (sucursal.getOverBooking().equals(true) ||sucursal.getOverBooking().equals(false) ) ){
            sucursale.get().setOverBooking(sucursal.getOverBooking());
        }
        if(sucursal.getStatus() != null && (sucursal.getStatus().equals(true) ||sucursal.getStatus().equals(false) )){
            sucursale.get().setStatus(sucursal.getStatus());
        }

        return this.repositorySucursal.save(sucursale.get()); }

    @Transactional
    public void delete(Long id)throws NullResponseNotFoundException{
        Optional<Sucursal> sucursal = this.repositorySucursal.findById(id);
        if(!sucursal.isPresent()){
            throw new NullResponseNotFoundException("Data not available");
        }
        this.repositorySucursal.deleteById(id); }
}
