package org.corey.expiryqueue;

public class DemoExpiryThread extends Thread {
	
	
	private ExpiryQueue<String> queue;
	
	DemoExpiryThread() {
        super("DemoExpiryThread");
    }

    public void run() {
        try {
            while (true) {
                long waitTime = queue.getWaitTime();
                if (waitTime > 0) {
                    Thread.sleep(waitTime);
                    continue;
                }
                for (String elem : queue.poll()) {
                	//handle expired element
                }
            }

        } catch (InterruptedException e) {
              System.out.println("ConnnectionExpirerThread interrupted");
        }
    }
}
