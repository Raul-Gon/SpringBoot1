package com.miempresa.ejerciciopractico1corregido.controller;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	private Random random = new Random();	
	private String[] listaDeProverbios = {
			"El conocimiento es como la ropa interior, no se ve pero es importante .", 
			"No temas al oponente con forma de tigre, teme a tus compañeros de equipo con forma de cerdo .", 
			"Puedes vivir como un cerdo, pero nunca podrás ser tan feliz como uno ." ,
			"El salario es como la menstruación: llega una vez al mes y desaparece en una semana .", 
			"Una hoja delante de los ojos impide ver la montaña de Tai Shan ." ,
			"Las grandes almas tienen voluntad; las débiles solo tienen deseos .", 
			"No puedes evitar que los pájaros de la tristeza vuelen sobre tu cabeza, pero sí puedes evitar que aniden en tu cabello .", 
			"El agua hace flotar un barco, pero también puede hundirlo ." ,
			"Antes de que un dragón pueda nacer, tiene que sufrir como una hormiga .", 
			"Si no quieres que se sepa, no lo hagas ."
	};
	private String[] proverbiosEnChino = {
				"知识就像内衣，看不见，但很重要。",
			  "不要怕像老虎一样的对手，要怕像猪一样的队友。",
			  "你可以像猪一样生活，但永远不会像猪那样快乐。",
			  "工资就像月经，一个月来一次，一个星期就没了。",
			  "眼前一片叶子，看不见泰山。",
			  "伟大的灵魂有意志，弱小的只有欲望。",
			  "你无法阻止悲伤的鸟儿从你头上飞过，但可以不让它们在你头上筑巢。",
			  "水能载舟，亦能覆舟。",
			  "龙出生之前，必须像蚂蚁一样受苦。",
			  "如果不想让别人知道，就不要去做。"
	};
	
	private String[] dameUnProverbioChino() {
		int indiceRandom = random.nextInt(listaDeProverbios.length);
		String[] resultado = {
				listaDeProverbios[indiceRandom],
				proverbiosEnChino[indiceRandom]
		};
		return resultado;
	}
	
	@GetMapping({"", "/", "/home"})
	public String homeHandler(Model model) {		
		model.addAttribute("titulo", "Primer HOME");
		model.addAttribute("cabecera", "Primer home en Sprin Boot");
		model.addAttribute("proverbio", dameUnProverbioChino());		
		
		return "home/home";
	}

}
