package com.dheredia.unitesting;
import com.dheredia.unitesting.data.SomeDataService;

import java.util.Arrays;

public class SomeBusinessImpl {

    private SomeDataService dataService;


    /**
     * GETTER
     * @return
     */
    public SomeDataService getDataService() {
        return dataService;
    }

    /**
     * SETTER
     * @param dataService
     */
    public void setDataService(SomeDataService dataService) {
        this.dataService = dataService;
    }


    /**
     * Without Interface
     * @param data
     * @return sum;
     */
    public int calculateSum(int[] data){

        /*int sum = 0;
        for(int value:data){
            sum += value;
        }
        return sum;*/

        //Functional Programming
        return Arrays.stream(data).reduce(Integer::sum).orElse(0);
    }

    /**
     *
     * @return sum;
     */
    public int calcularSumDataService(){
        /*int data[] = dataService.retrieveAllData();
        int sum = 0;
        for(int value:data){
            sum += value;
        }
        return sum;*/
        return Arrays.stream(dataService.retrieveAllData()).reduce(Integer::sum).orElse(0);
    }
}
