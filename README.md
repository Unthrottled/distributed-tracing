# Distributed Tracing

This project demonstrates the capabilities of Zipkin's ablity to tracing distributed Systems, without really having requests go no further than the initial server initially queried.
Meaning that all dependencies remain on a single server.

To run the sample you will need:
 - Internet Connection (At least the first time it is run)
 - [Java 8 runtime](http://blog.acari.io/jvm/2017/05/05/Gradle-Install.html)
 - [Gradle 2.3+ ](http://blog.acari.io/jvm/2017/05/05/Gradle-Install.html)
 - [RabbitMQ](https://www.rabbitmq.com/download.html), alternatively through a [Docker Image](https://hub.docker.com/_/rabbitmq/) running on port 5672
 - A whole lot of memory, 8gb or more.
 
For a more smaller example please visit [https://github.com/cyclic-reference/simple-zipkin](https://github.com/cyclic-reference/simple-zipkin)

The following code base contains seven runnable web application servers.

The first is located in the "zipkin-server" directory.
Which should come to no surprise, contains a Spring flavored Zipkin Stream Server.
Allowing other applications running Spring Cloud Sleuth Stream, to send its Span information to this server.
Provided correct configurations and an available RabbitMQ server.
The Zipkin server will run on a different port than the well known default port.
In this repository, the server will be running on port 10006.

The second server is located in the "eureka-server" directory.
This is, well a Eureka server.
Which is [Netflix OSS](https://netflix.github.io/) (Open Source Software) Service Discovery.
In short Service Discovery allows services to register themselves to be, well discovered.
Let's say that we have two instances of Alpha Service deployed on separate boxes.
Both of the services can register themselves on a Eureka cluster. 
So when a client comes along and wants to use an instance of Alpha Service, then all it has to do is go to the Eureka cluster.
Allowing Alpha Services to come and go as they please, without having the clients having to know about it.
In this repository, the server will be running on port 10001.

Next, is the web server located in the "alpha-client" directory.
This is Spring Boot application.
It should probably be obvious that this will be consuming a Alpha Service (which will be discussed next).
The application exposes a HTTP GET REST api on port 10010.
This is the following resource:

    http://localhost:10010/get/message
    
This application and all of servers yet to be mention have the following dependencies:

- Feign Client
- Eureka Discovery (needed for feign client to work)
- Sleuth Stream (needed to send spans to zipkin) 
- Stream Rabbit (needed because I asked for RabbitMQ as message delivery)

As promised, the Alpha Service is located in the "alpha-service" directory.
Alpha service has a dependency on both Bravo and Charlie Service.
It exposed an HTTP GET REST api on port 10002.
This is the following resource:
    
    http://localhost:10002/alpha

Next is the Bravo Service is located in the "bravo-service" directory (starting to see a pattern?).
Bravo service has no dependencies on any other services.
It exposed an HTTP GET REST api on port 10003.
This is the following resource:
    
    http://localhost:10003/bravo

After that, there is the Charlie Service in the "charlie-service" directory.
Charlie Service has a dependency on Zulu Service.
It exposed an HTTP GET REST api on port 10004.
This is the following resource:
    
    http://localhost:10004/charlie

Lastly we end with Zulu Service, which is-wait for it-in the "zulu-service" directory.
Big surprise!!
Much like Bravo Service, it has no external dependencies.
Exposing an HTTP GET REST api on port 10005 (I made these first).
This is the following resource:
    
    http://localhost:10005/zulu


Which should have a trace that looks like this:

![trace](images/trace.png)

To run the example.
1. Open a terminal whose current working directory is the zipkin-server directory of this repository.
1. Run `gradle bootRun`
1. Open a terminal whose current working directory is the async-rest directory of this repository.
1. Run `gradle bootRun`
1. Open a web browser and enter the following address: `http://localhost:7866`

This should output something like this to the browser window
    
>Hello from Alpha Service @ 2017-05-21T19:14:38.269Z and Hello from Bravo Service @ 2017-05-21T19:14:38.245Z and Hello from Charlie Service @ 2017-05-21T19:14:38.266Z and Hello from Zulu Service @ 2017-05-21T19:14:38.251Z

You should now be able to access the Zipkin UI, and have at least one trace, in a browser window as well at `http://localhost:7865/`



Provided that the "End Time" parameter of the trace query is at or after the time you made your browser requests, you should get something that looks like this!



Enjoy!

-Alex