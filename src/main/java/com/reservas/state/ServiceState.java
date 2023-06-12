package com.reservas.state;

import com.reservas.error.NullResponseNotFoundException;
import com.reservas.role.Roless;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServiceState {

    private final RepositoryState repositoryStates;

    @Transactional(readOnly = true)
    public List<States> list(){ return this.repositoryStates.findAll(); }

    @Transactional(readOnly = true)
    public States show(Long id)throws NullResponseNotFoundException {
        Optional<States> states = this.repositoryStates.findById(id);
        if(!states.isPresent()){
            throw new NullResponseNotFoundException("Data not available");
        }
        return states.get(); }

    @Transactional
    public States create(States states) throws NullResponseNotFoundException {
        Optional<States> states1 = Optional.of(findState(states.getName()).orElseThrow(()->new NullResponseNotFoundException("States already exists")));
        return this.repositoryStates.save(states);
    }

    @Transactional
    public States edit(States states)throws NullResponseNotFoundException{
        Optional<States> state = this.repositoryStates.findById(states.getId());
        if(!state.isPresent()){
            throw new NullResponseNotFoundException("Data not available");
        }
        if(states.getName() != null && !states.getName().isEmpty()){
            if(!states.getName().equals(state.get().getName())){
                Optional<States> newName = findState(states.getName());
                if(newName.isPresent()){
                    throw new NullResponseNotFoundException("State already exists");
                }
                state.get().setName(states.getName());
            }

        }

        if(states.getDescription() != null && !states.getDescription().isEmpty()){
            state.get().setDescription(states.getDescription());
        }
        return this.repositoryStates.save(state.get()); }

    @Transactional
    public void delete(Long id) throws NullResponseNotFoundException {
        Optional<States> states = Optional.of(this.repositoryStates.findById(id).orElseThrow(()->new NullResponseNotFoundException("Data not available")));
        this.repositoryStates.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Optional<States> findState(String name){ return this.repositoryStates.findByName(name);}
}
