package com.reservas.booking;

import com.reservas.error.NullResponseNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceBooking {

    @Autowired
    private final RepositoryBooking repositoryBooking;

    @Autowired
    public ServiceBooking (RepositoryBooking repositoryBooking){
        this.repositoryBooking = repositoryBooking;
    }

    public List<Booking> list(){
        return this.repositoryBooking.findAll();
    }

    public Booking show(Long id) throws NullResponseNotFoundException {
        Optional<Booking> booking=  this.repositoryBooking.findById(id);
        if (!booking.isPresent()){
            throw new NullResponseNotFoundException("Data not available");
        }
        return booking.get();
    }

    public Booking create(Booking booking){
        return this.repositoryBooking.save(booking);
    }

    public Booking edit(Booking booking){
        return this.repositoryBooking.save(booking);
    }

    public void delete(Long id){
        this.repositoryBooking.deleteById(id);
    }
}
