public class DynamicThread extends Thread {
    private final int n;
    public DynamicThread(int myN)
    {
        n = myN;
    }
    @Override
    public void run()
    {
        //format the output
        String dynamFormat = "Dynamic Fibonacci with n = %d results in: %d\nTime elapsed: %d ms\n";
        //grab the current time
        long startTimeD = System.currentTimeMillis();
        //run the function
        int dynamResult = dynamicFibonacci(n);
        //grab the time that it is after the function has returned a result
        long endTimeD = System.currentTimeMillis();
        //calculate the difference to get the time elapsed
        long deltaTimeD = endTimeD - startTimeD;
        //output it to the screen for the user
        System.out.printf(dynamFormat,n,dynamResult,deltaTimeD);
    }
    private static int dynamicFibonacci(int n)
    {
        int v1 = 0;
        int v2 = 1;
        int v3 = 0;
        for(int i = 2; i <=n; i++)
        {
            v3 = v1 + v2;
            v1 = v2;
            v2 = v3;
        }
        return v3;
    }

}
