# Anomalies in transactions

In short we can distinguish sucha types of anomalies in database transactions:
- dirty reads,
- non-repeatable reads,
- phantom reads.

### dirty reads
In this type of anomaly stands that if we have transaction **A** which query on table `orders` e.g. `select * from orders where id = 123'` and in the same point of time transaction **B** updates this row on table: `update orders set status = 'Blocked' where id = 123` and this transaction was not commited yet. So there is danger that transaction **A** read a modificated value of column `status` even if  transaction **B** was not commited. 

At a glance transaction **A** read modificated value of transaction **B** and transaction **B** was not commited yet. :exclamation: :collision: :exclamation:  

### non-repeatable reads
It occurs in situation when in transaction **A** we query more than once. In transaction **A** we query e.g. `select * from orders where id = 123'` and we get concrete data and in transaction **B** this row is updated `update orders set status = 'Blocked' where id = 123` and commited !!! Again in transaction **A** we query the same `select * from orders where id = 123'` and we get modificated row. To different result of this same query in transaction!!! 

At a glance transaction **A** querying on a table and may have return different results because of data was modificated by another transaction in time of working transaction **A**. exclamation: :collision: :exclamation:  

### phantom reads
We have transaction **A** and it query on table `select * from orders where id > 123'` to fetch a concrete number of rows. At the same point of time transaction **B** insert new row which meet requirements of above query `insert into orders ('id','status',name) values (124,'New','Hardware order')` and commit the changes. The transaction **A** querying once again and get additional record inserted in transaction **B**. 

At the glance transaction **A** querying on the table and in the mean time transactin **B** insert new row (met requirements of query from transaction **A** and commit it). Transaction **A** querying again and get additional row in the context of the same transaction using the exactly tyhe same query.  exclamation: :collision: :exclamation:  

Sources:
 - http://blog.stelmisoft.pl/2010/poziom-izolacji-transakcji-w-jdbc/  [PL]
