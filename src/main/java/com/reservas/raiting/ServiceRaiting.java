package com.reservas.raiting;

import com.reservas.error.NullResponseNotFoundException;
import com.reservas.table.RepositoryTable;
import com.reservas.table.TableRest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServiceRaiting {

    private final RepositoryRaiting repositoryRaiting;
    @Transactional(readOnly = true)
    public List<Raiting> list(){ return this.repositoryRaiting.findAll(); }

    @Transactional(readOnly = true)
    public Raiting show(Long id) throws NullResponseNotFoundException {
        Optional<Raiting> raiting = this.repositoryRaiting.findById(id);
        if(!raiting.isPresent()){
            throw new NullResponseNotFoundException("Data not available");
        }
        return raiting.get(); }

    @Transactional
    public Raiting create(Raiting raiting){ return this.repositoryRaiting.save(raiting); }

    @Transactional
    public Raiting edit(Raiting raiting) throws NullResponseNotFoundException{
        Optional<Raiting> raitin = this.repositoryRaiting.findById(raiting.getId());
        if(!raitin.isPresent()){
            throw new NullResponseNotFoundException("Data not available");
        }
        //score, comments
        if(raiting.getComments() != null && !raiting.getComments().isEmpty()){
            raitin.get().setComments(raiting.getComments());
        }
        if(raiting.getScore() != null && raiting.getScore() >= 0 && raiting.getScore() <= 10){
            raitin.get().setScore(raiting.getScore());
        }
        return this.repositoryRaiting.save(raitin.get()); }

    @Transactional
    public void delete(Long id) throws NullResponseNotFoundException{
        Optional<Raiting> raiting = this.repositoryRaiting.findById(id);
        if(!raiting.isPresent()){
            throw new NullResponseNotFoundException("Data not available");
        }
        this.repositoryRaiting.deleteById(id);
    }
}
