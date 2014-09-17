

public class Timer {

    private long start = 0;
    private long end = 0;

    public Timer() {
        start = 0;
        end = 0;
    }
    
    public void reset() {
        start = 0;
        end = 0;
    }
    
    public void start() {
        start = System.currentTimeMillis();
    }
    
    public void stop() {
        end = System.currentTimeMillis();
    }
    
    public long getTime() {
        return end - start;
    }
    
    public long getLapTime() {
        return System.currentTimeMillis() - start;
    }

}