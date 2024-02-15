package com.mapping.gmail.Refoctored.Threading;

public class ThreadUtils {

    private static long startTime;
    private static long endTime;


    public long getStartTime(){
        return startTime;
    }
    public void setStartTime(){
        this.startTime=System.currentTimeMillis();
    }

    public long getEndTime(){
        return endTime;
    }
    public void setEndTime(){
        this.endTime=System.currentTimeMillis();
    }


    public static long printThreadRunTime(){
        long runTime=endTime-startTime;
        System.out.println("Thread runtime: " + runTime + " milliseconds");
            return runTime;
    }



}
