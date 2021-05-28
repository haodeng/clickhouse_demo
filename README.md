# clickhouse_demo
ClickHouse is a fast open-source OLAP database management system

## Setup env

    docker pull yandex/clickhouse-server
    
    # run server
    docker run -d --name clickhouse-server -p 8123:8123 --ulimit nofile=262144:262144 yandex/clickhouse-server
    
    # run client
    docker run -it --rm --link clickhouse-server:clickhouse-server yandex/clickhouse-client --host clickhouse-server
    
