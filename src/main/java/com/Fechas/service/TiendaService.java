package com.Fechas.service;


import com.Fechas.dao.TiendaRepository;
import com.Fechas.entity.Tienda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TiendaService {

    @Autowired
    TiendaRepository tiendaRepository;

    public List<Tienda> list(){return tiendaRepository.findAll();}

    public void save(Tienda tienda){tiendaRepository.save(tienda);}

    public void delete(long id){tiendaRepository.deleteById(id);}

    public boolean existsById(long id){return tiendaRepository.existsById(id);}

    public Optional<Tienda> getOne(long id){return tiendaRepository.findById(id);}

}
