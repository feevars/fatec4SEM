package controller;

import static org.lwjgl.openal.AL10.*;

public class OpenALException extends RuntimeException {

	private static final long serialVersionUID = -2790438490695129098L;
	
	OpenALException(int errorCode){
		
		super("Erro interno: " + (errorCode == AL_INVALID_NAME ? "Nome inválido" : errorCode == AL_INVALID_ENUM ? "Enum inválido" : errorCode == AL_INVALID_VALUE ? "Valor inválido" : errorCode == AL_INVALID_OPERATION ? "Operação Inválida" : "Erro desconhecido.") + "OpenAL Exception.");
	}

}
