# Microsoft Azure Cheat Sheet


## Quick Overview

- DTU vs vCore
  - DTUs are a blend of compute, storage, and I/O. All scale together. This is more used by people who want simple/quick configurations.
  - vCore separates compute, storage, and I/O resources.
- DWU (Data Warehouse Unit): Basically, each 100DWU is one compute node (up to 60). Each additional DWU increases performance/parallelism.

## Quick Comparisons

### Extract, Load, Transform
|          |                    SSIS                    |               Data Factory               |                 Databricks                |
|----------|:------------------------------------------:|:----------------------------------------:|:-----------------------------------------:|
| Platform | On-Premises<br>Own Hardware<br>Scale Out |      Hybrid<br>Managed<br>Scale Up     |      Cloud<br>Managed<br>Autoscale      |
| Lanauges |                VB, C#, Biml                |         .NET, Python, PowerShell         |           SQL, Python, R, Scala           |
| Variety  |                 Structured                 |         Structured, Unstructured         |          Structured, Unstructured         |
| Velocity |                    Batch                   |             Batch<br>Streaming             |        Batch<br>Streaming<br>Real-Time        |
| Volume   |                   Medium                   |                   High                   |                    High                   |
| Purpose  |   Integration<br>Transformation<br>ETL   | Movement<br>Orchestration<br>ETL / ELT | Preparation<br>Collaboration<br>AI / ML |

### Storage

## [Azure Resource Manager](https://docs.microsoft.com/en-us/azure/azure-resource-manager/)

### Template Deployment

Template format:

    {
      "$schema": "https://schema.management.azure.com/schemas/2015-01-01/deploymentTemplate.json#",
      "contentVersion": "",
      "apiProfile": "",
      "parameters": {  },
      "variables": {  },
      "functions": [  ],
      "resources": [  ],
      "outputs": {  }
    }

Example:

    "resources": [
      {
        "apiVersion": "2016-01-01",
        "type": "Microsoft.Storage/storageAccounts",
        "name": "mystorageaccount",
        "location": "westus",
        "sku": {
          "name": "Standard_LRS"
        },
        "kind": "Storage",
        "properties": {
        }
      }
    ]

Example with parameters:

    "parameters": {
      "storageSKU": {
        "type": "string",
        "allowedValues": [
          "Standard_LRS",
          "Standard_ZRS",
          "Standard_GRS",
          "Standard_RAGRS",
          "Premium_LRS"
        ],
        "defaultValue": "Standard_LRS",
        "metadata": {
          "description": "The type of replication to use for the storage account."
        }
      }   
    },
    "resources": [
      {
        "type": "Microsoft.Storage/storageAccounts",
        "sku": {
          "name": "[parameters('storageSKU')]"
        },
        ...
      }
    ]

