import java.io.Serializable;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

public class Library extends Object implements Serializable 
{
private static final long serialVersionUID = 1L;
private List<Book> collection;
public Library()
{
collection = new ArrayList<Book>();    
}

public void addBook(Book book)
{
	collection.add(book);
}
@Override
public String toString()
{
	String total ="\n";
	Iterator<Book> i= collection.iterator();
	while( i.hasNext())
	{
		Book b =(Book) i.next();
		total=total + b.toString();
	}
	return total;
}
}
