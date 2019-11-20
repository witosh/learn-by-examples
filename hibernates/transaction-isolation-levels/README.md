# Transactions levels

### READ UNCOMMITED
**Lack of isolation.** Transaction are not isolated from each other. This type of isolation are usually read-only.

Possible anomalies may occures:
 - dirty reads,
 - non-repeatable reads,
 - phantom reads.

### READ COMMITED
**Minimum isolation.** The transaction holds a read lock (if it only reads the row) or write lock (if it updates or deletes the row) on the current row to prevent other transactions from updating or deleting it (read dirty data).

**read lock** releases when moves off the current row.
**write locks** releases when it's commited or rolled back

Possible anomalies may occures:
 - non-repetable reads,
 - phantom reads.

### REPEATABLE READS
**Guarantee reproducibility of read data.** The transaction holds read locks on all rows it returns to the application and write locks on all rows it inserts, updates, or deletes. 

Because other transactions cannot update or delete these rows, the current transaction avoids any nonrepeatable reads.

**read lock** releases when it's commited or rolled back
**write locks** releases when it's commited or rolled back
 
Possible anomalies may occures:
 - phantom reads.

### SERIALIZABLE
**The highest level of isoation.** The transaction holds a read lock (if it only reads rows) or write lock (if it can update or delete rows) on the range of rows it affects. 

Because other transactions cannot update or delete the rows in the range, the current transaction avoids any nonrepeatable reads.

Because other transactions cannot insert any rows in the range, the current transaction avoids any phantoms.

**read lock** releases when it's commited or rolled back
**write locks** releases when it's commited or rolled back

Prevent against:
- dirty reads,
- non-repeatable reads,
- phantom reads.

Sorces:
 - https://docs.microsoft.com/en-us/sql/odbc/reference/develop-app/transaction-isolation-levels?view=sql-server-2017 [EN]
