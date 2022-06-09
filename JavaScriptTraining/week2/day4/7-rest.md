# REST
Representational State Transfer

"RESTful API" -> An API that conforms to REST standards

GraphQL and SOAP are other alternatives

# 6 Architectural Constraints of REST

1. Uniform Interface
   - One logical URL/URI per resource
2. Client-Server
   - Client and Servers should be entirely separate
   - One should not depend on the other
   - Clients will only know of the servers throught these API endpoints
     - This allows the two to grow indepent of one another
3. Stateless
   - We should store any variables about the user on the web server
   - If we want to do this, use a database
4. Cachable
5. Layered System
6. Code on Demand