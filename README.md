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
  -H 'postman-token: bfd88e31-5896-8fce-9807-08be29f7faf7' \
  -d '{
	"column" : "TODO",
	"timestamp" : 2124345565,
	"user" : "Ankit",
	"board" : "Jira",
	"tag" : "FDS",
	"desc" : "Ticket 1"
}'