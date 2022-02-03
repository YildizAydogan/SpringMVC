package springbootCrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import springbootCrud.model.Kisi;
import springbootCrud.repository.KisiRepository;

@Service    //@Servis sadece gevsek baglama icin kullanilir 
public class KisiService {
public static KisiRepository kisiRepository; //elci görevi yapiyor


   @Autowired
   public KisiService (KisiRepository kisiRepo) {
	kisiRepository= kisiRepo;
	//KisiService.kisiRepository = kisiRepositry;
	
	//static demezsek this. diyebiliriz  ..static olmak zorunda
	   
   }
	
	//veri tabanina kisi ekleyen service methodu eklemeliyiz
   public Kisi kisiEkle(Kisi kisi ) {   
	   return kisiRepository.save(kisi);  //repository sayesinde(jpa)  database e kisi verileri kaydoldu  
   }
	
   //database den tüm listeyi getir
   public List<Kisi> tumKisileriGetir(){
		return kisiRepository.findAll();
	}
   
   //id ile kisi silme
   
   public String idIleKisiSil(Integer id){
	if(kisiRepository.findById(id)==null) {
	throw new EmptyResultDataAccessException(id);	
		
	}  
	   kisiRepository.deleteById(id);
	
	   
	   return id + "id li kisi silindi";
	      
   }
   
   
   
	
}
