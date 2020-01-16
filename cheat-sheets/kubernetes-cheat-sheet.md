# Kubernetes Cheat Sheet

Kubernetes automates deployment, scaling, and management of containers.
Containers are light-weight like processes and isolated like an operating system. They simplify packaging applications and their dependencies, allowing for a consistent experience. An example of a container is Docker.

Features:
- Better hardware utilization
- Health monitoring and self-healing
- Automatic scaling

Kubernetes cluster:
- Node types: Master, Worker (used to be called 'minion')
    - Master node(s) (aka, the control plane) manage the entire system of worker node(s), consisting of:
        - API Server
        - Scheduler
        - Controller
        - etcd: Storage of data
        - Note: There may be multiple master nodes to ensure high availability
    - Worker nodes are the machines that run the actual application code, consisting of:
        - Container runtime (like, Docker and rkt)
        - Kubelet: Talks to the API Server
        - Kube Proxy: Load balanacing

Kubernetes development lifecycle:
1. Package app in containers
2. Put those container images in an Image Registry
3. Post App Descriptor to the Kubernetes API Server
4. Scheduler schedules containers on available Worker Nodes
5. Kubelet instructs Nodes to download Container Images
6. Kubelet instructs Nodes to run the Containers

More terminology:
- Pods: Smallest unit that Kubernetes manages. Everything is built on top of this. Pods have containers and information about those containers


## Kubectl
Command-line interface for running commands against Kubernetes cluster.

    kubectl <operation> <object> <resource name> <optional flags>
    kubectl get nodes
    kubectl help
    kubectl get pods --all-namespaces

## Azure Kubernetes Service (AKS)

Features:
- Simplify deployment, management, and operations of Kubernetes
- Manages maintenance by provisioning, upgrading, and scaling resources on demand
- Manages master nodes
- Automated Kubernetes version upgrades and patching
- Easy cluster scaling



# Resources
- [Pluralsight: Azure Kubernetes Service - The Big Picture](https://app.pluralsight.com/library/courses/azure-container-service-big-picture/table-of-contents)
