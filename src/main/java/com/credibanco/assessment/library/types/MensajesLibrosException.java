package com.credibanco.assessment.library.types;

public enum MensajesLibrosException {
	
	LIBRO_NO_EXISTE(10001, "Libro no existe");
	
	private int codigo;
	private String mensaje;
	
	private MensajesLibrosException(int codigo, String mensaje) {
		this.codigo = codigo;
		this.mensaje = mensaje;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getMensaje() {
		return mensaje;
	}
	
}
