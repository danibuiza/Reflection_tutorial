package com.danibuiza.javacodegeeks.reflection;

import java.util.List;

public class GenericsClass
{

    List<String> internalList;

    public List<String> getInternalList()
    {
        return internalList;
    }

    public void setInternalList( List<String> internalList )
    {
        this.internalList = internalList;
    }
    
}
