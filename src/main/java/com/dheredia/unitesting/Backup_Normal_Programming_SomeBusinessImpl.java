//package com.dheredia.unitesting;
//import com.dheredia.unitesting.data.SomeDataService;
//
//public class Backup_Normal_Programming_SomeBusinessImpl {
//
//    private SomeDataService dataService;
//
//
//    /**
//     * GETTER
//     * @return
//     */
//    public SomeDataService getDataService() {
//        return dataService;
//    }
//
//    /**
//     * SETTER
//     * @param dataService
//     */
//    public void setDataService(SomeDataService dataService) {
//        this.dataService = dataService;
//    }
//
//
//    /**
//     * Without Interface
//     * @param data
//     * @return sum;
//     */
//    public int calculateSum(int[] data){
//        int sum = 0;
//        for(int value:data){
//            sum += value;
//        }
//        return sum;
//    }
//
//    /**
//     *
//     * @return sum;
//     */
//    public int calcularSumDataService(){
//        int data[] = dataService.retrieveAllData();
//        int sum = 0;
//        for(int value:data){
//            sum += value;
//        }
//        return sum;
//    }
//}
