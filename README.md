# ...

# Pageable 요청용 쿼리

```aidl
http://localhost:8080/api/customers?page=0&size=5&sort=firstName,desc
```

- page: 0부터 시작한다.
- size: 한페이지당 조회개수
- sort: 소트하고자 하는 필드명 (sort=firstname,desc), (sort=firstName,desc&sort=lastName,asc)