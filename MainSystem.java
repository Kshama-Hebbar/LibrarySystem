import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
public class MainSystem 
{
	
static String filename = null;
static Library lib = new Library();
static Scanner in=new Scanner(System.in);
static Boolean running=true;
public static void main(String[] args)
{
	while(running)
	{
		System.out.println("\nEnter 0 to load a library" +
	                       "\nEnter 1 to save and quit" +
				           "\nEnter 2 to list all books in library" + 
	                       "\nEnter 3 to add book to library" );
		int answer = in.nextInt();
		switch(answer)
		{
		case 0:
			System.out.println("Enter the filename to load");
			filename=in.next();
			loadScript(filename);
			break; 
		case 1:
			System.out.println("");
			saveAndQuit();
		    break;
		case 2:
			System.out.println(lib.toString());
			break;
		case 3:
			addBook();
			break;
			
		}
	}
	System.exit(0);
}
private static void addBook() {
	// TODO Auto-generated method stub
	 int isbn;
	 String title,author;
	 double price;
	 
	 System.out.println("\nEnter the title:");
	 title=in.next();
	 System.out.println("\nEnter the author:");
	 author=in.next();
	 System.out.println("\nEnter the ISBN:");
	 isbn=in.nextInt();
	 System.out.println("\nEnter the price:");
	 price=in.nextDouble();
	 
	 Book b= new Book(isbn,title,author,price);
	 lib.addBook(b);
}
private static void saveAndQuit() {
	// TODO Auto-generated method stub
System.out.println("Enter filename:");
filename = in.next()+".ser";
running = false;
FileOutputStream  fos=null;
ObjectOutputStream out=null;

try
{
	fos= new FileOutputStream(filename);
	out= new ObjectOutputStream(fos);
	out.writeObject(lib);
	fos.close();
	out.close();
	
}
catch(FileNotFoundException e)
{
	e.printStackTrace();
}
catch(IOException e)
{
	e.printStackTrace();
}
}
private static void loadScript(String name) {
	// TODO Auto-generated method stub
	FileInputStream fis= null;
	ObjectInputStream in =null;
	File file=new File(name + ".ser");
	if(file.exists()) {
	try
	{
	fis=new FileInputStream(file);
	in = new ObjectInputStream(fis);
	lib=(Library) in.readObject();
	fis.close();
	in.close();
	}
	catch(IOException e)
	{
		e.printStackTrace(); 
	}
	catch(ClassNotFoundException e)
	{
		e.printStackTrace();
	}
	}else
	{
		System.out.println("\nFile doesn't exist");
	}
}
}
