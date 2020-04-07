# Docker Cheat Sheet

## Basic




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


