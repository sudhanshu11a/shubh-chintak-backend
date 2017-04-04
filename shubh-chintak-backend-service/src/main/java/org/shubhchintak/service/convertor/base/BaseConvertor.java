/**
 * 
 */
package org.shubhchintak.service.convertor.base;

/**
 * @author sudhanshusharma
 *
 */
public interface BaseConvertor<T, E> {

	public T entityToDTO(E e); 

	public E DTOToEntity(T t);
	
}
