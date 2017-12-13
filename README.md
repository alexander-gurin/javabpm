# javabpm

Реализована полная функциональность CRUD. Нет фронта, голый  REST

проверить можно постманом:

create: <br />
url: localhost:8080/create <br />
body:
```javascript
{
    "id": 1,
    "customer": "test2",
    "startDate": "2018-05-01T00:00:00.0000",
    "endDate": "2018-05-29T00:00:00.0000",
    "status": 0
}
```
read: <br />
url: localhost:8080/requests/customer1

update: <br />
url: localhost:8080/update <br />
body:
```javascript
{
    "id": 1,
    "customer": "customer1",
    "startDate": "2018-05-01T00:00:00.0000",
    "endDate": "2018-05-29T00:00:00.0000",
    "status": -1
}
```
delete: <br />
url: localhost:8080/delete/test1
