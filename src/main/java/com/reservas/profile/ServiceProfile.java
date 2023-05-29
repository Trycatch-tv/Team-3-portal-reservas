package com.reservas.profile;

import com.reservas.error.NullResponseNotFoundException;
import com.reservas.table.RepositoryTable;
import com.reservas.table.TableRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceProfile {
    @Autowired
    private final RepositoryProfile repositoryProfile;

    @Autowired
    public ServiceProfile(RepositoryProfile repositoryProfile){
        this.repositoryProfile = repositoryProfile;
    }

    public List<Profile> list(){ return this.repositoryProfile.findAll(); }

    public Profile show(Long id) throws NullResponseNotFoundException {
        Optional<Profile> profile = this.repositoryProfile.findById(id);
        if(!profile.isPresent()){
            throw new NullResponseNotFoundException("Data not available");
        }
        return profile.get(); }

    public Profile create(Profile profile){ return this.repositoryProfile.save(profile); }

    public Profile edit(Profile profile){ return this.repositoryProfile.save(profile); }

    public void delete(Long id){ this.repositoryProfile.deleteById(id); }
}
