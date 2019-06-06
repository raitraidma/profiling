# Hints to solve problems

Don't know how to GOOGLE?

- `equals` and `hashCode`
- DB INDEX
- `CREATE INDEX ix_index_name ON table_name USING GIN (to_tsvector('english', field_name));`
- `to_tsvector('english', field_name) @@ to_tsquery('text-to-search')`
