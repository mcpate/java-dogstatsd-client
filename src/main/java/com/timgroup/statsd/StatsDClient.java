package com.timgroup.statsd;

/**
 * Describes a client connection to a StatsD server, which may be used to post metrics
 * in the form of counters, timers, and gauges.
 * 
 * @author Tom Denley
 *
 */
public interface StatsDClient {

    /**
     * Cleanly shut down this StatsD client. This method may throw an exception if
     * the socket cannot be closed.
     */
    void stop();

    /**
     * Adjusts the specified counter by a given delta.
     * 
     * <p>This method is non-blocking and is guaranteed not to throw an exception.</p>
     * 
     * @param aspect
     *     the name of the counter to adjust
     * @param delta
     *     the amount to adjust the counter by
     */
    void count(String aspect, int delta);

    /**
     * Increments the specified counter by one.
     * 
     * <p>This method is non-blocking and is guaranteed not to throw an exception.</p>
     * 
     * @param aspect
     *     the name of the counter to increment
     */
    void incrementCounter(String aspect);

    /**
     * Convenience method equivalent to {@link #incrementCounter(String)}. 
     */
    void increment(String aspect);

    /**
     * Decrements the specified counter by one.
     * 
     * <p>This method is non-blocking and is guaranteed not to throw an exception.</p>
     * 
     * @param aspect
     *     the name of the counter to decrement
     */
    void decrementCounter(String aspect);

    /**
     * Convenience method equivalent to {@link #decrementCounter(String)}. 
     */
    void decrement(String aspect);

    /**
     * Records the latest fixed value for the specified named gauge.
     * 
     * <p>This method is non-blocking and is guaranteed not to throw an exception.</p>
     * 
     * @param aspect
     *     the name of the gauge
     * @param value
     *     the new reading of the gauge
     */
    void recordGaugeValue(String aspect, int value);

    /**
     * Convenience method equivalent to {@link #recordGaugeValue(String)}. 
     */
    void gauge(String aspect, int value);

    /**
     * Records an execution time in milliseconds for the specified named operation.
     * 
     * <p>This method is non-blocking and is guaranteed not to throw an exception.</p>
     * 
     * @param aspect
     *     the name of the timed operation
     * @param timeInMs
     *     the time in milliseconds
     */
    void recordExecutionTime(String aspect, int timeInMs);

    /**
     * Convenience method equivalent to {@link #recordExecutionTime(String)}. 
     */
    void time(String aspect, int value);

}