# Microsoft Azure DevOps Cheat Sheet

Health status: https://status.dev.azure.com/

## Azure DevOps Pipelines

- [Add syntax highlighting for Azure Pipelines (VS Code)](https://marketplace.visualstudio.com/items?itemName=ms-azure-devops.azure-pipelines)

Good resources:
- https://docs.microsoft.com/en-us/azure/devops/pipelines/customize-pipeline
- https://docs.microsoft.com/en-us/azure/devops/pipelines/ecosystems/java-function?view=azure-devops
- https://docs.microsoft.com/en-us/azure/devops/pipelines/yaml-schema?view=azure-devops&tabs=schema

### How to use variables in Azure Pipelines

Option 1 - Simple [variables](https://docs.microsoft.com/en-us/azure/devops/pipelines/process/variables?view=azure-devops&tabs=yaml%2Cbatch):

    variables:
      myKey: myValue
      resourceLocation: 'South Central US'
    
    steps:
    - script: echo $(myKey)

Option 2:

    variables:
    - name: myKey
      value: myValue
    - name: resourceLocation
      value: 'South Central US'

Option 3 - Using using [variable groups](https://docs.microsoft.com/en-us/azure/devops/pipelines/library/variable-groups?view=azure-devops&tabs=yaml):

    variables:
    - group: my-variable-group-name
    
    steps:
    - script: echo $(myKeyFromTheVariableGroup)

### How to access Azure Key Vault via Pipeline
There are two main ways of doing this: (1) Azure Key Vault Task, (2) Pipeline Variable Groups

**Via Azure Key Vault Task**

More info:
- Azure Key Vault Task: https://docs.microsoft.com/en-us/azure/devops/pipelines/tasks/deploy/azure-key-vault
    - Via GitHub: https://github.com/microsoft/azure-pipelines-tasks/blob/master/Tasks/AzureKeyVaultV1/README.md

**Via Azure Pipeline Variable Group**
1. Go to Pipelines > Library > Variable Groups, and create a new variable group:
    1. Select '+ Variable Group'
    2. Input the 'Variable group name'
    3. Enable 'Link secrets from an Azure key vault as variables'
    4. Choose an 'Azure subscription', or Service Connection (created in Project Settings > Service Connections)
    5. The drop-down for 'Key vault name' should contain your key vault. Select that, then click 'Authorize' if that button appears to the right
    6. In the 'Variables' section, add the Key Vault variables you are interested in (the 'Add' option should show a list of items (like Secrets) that can be selected
    7. Click 'Save'
2. In your pipeline YAML file:
    1. Add similar to the following at the top of the file (replace 'my-variable-group' with the name of your variable group):
        
            variables:
            - group: my-variable-group
        
    2. Access the variables from the group with the following syntax: `$(<my-variable-name>)`, for example: `$(my-key-vault-secret-key-name)`   

More info:
- Variable Groups: https://docs.microsoft.com/en-us/azure/devops/pipelines/library/variable-groups
- Variables: https://docs.microsoft.com/en-us/azure/devops/pipelines/process/variables

### How to pass variables from azure-pipelines.yaml to ARM templates

In the `AzureResourceManagerTemplateDeployment@3` task, this can easily be done with the `overrideParameters` key. For example:

    - task: AzureResourceManagerTemplateDeployment@3
        inputs:
            ...
            overrideParameters: -myArmTemplateKey myArmTemplateValue -myResourceName $(myValue)

More info: https://github.com/microsoft/azure-pipelines-tasks/blob/master/Tasks/AzureResourceManagerTemplateDeploymentV3/README.md

