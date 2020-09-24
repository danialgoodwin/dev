# Modern Software Architecture Cheat Sheet

## Basic

- Domain-driven design
  - 1. Learn about the domain, 2. Recognize subdomains, 3. Design a rich domain model, 4. Code by telling objects in the domain what to do
  - Goal: Tackling software complexity
  - Key points: ubiquitous language, bounded context, context map
    - Ubiquitous language: People use different languages, so have some common terminology, which helps everybody better understand the user requirements. Also, this is shared language between domain experts and dev teams. Avoid acronyms, if possible.
    - Bounded context: Limited space where elements (of the ubiquitous language) have well-defined meaning. Each context has its own architecture and implementation (exL CQRS). This helps to remove ambiguity/duplication, simplifies design of software modules (by keeping them smaller), and easy to integrate into legacy code.
    - Context map: Diagram that provides a comprehensive view of the system being designed, aka shows all bounded context and their relationships. The main type of relationships are 'Conformist' (downstream totally depends on upstream context, no negotiation possible) and 'Customer/Supplier' (Customer depends on supplier context, but customer can raise concerns and have them addressed in some way) and 'Partner' (mutual dependency between two context) and 'Shared Kernel' (shared model that can't be changed without consulting both team depending on it) and 'Anti-corruption Layer' (additional fixed interface for the downstream context so that the interface never changes regardless of the upstream context)
- Supporting architectures
- UX-first design methodology
- Business Logic
  - Application Logic: Dependent on use-cases
  - Domain Logic: Invariant to use-cases
- CQRS: Command Query Responsibility Segregation
  - Classes with 'action' methods may be good for commands use-cases, but may not want those methods in a class that is only used for presentation (in the presentation layer).
    - A 'command' alters state and doesn't return data. A 'query' returns data and doesn't alter state.
  - Three so-called 'flavors' (not official terms):
    - Regular: 
    - Premium: 
    - Deluxe: 

### Resources
- [Pluralsight: Modern Software Architecture: Domain Models, CQRS, and Event Sourcing
](https://app.pluralsight.com/library/courses/modern-software-architecture-domain-models-cqrs-event-sourcing/table-of-contents)

- BBM: Big Ball of Mud, aka spaghetti code
- DDD: Domain-driven design



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
