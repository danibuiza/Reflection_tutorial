package com.danibuiza.javacodegeeks.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class StaticReflection
{

    static class StaticExample
    {
        int counter;
    }

    public static void main( String[] args ) throws NoSuchMethodException, SecurityException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException, ClassNotFoundException
    {

        // access static class
        System.out.println( "directly " + StaticExample.class.getName() );

        // this throws an exception
        try
        {
            Class<?> forname = Class.forName( "com.danibuiza.javacodegeeks.reflection.StaticReflection.StaticExample" );
            System.out.println( "class for name " + forname.getName() );
        }
        catch( ClassNotFoundException ex )
        {
            System.err.println( "class not found " + ex.getMessage() );
        }

        // this would work but is not that nice
        try
        {
            Class<?> forname = Class.forName( "com.danibuiza.javacodegeeks.reflection.StaticReflection$StaticExample" );
            System.out.println( "class for name " + forname.getName() );
        }
        catch( ClassNotFoundException ex )
        {
            System.err.println( "class not found " + ex.getMessage() );
        }

        // another way iterating through all clases declared inside this class
        Class<?>[] classes = StaticReflection.class.getDeclaredClasses();
        for( Class<?> class1 : classes )
        {
            System.out.println( "iterating through declared classes " + class1.getName() );
        }

        // access static methods in the same way as instance ones
        Method mathMethod = Math.class.getDeclaredMethod( "round", double.class );

        // object can be null since method is static
        Object result = mathMethod.invoke( null, new Double( 12.4 ) );

        System.out.println( "result of calling Math.round using reflection for 12.4 " + result );

    }

}
