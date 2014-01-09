package br.com.guardiao.facade;

import java.io.Serializable;
import java.util.List;

public interface BaseFacade<T> extends Serializable {
	public abstract void salva(T t); 
	
	public abstract void remove(T t);  
	
	public abstract T procura(Long id);  

    public abstract void atualiza(T t);

    public abstract List<T> lista();
    
}