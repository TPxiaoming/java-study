package com.xiaoming.day05;
/**
 * @Author:         xiaoming
 * @CreateDate:     2019/6/19 21:34
 * @Description:    获取真实数据
 */
public class RealData extends Data{

    private String requestResult;

    /**
     * data 参数
     * @param requestData
     */
    public RealData(String requestData){
        System.out.println("正在使用data进行网络请求，requestData：" + requestData + "，开始...");
        try {
            //业务操作耗时
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("操作执行完毕.....获取到结果");
        //假设获取到返回结果
        this.requestResult = "小明";
    }

    @Override
    public String getRequest() {

        return requestResult;
    }

}
