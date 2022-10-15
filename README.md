# trello-clone

docker pull mongo:latest
docker run -d --name mongo_local -p 27017:27017 -e MONGO_INITDB_ROOT_USERNAME=trello -e MONGO_INITDB_ROOT_PASSWORD=trello mongo

curl -X GET \
  'http://localhost:8080/trello/cards?tag=FDS' \
  -H 'authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhbmtpdC5zb29kIiwiZXhwIjoxNTgwMDgyOTk4LCJpYXQiOjE1ODAwNjQ5OTh9.j7bG4Ra3zxWc6Y4-v7-cRwGCK5tod8NAigCDcV7oppWYz9bWyI4WxLz1Zj_hbzsKVWe-wYS4qS9x2UvqP4XI4g' \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: 83f3aacc-fa48-90a1-11c9-067a7755be2b' \
  
curl -X POST \
  http://localhost:8080/trello/cards \
  -H 'authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhbmtpdC5zb29kIiwiZXhwIjoxNTgwMDgyOTk4LCJpYXQiOjE1ODAwNjQ5OTh9.j7bG4Ra3zxWc6Y4-v7-cRwGCK5tod8NAigCDcV7oppWYz9bWyI4WxLz1Zj_hbzsKVWe-wYS4qS9x2UvqP4XI4g' \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: d992d32e-1053-b04a-046f-d8c8bdfd8304' \
  -d '{
	"columnId" : "c1-todo",
	"timestamp" : 2124345565,
	"userId" : "a0s227",
	"boardId" : "b227",
	"tag" : "FDS",
	"desc" : "Ticket 1"
}'