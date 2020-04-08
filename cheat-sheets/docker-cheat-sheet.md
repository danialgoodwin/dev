# Docker Cheat Sheet
Docker is a containerization platform used to develop, ship, and run containers.



## Basic

### Docker Architecture

- Docker Engine: Contains serveral components
    - Docker Client: The CLI (`docker`) to manage containers via a Docker server
    - Docker Server: A daemon ('dockerd') that tracks the lifecycle of containers and responds to requests from the client
    - Docker Objects: Includes networks, storage volumes, plugins, and other service objects to configure container deployments
- Docker Hub: The default SaaS Docker container registry for image management, similar to Azure Container Registry.



## Troubleshooting

### Error: "Cannot connect to the Docker daemon at unix:///var/run/docker.sock. Is the docker daemon running?"
Solution: Start the Docker daemon. If Mac, then launch the Docker app (cmd+space, docker, enter).

### Error: "Error response from daemon: dial unix docker.raw.sock: connect: connection refused"
If Linux, then here's a few alternatives that _might_ work: `service start docker`, `sudo snap start docker`, `systemctl start docker.service`.

### Error: The name is already in use by container
You can see all containers (running or not) by using `docker ps -a`

To start an existing container, run: `docker start <name>`

TO remove the existing container, run: `docker rm <name>`



## Resources


