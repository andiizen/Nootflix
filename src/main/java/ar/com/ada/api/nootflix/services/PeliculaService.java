package ar.com.ada.api.nootflix.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.nootflix.entities.Pelicula;
import ar.com.ada.api.nootflix.repos.PeliculaRepository;

@Service
public class PeliculaService {

    @Autowired
    PeliculaRepository pRepository;

    public void grabar(Pelicula pelicula) {
        pRepository.save(pelicula);
    }

    public List<Pelicula> listarPeliculas() {
        return pRepository.findAll();
    }
}