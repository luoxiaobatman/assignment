## DBS interview questions

> terminology:\
item marked as * is subject\
item marked as - is answering or thought

* Tech
    * Java
        * Basics
            * final class, final method, final field, what's the differences
            * about Collection interface vs. Stream interface
            * about Optional class
        * Advanced(if you dive in)
            * Concurrent programming
                - I don't think interviewer is familiar with java concurrent programming
                - I hinted frequently, but they don't follow  
    * (Advanced if you dive in) Topics
        * SSO
            * how sso works, why it works
                - talk about how sso server, client, api server communicate with each other 
            * about private key and public key, and regarding JWT
        * Distributed Tracing
            - talk about adding unique id alongside request url(if you use http)
            - K8S istio dive in, if you are familiar with cloud natives
        * Distributed Logging
            - talk about why traditional logging per machine is not suitable 
            - talk about ELK stack
            - K8S istio, EFK stack, if you are familiar with them
        * RBAC
            - a layer between user and privilege(privilege is a layer between user and resource)
            - adding flexibility and maintainability to your ACL system
            - talk about how computer software solve problem in general way by adding a new abstract layer.
    * Spring related
        * Spring Bean, talk about everything you know
        * about spring-batch and spring-security libs
        * about spring-mvc related annotations
    * VCS
        * what's your git workflow
* Coding
    - None
* System Design
    * Design bank account balance query api