package teste;

import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CreateTextFile {
	
	private static Formatter output;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		openFile();
		addRecords();
		closeFile();
	}
	
	//abre o arquivo clients.txt
	public static void openFile()
	{
		try
		{
			output = new Formatter ("/home/emery/projetos/clients.txt"); //abre o arquivo
		}
		catch (SecurityException securityException)
		{
			System.err.println("Write permission denied. Terminating.");
			System.exit(1);
		}
		catch (FileNotFoundException fileNotFoundException)
		{
			System.err.println("Error opening file. Terminating.");
			System.exit(1);
		}
	}

	//adiciona registros ao arquivo
	public static void addRecords()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter account number, first name, last name and balance.");
		System.out.println("Enter end-of-file indicator to end input.");

		
		while (input.hasNext())
		{
			try
			{
				//gera saída do novo registro para o arquivo: supõe entrada válida
				
				Object[] parametro = new Object[4];
				parametro[0] = new Integer(input.nextInt());
				parametro[1] = input.next();
				parametro[2] = input.next();
				parametro[3] = new Double (input.nextDouble());
				
				output.format("%d %s %s %.2f%n", parametro);
				
			}
			catch (FormatterClosedException formatterClosedException)
			{
				System.err.println("Error writing to file. Terminating.");
				break;
			}
			catch (NoSuchElementException elementException)
			{
				System.err.println("Invalid input. Please try again.");
				input.nextLine();
			}
			
			System.out.print("? ");
		} // fim do while
	} // fim do método addRecords
	
	//fecha o arquivo
	public static void closeFile()
	{
		if (output != null)
			output.close();
	}
}
