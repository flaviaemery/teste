package teste;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReadSesFile {
	
	private static Scanner input;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		openFile();
		readRecords();
		closeFile();
	}
	
	public static void openFile()
	{
		try
		{
			Path source = Paths.get("/home/emery/projetos/statusses/arquivo/ses301.local.ping");
			input = new Scanner(source);
			input.useDelimiter(",");
		}
		catch (IOException ioException)
		{
			System.err.println("Erro ao abrir o arquivo. Finalizando.");
			System.exit(1);
		}
	}
	
	//lê o registro no arquivo
	public static void readRecords()
	{
		try
		{
			while (input.hasNext()) //enquanto houver mais para ler
			{
				System.out.printf("%s%n %s%n %s%n", input.next(), input.next(), input.next());
			}
			
		}
		catch (NoSuchElementException elementException)
		{
			System.err.println("Arquivo formado indevidamente. Finalizando.");
		}
		catch (IllegalStateException stateException)
		{
			System.err.println("Erro na leitura do arquivo. Finalizando.");
		}
	}
		// fim do método readRecords
		
		// fecha o arquivo e termina o aplicativo
		public static void closeFile()
		{
			if (input != null)
				input.close();
		}
}
