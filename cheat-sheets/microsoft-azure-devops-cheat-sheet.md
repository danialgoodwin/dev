# Microsoft Azure DevOps Cheat Sheet

Health status: https://status.dev.azure.com/

## Azure DevOps Pipelines

- [Add syntax highlighting for Azure Pipelines (VS Code)](https://marketplace.visualstudio.com/items?itemName=ms-azure-devops.azure-pipelines)

Good resources:
- https://docs.microsoft.com/en-us/azure/devops/pipelines/customize-pipeline
- https://docs.microsoft.com/en-us/azure/devops/pipelines/ecosystems/java-function?view=azure-devops
- https://docs.microsoft.com/en-us/azure/devops/pipelines/yaml-schema?view=azure-devops&tabs=schema

### How to access Azure Key Vault via Pipeline
There are two main ways of doing this: (1) Azure Key Vault Task, (2) Pipeline Variable Groups

1. Via Azure Key Vault Task


2. Via Azure Pipeline Variable Group
    1. Go to Pipelines > Library > Variable Groups, and create a new variable group:
        1. Select '+ Variable Group'
        2. Input the 'Variable group name'
        3. Enable 'Link secrets from an Azure key vault as variables'
        4. Choose an 'Azure subscription', or Service Connection (created in Project Settings > Service Connections)
        5. The drop-down for 'Key vault name' should contain your key vault. Select that, then click 'Authorize' if that button appears to the right
        6. In the 'Variables' section, add the Key Vault variables you are interested in (the 'Add' option should show a list of items (like Secrets) that can be selected
        7. Click 'Save'
    3. In your pipeline YAML file:
        1. add similar to the following at the top of the file (replace 'my-variable-group' with the name of your variable group):
        
                variables:
                - group: my-variable-group
        
        2. Access the variables from the group with the following syntax: `$(<my-variable-name>)`, for example: `$(my-key-vault-secret-key-name)`
    

Source: https://docs.microsoft.com/en-us/azure/devops/pipelines/library/variable-groups
