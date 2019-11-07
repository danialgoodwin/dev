# Microsoft Azure Cheat Sheet


## Quick Overview

- DTU vs vCore
  - DTUs are a blend of compute, storage, and I/O. All scale together. This is more used by people who want simple/quick configurations.
  - vCore separates compute, storage, and I/O resources.


## Azure Resource Manager
Main site: https://docs.microsoft.com/en-us/azure/azure-resource-manager/


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

### Cosmos DB
- Unlimited 30-day free trials (but database is auto-deleted at the end of each trial): https://azure.microsoft.com/en-us/try/cosmosdb/
- Local emulator: https://aka.ms/cosmosdb-emulator

- There can only be one partition key, but that one key can be a combination of fields
- All data/properties are automatically indexed
- Virtually unlimited "Request Units" per second. But may have a contact Microsoft for extremely high RUs, just so that they make sure the costs are understood.

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


