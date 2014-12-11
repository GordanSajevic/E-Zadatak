package lab22;

public class DatumTest {

	/**
	 * Funkcija prima niz datuma i sortira datume
	 * @param nizDatuma
	 * @return nizDatuma
	 */
	
	private static Datum[] sortirajDatume (Datum[] nizDatuma)
	{
		for (int i = 0; i < nizDatuma.length-1; i++) 
		{
			for (int j = i + 1; j < nizDatuma.length; j++) 
			{
				if (nizDatuma[i].compare(nizDatuma[j]) == 1) 
				{
					Datum pomocna = new Datum(nizDatuma[i]);
					nizDatuma[i] = new Datum(nizDatuma[j]);
					nizDatuma[j] = new Datum(pomocna);
				}
			}
		}		
		return nizDatuma;
	}
	
	/**
	 * Funkcija kreira niz od 50 random datuma i vraća taj niz 
	 * @return datum
	 */
	
	private static Datum[] izmisliDatume()
	{
		Datum[] datum = new Datum[50];
		for (int i=0; i<50; i++)
		{
			datum[i] = new Datum();
			datum[i].setMjesec(1 + (int)(Math.random()*12));
			if (datum[i].getMjesec() == 2)
			{
				datum[i].setDan(1 + (int)(Math.random()*28)) ;
			}
			else if (datum[i].getMjesec() == 4 && datum[i].getMjesec() == 6 && datum[i].getMjesec() == 9 && datum[i].getMjesec() == 11)
			{
				datum[i].setDan(1 + (int)(Math.random()*30));
			}
			else
			{
				datum[i].setDan(1 + (int)(Math.random()*31));
			}
		}
		
		return datum;
	}
	
	public static void ispisiDatume() 
	{
		Datum[] datum = izmisliDatume();
		datum = sortirajDatume(datum);
		System.out.println(datum[0].toString() +  " 0 dana od prethodnog " + razlikaDatuma(datum[0], datum[1]) + " dana do sljedeceg.");
		for (int i = 1; i < datum.length - 1; i++) 
		{
			System.out.println(datum[i].toString() + " " + razlikaDatuma(datum[i - 1], datum[i]) + " dana od prethodnog " + razlikaDatuma(datum[i], datum[i + 1]) + " dana do sljedeceg.");
		}
		System.out.println(datum[datum.length - 1].toString() + " "+ razlikaDatuma(datum[datum.length-2], datum[datum.length - 1]) + " dana od prethodnog " + " 0 dana do sljedeceg.");
	}
	
	/**
	 * Funkcija prima dva datuma i ispisuje razliku datuma u danima
	 * @param datum1
	 * @param datum2
	 * @return razlikaDana
	 */
	
	public static int razlikaDatuma(Datum datum1, Datum datum2) 
	{
		int razlikaDana = 0;
		if (datum1.getMjesec() == datum2.getMjesec()) 
		{
			razlikaDana = datum2.getDan() - datum1.getDan();
		}
		if (datum1.getMjesec() < datum2.getMjesec()) 
		{
			if (datum2.getMjesec() == 4 || datum2.getMjesec() == 6 || datum2.getMjesec() == 9 || datum2.getMjesec() == 11) 
			{
				razlikaDana = (30 - datum1.getDan()) + datum1.getDan();
			} 
			else if(datum1.getMjesec() == 2) 
			{	
				razlikaDana = (28 - datum1.getDan()) + datum2.getDan();
			}
			else
			{
				razlikaDana = (31 - datum1.getDan()) + datum2.getDan();
			}
		} 
		return razlikaDana;
	}
	
	public static void main(String[] args) {
		Datum prviDatum = new Datum(10, 12, 2014);
		Datum drugiDatum = new Datum(prviDatum);
		prviDatum.setDan(15);
		System.out.println(prviDatum.toString());
		System.out.println(drugiDatum.toString());
		if (prviDatum.equals(drugiDatum) == true)
		{
			System.out.println("Jednaki");
		}
		else
		{
			System.out.println("Različiti");
		}
		System.out.println(prviDatum.compare(drugiDatum));
		ispisiDatume();

	}

}


