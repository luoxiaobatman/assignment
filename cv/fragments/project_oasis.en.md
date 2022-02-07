* About the app
    - Ins-like image-based content distribution software, users share and consume images on the app.
    - Users can interact with the content (refer to, comments, likes), and can interact with other users (mutual fans, private chats or through water drops (a currency of Oasis app))
    - Users can get water drops (a currency of the Oasis app) when using Oasis products.
    - Oasis and Weibo are connected, dynamic exchanges their contents.
    - The estimated carrying capacity of the project was 300K DAU, which was changed to 10M DAU at the initial stage of the official launch.
* Participate in the design and construction of the server architecture
    - Server version 1.0 app dau rises rapidly, and we went to microservice by splitting codes across departments and teams. 
    - Server version 2.0 we adopt K8S, using it and its ecology to realize the platformization of logging, monitoring, and link tracking, and realizes convenient functions related to Devops.
* Duty of Analyzing, designing and coding
    - Responsible for main status publisher, main feed stream, user-defined data, intercommunication with Weibo and other related businesses.
    - Use UML tools to disassemble and refine requirements, produce sequence diagrams, state diagrams and object designs, etc., and then pull in the team to review and code based on this.
    - Object-oriented coding, striving for code readability, easy to expand, easy to scale
    - Write Junit unit tests, integration tests across teams/departments if possible, to ensure delivery quality.
* Technology stack
    - Springboot and its eco-system.
    - Internet middleware such as Mysql, Redis, Kafka, Elasticsearch, etc.
    - Docker containerization.
    - K8S service scaling, grayscale publishing, sidecar mode (istio) log collection, JVM performance and business monitoring, microservice link tracking.
* Achievement
    - Completed milestones such as 30K DAUs and 1M DAUs.
    - Eventual consistent design and coding experience for millions of daily active products.
    - Experience accumulated in microservices