import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.jgr.reflection.Bird;
import com.jgr.reflection.Goat;
import com.jgr.reflection.Person;

public class Main {

	public static void main(String[] args) {
//		Test1();
//		givenObject_whenGetsClassName_thenCorrect();
//		givenClassName_whenCreatesObject_thenCorrect();
//		givenClass_whenRecognisesModifiers_thenCorrect();
//		givenClass_whenGetsPackageInfo_thenCorrect();
//		givenClass_whenGetsSuperClass_thenCorrect();
//		givenClass_whenGetsImplementedInterfaces_thenCorrect();
//		givenClass_whenGetsConstructor_thenCorrect();
//		givenClass_whenGetsFields_thenCorrect();
//		givenClass_whenGetsMethods_thenCorrect();
//		givenClass_whenInstantiatesObjectsAtRuntime_thenCorrect();
		givenClass_whenGetsPublicFields_thenCorrect();
	}

	public static void Test1() {
		Object person = new Person();
		Field[] fields = person.getClass().getDeclaredFields();

		List<String> actualFieldNames = getFieldNames(fields);

		actualFieldNames.stream().forEach(s -> System.out.println(s));
	}

	private static List<String> getFieldNames(Field[] fields) {
		List<String> fieldNames = new ArrayList<>();
		for (Field field : fields)
			fieldNames.add(field.getName());
		return fieldNames;
	}

	public static void givenObject_whenGetsClassName_thenCorrect() {
		Object goat = new Goat("goat");
		Class<?> clazz = goat.getClass();

		System.out.println("SimpleName: " + clazz.getSimpleName());
		System.out.println("Full class Name: " + clazz.getName());
		System.out.println("Canonocal Name: " + clazz.getCanonicalName());
	}

