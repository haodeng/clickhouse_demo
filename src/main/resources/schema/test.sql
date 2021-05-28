CREATE DATABASE IF NOT EXISTS test;

CREATE TABLE test.logevent (
    eventid FixedString(36),
    event String,
    time UInt64,
    message String
)
ENGINE = Memory;