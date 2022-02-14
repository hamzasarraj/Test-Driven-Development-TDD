package com.eql.introspection;

import java.lang.reflect.Field;

public class Introspection {
	public static void main(String[] args) {

		try {
			Class classe = Class.forName("java.lang.String");
			System.out.println("Le nom de la classe = " + classe.getName());
			
			Field[] tabChamps = classe.getDeclaredFields();
			for (Field field : tabChamps) {
				System.out.println(field);
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("La classe n'a pu être déterminée !");
		}
	}

}