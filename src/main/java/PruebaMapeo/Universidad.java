package PruebaMapeo;

import java.util.List;

import com.trabajofinal.models.Poliza;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Universidad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_poliza")
	private int id;
	
	private String nombre;
	
	@OneToMany(mappedBy = "universidad")
    private List<Estudiante> estudiantes;
	
	public Universidad() {
		
	}
	
}
