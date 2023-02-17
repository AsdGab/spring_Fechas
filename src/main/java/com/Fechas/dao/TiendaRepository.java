package com.Fechas.dao;

import com.Fechas.entity.Tienda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin
public interface TiendaRepository extends JpaRepository<Tienda, Long> {
    public boolean existsById(long id);
}
