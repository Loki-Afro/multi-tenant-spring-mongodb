multi-tenant-spring-mongodb
===========================

A project with spring-data-mongodb supporting multi tenancy

Why?
-----------

If you are having a structure like the following in your mongodb it is pretty bad to handle, since spring-data-mongodb does not support multi tenancy.

```
CUSTOMER_DB_A #
  - collectionA
  - collectionB
  - collectionC
CUSTOMER_DB_B
  - collectionA
  - collectionB
  - collectionC
```
the data structure in these collections is the same, every customer does just have its own database in one mongodb instance.


There are serveral requests on StackOverflow regarding this topic:
http://stackoverflow.com/questions/16325606/making-spring-data-mongodb-multi-tenant
http://stackoverflow.com/questions/20791656/multi-tenant-mongodb-database-based-with-spring-data
http://stackoverflow.com/questions/12078669/spring-data-mongodb-connect-to-multiple-databases-in-one-mongo-instance

Conclusion
----------------

I don't think that this is the best approach to archive this functionality but it just works without reinventing spring-data-mongodb.

With just a `ThreadLocal` it is not done, if you walso want to create Indexes. So I added a bit more sugar to it.


Just take a [look into Application.java](src/main/java/com/github/zarathustra/Application.java)

Happy Hacking!

