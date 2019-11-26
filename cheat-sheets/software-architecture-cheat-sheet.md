# Modern Software Architecture Cheat Sheet

## Basic

- Domain-driven design
  - 1. Learn about the domain, 2. Recognize subdomains, 3. Design a rich domain model, 4. Code by telling objects in the domain what to do
  - Goal: Tackling software complexity
  - Key points: ubiquitous language, bounded context, context map
    - Ubiquitous language: People use different languages, so have some common terminology, which helps everybody better understand the user requirements. Also, this is shared language between domain experts and dev teams. Avoid acronyms, if possible.
    - Bounded context: Limited space where elements (of the ubiquitous language) have well-defined meaning. Each context has its own architecture and implementation (exL CQRS). This helps to remove ambiguity/duplication, simplifies design of software modules (by keeping them smaller), and easy to integrate into legacy code.
    - Context map: 
- Supporting architectures
- UX-first design methodology


# Resources
- [Pluralsight: Modern Software Architecture: Domain Models, CQRS, and Event Sourcing
](https://app.pluralsight.com/library/courses/modern-software-architecture-domain-models-cqrs-event-sourcing/table-of-contents)


- BBM: Big Ball of Mud, aka spaghetti code
- DDD: Domain-driven design
