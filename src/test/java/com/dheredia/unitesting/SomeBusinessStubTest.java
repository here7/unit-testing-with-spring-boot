package com.dheredia.unitesting;

import com.dheredia.unitesting.data.SomeDataService;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

class SomeDataServiceStub implements SomeDataService{
    @Override
    public int[] retrieveAllData() {
        return new int[] {1,2,3};
    }
}

class SomeDataServiceEmptyStub implements SomeDataService{
    @Override
    public int[] retrieveAllData() {
        return new int[] {};
    }
}

public class SomeBusinessStubTest {

    /**
     * Test de un Stub: se prueba algo parcialmente. Normalmente, para una interfaz aun no desarrollada del todo
     * Lo que hará es, devolver un resultado legal (dentro de 'los escenarios felices') pero sin contener la lógica definitiva.
     * Por ello, decimos que estamos probándolo de forma parcial
     */
    @Test
    public void calcularSumDataServiceTest(){
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setDataService( new SomeDataServiceStub() ); //implements from interface

        int current_result = business.calcularSumDataService();
        int expected_result = 6;

        assertEquals(expected_result, current_result);
    }

    @Test
    public void calcularSumDataServiceEmptyTest(){
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setDataService( new SomeDataServiceEmptyStub() );

        int current_result = business.calcularSumDataService();
        int expected_result = 0;

        assertEquals(expected_result, current_result);
    }
}
