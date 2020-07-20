package ar.com.ada.api.nootflix.controllers;

import java.util.*;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ar.com.ada.api.nootflix.models.GenericResponse;

import ar.com.ada.api.nootflix.entities.*;
import ar.com.ada.api.nootflix.services.*;

@RestController
public class PeliculaController {

    @Autowired
    PeliculaService peliculaService;

    @PostMapping("/api/peliculas")
    public ResponseEntity<GenericResponse> crearPelicula(@RequestBody Pelicula peliInfo) {

        peliculaService.grabar(peliInfo);
        GenericResponse response = new GenericResponse();
        response.isOK = true;
        response.message = "Pelicula creada con exito!";
        response.id = peliInfo.get_id();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/api/peliculas")
    public ResponseEntity<List<Pelicula>> listarPeliculas() {

        return ResponseEntity.ok(peliculaService.listarPeliculas());
    }

    @GetMapping("/api/peliculas/{id}")
    public ResponseEntity<Pelicula> GetPelicula(@PathVariable String id) {

        ObjectId obId = new ObjectId(id);

        Pelicula p = peliculaService.buscarPorId(obId);
        if (p == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(p);

        // OBtener la pelicula.
    }
}
