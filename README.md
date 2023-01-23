## challengeWit
To use this application you need to install and run RabbitMQ and JDK11.

To send a message you need to run the calc module, access http://localhost:8081/publish and define the operator, the "a" value and the "b" value. For example: http://localhost:8081/publish?operator=add&a=1&b=1 . The available operators are add, sub, multiply and divide.
After you sent the message, the REST will consume, process and print the message.