import java.util.concurrent.Exchanger;

public class ExchangerExample {
	public void Example() {
		Exchanger exchanger = new Exchanger();
		new Thread(new ProducerExchange(exchanger)).start();
		new Thread(new ConsumerExchange(exchanger)).start();
	}
}
