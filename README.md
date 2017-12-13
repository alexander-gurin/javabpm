# javabpm
реализована полная функциональность CRUD, без фронта на REST

проверить можно постманом:

create:
url: localhost:8080/create
body: {
    "id": 1,
    "customer": "test2",
    "startDate": "2018-05-01T00:00:00.0000",
    "endDate": "2018-05-29T00:00:00.0000",
    "status": 0
}

read:
url: localhost:8080/requests/customer1

update:
url: localhost:8080/update
body: {
    "id": 1,
    "customer": "customer1",
    "startDate": "2018-05-01T00:00:00.0000",
    "endDate": "2018-05-29T00:00:00.0000",
    "status": -1
}

delete:
url: localhost:8080/delete/test1
