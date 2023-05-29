# API DOC

## Register User

Endpoint : POST /api/users

Request Body :

```json
{
  "name" : "Alviona",
  "email" : "alviona@gmail.com",
  "password" : "rahasia"
}
```

Response Body :

```json
{
  "error" : "false",
  "message" : "user created" 
}
```


## Login User

Endpoint : POST /api/login

Request Body :

```json
{
  "email" : "alviona@gmail.com",
  "password" : "rahasia"
}
```

Response Body :

```json
{
  "error" : "false",
  "message" : "success",
  "loginResult" : {
      "userId" : "1",
      "name" : "Alviona",
      "token" : "blablablabala"
  }
}
```
