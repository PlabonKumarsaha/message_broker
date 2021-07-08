# message_broker
cmd in powershell terminal
docker run -d --name some-rabbit -p 5672:5672 -p 5673:5673 -p 15672:15672 rabbitmq:3-management   : install rabbit mq
-management provides the dashboad

- docker ps -> see the container

# the service of rabbitMQ
http://localhost:15672/
uname and pass are both guest

* create a spring project with rabbit mq where queue and exhnage must bec created

* Request type from publisher :
* POST method
http://localhost:9000/publish
{
	"messageId":"1",
	"message": "7"
}
