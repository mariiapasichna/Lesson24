## Task:

Implement a full set of CRUD operations for user in JSON format with saving to H2 database:
- create;
- delete;
- update;
- get user by name or id;
- get list of users.

1) ***Create user: POST***

The server should return:
- Status: 200 OK, response in JSON format `"{"result":"success"}"` and save user to H2 database if operation is successful;
- Status: 400 BAD_REQUEST, response in JSON format `"{"result":"failed"}"` if operation is failed;

#### Example:
At the url http://164.68.101.149:12345/Lesson_24_mariiapasichna/database we send POST request and body in JSON format:

`{
      "name": "Alex",
      "age": 22
}`

Get JSON:

`{
  "result":"success"
}`

2) ***Get list of users: GET***

The server should return:
- Status: 200 OK and list of users in JSON format

#### Example:
At the url http://164.68.101.149:12345/Lesson_24_mariiapasichna/database we send GET request

We get the list of users in JSON format:

`[{
    "id": 1,
    "name": "Alex",
    "age": 22
}]`

3) ***Get user by id: GET***

The server should return:
- Status: 200 OK and user in JSON format if operation is successful;
- Status: 404 NOT_FOUND and response in JSON format `"{"result":"user not found"}"` if user with such id was not found;

#### Example:
At the url http://164.68.101.149:12345/Lesson_24_mariiapasichna/database/1 we send GET request

We get the user in JSON format:

`{
    "id": 1,
    "name": "Alex",
    "age": 22
}`

4) ***Update user: PUT***

The server should return:
- Status: 200 OK, the changed user in JSON format and make changes to H2 database if operation is successful;
- Status: 404 NOT_FOUND, response in JSON format `"{"result":"user not found"}"` if user with such id was not found;

#### Example:
At the url http://164.68.101.149:12345/Lesson_24_mariiapasichna/database we send PUT request and body in JSON format:

`{
    "id": 1,
    "name": "Alex",
    "age": 44
}`

We get the changed user in JSON format:

`{
    "id": 1,
    "name": "Alex",
    "age": 44
}`

5) ***Delete user: DELETE***

The server should return:
- Status: 200 OK, response in JSON format `"{"result":"success"}"` and delete user from H2 database if operation is successful;
- Status: 404 NOT_FOUND, response in JSON format `"{"result":"user not found"}"` if user with such id was not found;

#### Example:
At the url http://164.68.101.149:12345/Lesson_24_mariiapasichna/database we send DELETE request and body in JSON format:

`{
    "id": 1,
    "name": "Alex",
    "age": 44
}`

Get JSON:

`{
  "result":"success"
}`

6) ***Delete all users: DELETE***

The server should return:
- Status: 200 OK, response in JSON format `"{"result": number of deleted users}"` and delete all users from H2 database

#### Example:
At the url http://164.68.101.149:12345/Lesson_24_mariiapasichna/database/clear we send DELETE request

Get JSON:

`{
  "result": 1
}`
