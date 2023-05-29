package com.reservas.configrestaurant;

import com.reservas.error.NullResponseNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceConfigRestaurant {

    @Autowired
    private final RepositoryConfigRestaurant repositoryConfigRestaurant;

    @Autowired
    public ServiceConfigRestaurant(RepositoryConfigRestaurant repositoryConfigRestaurant){
        this.repositoryConfigRestaurant = repositoryConfigRestaurant;
    }

    public List<ConfigRestaurant> list(){ return this.repositoryConfigRestaurant.findAll(); }

    public ConfigRestaurant show(Long id) throws NullResponseNotFoundException {
        Optional<ConfigRestaurant> configRestaurant = this.repositoryConfigRestaurant.findById(id);
        if(!configRestaurant.isPresent()){
            throw new NullResponseNotFoundException("Data not available");
        }
        return configRestaurant.get(); }

    public ConfigRestaurant create(ConfigRestaurant configRestaurant){ return this.repositoryConfigRestaurant.save(configRestaurant); }

    public ConfigRestaurant edit(ConfigRestaurant configRestaurant){ return this.repositoryConfigRestaurant.save(configRestaurant); }

    public void delete(Long id){ this.repositoryConfigRestaurant.deleteById(id); }

}