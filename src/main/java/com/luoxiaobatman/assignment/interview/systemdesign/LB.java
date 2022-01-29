package com.luoxiaobatman.assignment.interview.systemdesign;

/**
 * LoadBalancer
 * <p>
 * Random
 * Round Robin
 * Least Busy
 * Sticky Session/Cookie
 * sniffing Protocol
 * <p>
 * and wait for response or not? then forward the response to client?
 * <p>
 * prevent:
 * a single point of failure
 * going to unhealthy servers
 * overloading resources
 * <p>
 * SSL termination - Decrypt incoming requests and encrypt server responses so backend servers do not have to perform these potentially expensive operations
 * <p>
 * Session persistence - Issue cookies and route a specific client's requests to same instance if the web apps do not keep track of sessions
 */
public interface LB {
}
