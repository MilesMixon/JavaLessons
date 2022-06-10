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
     - This allows the two to grow independent of one another
3. Stateless
   - We should store any variables about the user on the web server
   - If we want to do this, use a database
   - Treats all requests as brand new requests
4. Cachable
   - Requests should be made to be cacheable
     - Is used to improve lookup times for resources
   - Client will pass some header in the HTTP request for some cached resource
   - GET requests are cacheable by default
     - Caches are opt out, clients should be able to send a request to "invalidate the cache"
   - POST requests can be cached if indicated through specific headers such as "Expires" or "Cache-Control"
5. Layered System
   - Gateways or Load Balancers
   - I can store logic on separate servers, but the client does not know about these separate servers
6. Code on Demand (Optional)
   - Have the ability to return executable code

# URL Conventions

1. Let the HTTP method drive the implication (Don't put the verb in the URL)

Bad: GET https://www.mysite.com/getCat/a_calico_cat.png
     PUT https://www.mysite.com/updateCat/a_calico_cat.png
Good: GET https://www.mysite.com/cat/a_calico_cat.png
      PUT https://www.mysite.com/cat/a_calico_cat.png

2. Adding hierarchies to your URLs

Similar to a file system
/users/Sean/Documents
/users/Gary/Documents

http://mysite.com/<category>/<sub-category>/<item>
ex. http://mysite.com/user/23/friends/52
ex. http://mysite.com/movies/56

3. Filtering based off URL

GET http://mysite.com/movies // GET all movies
GET http://mysite.com/movies?limit=5 // GET 5 movies
GET http://mysite.com/movies?genre=vampire GET all movies that have vampire as genre

4. Versioning
We want to version our URLs so that we can update them at a later point in time
This is useful as to not break your users' websites if they depend on your API (They will be angry)

GET http://mysite.com/v1/movies/37 -> 'Star Wars'
GET http://mysite.com/v2/movies/37 -> {title: 'Star Wars', director: 'George Lucas'}