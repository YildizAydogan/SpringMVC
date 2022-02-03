package springbootCrud.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Kisiler")
@Data                // parametreli cons + getter setter  + to String yerine bu tek basina yeter
@NoArgsConstructor   // parametresiz cont icin de bunu yaptik
public class Kisi {
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)  //id otomatik olsun diye yaptik
	private Integer id;
	private String ad;
	private String soyad;
	private int yas;
	
	
	
	
	
}
