package com.reservas.detailraiting;

import com.reservas.client.Client;
import com.reservas.client.RepositoryClient;
import com.reservas.error.NullResponseNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServiceDetailRaiting {

    private final RepositoryDetailRaiting repositoryDetailRaiting;

    public List<DetailRaiting> list(){ return this.repositoryDetailRaiting.findAll(); }

    public DetailRaiting show(Long id) throws NullResponseNotFoundException {
        Optional<DetailRaiting> detailRaiting = this.repositoryDetailRaiting.findById(id);
        if(!detailRaiting.isPresent()){
            throw new NullResponseNotFoundException("Data not available");
        }
        return detailRaiting.get();}

    public DetailRaiting create(DetailRaiting detailRaiting){ return this.repositoryDetailRaiting.save(detailRaiting); }

    public DetailRaiting edit(DetailRaiting detailRaiting) throws NullResponseNotFoundException {
        Optional<DetailRaiting> detail = Optional.of(this.repositoryDetailRaiting.findById(detailRaiting.getId()).orElseThrow(()->new NullResponseNotFoundException("Data not available")));
        //Validar entrada
        return this.repositoryDetailRaiting.save(detailRaiting);
    }

    public void delete(Long id) throws NullResponseNotFoundException {
        Optional<DetailRaiting> detail = Optional.of(this.repositoryDetailRaiting.findById(id).orElseThrow(()->new NullResponseNotFoundException("Data not available")));
        this.repositoryDetailRaiting.deleteById(id);
    }
}
