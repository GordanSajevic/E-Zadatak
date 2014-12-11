package lab19;

	public class DatumTest {
		public static void main(String[] arg)
		{
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
			Datum.ispisiDatume();
		}
		

	}


