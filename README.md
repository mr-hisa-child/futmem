# futmem

```
postgresql:
  image: postgres:9.4
  ports:
    - 5432:5432
  volumes:
    - ~/work/postgres/data:/var/lib/postgresql/data
redis:
  image: redis
  ports:
    - 6379:6379
```
