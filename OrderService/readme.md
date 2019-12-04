docker run \
    -p 9090:9090 \
    -v /Users/riazm/Documents/workspaces/eclipse/OrderService/prometheus.yaml:/etc/prometheus/prometheus.yml \
    prom/prometheus