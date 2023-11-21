package PruebaMapeo;

import com.trabajofinal.utils.EntityManagerUtil;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Estudiante {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_estudiantes")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="id_universidad")
	private Universidad universidad;
	
	public Estudiante() {
		
	}
	
}