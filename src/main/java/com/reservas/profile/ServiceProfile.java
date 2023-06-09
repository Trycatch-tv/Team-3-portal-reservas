package com.reservas.profile;

import com.reservas.error.NullResponseNotFoundException;
import com.reservas.table.RepositoryTable;
import com.reservas.table.TableRest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServiceProfile {

    private final RepositoryProfile repositoryProfile;

    @Transactional(readOnly = true)
    public List<Profile> list(){ return this.repositoryProfile.findAll(); }

    @Transactional(readOnly = true)
    public Profile show(Long id) throws NullResponseNotFoundException {
        Optional<Profile> profile = this.repositoryProfile.findById(id);
        if(!profile.isPresent()){
            throw new NullResponseNotFoundException("Data not available");
        }
        return profile.get(); }

    @Transactional
    public Profile create(Profile profile){
        return this.repositoryProfile.save(profile); }

    @Transactional
    public Profile edit(Profile profile) throws NullResponseNotFoundException {
        Optional<Profile> profil = this.repositoryProfile.findById(profile.getId());
        if(!profil.isPresent()){
            throw new NullResponseNotFoundException("Data not available");
        }

        if(profile.getName() != null && !profile.getName().isEmpty()){
            profil.get().setName(profile.getName());
        }

        if(profile.getLastName() != null && !profile.getLastName().isEmpty()){
            profil.get().setLastName(profile.getLastName());
        }

        if(profile.getAddress() != null && !profile.getAddress().isEmpty()){
            profil.get().setAddress(profile.getAddress());
        }

        if(profile.getPhone() != null && !profile.getPhone().isEmpty()){
            profil.get().setPhone(profile.getPhone());
        }

        if(profile.getPostalCode() != null && !profile.getPostalCode().isEmpty()){
            profil.get().setPostalCode(profile.getPostalCode());
        }

        if(profile.getAvatar() != null && !profile.getAvatar().isEmpty()){
            profil.get().setAvatar(profile.getAvatar());
        }

        return this.repositoryProfile.save(profil.get()); }

    @Transactional
    public void delete(Long id) throws NullResponseNotFoundException {
        Optional<Profile> profile = this.repositoryProfile.findById(id);
        if(!profile.isPresent()){
            throw new NullResponseNotFoundException("Data not available");
        }
        this.repositoryProfile.deleteById(id); }
}
