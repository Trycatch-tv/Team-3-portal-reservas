package com.reservas.role;


import com.reservas.error.NullResponseNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceRole {
    @Autowired
    private final RepositoryRole repositoryRole;

    @Autowired
    public ServiceRole(RepositoryRole repositoryRole){
        this.repositoryRole = repositoryRole;
    }

    public List<Roles> list(){ return this.repositoryRole.findAll(); }

    public Roles show(Long id)throws NullResponseNotFoundException {
        Optional<Roles> roles = this.repositoryRole.findById(id);
        if(!roles.isPresent()){
            throw new NullResponseNotFoundException("Data not available");
        }
        return roles.get(); }

    public Roles create(Roles roles){ return this.repositoryRole.save(roles); }

    public Roles edit(Roles roles){ return this.repositoryRole.save(roles); }

    public void delete(Long id){ this.repositoryRole.deleteById(id); }

}
