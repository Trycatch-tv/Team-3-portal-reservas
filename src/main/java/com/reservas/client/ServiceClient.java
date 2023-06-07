package com.reservas.client;

import com.reservas.error.NullResponseNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServiceClient {
    private final RepositoryClient repositoryClient;

    public List<Client> list(){ return this.repositoryClient.findAll(); }

    public Client show(Long id) throws NullResponseNotFoundException{
        Optional<Client> client = this.repositoryClient.findById(id);
        if(!client.isPresent()){
            throw new NullResponseNotFoundException("Data not available");
        }
        return client.get();}

    public Client create(Client client){ return this.repositoryClient.save(client); }

    public Client edit(Client client) throws NullResponseNotFoundException{
        Optional<Client> clientOpt = this.repositoryClient.findById(client.getId());
        if(!clientOpt.isPresent()){
            throw new NullResponseNotFoundException("Data not available");
        }
        //Validar entrada
        return this.repositoryClient.save(clientOpt.get());
    }

    public void delete(Long id)throws NullResponseNotFoundException{
        Optional<Client> client = this.repositoryClient.findById(id);
        if(!client.isPresent()){
            throw new NullResponseNotFoundException("Data not available");
        }
        this.repositoryClient.deleteById(id); }
}
