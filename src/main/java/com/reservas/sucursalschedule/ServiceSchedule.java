package com.reservas.sucursalschedule;

import com.reservas.error.NullResponseNotFoundException;
import com.reservas.table.RepositoryTable;
import com.reservas.table.TableRest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServiceSchedule {

    private final RepositorySchedule repositorySchedule;
    public List<Schedule> list(){ return this.repositorySchedule.findAll(); }

    public Schedule show(Long id)  throws NullResponseNotFoundException {
        Optional<Schedule> schedule = this.repositorySchedule.findById(id);
        if(!schedule.isPresent()){
            throw new NullResponseNotFoundException("Data not available");
        }
        return schedule.get(); }

    public Schedule create(Schedule schedule){ return this.repositorySchedule.save(schedule); }

    public Schedule edit(Schedule schedule) throws NullResponseNotFoundException {
        Optional<Schedule> schedul = this.repositorySchedule.findById(schedule.getId());
        if(!schedul.isPresent()){
            throw new NullResponseNotFoundException("Data not available");
        }
        //Validar entrada
        return this.repositorySchedule.save(schedul.get()); }

    public void delete(Long id) throws NullResponseNotFoundException {
        Optional<Schedule> schedule = this.repositorySchedule.findById(id);
        if(!schedule.isPresent()){
            throw new NullResponseNotFoundException("Data not available");
        }
        this.repositorySchedule.deleteById(id); }

}
