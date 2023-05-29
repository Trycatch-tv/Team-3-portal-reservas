package com.reservas.state;

import com.reservas.error.NullResponseNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceState {

    @Autowired
    private final RepositoryState repositoryStates;

    @Autowired
    public ServiceState (RepositoryState repositoryStates){
        this.repositoryStates = repositoryStates;
    }

    public List<States> list(){ return this.repositoryStates.findAll(); }

    public States show(Long id)throws NullResponseNotFoundException {
        Optional<States> states = this.repositoryStates.findById(id);
        if(!states.isPresent()){
            throw new NullResponseNotFoundException("Data not available");
        }
        return this.repositoryStates.findById(id).get(); }

    public States create(States states){ return this.repositoryStates.save(states); }

    public States edit(States states){ return this.repositoryStates.save(states); }

    public void delete(Long id){ this.delete(id); }

}
