package teste;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReadTextFile {

	private static Scanner input;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		openFile();
		readRecords();
		closeFile();
	}
	
	// abre o arquivo clients.txt
	public static void openFile()
	{
		try
		{
			URI uri = new URI("file:/home/emery/projetos/clients.txt");
			input = new Scanner(Paths.get(uri));
		}
		catch (IOException ioException)
		{
			System.err.println("Error opening file. Terminating.");
			System.exit(1);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void readRecords()
	{
		System.out.println("Account");
		System.out.println("First Name");
		System.out.println("Last Name");
		System.out.println("Balance");
		
		try
		{
			while (input.hasNext()) // enquanto houver mais para ler
			{
				Object[] parametro = new Object[4];
				parametro[0] = new Integer(input.nextInt());
				parametro[1] = input.next();
				parametro[2] = input.next();
				parametro[3] = new Double (input.nextDouble());
				
				System.out.printf("%d %s %s %.2f%n", parametro);
			}
		}
		
		catch (NoSuchElementException elementException)
		{
			System.err.println("File improperly formed. Terminating.");
		}
		catch (IllegalStateException stateException)
		{
			System.err.println("Error reading from file. Terminating.");
		}
	}// fim do método readRecords
	
	// fecha o arquivo e termina o aplicativo
	public static void closeFile()
	{
		if (input != null)
			input.close();
	}
}// fim da classe readTextFile
