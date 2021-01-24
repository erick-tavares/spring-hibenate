package br.com.curso.springhibernate.service.exception;

public class DataBaseException extends RuntimeException{

    public DataBaseException(String msg){
        super(msg);
    }
}
