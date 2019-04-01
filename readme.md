Based on https://medium.com/@tminussi/building-the-backend-for-a-real-time-chat-app-with-reactive-spring-d22b4039fcc8

MongoDB:
Doesn't work without mounting, according to: https://hub.docker.com/_/mongo
docker volume create --name=mongochatdata
docker run --name mongo-chat -p 27017:27017 -v mongochatdata:/data/db -d mongo

(Had a strange bug, Error starting userland proxy: mkdir /port/tcp:0.0.0.0:27017:tcp:172.17.0.2:27017: input/output error, this might not have been the cause, according to stackoverflow the port might have been in use, but it surely wasn't, but restarting docker solved the issue.)


db.createCollection("messages", { capped: true, size: 5000000, max: 10000 });

-can only react to capped collections  
-can't update data in capped collection  
-can't remove data from capped collection  
