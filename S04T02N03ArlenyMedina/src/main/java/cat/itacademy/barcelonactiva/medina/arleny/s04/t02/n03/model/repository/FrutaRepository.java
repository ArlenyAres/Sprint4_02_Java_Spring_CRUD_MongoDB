package cat.itacademy.barcelonactiva.medina.arleny.s04.t02.n03.model.repository;


import cat.itacademy.barcelonactiva.medina.arleny.s04.t02.n03.model.domain.Fruta;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FrutaRepository extends MongoRepository<Fruta, Long> {

}
