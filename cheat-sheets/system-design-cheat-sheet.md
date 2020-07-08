# System Design Cheat Sheet


## Things to Consider

- Amount of I/O


- Backups. Point-in-time copy of a workload. Isolated from the source. Recovery point.
- High Availability.
- Disaster Recovery. Recovery time.



## Fallicies of distributed computing
1. The network is reliable
1. Latency isn't a problem
1. Bandwidth isn't a problem
1. The network is secure
1. The topology won't change
1. The administator will know what to do 
1. Transport cost isn't a problem
1. The network is homogeneous
1. The system is atomic/monolithic
1. The system is finished
1. Business logic can and should be centralized

Source: Deutsch 94 and Gosling 97 (1-8), Neward 06 (9-11)



## Ideas
- Can't eagerly fetch everything and can't lazy-load everything, so we may need to split the domain model to resolve forces of bandwidth and latency
- APIs as priority-centric rather than entity-centric
- Production data may be secure, what about back-up data?



## Different types of coupling
- Platform
- Spatial
- Efferent/Incoming
- Afferent/Outgoing
- Tempoaral



## Resources
- 


