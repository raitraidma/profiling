# Java profiling demo project

## About

- Presentation is in `presentation` folder.
  - It also contains `solutions.md` with fixes for demo project. **Do not peek in there before you have finished.**
- If you get stuck with fixing (not finding) problems, then there are some hints in `hints.md` file.
- `presentation` package contains examples for presentation.
- `lab` package contains code for hands-on lab.
- `lab` contains embedded PostgreSQL that will be downloaded when starting the project.


## Prerequisites

- Java 8
- Maven 3.6
- IntelliJ IDEA
- JProfiler 11

If you do not have IDE then you can:
- Open JProfiler
- `Start Center` > `New Session` > `New Session`
  - Session type: `Launch`
  - Main class or executable JAR: `target/profiling-1.0.jar`
  - From `Java File Path` select `Source path` and select `src/main/java`
- In `Call tree filters` add package `lab`

## Statistics of demo data

```sql
select count(1) from author; -- 10
select count(1) from post; -- 1000
select count(1) from comment; -- 1 000 000
```

## Embedded PostgreSQL
- Host: 127.0.0.1
- Port: 15432
- Username: postgres
- Password: postgres

# Help

- If Embedded PostgreSQL is not shut down, then find process id (PID)
  with `netstat -tulp | grep 15432` and kill it with `kill -9 <pid>`.
