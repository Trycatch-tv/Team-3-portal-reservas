package com.reservas.client;

import com.reservas.error.NullResponseNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServiceClient {
    private final RepositoryClient repositoryClient;

    @Transactional(readOnly = true)
    public List<Clientes> list(){ return this.repositoryClient.findAll(); }

    @Transactional(readOnly = true)
    public Clientes show(Long id) throws NullResponseNotFoundException{
        Optional<Clientes> client = this.repositoryClient.findById(id);
        if(!client.isPresent()){
            throw new NullResponseNotFoundException("Data not available");
        }
        return client.get();}

    @Transactional
    public Clientes create(Clientes client){ return this.repositoryClient.save(client); }

    @Transactional
    public Clientes edit(Clientes client) throws NullResponseNotFoundException{
        Optional<Clientes> clientOpt = this.repositoryClient.findById(client.getId());
        if(!clientOpt.isPresent()){
            throw new NullResponseNotFoundException("Data not available");
        }
        //Validar entrada
        return this.repositoryClient.save(clientOpt.get());
    }

    @Transactional
    public void delete(Long id)throws NullResponseNotFoundException{
        Optional<Clientes> client = this.repositoryClient.findById(id);
        if(!client.isPresent()){
            throw new NullResponseNotFoundException("Data not available");
        }
        this.repositoryClient.deleteById(id); }
}
