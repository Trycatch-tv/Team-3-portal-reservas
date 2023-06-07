package com.reservas.configrestaurant;

import com.reservas.error.NullResponseNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServiceConfigRestaurant {

    private final RepositoryConfigRestaurant repositoryConfigRestaurant;


    public List<ConfigRestaurant> list(){ return this.repositoryConfigRestaurant.findAll(); }

    public ConfigRestaurant show(Long id) throws NullResponseNotFoundException {
        Optional<ConfigRestaurant> configRestaurant = this.repositoryConfigRestaurant.findById(id);
        if(!configRestaurant.isPresent()){
            throw new NullResponseNotFoundException("Data not available");
        }
        return configRestaurant.get(); }

    public ConfigRestaurant create(ConfigRestaurant configRestaurant){ return this.repositoryConfigRestaurant.save(configRestaurant); }

    public ConfigRestaurant edit(ConfigRestaurant configRestaurant) throws NullResponseNotFoundException{
        Optional<ConfigRestaurant> restaurant = this.repositoryConfigRestaurant.findById(configRestaurant.getId());
        if(!restaurant.isPresent()){
            throw new NullResponseNotFoundException("Data not available");
        }
        //Validar entrada
        return this.repositoryConfigRestaurant.save(restaurant.get());
    }

    public void delete(Long id) throws NullResponseNotFoundException{
        Optional<ConfigRestaurant> configRestaurant = this.repositoryConfigRestaurant.findById(id);
        if(!configRestaurant.isPresent()){
            throw new NullResponseNotFoundException("Data not available");
        }
        this.repositoryConfigRestaurant.deleteById(id);
    }

}