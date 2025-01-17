package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;
    /**
    * create a mocklist for my citylist
    * @return
    */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
    * get the size of the list
    * increase the list by adding a new city
    * check if our current size matches the initial size
    plus one
    */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1); 
    }

    @Test
    private void testHasCity(){
        list = MockCityList();
        
        // empty list
        assertTrue(list.getCount() == 0);

        City city = new City("Calgary", "Alberta");
        assertFalse(list.hasCity(city));
    }

    @Test
    private void testDelete(){
        list = MockCityList();
        list.add(new City("Calgary", "Alberta"));
        City city = new City("Calgary", "Alberta");
        list.delete(city);
        assertFalse(list.hasCity(city));
    }

    @Test
    private void testCountCities(){
        list = MockCityList();
        assertEquals(0, list.countCities());

        City city = new City("Toronto", "Ontario");
        list.add(city);
        assertEquals(1, list.countCities());

        list.delete(city);
        assertEquals(0, list.countCities());
    }


}
