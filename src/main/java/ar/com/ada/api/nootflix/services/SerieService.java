package ar.com.ada.api.nootflix.services;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.nootflix.entities.Serie;
import ar.com.ada.api.nootflix.repos.SerieRepository;

@Service
public class SerieService {

    @Autowired
    SerieRepository sRepository;

    public void grabar(Serie serie) {
        sRepository.save(serie);
    }

    public List<Serie> listarSeries() {
        return sRepository.findAll();
    }

    public Serie buscarPorId(ObjectId id) {
        return sRepository.findBy_id(id);
    }
}
