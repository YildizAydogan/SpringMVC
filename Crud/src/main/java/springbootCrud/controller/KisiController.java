package springbootCrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import springbootCrud.model.Kisi;
import springbootCrud.service.KisiService;



@RestController //parent/ana controllerdir.Tüm hepsini kapsasin diye bunu yazdik
                //her türlü mapping kullanilabilir bu anotasyonla

public class KisiController {

	
	public KisiService kisiService;
	  
	
	@Autowired//biz yazınca değil lazım olduğunda oluştur. alttaki gibi yaparak sıkı sıkı
	//bağlanmalarını engelledik, yeri geldiğinde birbirinden bağımsız olsun diye.
	//dependency injection yaptık, controller ın içine service yi injekte ettik
	public KisiController(KisiService kisiServ) {
		this.kisiService=kisiServ;
		
		
	}
	
	@GetMapping(path="/kisiler")  //bu bir get islemi oldugu icin @RequestMapping yerine (butun mappingleri kapsayan anatasyon)
	//degilde get islemine ozel olan QGetMapping anotasyonunu kullandik
	public List<Kisi>fetchPerson(){

    //kisiService classindaki tüm kisileri getir methoduna git, 
    //o da database den tüm verileri döndürsün
	 	return kisiService.tumKisileriGetir();
	
	}
	
	
	
	@PostMapping(path="/kisiler/ekle")
	public Kisi addPerson(@RequestBody Kisi kisi) {
		return kisiService.kisiEkle(kisi);
		
	}
	
	
	@DeleteMapping(path="/kisiler/sil/{id}") //frontend e id girerek sil butonuna basmak =
	// ="/kisiler/sil/{id}" <-bunu localhosta yazmak demektir
	public String deletePersonWithId(@PathVariable Integer id) {
		
		return kisiService.idIleKisiSil(id);
	}
	
	
	
	
}
