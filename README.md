# Dietary Journal API

This project provides a REST API for an dietary journal app, that allows the user to track what he eats in a day.
This project uses Quarkus, the Supersonic Subatomic Java Framework.

## URL

localhost with port 8080 is used for test purposes
```
http://localhost:8080
```

## GET 

   **Get list of food for specific user**
  ``` 
   /foods/{userId}
 ```
 where
   `userId=[string]`

GET Request example:
  ```GET /foods/4 
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache
  ```
   **Get list of food for specific user and date filter**
  ``` 
   /{userId}/{dateStart}/{dateEnd}
 ```
 where
   `userId=[string]`
   `dateStart=[long]`
   `dateEnd=[long]`

GET Request example:
  ```GET /foods/4/1579598718223/1579599042409
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache
  ```
  
GET Response example:
  ```[
    {
        "date": "2020-01-21T13:45:24.194Z[UTC]",
        "id": 1,
        "name": "apple",
        "portion": 2,
        "userId": "4",
        "weight": 300
    },
    {
        "date": "2020-01-21T13:45:43.002Z[UTC]",
        "id": 2,
        "name": "pineapple",
        "portion": 1,
        "userId": "4",
        "weight": 400
    }
]
  ```
## POST

   **Add a new food**
  ``` 
   /foods
 ```
POST Request example:
  ```POST /foods
Host: localhost:8080
Content-Type: application/json
cache-control: no-cache

Body:
{"portion":2,"weight":300,"name":"apple","userId":"4"}
  ```
  
POST Response example:
  ```1
  ```
## DELETE

   **Remove new food by ID**
  ``` 
   /foods/{id}
 ```
where
   `id=[long]`
   
DELETE Request example:
  ```DELETE /foods/1
Host: localhost:8080
Content-Type: application/json
cache-control: no-cache
  ```
DELETE Response example:
  ```{
        "date": "2020-01-21T13:45:24.194Z[UTC]",
        "id": 1,
        "name": "apple",
        "portion": 2,
        "userId": "4",
        "weight": 300
    }
  ```
