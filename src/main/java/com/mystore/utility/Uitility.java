package com.mystore.utility;

import java.util.Collection;
import java.util.Collections;

public class Uitility {

    public void sortingnum()
    {
        Integer [] str = new Integer[]{4,6,1,8,2};
         Integer[] sorted = new Integer[5];
        for (int i = 0; i< str.length;i++)
        {
            for(int j =1;j< str.length;j++)
            {

                if(str[i]< str[j])
                {
                    str[i] = str[j];
                }

            }
            sorted[i]=str[i];
        }


    }
}
