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
1. Run: `docker start camunda`
1. Start your model's task worker(s), i.e. `node worker.js`



## Basic Workflow
1. Start the local BPM engine, `nodeworker.js`
1. Update the workflow model via Camunda Modeler (BPMN, DMN)
1. In Camunda Modeler, save and deploy
1. Start a process



## Development

### How to programmatically update BMPS and DMS rules

    curl -v http://localhost:8080/engine-rest/deployment/create -F deployment-name="<NAME>" -F table.dmn=@<FILE>

Reference: https://stackoverflow.com/questions/39220889/how-to-programatically-update-dmn-rules-in-camunda-tomcat

### How to use http-connector connecer
1. Create a new 'Service' task, and set its 'Implementation' to 'Connector'
1. In the 'Connector' tab, set the following input parameters:
    - method: <GET or POST>
    - url: <your-url>
    - headers: <your-headers>
    - payload: <your-payload>

Reference: https://docs.camunda.org/manual/latest/reference/connect/http-connector/

Similar: https://github.com/camunda/camunda-bpm-examples/tree/master/servicetask/rest-service

### How to use mail-send connector
todo

### How to use SendGrid with Camunda
1. Set up a http-connector in Camunda Modeler
1. Set up a SendGrid account and call it

Reference:
- Node.js: https://github.com/sendgrid/sendgrid-nodejs0
- v3-mail-send:
    - https://sendgrid.com/docs/API_Reference/api_v3.html
    - https://sendgrid.api-docs.io/v3.0/mail-send/v3-mail-send
- Verify Sender:
    - https://sendgrid.com/docs/ui/sending-email/senders/
    - https://sendgrid.com/docs/for-developers/sending-email/sender-identity/



## Products

### Camunda BPM Run
Simplified and lightweight version of the full Camunda BPM engine.

More info:
- [Documentation - Camunda BPM Run](https://docs.camunda.org/manual/latest/user-guide/camunda-bpm-run/)
    - Notes: "The idea behind Run is to provide a full Camunda BPM distro with a simple but powerful configuration mechanism that can be operated by everyone, regardless of their knowledge about Java or application server configuration."
- [Blog: Introducing Camunda BPM Run (2020-03-06)](https://blog.camunda.com/post/2020/03/introducing-camunda-bpm-run/) - Still in 'early alpha stage'
    - Notes: "Early alpha stage". "easy configuration and fast bootstrapping of a Camunda BPM engine". "We have many ideas for further improvements to the distro, like providing a docker container, integrate a Swagger API endpoint, or add a drop folder for custom script engines."

### Camunda Cloud and Zeebe
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

- [BPMN Quick Guide](https://www.bpmnquickguide.com/view-bpmn-quick-guide/)
- [Camunda's BPMN 2.0 Symbol Reference with examples](https://camunda.com/bpmn/reference/)

### CMMN

### DMN
A decision table represents decision logic, consisting of inputs, outputs, and rules. The table in XML uses DMN (Decision Model and Notation) for the encoding.



## Troubleshooting
In general, if there is an error starting Camunda BPM with Tomcat, then check the logs at <download-location>/server/apache-tomcat-9.0.24/logs/catalina.*.log. For example: '~/Downloads/camunda-bpm-tomcat-7.12.0/server/apache-tomcat-9.0.24/logs/catalina.2020-04-16.log'



## Resources
- Camunda
    - Learn:
        - [https://camunda.com/learn/videos/](https://camunda.com/learn/videos/)
        - [Best practices](https://camunda.com/best-practices)
        - Many examples: https://github.com/camunda/camunda-bpm-examples
    - [Architecture Overview](https://docs.camunda.org/manual/latest/introduction/architecture/)
    - [Camunda Cloud](https://camunda.com/products/cloud/)
    - [Orchestrating Azure Functions using BPMN and Camunda — a case study](https://blog.bernd-ruecker.com/orchestrating-azure-functions-using-bpmn-and-camunda-a-case-study-ff71264cfad6)
    - [Performance Notes](https://camunda.com/products/performance/)
- ISO: https://www.iso.org/standard/62652.html
    - [BPMN 2.0 specification](https://www.omg.org/spec/BPMN/2.0/)


Similar:
- [Amazon Simple Workflow Service (SWF)](https://aws.amazon.com/swf/)


Meh:
- [Sandy Kemsley, Industry Analyst Best of Breed: Rolling Your Own Digital Automation Platform using BPMS and Microservices](https://www.youtube.com/watch?v=j5RMoBF-kng)
