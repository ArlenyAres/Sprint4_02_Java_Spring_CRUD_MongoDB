package cat.itacademy.barcelonactiva.medina.arleny.s04.t02.n03.model.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "fruta")
public class Fruta {

    @Id
    private long id;
    private String nombre;
    private int cantidadKg;
}