More info:
- https://docs.microsoft.com/en-us/azure/azure-resource-manager/resource-group-authoring-templates
- [Azure Resource Manager template best practices](https://docs.microsoft.com/en-us/azure/azure-resource-manager/template-best-practices)
    - Parameter names should be camelCase
    - Each parameter should have a description
    - Each resource should have a comment
- [Azure Resource Manager Schemas](https://github.com/Azure/azure-resource-manager-schemas)
    - Includes validation tool
    - [Schemas for resources](https://docs.microsoft.com/en-us/azure/templates/)
- Get keys from Microsoft.DocumentDB/databaseAccounts:
    - Via REST: https://docs.microsoft.com/en-us/rest/api/cosmos-db-resource-provider/DatabaseAccounts/ListKeys
    - On Stack Overflow: https://stackoverflow.com/questions/42486845/azure-arm-templates-documentdb-primarymasterkey-as-output
    - https://docs.microsoft.com/en-us/azure/azure-resource-manager/resource-group-template-functions-resource#reference


## [Azure Analysis Services](https://azure.microsoft.com/en-us/services/analysis-services/)
Connect multiple data sources and combine them into a single/simplified view that business users can connect to without having to connect to the data source itself. Data is in-memory, which allows it to be faster than databases. Has role-based security and Active Directory support. 99.9% availability
- Pro: Reads are done from this service rather than using database resources. Allows us to pass a URL to clients to mess with the data directly.
- Con: Extra cost/service/setup

This Microsoft's cloud version of Analysis Services. The on-premises version is called 'SQL Server Analysis Services'.


## Azure Event Grid
Use Event Grid for reactive programming, aka react to status changes for discrete messaging.


## Azure Functions

Testing:
- https://docs.microsoft.com/en-us/azure/azure-functions/functions-test-a-function


## Azure Storage Services

Table of needs: (Source: https://azure.microsoft.com/en-us/product-categories/storage/)

    IF YOU WANT TO...                                                                	USE THIS
    Get scalable and secure storage for your virtual machines                       	Disk Storage
    Find massively scalable, secure storage for your unstructured data .            	Blob Storage
    Get low-cost storage for rarely accessed data                                   	Archive Storage
    Get secure cloud file shares                                                    	File Storage
    Run high-performance, file-based workloads in the cloud                         	Avere vFXT for Azure
    Get secure storage for message-based communication between apps                 	Queue Storage
    Appliances and solutions for data transfer to Azure and edge compute            	Data Box
    Create powerful file shares for enterprise workloads, including open-source/Linux	Azure NetApp Files
    File caching for high-performance computing (HPC)                               	Azure HPC Cache

### [Cosmos DB](https://azure.microsoft.com/en-us/services/cosmos-db/)
Description: Easy (fully-managed) globally-distributed database service.

Features:
- Multi-model database, aka access using different APIs: SQL, Cassandra, MongoDB, Gremlin (Graph), Etcd, and Table. But, SQL (aka Core) will have the most features. And, implementation is only NoSQL 'behind-the-scenes'.
- Virtually unlimited "Request Units" per second. But, may have to contact Microsoft for extremely high RUs, just so that they make sure the costs are understood.
- Literally, a single click to add/remove database regions
- Can be easily configured to allow write in multiple regions (multi-master) or single region (single-master)
- Transparent multi-master replication
- 5 levels for consistency to choose from:
- SSD-backed data and index
- 99.999% availability

[Pricing](https://azure.microsoft.com/en-us/pricing/details/cosmos-db/):
- Lowest: 400 RU/s (about 1 billion reads/month)
- Provisioned/elastic increments (100 RU/s) { single-region: 1 x $0.008/hour, multi-region/single-master: N x $0.008/hour, multi-region/multi-master: N x $0.016/hour }
- 'Autopilot' increments (100 RU/s): $0.012 (NOTE: this auto-scale feature in is Preview)
- Reserved capacity: Roughly 20% to 50% savings depending on 1-year reservation vs 3-year reservation
- Storage: $0.25/GB/month

Learn:
- Unlimited 30-day free trials (but database is auto-deleted at the end of each trial): https://azure.microsoft.com/en-us/try/cosmosdb/ ("You can renew any number of times.")
- Local emulator (always free, only for Windows OS): https://aka.ms/cosmosdb-emulator
- Getting started: https://docs.microsoft.com/en-us/azure/cosmos-db/create-sql-api-nodejs
- There can only be one partition key, but that one key can be a combination of fields via a [synthetic partition key](https://docs.microsoft.com/en-us/azure/cosmos-db/synthetic-partition-keys)
- All data/properties are automatically indexed by default
- Computation resources are measured in 'Request Units' (RU) per second. Basically, a 'Read' is 1 unit and a 'Write' is 5 units, though Writes will cost an additional unit for each secondary node. Each request will return the number of RUs used.

### [Data Lake Storage](https://azure.microsoft.com/en-us/services/storage/data-lake-storage/)
Description: There is a Gen2 version (GA since 2019-02-07) that this section will be about. Optimized storage for big data. Built on top of Azure Blob Storage. Has Hadoop file system with hierarchial namespace.

Features:
- 'Unlimited scale and performance' (petabyte-size files, trillions of objects)
- Massively parallel
- Data can be unstructured, semi-structured, and/or structured
- Security: Encryption at rest using either Microsoft or customer manager keys
- Durability: Zone-redundancy, Geo-redundancy
- 'Azure Storage is built on a platform grounded in strong consistency guaranteeing that writes are made durable before acknowledging success to the client.'

Pricing:
- Lowest storage (local-redundancy): $0.0208/GB/month
- Lowest compute: $0.065/10k-write, $0.0052/10k-read

Learn:
- Best practices: https://docs.microsoft.com/en-us/azure/storage/blobs/data-lake-storage-best-practices

### SQL Database
Description: Fully-managed SQL in the cloud

Features:
- Serverless option
- Scale compute and storage resources independently, up to 4TB (or 100TB for hyperscale tier)
- Security: Encryption at-rest
- 99.995% availability

Pricing:
- Serverless:
    - Compute: $0.5218/vCore-hour (min vCore: 0.5, max vCore: 16)
    - Storage: $0.115/GB/month (min: 5GB, max: 4TB)
- Provisioned:
    - Compute: { 1-year-reserved: 21% off, 3-year-reserved: 33% off }, from 2-80 vCore
    - Storage: $0.115/GB/month (min: 5GB, max: 4TB)
- Provisioned, business-critical:
    - Compute per 2 vCore: { 1-year-reserved: $1.1457/hour, 3-year-reserved: $1.0240/hour }, from 2-80 vCore
    - Storage, SSD: $0.25/GB/month (min: 5GB, max: 4TB)
- Geo-replication: 100% of primary database cost

Learn:


## [Azure Synapse Analytics](https://azure.microsoft.com/en-us/services/synapse-analytics/)
Basically, Azure SQL Data Warehouse v2.0. Meant to be a 'unified experience for developing end-to-end analytics solutions', mainly combining Data Warehouse and Data Lake. Released 2019-11-04.

Features:
- 'Limitless scale', peta-byte scale, 'limitless concurrency'
- Security: column-level and row-level security, dynamic data masking, always-on data encryption
- Query both relational and non-relational data
- 'Deeply integrated with Power BI and Azure Machine Learning'
- Choice of language: T-SQL, Python, Scala, Spark, SQL, .NET, ...
- Serverless or provisioned compute resources
- 99.9% uptime

[Pricing](https://azure.microsoft.com/en-us/pricing/details/synapse-analytics/gen2/):
- Lowest compute (Gen2 DW100c for 100 DWU): { pay-as-you go: $1.51/hour, 1-year-reserved: $0.9513/hour, 3-year-reserved: $0.5285/hour} 
- Data storage: $135.17/TB/month ($0.19/TB/hour). "Storage is sold in 1 TB allocations. If you grow beyond 1 TB of storage, your storage account will automatically grow to 2 TBs."
- Geo-redundancy: $0.12/GB/month
- Threat detection: $0.02/node/month



# Notes
- Prefer NOT to use Java for Azure Function Apps because:
    - Azure Functions only support JDK 8
    - Notably less Java code samples compared to C# and JavaScript
    - Microsoft's default Java dependency manager is Maven, so they really aren't trying
    - But, if you do: https://docs.microsoft.com/en-us/azure/azure-functions/functions-reference-java
        - [Event Grid sample in Java](https://docs.microsoft.com/en-us/samples/azure-samples/event-grid-java-publish-consume-events/microsoft-azure-event-grid-java-sample/)



