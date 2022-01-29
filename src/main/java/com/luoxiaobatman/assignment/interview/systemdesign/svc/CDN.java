package com.luoxiaobatman.assignment.interview.systemdesign.svc;

import com.luoxiaobatman.assignment.interview.systemdesign.SVC;
import com.luoxiaobatman.assignment.interview.systemdesign.trait.Distributed;

/**
 * 全球分布式内容服务服务器
 * <p>
 * Users receive content from data centers close to them
 * Your servers do not have to serve requests that the CDN fulfills
 *
 * pushCDN vs. pullCDN
 *
 *
 */
public interface CDN extends SVC, Distributed {
}