	public static void givenClassName_whenCreatesObject_thenCorrect() {
		Class<?> clazz = null;
		try {
			clazz = Class.forName("com.jgr.reflection.Goat");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("Goat: " + clazz.getSimpleName());
		System.out.println("Full class Name: " + clazz.getName());
		System.out.println("Canonocal Name: " + clazz.getCanonicalName());
	}

	public static void givenClass_whenRecognisesModifiers_thenCorrect() {
		Class<?> goatClass = null;
		Class<?> animalClass = null;
		try {
			goatClass = Class.forName("com.jgr.reflection.Goat");
			animalClass = Class.forName("com.jgr.reflection.Animal");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		int goatMods = goatClass.getModifiers();
		int animalMods = animalClass.getModifiers();

		System.out.println(Modifier.isPublic(goatMods));
		System.out.println(Modifier.isAbstract(animalMods));
		System.out.println(Modifier.isPublic(animalMods));
	}

	public static void givenClass_whenGetsPackageInfo_thenCorrect() {
		Goat goat = new Goat("goat");
		Class<?> goatClass = goat.getClass();
		Package pkg = goatClass.getPackage();

		System.out.println("com.jgr.reflection: " + pkg.getName());
	}

	public static void givenClass_whenGetsSuperClass_thenCorrect() {
		Goat goat = new Goat("goat");
		String str = "any string";

		Class<?> goatClass = goat.getClass();
		Class<?> goatSuperClass = goatClass.getSuperclass();

		System.out.println("Animal: " + goatSuperClass.getSimpleName());
		System.out.println("Object: " + str.getClass().getSuperclass().getSimpleName());
	}

	public static void givenClass_whenGetsImplementedInterfaces_thenCorrect() {
		Class<?> goatClass = null;
		Class<?> animalClass = null;
		try {
			goatClass = Class.forName("com.jgr.reflection.Goat");
			animalClass = Class.forName("com.jgr.reflection.Animal");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Class<?>[] goatInterfaces = goatClass.getInterfaces();
		Class<?>[] animalInterfaces = animalClass.getInterfaces();

		System.out.println("length 1 : " + goatInterfaces.length);
		System.out.println("length 1 : " + animalInterfaces.length);
		System.out.println("Locomotion: " + goatInterfaces[0].getSimpleName());
		System.out.println("Eating: " + animalInterfaces[0].getSimpleName());
	}

	public static void givenClass_whenGetsConstructor_thenCorrect() {
		Class<?> goatClass = null;
		try {
			goatClass = Class.forName("com.jgr.reflection.Goat");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Constructor<?>[] constructors = goatClass.getConstructors();

		System.out.println(constructors.length);
		System.out.println("com.jgr.reflection.Goat: " + constructors[0].getName());
	}

	public static void givenClass_whenGetsFields_thenCorrect() {
		Class<?> animalClass = null;
		try {
			animalClass = Class.forName("com.jgr.reflection.Animal");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Field[] fields = animalClass.getDeclaredFields();

		List<String> actualFields = getFieldNames(fields);

		System.out.println(actualFields.size());
		System.out.println(actualFields.containsAll(Arrays.asList("name", "CATEGORY")));
	}

	public static void givenClass_whenGetsMethods_thenCorrect() {
		Class<?> animalClass = null;
		try {
			animalClass = Class.forName("com.jgr.reflection.Animal");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Method[] methods = animalClass.getDeclaredMethods();
		List<String> actualMethods = getMethodNames(methods);

		System.out.println(actualMethods.size());
		System.out.println(actualMethods.containsAll(Arrays.asList("getName", "setName", "getSound")));
	}

	private static List<String> getMethodNames(Method[] methods) {
		List<String> methodNames = new ArrayList<>();
		for (Method method : methods)
			methodNames.add(method.getName());
		return methodNames;
	}

	public static void givenClass_whenGetsEachConstructorByParamTypes_thenCorrect() {
		Class<?> birdClass = null;
		try {
			birdClass = Class.forName("com.jgr.reflection.Bird");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			Constructor<?> cons1 = birdClass.getConstructor();
			Constructor<?> cons2 = birdClass.getConstructor(String.class);
			Constructor<?> cons3 = birdClass.getConstructor(String.class, boolean.class);
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}

	}

	public static void givenClass_whenInstantiatesObjectsAtRuntime_thenCorrect() {
		Class<?> birdClass = null;
		try {
			birdClass = Class.forName("com.jgr.reflection.Bird");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Constructor<?> cons1 = null;
		Constructor<?> cons2 = null;
		Constructor<?> cons3 = null;
		try {
			cons1 = birdClass.getConstructor();
			cons2 = birdClass.getConstructor(String.class);
			cons3 = birdClass.getConstructor(String.class, boolean.class);
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}

		Bird bird1 = null;
		Bird bird2 = null;
		Bird bird3 = null;
		try {
			bird1 = (Bird) cons1.newInstance();
			bird2 = (Bird) cons2.newInstance("Weaver bird");
			bird3 = (Bird) cons3.newInstance("dove", true);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}

		System.out.println("bird : " + bird1.getName());
		System.out.println("Weaver bird: " + bird2.getName());
		System.out.println("dove: " + bird3.getName());

		System.out.println(bird1.walks());
		System.out.println(bird3.walks());
	}

	public static void givenClass_whenGetsPublicFields_thenCorrect() {
		Class<?> birdClass = null;
		try {
			birdClass = Class.forName("com.jgr.reflection.Bird");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Field[] fields = birdClass.getFields();

		System.out.println(fields.length);
		System.out.println("CATEGORY: " + fields[0].getName());
	}

	public static void givenClass_whenGetsPublicFieldByName_thenCorrect() {
		Class<?> birdClass = null;
		try {
			birdClass = Class.forName("com.jgr.reflection.Bird");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Field field = null;
		try {
			field = birdClass.getField("CATEGORY");
		} catch (NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}

		System.out.println("CATEGORY: " + field.getName());
	}

	public static void givenClass_whenGetsDeclaredFields_thenCorrect() {
		Class<?> birdClass = null;
		try {
			birdClass = Class.forName("com.jgr.reflection.Bird");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Field[] fields = birdClass.getDeclaredFields();

		System.out.println(fields.length);
		System.out.println("walks: " + fields[0].getName());
	}

	public static void givenClass_whenGetsFieldsByName_thenCorrect() {
		Class<?> birdClass = null;
		try {
			birdClass = Class.forName("com.jgr.reflection.Bird");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Field field = null;
		try {
			field = birdClass.getDeclaredField("walks");
		} catch (NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("walks: " + field.getName());
	}

	public static void givenClassField_whenGetsType_thenCorrect() {
		Field field = null;
		try {
			field = Class.forName("com.jgr.reflection.Bird").getDeclaredField("walks");
		} catch (NoSuchFieldException | SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		Class<?> fieldClass = field.getType();

		System.out.println("boolean" + fieldClass.getSimpleName());
	}

	public static void givenClassField_whenSetsAndGetsValue_thenCorrect() {
		Class<?> birdClass = null;
		try {
			birdClass = Class.forName("com.baeldung.reflection.Bird");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Bird bird = null;
		try {
			bird = (Bird) birdClass.getConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Field field = null;
		try {
			field = birdClass.getDeclaredField("walks");
		} catch (NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		field.setAccessible(true);

		try {
			System.out.println(field.getBoolean(bird));
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		System.out.println(bird.walks());

		try {
			field.set(bird, true);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		try {
			System.out.println(field.getBoolean(bird));
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		System.out.println(bird.walks());
	}

	public static void givenClassField_whenGetsAndSetsWithNull_thenCorrect() {
		Class<?> birdClass = null;
		try {
			birdClass = Class.forName("com.baeldung.reflection.Bird");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Field field = null;
		try {
			field = birdClass.getField("CATEGORY");
		} catch (NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
		field.setAccessible(true);

		try {
			System.out.println("domestic: " + field.get(null));
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	public static void givenClass_whenGetsAllPublicMethods_thenCorrect() {
		Class<?> birdClass = null;
		try {
			birdClass = Class.forName("com.jgr.reflection.Bird");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Method[] methods = birdClass.getMethods();
		List<String> methodNames = getMethodNames(methods);

		System.out.println(
				methodNames.containsAll(Arrays.asList("equals", "notifyAll", "hashCode", "walks", "eats", "toString")));
	}

	public static void givenClass_whenGetsOnlyDeclaredMethods_thenCorrect() {
		Class<?> birdClass = null;
		try {
			birdClass = Class.forName("com.jgr.reflection.Bird");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<String> actualMethodNames = getMethodNames(birdClass.getDeclaredMethods());

		List<String> expectedMethodNames = Arrays.asList("setWalks", "walks", "getSound", "eats");

		System.out.println(expectedMethodNames.size() + " : " + actualMethodNames.size());
		System.out.println(expectedMethodNames.containsAll(actualMethodNames));
		System.out.println(actualMethodNames.containsAll(expectedMethodNames));
	}

	public static void givenMethodName_whenGetsMethod_thenCorrect() throws Exception {
		Bird bird = new Bird();
		Method walksMethod = bird.getClass().getDeclaredMethod("walks");
		Method setWalksMethod = bird.getClass().getDeclaredMethod("setWalks", boolean.class);

		System.out.println(walksMethod.canAccess(bird));
		System.out.println(setWalksMethod.canAccess(bird));
	}

	public static void givenMethod_whenInvokes_thenCorrect() {
		Class<?> birdClass = null;
		try {
			birdClass = Class.forName("com.jgr.reflection.Bird");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Bird bird = null;
		try {
			bird = (Bird) birdClass.getConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		Method setWalksMethod = null;
		try {
			setWalksMethod = birdClass.getDeclaredMethod("setWalks", boolean.class);
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		Method walksMethod = null;
		try {
			walksMethod = birdClass.getDeclaredMethod("walks");
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		boolean walks = false;
		try {
			walks = (boolean) walksMethod.invoke(bird);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}

		System.out.println(walks);
		System.out.println(bird.walks());

		try {
			setWalksMethod.invoke(bird, true);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}

		boolean walks2 = false;
		try {
			walks2 = (boolean) walksMethod.invoke(bird);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		System.out.println(walks2);
		System.out.println(bird.walks());
	}

}
