

Create monitoring namespace

kubectl create ns monitoring

set context


kubectl create serviceaccount --namespace kube-system tiller

kubectl create clusterrolebinding tiller-clusterrolebinding --clusterrole=cluster-admin --serviceaccount=kube-system:tiller

helm init --service-account tiller


point the browser to the external ip


helm install --name monitoring stable/prometheus-operator
kubectl expose deployment monitoring-grafana --name=monitoring-grafanalb --port=80 --target-port=3000 --type=LoadBalancer --namespace=monitoring


Jaeger

kubectl create -f https://raw.githubusercontent.com/jaegertracing/jaeger-kubernetes/master/all-in-one/jaeger-all-in-one-template.yml

Get service
kubectl get svc


docker build -t orderservice .

docker images

docker image tag orderservice riazvm/publicrepo:orderservice1.0

docker push riazvm/publicrepo:orderservice1.0







kubectl expose deployment grafana --name=grafanalb --port=3000 --target-port=3000 --type=LoadBalancer --namespace=ingress-nginx

kubectl expose deployment prometheus-server --name=prometheuslb --port=9090 --target-port=9090 --type=LoadBalancer --namespace=ingress-nginx





kubectl expose deployment my-release-prometheus-oper-operator --name=my-release-promlb --port=9090 --target-port=9090 --type=LoadBalancer --namespace=monitoring



 