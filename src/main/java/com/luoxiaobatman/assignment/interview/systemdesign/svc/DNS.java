package com.luoxiaobatman.assignment.interview.systemdesign.svc;


/**
 * 域名解析服务
 * <p>
 * NS record (name server) - Specifies the DNS servers for your domain/subdomain.
 * MX record (mail exchange) - Specifies the mail servers for accepting messages.
 * A record (address) - Points a name to an IP address.
 * CNAME (canonical) - Points a name to another name or CNAME (example.com to www.example.com) or to an A record.
 * <p>
 * routing:
 * Weighted round robin
 * Latency-based
 * Geolocation-based
 * <p>
 * disadvantage:
 * a slight delay
 * DNS server management complex
 * DDos attack on DNS server
 */
public interface DNS {
}
