package com.reservas.sucursalmap;

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
public class ServiceMap {

    private final RepositoryMap repositoryMap;

    @Transactional(readOnly = true)
    public List<Maps> list(){ return this.repositoryMap.findAll(); }

    @Transactional(readOnly = true)
    public Maps show(Long id) throws NullResponseNotFoundException  {
        Optional<Maps> maps =this.repositoryMap.findById(id);
        if(!maps.isPresent()){
            throw new NullResponseNotFoundException("Data not available");
        }
        return maps.get(); }

    @Transactional
    public Maps create(Maps maps){ return this.repositoryMap.save(maps); }

    @Transactional
    public Maps edit(Maps maps) throws NullResponseNotFoundException {
        Optional<Maps> map =this.repositoryMap.findById(maps.getId());
        if(!map.isPresent()){
            throw new NullResponseNotFoundException("Data not available");
        }
        if(maps.getName() != null && !maps.getName().isEmpty()){
            map.get().setName(maps.getName());
        }
        if(maps.getDescription() != null && !maps.getDescription().isEmpty()){
            map.get().setDescription(maps.getDescription());
        }
        return this.repositoryMap.save(map.get()); }

    @Transactional
    public void delete(Long id) throws NullResponseNotFoundException {
        Optional<Maps> maps =this.repositoryMap.findById(id);
        if(!maps.isPresent()){
            throw new NullResponseNotFoundException("Data not available");
        }
        this.repositoryMap.deleteById(id); }

}
