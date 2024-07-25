package cat.itacademy.barcelonactiva.medina.arleny.s04.t02.n03.model.services;


import cat.itacademy.barcelonactiva.medina.arleny.s04.t02.n03.exceptions.FrutaNotFoundException;
import cat.itacademy.barcelonactiva.medina.arleny.s04.t02.n03.model.domain.Fruta;
import cat.itacademy.barcelonactiva.medina.arleny.s04.t02.n03.model.repository.FrutaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FrutaService {

    @Autowired
    private FrutaRepository frutaRepository;

    public List<Fruta> getAllFrutas() {
        return frutaRepository.findAll();
    }

    public Fruta getFrutaById(long id) {
        return frutaRepository.findById(id)
                .orElseThrow(() -> new FrutaNotFoundException("Fruta not found with id: " + id));
    }

    public Fruta addFruta(Fruta fruta) {
        return frutaRepository.save(fruta);
    }

    public Fruta updateFruta(long id, Fruta newFrutaData) {
        Fruta oldFrutaData = frutaRepository.findById(id)
                .orElseThrow(() -> new FrutaNotFoundException("Fruta not found with id: " + id));

        oldFrutaData.setNombre(newFrutaData.getNombre());
        oldFrutaData.setCantidadKg(newFrutaData.getCantidadKg());
        return frutaRepository.save(oldFrutaData);
    }

    public void deleteFruta(long id) {
        if (!frutaRepository.existsById(id)) {
            throw new FrutaNotFoundException("Fruta not found with id: " + id);
        }
        frutaRepository.deleteById(id);
    }
}
