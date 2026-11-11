package com.alura.screenMatch;

import com.alura.screenMatch.model.DadosSerie;
import com.alura.screenMatch.service.ConsumoAPI;
import com.alura.screenMatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenMatchApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(ScreenMatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ConsumoAPI consumoAPI=new ConsumoAPI();
		var json=consumoAPI.obterDados("http://www.omdbapi.com/?t=gilmore+girls&apikey=26ef83b4");
//		System.out.println(json);
//		json=consumoAPI.obterDados("");
		ConverteDados conversor=new ConverteDados();
		DadosSerie dados=conversor.obterDados(json,DadosSerie.class);
		System.out.println(dados);
	}

}
