# Circle CI Multi-Cloud Kubernetes Demo

Build, Test and Deploy a simple webapp using CircleCI, Docker, Kubernetes and CloudFlare DNS.  


## More Info
This project repo is the source code companion a series of CircleCI Blog posts. [ADDRESS]


##  Testing
To test simple UI functionality we're using Spring Boot's test starter and Selenium's `WebDriver` interface.  If you'd like an isolated example building Docker containers from Java, checkout [CircleCI Jib demo project](https://github.com/eddiewebb/circleci-jib-demo)

## Containerizing
To turn our executable jar into a Docker image we're using Jib, a project from Google.

## Deploying
Locking into a single cloud provider can reduce initial investment, but may limit future portability.  This demo targets k8s on a few major providers

###  GCP (Google Cloud)
We'll install gcloud cli and kubectl to manage our interations with Google's cluster orschestration.

### AWS ECS (Amazon Container Service)


## DNS Management
It's easy to use static IPs with a single cloud provider, but when you want your application across many providers or regions, you might want a global DNS solution.  THis demo uses CloudFlare which has a rich API for enabling and re-routing traffic through our deployment lifecycle.

### Viewing
And live app visible on http://justademo.online

### Cloud Specific URLS
Yeah, that'd be cool, TBD.




## Running locally

This project uses spring boot, so run as you would any other like project to start on port :8080 locally.

```
mvn spring-boot:run
```
