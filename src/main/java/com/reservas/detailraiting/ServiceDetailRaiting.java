package com.reservas.detailraiting;

import com.reservas.client.Client;
import com.reservas.client.RepositoryClient;
import com.reservas.error.NullResponseNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceDetailRaiting {

    @Autowired
    private final RepositoryDetailRaiting repositoryDetailRaiting;

    @Autowired
    public ServiceDetailRaiting(RepositoryDetailRaiting repositoryDetailRaiting){ this.repositoryDetailRaiting = repositoryDetailRaiting; }

    public List<DetailRaiting> list(){ return this.repositoryDetailRaiting.findAll(); }

    public DetailRaiting show(Long id) throws NullResponseNotFoundException {
        Optional<DetailRaiting> detailRaiting = this.repositoryDetailRaiting.findById(id);
        if(!detailRaiting.isPresent()){
            throw new NullResponseNotFoundException("Data not available");
        }
        return detailRaiting.get();}

    public DetailRaiting create(DetailRaiting detailRaiting){ return this.repositoryDetailRaiting.save(detailRaiting); }

    public DetailRaiting edit(DetailRaiting detailRaiting) { return this.repositoryDetailRaiting.save(detailRaiting); }

    public void delete(Long id){ this.repositoryDetailRaiting.deleteById(id); }
}
