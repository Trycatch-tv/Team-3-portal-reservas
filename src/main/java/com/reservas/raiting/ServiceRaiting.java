package com.reservas.raiting;

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
public class ServiceRaiting {

    private final RepositoryRaiting repositoryRaiting;
    public List<Raiting> list(){ return this.repositoryRaiting.findAll(); }

    public Raiting show(Long id) throws NullResponseNotFoundException {
        Optional<Raiting> raiting = this.repositoryRaiting.findById(id);
        if(!raiting.isPresent()){
            throw new NullResponseNotFoundException("Data not available");
        }
        return raiting.get(); }

    public Raiting create(Raiting raiting){ return this.repositoryRaiting.save(raiting); }

    public Raiting edit(Raiting raiting) throws NullResponseNotFoundException{
        Optional<Raiting> raitin = this.repositoryRaiting.findById(raiting.getId());
        if(!raitin.isPresent()){
            throw new NullResponseNotFoundException("Data not available");
        }
        //Validar entrada
        return this.repositoryRaiting.save(raitin.get()); }

    public void delete(Long id) throws NullResponseNotFoundException{
        Optional<Raiting> raiting = this.repositoryRaiting.findById(id);
        if(!raiting.isPresent()){
            throw new NullResponseNotFoundException("Data not available");
        }
        this.repositoryRaiting.deleteById(id);
    }
}
