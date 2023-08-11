namespace java org.example.thrift

struct Person {
    1: required i32 id,
    2: required string name,
    3: optional string email
}