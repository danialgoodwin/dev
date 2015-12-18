# Database Cheat Sheet #
There are many different types of databases just like there are many types of data structures. Know which one to use and when.


- ACID
  - Atomicity
  - Consistency
  - Isolation
  - Durability






## Types of Databases ##

### Relational ###

- SQL
  - SQLite . The entire database is stored in a single file, so there is easy portability. Pro: Great for embedded apps.
  - MySQL
    - MariaDB
  - PostgreSQL: Advanced open-source SQL-standards compliant.
  - Oracle SQL


### Non-Relational (NoSQL) ###

There are different operational models for NoSQL:

- Key-Value Based:
  - Ex: Redis, MemcacheDB, Amazon's Dynamo
- Column Based:
  - Ex: Apache's Cassandra, HBase
- Document Based:
  - Ex: MongoDB, Couchbase
- Graph Based:
  - Ex: OrientDB, Neo4J





### NewSQL ###

Google's __ and F1

And more...



## Further Resources ##
- Great: [Comparison of Relational DBMS: SQLite, MySQL, PostgreSQL](https://www.digitalocean.com/community/tutorials/sqlite-vs-mysql-vs-postgresql-a-comparison-of-relational-database-management-systems)
- Great: [Comparison of NoSQL DBMS](https://www.digitalocean.com/community/tutorials/a-comparison-of-nosql-database-management-systems-and-models)
- [Quick comparison of many different NoSQL DBs](http://kkovacs.eu/cassandra-vs-mongodb-vs-couchdb-vs-redis)
- [Benchmarks for NoSQL: Cassandra, Couchbase, HBase, MongoDB](http://www.datastax.com/wp-content/themes/datastax-2014-08/files/NoSQL_Benchmarks_EndPoint.pdf): For 2015-04, Apache's Cassandra was a big leader of these four.
