/*
 * Classe criada para tratamento de exceções gerais
 */
package br.com.biblioteca.exception;

/**
 *
 * @author Régis
 */
public class ExceptionHandler extends Exception {
    
    public ExceptionHandler(String mensagem) {
        super(mensagem);
    }
}
