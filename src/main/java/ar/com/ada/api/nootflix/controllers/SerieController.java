package ar.com.ada.api.nootflix.controllers;

import java.util.*;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ar.com.ada.api.nootflix.models.GenericResponse;

import ar.com.ada.api.nootflix.entities.*;
import ar.com.ada.api.nootflix.services.*;

@RestController
public class SerieController {

    @Autowired
    SerieService serieService;

    @PostMapping("/api/series")
    public ResponseEntity<GenericResponse> crearSerie(@RequestBody Serie serieInfo) {

        serieService.grabar(serieInfo);
        GenericResponse response = new GenericResponse();
        response.isOK = true;
        response.message = "Serie creada con exito!";
        response.id = serieInfo.get_id();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/api/series")
    public ResponseEntity<List<Serie>> listarSeries() {

        return ResponseEntity.ok(serieService.listarSeries());
    }

    // En SerieController.java/Netflyx.java este GET en base a un Id de tipo String
    // transforma a un ObjectId
    @GetMapping("/api/series/{id}")
    public ResponseEntity<Serie> GetSerie(@PathVariable String id) {

        ObjectId obId = new ObjectId(id);

        Serie s = serieService.buscarPorId(obId);
        if (s == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(s);

        // OBtener la serie.
    }

    @DeleteMapping("api/series/{id}")
    public ResponseEntity<GenericResponse> borrarSerie(@PathVariable String id) {

        ObjectId obId = new ObjectId(id);
        GenericResponse resp = new GenericResponse();

        boolean resultado = false;
        resultado = serieService.eliminarSerie(obId);

        if (resultado) {

            resp.isOK = true;
            resp.message = "Fue eliminada con exito";
            return ResponseEntity.ok(resp);

        }
        resp.isOK = false;
        resp.message = "No se pudo eliminar la Serie";
        return ResponseEntity.ok(resp);
    }
}