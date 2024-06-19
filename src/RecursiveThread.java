public class RecursiveThread extends Thread{
    private final int n;
    public RecursiveThread(int myN)
    {
        n = myN;
    }
    @Override
    public void run()
    {
        //format the output
        String recurFormat = "Recursive Fibonacci with n = %d results in: %d\nTime elapsed: %d ms\n";
        //grab the current time
        long startTime = System.currentTimeMillis();
        //run the function
        int recurResult = recursiveFibonacci(n);
        //grab the time that it is after the function has returned a result
        long endTime = System.currentTimeMillis();
        //calculate the difference to get the time elapsed
        long deltaTime = endTime - startTime;
        //output it to the screen for the user
        System.out.printf(recurFormat,n,recurResult,deltaTime);
    }
    private static int recursiveFibonacci(int n)
    {
        if(n == 0)
            return 0;
        if(n==1)
            return 1;
        return recursiveFibonacci(n-1) + recursiveFibonacci(n-2);
    }
}
