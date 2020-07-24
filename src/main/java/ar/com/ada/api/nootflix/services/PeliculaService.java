package ar.com.ada.api.nootflix.services;

import java.util.List;

import org.bson.types.ObjectId;
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

    public Pelicula buscarPorId(ObjectId id) {
        return pRepository.findBy_id(id);
    }
    public boolean eliminarPelicula(ObjectId id) {
        pRepository.deleteById(id);
        return true;
    }
}