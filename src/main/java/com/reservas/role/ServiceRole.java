package com.reservas.role;


import com.reservas.error.NullResponseNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServiceRole {

    private final RepositoryRole repositoryRole;
    public List<Roles> list(){ return this.repositoryRole.findAll(); }

    public Roles show(Long id)throws NullResponseNotFoundException {
        Optional<Roles> roles = this.repositoryRole.findById(id);
        if(!roles.isPresent()){
            throw new NullResponseNotFoundException("Data not available");
        }
        return roles.get(); }

    public Roles create(Roles roles){ return this.repositoryRole.save(roles); }

    public Roles edit(Roles roles)throws NullResponseNotFoundException{
        Optional<Roles> role = this.repositoryRole.findById(roles.getId());
        if(!role.isPresent()){
            throw new NullResponseNotFoundException("Data not available");
        }
        //Validar entrada
        return this.repositoryRole.save(role.get()); }

    public void delete(Long id)throws NullResponseNotFoundException{
        Optional<Roles> roles = this.repositoryRole.findById(id);
        if(!roles.isPresent()){
            throw new NullResponseNotFoundException("Data not available");
        }
        this.repositoryRole.deleteById(id); }

}
