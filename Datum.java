package lab22;

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
	
	/**
	 * Funkcija provjerada da li su datumi jednaki
	 * @param datum
	 * @return boolean
	 */
	
	public boolean equals(Datum datum)
	{
		if (this.dan == datum.dan && this.mjesec == datum.mjesec && this.godina == datum.godina)
		{
			return true;
		}
		return false;
	}
	
	/**
	 * Funkcija poredi dva datuma
	 * @param datum
	 * @return int
	 */
	
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
	

}
