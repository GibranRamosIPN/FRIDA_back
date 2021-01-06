package com.escom.FRIDA_BackEnd.Repository;

import com.escom.FRIDA_BackEnd.Entity.Brigadista;
import java.util.List;
import org.springframework.data.repository.Repository;

public interface BrigadistaRepository extends Repository<Brigadista, Integer> {
    List<Brigadista>findAll();
    //Brigadista findOne(int idBrigadista);
    Brigadista save(Brigadista b);
    void delete(Brigadista b);
}
