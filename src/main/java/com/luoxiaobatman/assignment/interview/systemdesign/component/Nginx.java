package com.luoxiaobatman.assignment.interview.systemdesign.component;

import com.luoxiaobatman.assignment.interview.systemdesign.LB;
import com.luoxiaobatman.assignment.interview.systemdesign.protocol.l4.TCP;
import com.luoxiaobatman.assignment.interview.systemdesign.protocol.l7.HTTP;
import com.luoxiaobatman.assignment.interview.systemdesign.protocol.l7.IMAP;
import com.luoxiaobatman.assignment.interview.systemdesign.protocol.l7.POP3;
import com.luoxiaobatman.assignment.interview.systemdesign.protocol.l7.SMTP;

/**
 * Arch:
 * <p>
 * master process: privileged operations such as reading configuration and binding to ports, and then creates a small number of child processes
 * <p>
 * cache loader process:  load the disk‑based cache into memory, and then exits
 * <p>
 * cache manager process: runs periodically and prunes entries from the disk caches to keep them within the configured sizes.
 * <p>
 * worker processes:  handle network connections, read and write content to disk, and communicate with upstream servers
 * <p>
 * <p>
 * Worker Process Detail:
 * <p>
 * listen sockets(操作系统内核去竞争mutex拿到connection) -> new incoming connections -> protocol specific state machine -> the state machine governs how to process this connection
 */
public class Nginx implements LB, HTTP, TCP, IMAP, POP3, SMTP {
}
