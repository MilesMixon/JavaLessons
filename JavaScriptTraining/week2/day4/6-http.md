# HTTP
HyperText Transfer Protocol

HTTP is the language of the web
It occurs Layer 7 of the OSI (Application Layer)
Protocol for transfering data across the internet

# HTTP Request
Is made by the client and sent to a server
The request will carry information on it such as any data, the request method, and any additional meta data

# HTTP Response
When a web server receives an HTTP request it will process before sending back an HTTP response

A response is sent by the web server to pass back any data that user requested or any error that may have occured

# HTTP Methods
Methods are used to add semantic meaning to our HTTP requests

GET - Retrieve a resource
POST - Creating a resource
PUT - Updating a resource (Putting in a new tire)
DELETE - Deletes a resources

Others:
HEAD - Same as a GET request, but the request body is ignored (ping)
PATCH - Updating a resource (Taking an existing tire and just patching one spot)
OPTIONS - Asks the server what options are allowed before moving forward
        Typically used in conjunction with CORS and authorization

# HTTP Status Codes

# Idempotency
- The ability to perform/apply the same method multiple times in conjunction and have the same effect each time
- GET is idempotent because I can request the same resource many times without changing what I get back
  - Think of this as looking at a piece of cake. I can look as much as I want without altering things
- PUT is idempotent because if I update something many times, it's functionally the same effect
  - Sean -> John and John -> John
    - That's still a job well done
- DELETE is idempotent
  - Same reason. Deleting multiple times will still result in it being deleted so job well done
- POST is NOT idempotent
  - Creating a resource is not the same effect because it's brand new
  - DOing two POST requests should result in 2 new entities being created
