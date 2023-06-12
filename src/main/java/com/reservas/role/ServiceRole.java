package com.reservas.role;


import com.reservas.error.NullResponseNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServiceRole {

    private final RepositoryRole repositoryRole;

    @Transactional(readOnly = true)
    public List<Roless> list(){ return this.repositoryRole.findAll(); }

    @Transactional(readOnly = true)
    public Roless show(Long id)throws NullResponseNotFoundException {
        Optional<Roless> roles = this.repositoryRole.findById(id);
        if(!roles.isPresent()){
            throw new NullResponseNotFoundException("Data not available");
        }
        return roles.get(); }

    @Transactional
    public Roless create(Roless roles) throws NullResponseNotFoundException {
        Optional<Roless> roless = findRoles(roles.getName());
        if(roless.isPresent()){
            throw new NullResponseNotFoundException("Role already exists");
        }
        return this.repositoryRole.save(roles);
    }

    @Transactional
    public Roless edit(Roless roles)throws NullResponseNotFoundException{
        Optional<Roless> role = this.repositoryRole.findById(roles.getId());
        if(!role.isPresent()){
            throw new NullResponseNotFoundException("Data not available");
        }

        if(roles.getName() != null && !roles.getName().isEmpty()){
            if(!roles.getName().equals(role.get().getName())){
                Optional<Roless> newName = findRoles(roles.getName());
                if(newName.isPresent()){
                    throw new NullResponseNotFoundException("Role already exists");
                }
                role.get().setName(roles.getName());
            }

        }

        if(roles.getDescription() != null && !roles.getDescription().isEmpty()){
            role.get().setDescription(roles.getDescription());
        }

        return this.repositoryRole.save(role.get()); }

    @Transactional
    public void delete(Long id)throws NullResponseNotFoundException{
        Optional<Roless> roles = this.repositoryRole.findById(id);
        if(!roles.isPresent()){
            throw new NullResponseNotFoundException("Data not available");
        }
        this.repositoryRole.deleteById(id); }
    @Transactional(readOnly = true)
    public Optional<Roless> findRoles(String roles){ return this.repositoryRole.findByName(roles);}
}
