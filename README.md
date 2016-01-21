
## Docker
docker pull redis
docker pull andrewwatson/dynomite

This is a very minimal dynomite server that is configured to sit in front of redis.

Start Redis
First, start up a Redis server in a container.

docker run -d --name redis-server redis redis-server
Start Dynomite
Now we start up a dynomite node that connects to Redis. You must link this container to the other one.

docker run -d --link redis-server:redis-server -p 8379:8379  andrewwatson/dynomite 


Admin 
curl http://<docker_host>:22222



