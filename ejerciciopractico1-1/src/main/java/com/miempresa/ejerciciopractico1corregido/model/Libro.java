package com.miempresa.ejerciciopractico1corregido.model;

public class Libro {
	
	private static int nextId = 1;
	private int id;
	private int cantidad;
	private String autor;
	private String titulo;
	private String genero;
	
	private static Libro[] biblioteca = {
		    new Libro(5, "Gabriel García Márquez", "Cien años de soledad", "Realismo mágico"),
		    new Libro(3, "George Orwell", "1984", "Distopía"),
		    new Libro(4, "J.K. Rowling", "Harry Potter y la piedra filosofal", "Fantasía"),
		    new Libro(2, "J.R.R. Tolkien", "El Señor de los Anillos", "Fantasía épica"),
		    new Libro(6, "Jane Austen", "Orgullo y prejuicio", "Romance"),
		    new Libro(5, "F. Scott Fitzgerald", "El gran Gatsby", "Drama"),
		    new Libro(7, "Miguel de Cervantes", "Don Quijote de la Mancha", "Clásico"),
		    new Libro(4, "Franz Kafka", "La metamorfosis", "Filosofía / Existencialismo"),
		    new Libro(3, "Harper Lee", "Matar a un ruiseñor", "Ficción social"),
		    new Libro(6, "Ernest Hemingway", "El viejo y el mar", "Aventura"),
		    new Libro(5, "Leo Tolstói", "Guerra y paz", "Histórico"),
		    new Libro(4, "Mark Twain", "Las aventuras de Tom Sawyer", "Aventura"),
		    new Libro(3, "Albert Camus", "El extranjero", "Filosofía / Existencialismo"),
		    new Libro(7, "Antoine de Saint-Exupéry", "El principito", "Fábula / Filosofía"),
		    new Libro(5, "Paulo Coelho", "El alquimista", "Ficción espiritual"),
		    new Libro(6, "Homero", "La Odisea", "Épico"),
		    new Libro(3, "Victor Hugo", "Los miserables", "Drama histórico"),
		    new Libro(4, "Mary Shelley", "Frankenstein", "Terror / Ciencia ficción"),
		    new Libro(5, "Arthur Conan Doyle", "Sherlock Holmes: Estudio en escarlata", "Misterio"),
		    new Libro(4, "Oscar Wilde", "El retrato de Dorian Gray", "Filosofía / Drama"),
		    new Libro(6, "Charles Dickens", "Oliver Twist", "Drama social"),
		    new Libro(5, "Herman Melville", "Moby Dick", "Aventura / Filosofía"),
		    new Libro(3, "Dante Alighieri", "La Divina Comedia", "Poesía / Religión"),
		    new Libro(4, "George R.R. Martin", "Juego de Tronos", "Fantasía épica"),
		    new Libro(7, "Sun Tzu", "El arte de la guerra", "Estrategia / Filosofía")
		};
	
	public static Libro getLibroById(int id) {
		for(Libro libro : biblioteca) {
			if (libro.id == id) {
				return libro;
			}
		}
		
		return null;
	}
	
	public Libro(int cantidad, String autor, String titulo, String genero) {
		this.id = nextId++;
		this.cantidad = cantidad;
		this.autor = autor;
		this.titulo = titulo;
		this.genero = genero;
		
	}

	public int getId() {
		return id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public String getAutor() {
		return autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getGenero() {
		return genero;
	}

	public static Libro[] getBiblioteca() {
		return biblioteca;
	}		
	
}
