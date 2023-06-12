package com.reservas.configrestaurant;

import com.reservas.error.NullResponseNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServiceConfigRestaurant {

    private final RepositoryConfigRestaurant repositoryConfigRestaurant;

    @Transactional(readOnly = true)
    public List<ConfigRestaurant> list(){ return this.repositoryConfigRestaurant.findAll(); }

    @Transactional(readOnly = true)
    public ConfigRestaurant show(Long id) throws NullResponseNotFoundException {
        Optional<ConfigRestaurant> configRestaurant = this.repositoryConfigRestaurant.findById(id);
        if(!configRestaurant.isPresent()){
            throw new NullResponseNotFoundException("Data not available");
        }
        return configRestaurant.get(); }

    @Transactional
    public ConfigRestaurant create(ConfigRestaurant configRestaurant){ return this.repositoryConfigRestaurant.save(configRestaurant); }

    @Transactional
    public ConfigRestaurant edit(ConfigRestaurant configRestaurant) throws NullResponseNotFoundException{
        Optional<ConfigRestaurant> restaurant = this.repositoryConfigRestaurant.findById(configRestaurant.getId());
        if(!restaurant.isPresent()){
            throw new NullResponseNotFoundException("Data not available");
        }

        if(configRestaurant.getName() != null && !configRestaurant.getName().isEmpty()){
            restaurant.get().setName(configRestaurant.getName());
        }
        if(configRestaurant.getSlogan() != null && !configRestaurant.getSlogan().isEmpty()){
            restaurant.get().setSlogan(configRestaurant.getSlogan());
        }
        if(configRestaurant.getLogo() != null && !configRestaurant.getLogo().isEmpty()){
            restaurant.get().setLogo(configRestaurant.getLogo());
        }
        if(configRestaurant.getBanner() != null && !configRestaurant.getBanner().isEmpty()){
            restaurant.get().setBanner(configRestaurant.getBanner());
        }

        if(configRestaurant.getDescription() != null && !configRestaurant.getDescription().isEmpty()){
            restaurant.get().setDescription(configRestaurant.getDescription());
        }
        if(configRestaurant.getAddress() != null && !configRestaurant.getAddress().isEmpty()){
            restaurant.get().setAddress(configRestaurant.getAddress());
        }
        if(configRestaurant.getPostalCode() != null && !configRestaurant.getPostalCode().isEmpty()){
            restaurant.get().setPostalCode(configRestaurant.getPostalCode());
        }
        if(configRestaurant.getPhone() != null && !configRestaurant.getPhone().isEmpty()){
            restaurant.get().setPhone(configRestaurant.getPhone());
        }
        //code_trade,email
        if(configRestaurant.getCodeTrade() != null && !configRestaurant.getCodeTrade().isEmpty()){
            restaurant.get().setCodeTrade(configRestaurant.getCodeTrade());
        }

        if(configRestaurant.getEmail() != null && !configRestaurant.getEmail().isEmpty()){
            restaurant.get().setEmail(configRestaurant.getEmail());
        }
        return this.repositoryConfigRestaurant.save(restaurant.get());
    }

    @Transactional
    public void delete(Long id) throws NullResponseNotFoundException{
        Optional<ConfigRestaurant> configRestaurant = this.repositoryConfigRestaurant.findById(id);
        if(!configRestaurant.isPresent()){
            throw new NullResponseNotFoundException("Data not available");
        }
        this.repositoryConfigRestaurant.deleteById(id);
    }

}