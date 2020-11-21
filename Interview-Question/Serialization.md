# Serialization

### 1. What is Serialization?
Java provides mechanism called serialization to persists java objects in a form of ordered or sequence of bytes that includes the object’s data as well as information about the object’s type and the types of data stored in the object.So if we need to serialize any object then it can be read and deserialize it using object’s type and other information so we can retrieve original object.Classes ObjectInputStream and ObjectOutputStream are high-level streams that contain the methods for serializing and deserializing an object.
```java
private void writeObject(ObjectOutputStream os) throws IOException { 
} 
private void readObject(ObjectInputStream is) throws IOException, ClassNotFoundException {
}
```
### 2: What is need of Serialization?
Serialization is usually used when there is need to send our data over network or to store in files. By data we mean objects and not text.

Now the problem is our Network infrastructure and our Hard disk is hardware components that understand bits and bytes but not Java objects.
Serialization is the translation of Java object’s values/states to bytes to send it over network or to save it.On the other hand, Deserialization is conversion of byte code to corresponding java objects.

### 3: Can we explain about Concept of serialVersionUID?
serialVersionUID is used to ensure that same class(That was used during Serialization) is loaded during Deserialization. serialVersionUID is used for version control of object.
we can read more at serialVersionUID in java serialization

### 4: Is it necessary to implement Serializable interface if we want to serialize any object?
Yes, it is necessary to implement Serializable interface if we want to serialize any object. Serializable is marker interface. 
Marker interface in Java is interfaces with no field or methods or in simple word empty interface in java is called marker interface.

### 5: Can we Serialize static variables?
No,we can’t.As we know static variable are at class level not at object level and we serialize a object so we can’t serialize static variables.

### 6: How can we customize serialization process?
we can customize Serialization process by defining writeObject and readObject method. 
Java serialization provides a mechanism such that if we have private methods with particular signature then they will get called during serialization and deserialization, so in this way, we can customize Serialization process.
For example:
```java 
private void writeObject(ObjectOutputStream os) throws IOException, ClassNotFoundException
 { 
  try {
   os.defaultWriteObject();
   os.writeInt(address.getHomeNo());
   os.writeObject(address.getStreet());
   os.writeObject(address.getCity());
  } 
  catch (Exception e) 
  { e.printStackTrace(); }
 }
 
 private void readObject(ObjectInputStream is) throws IOException, ClassNotFoundException
 {
  try {
   is.defaultReadObject();
   int homeNo=is.readInt();
   String street=(String) is.readObject();
   String city=(String) is.readObject();
   address=new Address(homeNo,street,city); 
  }
```
One thing should be kept in mind that ObjectInputStream should read data in same sequence in which we have written data to ObjectOutputStream.

### 7: How can we avoid certain member variable of class to be serialized?

we can mark that variable as either static or transient. Transient variable is the variable whose value is not serialized during serialization. we will get default value for these variable when we deserialize it.
```java
import java.io.Serializable;
 
public class Country implements Serializable {  
  
 String name;  
 transient long population; 
 public Country() {
 super();
}
public Country(String name, long population) {  
  super();  
  this.name = name;  
  this.population = population;  
 }  
 public String getName() {  
  return name;  
 }  
 public void setName(String name) {  
  this.name = name;  
 }  
 public long getPopulation() {  
  return population;  
 }  
 public void setPopulation(long population) {  
  this.population = population;  
 }    
}  
```
```java
 
package org.arpit.java2blog;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
 
public class SerializeMain {
 public static void main(String[] args) {
 
  Country india = new Country();
 india.setName("India");
 india.setPopulation(100000);
  try
  {
   FileOutputStream fileOut = new FileOutputStream("country.ser");
   ObjectOutputStream outStream = new ObjectOutputStream(fileOut);
   outStream.writeObject(india);
   outStream.close();
   fileOut.close();
  }catch(IOException i)
  {
   i.printStackTrace();
  }
  
  System.out.println("serialized");
 }
}
```

```java 
package org.arpit.java2blog;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
 
public class DeserializeMain {

 public static void main(String[] args) {
  
  Country india = null;
       try
       {
          FileInputStream fileIn =new FileInputStream("country.ser");
          ObjectInputStream in = new ObjectInputStream(fileIn);
          india = (Country) in.readObject();
          in.close();
          fileIn.close();
       }catch(IOException i)
       {
          i.printStackTrace();
          return;
       }catch(ClassNotFoundException c)
       {
          System.out.println("Country class not found");
          c.printStackTrace();
          return;
       }
       System.out.println("Deserialized Country...");
       System.out.println("Country Name : " + india.getName());
       System.out.println("Population : " + india.getPopulation());
       
 }
}
```

### 8: What if superclass is Serializable? Does that mean child class is automatically Serializable?
Yes

### 9: What if superclass is Serializable but we don’t want subclass to be Serializable?
If we don’t want subclass to serializable then we need to implement writeObject() and readObject() method and need to throw NotSerializableException from this methods.

### 10 :What is externalizable interface?
 As name suggest it is externalilizing our serialization. If we want to customize our serialization mechanism then we can use it. 
 It uses custom written mechanism to perform marshalling and unmarshalling of objects. Externalizable interface extends Serializable interface. If we implement this interface then we need to override following methods.
```java
 @Override
 public void readExternal(ObjectInput arg0) throws IOException,ClassNotFoundException {
 
 }
 
 @Override
 public void writeExternal(ObjectOutput arg0) throws IOException {
 
 }
 ```
### 11 : What are differences between Serializable and Externalizable in Java?
Parameter | Serializable | Externalizable
--------- | ------------ | --------------
Marker interface | It is marker interface. we don’t have to provide implementation of any method. | Externalizable is not marker interface, we have to override writeExternal and readExternal method.
Control | Serializable interface has less control over serialization process and it is optional to override readObject and writeObject. | Externalizable interface has more control over serialization process and it is mandatory to override writeExternal and readExternal.
Performance | JVM uses reflection to perform serialization in the case of Serializable interface which is quite slow. | Programmer have to implement readExternal and writeExternal methods but it relatively results in better performance
Supersedes | NA | If we implement Externalizable interface and provide implementation of readExternal and writeExternal then it supersedes readObject and writeObject methods in that class. It is due to the fact that Externalizable extends Serializable interface.
Constructor called during Deserialization | Default constructor is not called during Deserialization process. | Default constructor is called during Deserialization process.

#### Reference's ####
01. https://java2blog.com/
02. https://howtodoinjava.com
03. https://www.journaldev.com
04. https://www.geeksforgeeks.org/
05. https://www.baeldung.com/

