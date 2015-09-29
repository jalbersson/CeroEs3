package com.example.jalber.ceroes3.modelo;

import com.parse.ParseFile;
import com.parse.ParseObject;

/**
 * Created by Jalber on 29/09/2015.
 */
public class Logo extends ParseObject
{

    public ParseFile getFoto()
    {
        return getParseFile("AppPhoto");
    }
}
