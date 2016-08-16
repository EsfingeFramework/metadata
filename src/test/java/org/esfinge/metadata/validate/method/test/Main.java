package org.esfinge.metadata.validate.method.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
				
//		Class<?>[][] arrays = { {String.class, int.class}, {String.class, Integer.class} };
//		
//		for(Class<?>[] array: arrays){
//			
//			System.out.println(array[0] + " " + array[1]);
//			
//		}
//		
//		
//		List<Class<?>[]> arrays3 = new ArrayList<Class<?>[]>() ;
//				
//		Class<?>[] el = {String.class, int.class};
//		
//		arrays3.add(el);
		
//		arrays3.add({String.class, int.class});
		
		
//		if((Integer.class).isAssignableFrom(int.class))
//			System.out.println("yes");
//		else
//			System.out.println("no");
//		
//		
//		if((int.class).isAssignableFrom(Integer.class))
//			System.out.println("yes");
//		else
//			System.out.println("no");
//		
//		
//		if((List.class).isAssignableFrom(ArrayList.class))
//			System.out.println("yes");
//		else
//			System.out.println("no");
//		
//		
//		
//		if((ArrayList.class).isAssignableFrom(List.class))
//			System.out.println("yes");
//		else
//			System.out.println("no");
		
		
//		if((int.class).isAssignableFrom(int.class))
//			System.out.println("yes");
//		else
//			System.out.println("no");
		
		
//		if((int.class).isPrimitive() && (int.class).toString().equals((int.class).toString()))

		String[] methodsNames = {"getName", "agetName", "aaget", "GETName"};
		
		for(String methodName: methodsNames){
		
			Pattern pattern = Pattern.compile("^get");
	        Matcher matcher = pattern.matcher(methodName);
	 
	        if( matcher.find() )
	            System.out.println("Encontrou");
	        else
	            System.out.println("Não encontrou");
        }
        
        
		
	}

}
