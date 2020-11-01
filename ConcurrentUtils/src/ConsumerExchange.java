import java.util.concurrent.Exchanger;

public class ConsumerExchange implements Runnable {
	Exchanger ex;

	ConsumerExchange(Exchanger ex){
        this.ex = ex;
    }

	@Override
	public void run() {
		for (int i = 0; i < 2; i++) {
			try {
				// Getting Country object from producer thread
				// giving dummy country object in return
				Country country = (Country) ex.exchange(new Country("Dummy Country"));
				System.out.println("Got country object from Producer thread : " + country.getCountryName());

			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
	}
}
