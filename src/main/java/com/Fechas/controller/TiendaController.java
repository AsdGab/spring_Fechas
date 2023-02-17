package com.Fechas.controller;

import com.Fechas.dto.Mensaje;
import com.Fechas.dto.TiendaDto;
import com.Fechas.entity.Tienda;
import com.Fechas.service.TiendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tienda")
@CrossOrigin
public class TiendaController {

    @Autowired
    TiendaService tiendaService;

    @GetMapping("/listado")
    public ResponseEntity<List<Tienda>> List() {
        List<Tienda> lista = tiendaService.list();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody TiendaDto tiendaDto) {
        tiendaService.save(new Tienda(tiendaDto.getNombre(), tiendaDto.getFecha(), tiendaDto.getHora()));
        return new ResponseEntity<>(new Mensaje("La tienda ha sido creada"), HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody TiendaDto tiendaDto) {
        if (!tiendaService.existsById(id))
            return new ResponseEntity<>(new Mensaje("La tienda no existe"), HttpStatus.OK);

        Tienda tienda = tiendaService.getOne(id).get();
        tienda.setNombre(tiendaDto.getNombre());
        tienda.setFecha(tiendaDto.getFecha());
        tienda.setHora(tiendaDto.getHora());

        tiendaService.save(tienda);
        return new ResponseEntity<>(new Mensaje("La tienda ha sido actualizada"), HttpStatus.OK);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")long id) {
        if(tiendaService.existsById(id))
            return new ResponseEntity<>(new Mensaje("La tienda no existe"), HttpStatus.NOT_FOUND);
        tiendaService.delete(id);
        return new ResponseEntity<>(new Mensaje("La tienda ha sido borrada"), HttpStatus.OK);
    }
}
