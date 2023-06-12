package com.reservas.follow;

import com.reservas.error.NullResponseNotFoundException;
import com.reservas.state.RepositoryState;
import com.reservas.state.States;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServiceFollow {

    private final RepositoryFollow repositoryFollow;

    @Transactional(readOnly = true)
    public List<Follow> list(){ return this.repositoryFollow.findAll(); }

    @Transactional(readOnly = true)
    public Follow show(Long id) throws NullResponseNotFoundException {
        Optional<Follow> follow = this.repositoryFollow.findById(id) ;
        if(!follow.isPresent()){
            throw new NullResponseNotFoundException("Data not available");
        }
        return follow.get(); }

    @Transactional
    public Follow create(Follow follow){ return this.repositoryFollow.save(follow); }

    @Transactional
    public Follow edit(Follow follow)throws NullResponseNotFoundException{
        Optional<Follow> follo = Optional.of(this.repositoryFollow.findById(follow.getId()).orElseThrow(()->new NullResponseNotFoundException("Data not available")));
        //Validar entrada
        return this.repositoryFollow.save(follo.get()); }

    @Transactional
    public void delete(Long id) throws NullResponseNotFoundException{
        Optional<Follow> follow = this.repositoryFollow.findById(id) ;
        if(!follow.isPresent()){
            throw new NullResponseNotFoundException("Data not available");
        }
        this.delete(id);
    }

}
