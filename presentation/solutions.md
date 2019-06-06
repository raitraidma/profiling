- CPU
  ```sql
  CREATE INDEX ix_comment_content ON comment USING GIN (to_tsvector('english', content));
  ```
  ```java
  @Query(value =
    "SELECT count(1) " +
      "FROM comment c " +
      "WHERE to_tsvector('english', content) @@ to_tsquery(:text)",
    nativeQuery = true)
  int countByContentIgnoreCaseContaining(@Param("text") String text);
  ```

- CPU
  ```sql
  CREATE INDEX ix_comment_created_at ON comment (created_at);
  CREATE INDEX ix_post_created_at ON post (created_at);
  ```

- Memory
  ```java
  @Cacheable(value = "avatar", key = "#author.id")
  ```
  or implement `hashCode`
  or
  ```java
  public byte[] getImageFromExternalService(Integer authorId)
  ```
