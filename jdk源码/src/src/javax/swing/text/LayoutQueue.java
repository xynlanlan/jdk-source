/*
 * @(#)LayoutQueue.java	1.8 09/05/04
 *
 * Copyright 2006 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package javax.swing.text;

import java.util.Vector;
import sun.awt.AppContext;

/**
 * A queue of text layout tasks. 
 *
 * @author  Timothy Prinzing
 * @version 1.8 05/04/09
 * @see     AsyncBoxView
 * @since   1.3 
 */
public class LayoutQueue {

    private static final Object DEFAULT_QUEUE = new Object();

    private Vector tasks;
    private Thread worker;

    /**
     * Construct a layout queue.
     */
    public LayoutQueue() {
	tasks = new Vector();
    }

    /**
     * Fetch the default layout queue.
     */
    public static LayoutQueue getDefaultQueue() {
        AppContext ac = AppContext.getAppContext();
        synchronized (DEFAULT_QUEUE) {
            LayoutQueue defaultQueue = (LayoutQueue) ac.get(DEFAULT_QUEUE);
            if (defaultQueue == null) {
                defaultQueue = new LayoutQueue();
                ac.put(DEFAULT_QUEUE, defaultQueue);
            }
            return defaultQueue;
	}
    }

    /**
     * Set the default layout queue.
     *
     * @param q the new queue.
     */
    public static void setDefaultQueue(LayoutQueue q) {
        synchronized (DEFAULT_QUEUE) {
            AppContext.getAppContext().put(DEFAULT_QUEUE, q);
        }
    }

    /**
     * Add a task that is not needed immediately because
     * the results are not believed to be visible.
     */
    public synchronized void addTask(Runnable task) {
	if (worker == null) {
	    worker = new LayoutThread();
	    worker.start();
	}
	tasks.addElement(task);
	notifyAll();
    }

    /**
     * Used by the worker thread to get a new task to execute
     */
    protected synchronized Runnable waitForWork() {
	while (tasks.size() == 0) {
	    try {
		wait();
	    } catch (InterruptedException ie) {
		return null;
	    }
	}
	Runnable work = (Runnable) tasks.firstElement();
	tasks.removeElementAt(0);
	return work;
    }

    /**
     * low priority thread to perform layout work forever
     */
    class LayoutThread extends Thread {
	
	LayoutThread() {
	    super("text-layout");
	    setPriority(Thread.MIN_PRIORITY);
	}
	
        public void run() {
	    Runnable work;
	    do {
		work = waitForWork();
		if (work != null) {
		    work.run();
		}
	    } while (work != null);
	}


    }

}
