package utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Questa classe gestisce i dati di input: legge e trasforma nel tipo corretto
 * pu� utilizzare dei metodi di classe -> static
 * @author robyM
 */
public abstract class ConsoleApp {

	private Scanner kbd;
	
	public ConsoleApp() {
		kbd = new Scanner(System.in);
	}
	
	
	public static String readFile(String path)
	{
		String ris = "";
		
		Scanner kbd = null; 
		try 
		{
			kbd = new Scanner(new File(path));
			while(kbd.hasNextLine())
				ris += kbd.nextLine() + "\n";
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				kbd.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return ris;
	}
	
	/**
	 * Shortcut per System.out.println(Object obj)
	 * @param obj l'oggetto da stampare a console
	 */
	public static void print(Object obj) {
		System.out.println(obj.toString());
	}
	
	/**
	 * Stampa il msg in console e legge la riga inserita che potr� essere
	 * direttamente salvata in una variabile String
	 * @param msg il messaggio da stampare su console per prendere poi l'output
	 * @return il valore inserito da tastiera che viene restituito
	 */
	public String nextLine(String msg) {
		print(msg);
		return kbd.nextLine();
	}
	
	/**
	 * Dato il msg di richiesta e il messaggio di errore
	 * fa inserire l'input finch� questo non � un numero intero
	 * @param msg il messaggio da stampare su console per prendere poi l'input
	 * @param errorMsg il messaggio di errore da stampare nel caso non sia
	 * 					stato possibile parsare ad in il valore inserito
	 * 					da tastiera
	 * @return il valore inserito da tastiera parsato ad int
	 */
	public int nextInt(String msg, String errorMsg) {
		boolean valid = false;
		int ris = 0;
		
		do {
			String value = nextLine(msg);
			
			try {
				ris = Integer.parseInt(value);
				
				valid = true;
			} catch (NumberFormatException e) {
				print(errorMsg);
			}
		} while (!valid);
		
		return ris;
	}
	
	/**
	 * Dato il msg di richiesta e il messaggio di errore
	 * fa inserire l'input finch� questo non � un numero intero
	 * @param msg il messaggio da stampare su console per prendere poi l'input
	 * @param errorMsg il messaggio di errore da stampare nel caso non sia
	 * 					stato possibile parsare ad in il valore inserito
	 * 					da tastiera
	 * @param minValue il valore minimo che potr� assumere l'intero inserito
	 * @param maxValue il valore massimo che potr� assumerre l'intero inserito
	 * @return il valore inserito da tastiera parsato ad int e se � compreso
	 * 			tra minValue e maxValue
	 */
	public int nextInt(String msg, String errorMsg, int minValue, int maxValue) {
		boolean valid = false;
		int ris = 0;
		
		do {
			ris = nextInt(msg, errorMsg);
			
			if (ris >= minValue && ris <= maxValue) {
				valid = true;
			} else {
				print("Inserire un valore compreso tra " + minValue + " e " + maxValue);
			}
		} while (!valid);
		
		return ris;
	}
	
	
	/**
	 * Dato il msg di richiesta e il messaggio di errore
	 * fa inserire l'input finch� questo non � un numero double
	 * @param msg il messaggio da stampare su console per prendere poi l'input
	 * @param errorMsg il messaggio di errore da stampare nel caso non sia
	 * 					stato possibile parsare ad in il valore inserito
	 * 					da tastiera
	 * @return il valore inserito da tastiera parsato ad double
	 */
	public double nextDouble(String msg, String errorMsg) {
		boolean valid = false;
		double ris = 0;
		
		do {
			String value = nextLine(msg);
			
			try {
				ris = Double.parseDouble(value);
				
				valid = true;
			} catch (NumberFormatException e) {
				print(errorMsg);
			}
		} while (!valid);
		
		return ris;
	}
	
	/**
	 * L'utente inserir� un valore in stringa. A seconda di cosa inserisce verr� restituito true/false
	 * True se la stringa corrisponde a trueValue, false se corrisponde a falseValue.
	 * Se inserisce qualsiasi altro valore, richiedo l'input
	 * @param msg il messaggio da stampare su console per prendere poi l'input
	 * @param errorMsg il messaggio di errore da stampare nel caso il valore inserito
	 * 					non corrisponda n� al trueValue n� al falseValue
	 * @param trueValue la stringa a cui deve corrispondere il valore inserito per fare restituire
	 * 					il valore true
	 * @param falseValue la stringa a cui deve corrispondere il valore inserito per fare restituire
	 * 					il valore false
	 * @return true o false
	 */
	public boolean nextBoolean(String msg, String errorMsg, String trueValue, String falseValue) {
		while (true) {
			String value = nextLine(msg);
			
			if (value.equalsIgnoreCase(trueValue)) {
				return true;
			} else if (value.equalsIgnoreCase(falseValue)) {
				return false;
			}
			
			print(errorMsg);
		}
	}
	
	
	/**
	 * Tutta la logica del programma in questo metodo.
	 * Tutte le console app saranno obbligate a fornire l'implementazione del metodo abstract
	 */
	public abstract void run();
	
	
	
	
	/* ------------------------------------------------------------- */
	public static int getInt(String input)
	{
		try 
		{
			return Integer.parseInt(input);
		}
		catch(NumberFormatException n)
		{
			System.err.println(input + " non � un numero");
			return 0;
		}
	}
	
	public static int getInt(String input, int min, int max)
	{
		try 
		{
			int in = Integer.parseInt(input);
			if(in >= min && in <= max)
				return in;
			return 0;
		}
		catch(NumberFormatException n)
		{
			System.err.println(input + " non � un numero");
			return 0;
		}
	}
	
	public static double getDouble(String input)
	{
		try 
		{
			return Double.parseDouble(input);
		}
		catch(NumberFormatException n)
		{
			System.err.println(input + " non � un numero");
			return 0;
		}
	}
	
	public static double getDouble(String input, double min, double max)
	{
		try 
		{
			double in = Double.parseDouble(input);
			if(in >= min && in <= max)
				return in;
			return 0;
		}
		catch(NumberFormatException n)
		{
			System.err.println(input + " non � un numero");
			return 0;
		}
	}
	
	public static Date getData(String input)
	{
		try {
			return Date.valueOf(input);
		}
		catch(Exception e)
		{
			System.err.println(input + " non � una data");
			return null;
		}
	}
	
	public static boolean getBoolean(String input) {
		if (input.equalsIgnoreCase("1")) {
			return Boolean.parseBoolean("true");
		} else if (input.equalsIgnoreCase("0")) {
			return Boolean.parseBoolean("false");
		} else {
			System.err.println(input + " non � un boolean");
			return false;
		}
	}
	
	
	public static Map<String,String> readMap(String path)
	{
		String file = readFile(path);
		Map<String,String> mappa = new LinkedHashMap<String,String>();
		for(String riga : file.split("\n")) //read:select * from anagrafica;
		{
			String[] parti = riga.split(":"); //parti[0]: read - parti[1]: select * from anagrafica;
			mappa.put(parti[0], parti[1]);
		}
		return mappa;
	}
	
	public static Map<String, String> readQuery(String path) {
		Map<String, String> map = new LinkedHashMap<String, String>();
		String file = readFile(path);

		for (String row : file.split("\n")) {
		    String[] parti = row.split(":");
		    map.put(parti[0], parti[1]);
		}
		return map;
	    }

}    /***********************   end  ConsoleApp   ********************************************/