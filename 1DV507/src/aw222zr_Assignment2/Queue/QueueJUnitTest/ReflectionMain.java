package aw222zr_Assignment2.Queue.QueueJUnitTest;


import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class ReflectionMain {
	
	// Just copied the code from the example and studied it. Made minor changes.
	public static void main(String[] args) throws Exception{
		//Class clz = Class.forName("junit5.list_test.IntListTest");     
		Class<TestJunit> checkClass = aw222zr_Assignment2.Queue.QueueJUnitTest.TestJunit.class;        // Simplified version
		System.out.println(checkClass.getName());    // Class name

		for (Method classMethods : checkClass.getDeclaredMethods()) {
			System.out.println("\t"+classMethods.getName());  // Method names 
			for (Annotation a : classMethods.getAnnotations()) {
				String str = a.toString();
				int stop = str.indexOf('(');
				System.out.println("\t\t"+str.substring(0, stop));  // Annotation names
			}
		}

		invokeToString("java.util.Date");  // Previous slide
	}

	public static void invokeToString(String class_name) throws Exception {
		Class<?> cl = Class.forName(class_name);  // Get class instance
		Method m = cl.getMethod("toString");      // Find toString() method
		Object obj = cl.newInstance();            // Create new instance
		System.out.println(cl.getName()+"\t"+m.invoke(obj));  // Make call o.m()		
	}
}