/**
 * 
 */
package Interface;

import java.util.List;

/**
 * @author ajc
 *
 */
public interface ILectureFichiers {
	
	public List<T> findAll();
	
	public T findById(Long id);

}
