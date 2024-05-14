package countOperations;

public class StopWatch {
    private long startTime;
    private long endTime;

    public void start() {
        startTime = System.currentTimeMillis();
    }

    public void stop() {
        endTime = System.currentTimeMillis();
    }

    public long elapsedTime() {
        return endTime - startTime;
    }

}

