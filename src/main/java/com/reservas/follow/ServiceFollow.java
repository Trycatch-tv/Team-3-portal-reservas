package com.reservas.follow;

import com.reservas.error.NullResponseNotFoundException;
import com.reservas.state.RepositoryState;
import com.reservas.state.States;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceFollow {
    @Autowired
    private final RepositoryFollow repositoryFollow;

    @Autowired
    public ServiceFollow (RepositoryFollow repositoryFollow){
        this.repositoryFollow = repositoryFollow;
    }

    public List<Follow> list(){ return this.repositoryFollow.findAll(); }

    public Follow show(Long id) throws NullResponseNotFoundException {
        Optional<Follow> follow = this.repositoryFollow.findById(id) ;
        if(!follow.isPresent()){
            throw new NullResponseNotFoundException("Data not available");
        }
        return follow.get(); }

    public Follow create(Follow follow){ return this.repositoryFollow.save(follow); }

    public Follow edit(Follow follow){ return this.repositoryFollow.save(follow); }

    public void delete(Long id){ this.delete(id); }

}
