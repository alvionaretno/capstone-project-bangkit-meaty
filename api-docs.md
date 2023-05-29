# API DOC

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

## Add Images

Endpoint : POST /stories

Headers :
```json
{
  "content-type" : "multipart/form-data",
  "authorization" : "<token>"
}
```


Request Body :

```json
{
  "file" : "image.jpg",
  "description" : "something something"
}
```

Response Body :

```json
{
  "error" : "false",
  "message" : "success"
}
```

## Get Image

Endpoint : POST /stories

Parameter : `id`

Headers :
```json
{
  "authorization" : "<token>"
}
```


Request Body :

```json
{
  "file" : "image.jpg",
  "description" : "something something"
}
```

Response Body :

```json
{
  "id" : "1",
  "error" : "false",
  "message" : "success",
  "image" : {
      "photoUrl" : ".....",
      "description" : "something something",
      "createdAt" : "....."
  }
}
```
