/**
 * 
 */
package Interface;

import java.io.IOException;
import java.util.List;

/**
 * @author ajc
 *
 */
public interface ILectureFichiers<T> {
	
	public List<T> findAll() throws IOException;
	
	public T findById(Integer id) throws IOException;

}
