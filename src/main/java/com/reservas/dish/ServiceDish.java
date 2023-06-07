package com.reservas.dish;

import com.reservas.error.NullResponseNotFoundException;
import com.reservas.state.RepositoryState;
import com.reservas.state.States;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServiceDish {
    private final RepositoryDish repositoryDish;

    public List<Dish> list(){ return this.repositoryDish.findAll(); }

    public Dish show(Long id) throws NullResponseNotFoundException {
        Optional<Dish> dish = this.repositoryDish.findById(id);
        if(!dish.isPresent()){
            throw new NullResponseNotFoundException("Data not available");
        }
        return dish.get(); }

    public Dish create(Dish dish){ return this.repositoryDish.save(dish); }

    public Dish edit(Dish dish) throws NullResponseNotFoundException{
        Optional<Dish> dishes = this.repositoryDish.findById(dish.getId());
        if(!dishes.isPresent()){
            throw new NullResponseNotFoundException("Data not available");
        }
        //Validar entrada
        return this.repositoryDish.save(dishes.get()); }

    public void delete(Long id) throws NullResponseNotFoundException {
        Optional<Dish> dish = this.repositoryDish.findById(id);
        if(!dish.isPresent()){
            throw new NullResponseNotFoundException("Data not available");
        }
        this.delete(id); }
}
