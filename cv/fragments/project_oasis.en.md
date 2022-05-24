* About the app
    - Instagram-like image distribution software, users use app to post and consume images.
    - Users can interact with posts through referring to & commenting & liking, and communicate with other users through following, chatting, giving gifts.
    - User may gather water drops(a currency of the Oasis app). Water drop is used for exchanging real money, giving each others as gifts or buying consumer-products.
    - Oasis and Weibo can dynamically exchange contents.
    - The estimated carrying capacity of the project was 300K DAU. Due to popularity after official launch, it was changed to 10M DAU.
    - Deployed in Sina Weibo private cloud.
* Architect, Design, Code responsibilities
    - After official launch, we refactored from monolithic to spring cloud microservice to increase delivery speed, and decouple services with clear boundary to achieve isolation. I was in charge of splitting parts of monolithic like Status-Service, Comment-Service, SSO, Anti-Junk, etc... among teams. I was also responsible for the business continuity during refactoring.
    - Late 2021, we decided to adopt K8S, we planed to migrate all our microservices to deprecate spring cloud and enjoy better dev&ops experience. Until early 2022, I successfully migrated Status-Service and User-Service, adding bonuses like telemetry, auto-scaling, better isolation, better network issue handling, etc...
    - For designing & coding, I was responsible for status publisher, main feed stream delivery system, user defined data related logic, intercommunication with Weibo, etc... I analyzed functional requirements and non-functional. I Heavily used UML tool to do the design before coding. I prefer Object-Oriented coding style, adhere to SOLID principle. I followed tech&trick like cache best practises, message queue, concurrent programming, sharding etc... to accomplish various tasks. I wrote unit tests to ensure delivery quality and maintenance. We did peer review before merging branches. As a result, We as a team can wrote bug free, maintainable, readable, high performance code.
* Technology stack
    - Springboot, Spring Cloud and their eco-system.
    - Middlewares such as Mysql, Redis, Kafka, Elasticsearch, etc...
    - Docker, K8S and it's ecosystem.
    - Reactjs and it's ecosystem, AntDesign UI framework.
* Achievement
    - Completed milestones such as 30K DAUs and 1M DAUs.
    - Microservices and migrating to K8S.
    - Architect to support high traffic situations.