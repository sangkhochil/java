import java.util.concurrent.Exchanger;

public class ProducerExchange implements Runnable {
	Exchanger ex;

	ProducerExchange(Exchanger ex){
        this.ex = ex;       
    }

	@Override
	public void run() {
		for (int i = 0; i < 2; i++) {
			Country country = null;
			if (i == 0)
				country = new Country("Bangladesh");
			else
				country = new Country("USA");

			try {
				// exchanging with an dummy Country object
				Country dummyCountry = (Country) ex.exchange(country);
				System.out.println("Got country object from Consumer thread : " + dummyCountry.getCountryName());
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
	}
}
