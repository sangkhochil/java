import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TrasientSerialize {
	public void Serialize_1() {
		Country india = new Country();
		india.setName("Bangladesh");
		india.setPopulation(170000000);
		try {
			FileOutputStream fileOut = new FileOutputStream("country.ser");
			ObjectOutputStream outStream = new ObjectOutputStream(fileOut);
			outStream.writeObject(india);
			outStream.close();
			fileOut.close();
		} catch (IOException i) {
			i.printStackTrace();
		}

		System.out.println("serialized");
	}

	public void Deserialize_1() {
		Country india = null;
		try {
			FileInputStream fileIn = new FileInputStream("country.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			india = (Country) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException i) {
			i.printStackTrace();
			return;
		} catch (ClassNotFoundException c) {
			System.out.println("Country class not found");
			c.printStackTrace();
			return;
		}
		System.out.println("Deserialized Country...");
		System.out.println("Country Name : " + india.getName());
		System.out.println("Population : " + india.getPopulation());
	}
}
