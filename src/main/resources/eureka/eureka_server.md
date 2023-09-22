
Eureka Server: 

and enable it at Root app level:


![img.png](img.png)

And in App.yml or App.prop:

![img_1.png](img_1.png)


Eureka Client:

![img_2.png](img_2.png)

And at app root 

![img_3.png](img_3.png)

In App.props:

![img_4.png](img_4.png)

sever.port = 0 : Tells server to take any  free port available.

To run multiple instances. Go to Edit configuration and inside that 
check "Allow parallel run" check box and run the same service again
thus 2 services will run in parallel and will be registered under 
"Eureka dashboard" as well.




