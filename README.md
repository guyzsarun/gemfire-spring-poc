# TanzuGemfire-SpringBoot-POC

## Project Structure

    .
    ├── ci                            # Concourse CI Configuration
    ├── gemfire-backend               # SpringBoot Application
    ├── gemfire-cluster               # Gemfire Cluster on Kubernetes
    ├── k8s                           # Kubernetes Cluster Configuration
    │
    └── README.md

## Installation

Clone the repo from Github

```
git clone  https://github.com/guyzsarun/gemfire-spring-poc.git
```

## Starting Gemfire on Kubernetes

Install cert-manager

```
kubectl apply -f https://github.com/jetstack/cert-manager/releases/download/v1.6.1/cert-manager.yaml
```

Create Gemfire Operator ( Download [Tanzu Gemfire for k8s](https://network.pivotal.io/products/tanzu-gemfire-for-kubernetes/)) and Update docker-secret.yaml (Refer to `example.docker-secret`)

```
 kubectl create namespace gemfire-operator
 kubectl apply -n gemfire-operator -f ./gemfire-cluster/docker-secret.yaml

 helm install gemfire-operator gemfire-operator-1.0.0.tgz -n gemfire-operator
```

Create Gemfire Cluster

```
  kubectl create namespace gemfire-cluster
  kubectl apply -n gemfire-cluster -f ./gemfire-cluster
```

## Usage

Create storage region

```sh
create region --name=movie --type=REPLICATE_HEAP_LRU --entry-idle-time-expiration=3600 --enable-statistics
```

Update api secret in `application.properties` ( Refer to `example.application.properties` )<br>
Movie API from [RapidAPI](https://rapidapi.com/apidojo/api/imdb8/)

```
api.rapid.host=
api.rapid.key=
```

or Create secret and attach to Kubernetes Cluster (Refer to `example.movie-secret.yaml`)

## API

SpringBoot backend available at http://localhost:8080/api/movie <br>
Swagger documentation available at http://localhost:8080/docs.html

### Example Response

#### Request

`GET /api/movie/`

```sh
curl --location --request GET 'localhost:8080/api/movie?name=avatar'
```

#### Response

```yaml
{
  "movie":
    [
      {
        "title": "Avatar: The Last Airbender",
        "year": "2005",
        "rank": "419",
        "id": "tt0417299",
        "poster": "https://m.media-amazon.com/images/M/MV5BODc5YTBhMTItMjhkNi00ZTIxLWI0YjAtNTZmOTY0YjRlZGQ0XkEyXkFqcGdeQXVyODUwNjEzMzg@._V1_.jpg",
      },
    ],
  "delay(ms)": 10,
}
```

## Concourse CI

Update docker credentials in `ci/settings.yaml`

```sh
fly -t gemfire-spring set-pipeline --pipeline {pipeline-name} --config ./ci/pipeline.yaml -l ./ci/settings.yaml
```
