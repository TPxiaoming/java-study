package com.xiaoming.day05;

public class FutureClient {

    /**
     * 类似于submit
     * @return
     */
    public Data request(String requestData){
         final FutureData futureData = new FutureData();
        new Thread(new Runnable() {
            public void run() {
                RealData realData = new RealData("60064");
                futureData.setRealData(realData);
            }
        }).start();
        return futureData;
    }

}
