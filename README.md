# TanzuGemfire-SpringBoot-POC

[CI](http://20.88.163.225:8080/api/v1/teams/main/pipelines/master/badge)

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
git clone https://github.com/guyzsarun/gemfire-spring-poc.git
```

## Usage

### Run using Java Springboot

Update api secret in `application.properties` ( Refer to `example.application.properties` )<br>
Movie API from [RapidAPI](https://rapidapi.com/apidojo/api/imdb8/)

```
api.rapid.host=
api.rapid.key=
```

### Run using Docker

Update api secret in `gemfire-backend/docker-compose.yaml` then run the following command:

```
cd gemfire-backend
docker-compose up
```

### Run using k8s

Create secret and attach to Kubernetes Cluster (Refer to `example.movie-secret.yaml`) then

```
kubectl apply -f ./k8s
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

Create storage region using `gfsh` command

```sh
create region --name=movie --type=REPLICATE_HEAP_LRU --entry-idle-time-expiration=3600 --enable-statistics
```

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
        "id": "tt0499549",
        "title": "Avatar",
        "year": "2009",
        "duration": "162 minutes",
        "poster": "https://m.media-amazon.com/images/M/MV5BMTYwOTEwNjAzMl5BMl5BanBnXkFtZTcwODc5MTUwMw@@._V1_.jpg",
        "rating": "7.8",
        "ratingCount": "1173261",
        "plot": "A paraplegic Marine dispatched to the moon Pandora on a unique mission becomes torn between following his orders and protecting the world he feels is his home.",
        "cast":
          [
            { "originalName": "Sam Worthington", "movieName": "Jake Sully" },
            { "originalName": "Zoe Saldana", "movieName": "Neytiri" },
            {
              "originalName": "Sigourney Weaver",
              "movieName": "Dr. Grace Augustine",
            },
          ],
      },
    ],
  "delay(ms)": 46,
}
```

## Concourse CI

Update docker credentials in `ci/settings.yaml`

```sh
fly -t gemfire-spring set-pipeline --pipeline {pipeline-name} --config ./ci/pipeline.yaml -l ./ci/settings.yaml
```

## Resources

<img src="https://spring.io/images/spring-logo-9146a4d3298760c2e7e49595184e1975.svg" width="150" >

[Springboot](https://spring.io/)

<img src="https://tanzu.vmware.com/developer/images/icons/icon-tanzu-gemfire.svg" height="70" >

[VMware Tanzu Gemfire](https://tanzu.vmware.com/gemfire)

<img src="https://concourse-ci.org/images/logo-white.svg" height="70" >

[Concourse CI](https://concourse-ci.org/)
