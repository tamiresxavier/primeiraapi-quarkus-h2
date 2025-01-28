package acc.br.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

@Entity
public class Fruta extends PanacheEntity {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    public String nome;
    public int quantidade;
    
}