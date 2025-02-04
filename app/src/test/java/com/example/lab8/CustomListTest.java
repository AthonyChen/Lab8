package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
     * check if our current size matches the initial size plus
     one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }
    @Test
    void testhasCities() {
        list = MockCityList();
        City city = new City("Edmonton", "Alberta");
        list.addCity(city);
        City mockcity = new City("Calgary", "Alberta");
        list.addCity(mockcity);
        assertTrue(list.hasCity(mockcity));
    }
    @Test
    void testcountCities() {
        list = MockCityList();
        City city = new City("Edmonton", "Alberta");
        list.addCity(city);
        assertEquals(1,list.countCities());
    }
    @Test
    void testdeleteCities() {
        list = MockCityList();
        assertEquals(0, list.getCount());
        City city = new City("Regina", "Saskatchewan");
        list.addCity(city);
        list.delete(city);
        assertEquals(0, list.getCount());

    }
    @Test
    void testdeleteCitiesexception() {
        list = MockCityList();
        City city1 = new City("Edmonton", "Alberta");
        City city2 = new City("Edmonton", "Alberta");
        list.addCity(city1);
        assertThrows( IllegalArgumentException.class, () -> {list.delete(city2); });
    }

}
