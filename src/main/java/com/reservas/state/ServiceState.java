package com.reservas.state;

import com.reservas.error.NullResponseNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServiceState {

    private final RepositoryState repositoryStates;
    public List<States> list(){ return this.repositoryStates.findAll(); }

    public States show(Long id)throws NullResponseNotFoundException {
        Optional<States> states = this.repositoryStates.findById(id);
        if(!states.isPresent()){
            throw new NullResponseNotFoundException("Data not available");
        }
        return states.get(); }

    public States create(States states){ return this.repositoryStates.save(states); }

    public States edit(States states)throws NullResponseNotFoundException{
        Optional<States> state = this.repositoryStates.findById(states.getId());
        if(!state.isPresent()){
            throw new NullResponseNotFoundException("Data not available");
        }
        //Validar entrada
        return this.repositoryStates.save(state.get()); }

    public void delete(Long id) throws NullResponseNotFoundException {
        Optional<States> states = Optional.of(this.repositoryStates.findById(id).orElseThrow(()->new NullResponseNotFoundException("Data not available")));
        this.repositoryStates.deleteById(id);
    }

}
