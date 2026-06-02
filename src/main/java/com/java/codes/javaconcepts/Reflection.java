package com.java.codes.javaconcepts;

import lombok.Data;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@Data
public class Reflection {


    public void reflectionTest() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException, NoSuchFieldException {
        Dog dog = new Dog();
        dog.bark("normal INSTANCE");

        //GET CLASS OBJECT FROM TYPE WE KNOW
        Class<?> dogClassclass = Dog.class;
        Method[] methods = dogClassclass.getMethods();

        Method method = dogClassclass.getMethod("bark", String.class);
        method.invoke(dogClassclass.newInstance(), "class object from type");


        //Get class object from existing object
        Class dogClass2c = dog.getClass();

        //get class object from string (spring approach)
        Class cl = Class.forName("com.java.codes.javaconcepts.Dog");
        List<Field> fields = List.of(cl.getDeclaredFields());
        for (Field f : fields) {
            System.out.println(f.getName());
        }

        Field breedField = cl.getDeclaredField("breed");
        breedField.setAccessible(true);
        breedField.set(dog, "German shepher");

        System.out.println(breedField.get(dog));

    }
}
