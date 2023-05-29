package com.reservas.dish;

import com.reservas.error.NullResponseNotFoundException;
import com.reservas.state.RepositoryState;
import com.reservas.state.States;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceDish {
    @Autowired
    private final RepositoryDish repositoryDish;

    @Autowired
    public ServiceDish (RepositoryDish repositoryDish){
        this.repositoryDish = repositoryDish;
    }

    public List<Dish> list(){ return this.repositoryDish.findAll(); }

    public Dish show(Long id) throws NullResponseNotFoundException {
        Optional<Dish> dish = this.repositoryDish.findById(id);
        if(!dish.isPresent()){
            throw new NullResponseNotFoundException("Data not available");
        }
        return dish.get(); }

    public Dish create(Dish dish){ return this.repositoryDish.save(dish); }

    public Dish edit(Dish dish){ return this.repositoryDish.save(dish); }

    public void delete(Long id){ this.delete(id); }
}
