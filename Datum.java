package lab19;

public class Datum {
	private int dan;
	private int mjesec;
	private int godina;
	
	/**
	 * Konstruktor kreira objekat Datum
	 */
	
	public Datum()
	{
		dan = 1;
		mjesec = 1;
		godina = 2014;
	}
	
	/**
	 * Konstruktor prima tri int broja i kreira objekat Datum
	 * @param postaviDan
	 * @param postaviMjesec
	 * @param postaviGodinu
	 */
	
	public Datum(int postaviDan, int postaviMjesec, int postaviGodinu)
	{
		dan = postaviDan;
		mjesec = postaviMjesec;
		godina = postaviGodinu;
	}
	
	/**
	 * Funkcija je getter, tj. omogućava pristup varijabli dan iako je varijabla private
	 * @return dan
	 */
	
	public int getDan()
	{
		return dan;
	}
	
	/**
	 * Funkcija je getter, tj. omogućava pristup varijabli mjesec iako je varijabla private
	 * @return mjesec
	 */
	
	public int getMjesec()
	{
		return mjesec;
	}
	
	/**
	 * Funkcija je getter, tj. omogućava pristup varijabli godina iako je varijabla private
	 * @return godina
	 */
	
	public int getGodina()
	{
		return godina;
	}
	
	/**
	 * Funkcija je setter, tj. omogućava provjeru private varijable dan
	 * @param noviDan
	 */
	
	public void setDan(int dan)
	{
		if (dan < 0 || dan > 31)
		{
			throw new IllegalArgumentException("Dan nije u validnom intervalu: ");
		}
		else
		{
			this.dan = dan;
		}
	}
	
	/**
	 * Funkcija je setter, tj. omogućava provjeru private varijable mjesec
	 * @param noviMjesec
	 */
	
	public void setMjesec(int mjesec)
	{
		if (mjesec < 0 || mjesec > 12)
		{
			throw new IllegalArgumentException("Mjesec nije u validnom intervalu: ");
		}
		else
		{
			this.mjesec = mjesec;
		}
	}
	
	/**
	 * Funkcija je setter, tj. omogućava provjeru private varijable godina
	 * @param noviGodina
	 */
	
	public void setGodina(int godina)
	{
		if (godina < 1900 || godina > 2014)
		{
			throw new IllegalArgumentException("Godina nije u validnom intervalu: ");
		}
		else
		{
			this.godina = godina;
		}
	}
	
	/**
	 * Funkcija pretvara datum u jedan string i vraća taj string
	 */
	
	public String toString()
	{
		String strDatum = "";
		strDatum = dan + "/" + mjesec + "/" + godina;
		return strDatum;
	}
	
	public String toString(Datum datum)
	{
		String strDatum = "";
		strDatum = datum.dan + "/" + datum.mjesec + "/" + datum.godina;
		return strDatum;
	}
	
	
	public Datum(Datum other)
	{
		this.dan = other.dan;
		this.mjesec = other.mjesec;
		this.godina = other.godina;
	}
	
	public boolean equals(Datum datum)
	{
		if (this.dan == datum.dan && this.mjesec == datum.mjesec && this.godina == datum.godina)
		{
			return true;
		}
		return false;
	}
	
	public int compare(Datum datum)
	{
		if (this.godina < datum.godina)
		{
			return -1;
		}
		else if (this.godina > datum.godina)
		{
			return 1;
		}
		else
		{
			if (this.mjesec < datum.mjesec)
			{
				return -1;
			}
			else if (this.mjesec > datum.mjesec)
			{
				return 1;
			}
			else
			{
				if (this.dan < datum.dan)
				{
					return -1;
				}
				else if (this.dan > datum.dan)
				{
					return 1;
				}
				else
				{
					return 0;
				}
			}
		}
	}
	
	
	private static Datum[] izmisliDatume()
	{
		Datum[] datum = new Datum[50];
		for (int i=0; i<50; i++)
		{
			datum[i] = new Datum();
			datum[i].mjesec = 1 + (int)(Math.random()*12);
			if (datum[i].mjesec == 2)
			{
				datum[i].dan = 1 + (int)(Math.random()*28);
			}
			else if (datum[i].mjesec == 4 && datum[i].mjesec == 6 && datum[i].mjesec == 9 && datum[i].mjesec == 11)
			{
				datum[i].dan = 1 + (int)(Math.random()*30);
			}
			else
			{
				datum[i].dan = 1 + (int)(Math.random()*31);
			}
		}
		
		return datum;
	}
	
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
	
	private static int razlikaDatuma(Datum datum1, Datum datum2) 
	{
		int razlikaDana = 0;
		if (datum1.mjesec == datum2.mjesec) 
		{
			razlikaDana = datum2.dan - datum1.dan;
		}
		if (datum1.mjesec < datum2.mjesec) 
		{
			if (datum1.mjesec == 4 || datum1.mjesec == 6 || datum1.mjesec == 9 || datum1.mjesec == 11) 
			{
				razlikaDana = (30 - datum1.dan) + datum2.dan;
			} 
			else if(datum1.getMjesec() == 2) 
			{	
				razlikaDana = (28 - datum1.dan) + datum2.dan;
			}
		} 
		else 
		{
			razlikaDana = (31 - datum1.dan) + datum2.dan;
		}
		return razlikaDana;
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
}
