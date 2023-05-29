package com.reservas.autority;

import com.reservas.error.NullResponseNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceAuthority {

    @Autowired
    private final RepositoryAuthority repositoryAuthority;

    @Autowired
    public ServiceAuthority(RepositoryAuthority repositoryAuthority) {
        this.repositoryAuthority = repositoryAuthority;
    }

    public Authority show(Long id) throws NullResponseNotFoundException {
        Optional<Authority> authority = this.repositoryAuthority.findById(id);
        if (!authority.isPresent()){
            throw new NullResponseNotFoundException("Data not available");
        }
        return authority.get();
    }

    public List<Authority> list(){
        return this.repositoryAuthority.findAll();
    }

    public Authority create(Authority authority){
        return  this.repositoryAuthority.save(authority);
    }

    public Authority edit(Authority authority){
        return this.repositoryAuthority.save(authority);
    }

    public void delete(Long id){
        this.repositoryAuthority.deleteById(id);
    }

}
