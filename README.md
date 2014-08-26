spring-data-jpa-bug
===================

Reproduction scenario where moving from Spring Data JPA 1.5.3 to 1.6.2 causes an
`org.springframework.dao.InvalidDataAccessApiUsageException: detached entity passed to persist:...` error. The
exact same code but using Spring Data JPA 1.5.3 works perfectly.  Edit the `gradle.properties` file to see
what I mean.
