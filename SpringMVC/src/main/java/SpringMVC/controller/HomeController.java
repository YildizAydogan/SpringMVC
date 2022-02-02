package SpringMVC.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //sen kontrol sayfasısın
public class HomeController {

	
	
	@RequestMapping("/") // "/"-> get isteği ile anasyfada index i gör
	public String Home() { //basit bir metod yazalım
		return "index"; //properties deki eklediğimiz şey sayesinde 
		//index i gör dememiz, index.jsp ye	gelmesini sağlar
	}
}
//JSP (JavaServer Sayfaları)
//JSP, server da çalışan ve istemci tarafı dillerinde 
//(HTML, CSS, JavaScript, vb.) Şablon metni yazmanıza izin veren bir Java görünüm teknolojisidir . 
	
	
	
	

