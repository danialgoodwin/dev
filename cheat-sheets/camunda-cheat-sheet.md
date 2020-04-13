# Camunda Cheat Sheet
Open-source workflow automation.

Contents:
- [Get Started](#get-started)
- [Basic Workflow](#basic-workflow)
- [Zeebe](#zeebe)
- [Terminology](#terminology)
    - [BPMN](#bpmn)
- [Resources](#resources)



## Get Started via Docker
Great: https://docs.camunda.org/get-started/quick-start/

Summary:

**First time:**
1. Install Docker (if Mac: `brew install docker` and for GUI use `brew cask install docker`) and Java 8+
1. Run Docker and install the Camunda BPM Platform:
    - If Mac:
    
            docker pull camunda/camunda-bpm-platform:latest
            docker run -d --name camunda -p 8080:8080 camunda/camunda-bpm-platform:latest

1. Install the Camunda Modeler, see https://camunda.com/download/modeler
1. Run camunda-modeler


**Later times:**
1. Start Docker
1. Run: `docker run camunda/camunda-bpm-platform:latest`



## Basic Workflow
1. Start the local BPM engine, `nodeworker.js`
1. Update the workflow model via Camunda Modeler (BPMN, DMN)
1. In Camunda Modeler, save and deploy
1. Start a process



## Zeebe
A BPM similar to Camunda BPM, and made by Camunda, with more focus on scalability ('inifite' scale-out, [1M transactions/second](https://zeebe.io/blog/2018/06/benchmarking-zeebe-horizontal-scaling/)).

Zeebe supports BPMN and [YAML](https://docs.zeebe.io/yaml-workflows/index.html) workflows.

2020-01-28: [Camunda Cloud](https://camunda.com/products/cloud/) is in public beta, and at its core is Zeebee and Operate. Source: https://zeebe.io/blog/2020/01/announcing-camunda-cloud-public-beta/. BPMS-as-a-service.

More info:
- Zeebe FAQ: https://zeebe.io/faq/#how-is-zeebe-different-from-camunda-bpm
- Zeebe Forum 2017-08: https://forum.zeebe.io/t/understanding-zeebe/44/2
- Zeebe on GitHub: https://github.com/zeebe-io/



## Terminology

### BPMN
BPMN (Business Process Model and Notation) is a standard for defining workflow (business process) automation models and executions.

[BPMN Quick Guide](https://www.bpmnquickguide.com/view-bpmn-quick-guide/)

### CMMN

### DMN
A decision table represents decision logic, consisting of inputs, outputs, and rules. The table in XML uses DMN (Decision Model and Notation) for the encoding.



## Resources
- Camunda
    - Learn:
        - [https://camunda.com/learn/videos/](https://camunda.com/learn/videos/)
        - [Best practices](https://camunda.com/best-practices)
        - Many examples: https://github.com/camunda/camunda-bpm-examples
    - [Camunda Cloud](https://camunda.com/products/cloud/)
    - [Orchestrating Azure Functions using BPMN and Camunda — a case study](https://blog.bernd-ruecker.com/orchestrating-azure-functions-using-bpmn-and-camunda-a-case-study-ff71264cfad6)
- ISO: https://www.iso.org/standard/62652.html
    - [BPMN 2.0 specification](https://www.omg.org/spec/BPMN/2.0/)


Similar:
- [Amazon Simple Workflow Service (SWF)](https://aws.amazon.com/swf/)


Meh:
- [Sandy Kemsley, Industry Analyst Best of Breed: Rolling Your Own Digital Automation Platform using BPMS and Microservices](https://www.youtube.com/watch?v=j5RMoBF-kng)
