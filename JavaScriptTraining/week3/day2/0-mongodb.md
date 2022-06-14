# What is MongoDB?

- MongoDB is Non-Relational (NoSQL)
  - Mongo is a "Document Database"
- The data is structured as key value pairs
  - Uses something BSON (JSON-like)
    - Binary JSON
- MongoDB is "schemaless"
  - A "schemaless" database is not rigid in what it expects
  - Pros:
    - Makes the structure more flexible
    - Easier to add new details an existing collection
  - Cons:
    - Less rigid
    - Certain fields that maybe should be there might be ommitted
- MongoDB is very fast at reading/writing to a single document/collection
  - If you use joins though, it is MUCH slower

# BSON
- Binary JSON
- Quicker to read from
- The JSON-like structure is comfortable for developers
  - You structure your "documents" as you would expect the data back coming back client side
- Since it's binary there's some metadata attached such as the data type

# MongoDB Terminology
- Collection (Table)
- Document (Row)
- Field (Column)
- Embedding (A sub-document)
- Referencing (Foreign Key)

# Embedding vs Referencing

# Embedding
- You should favor embedding over referencing
  - Referencing requires a join/$lookup which is very expensive (time sensitive)
  - This may result in data duplication/de-normalization (occurs with embedding)
- 1-1 (Always embed)
- 1-Few (Embed if it makes sense)
- 1-Many (Referencing)
- 1-Squillions (Referencing)
- There IS a document size limit of 16 MB
  - If you embed TOO much data, you may hit that size limit
  - Avoid "unbounded arrays" by referecing where need be

# Referencing
- Referencing should be used where it's sensible
- Helps to prevent duplication of data
- Helps to normalize data
- Less performant than embedding
- It's good when you have a 1 to many relationship or a Many to Many

# Best Practices
- Design the structure of your database to the needs of your application
  - "Data that is accessed together should be stored together"
- Favor embedding over referencing
  - Don't be afraid of data duplication
  - The cost of storing duplicate data is less of a concern than the speed at which it's accessed