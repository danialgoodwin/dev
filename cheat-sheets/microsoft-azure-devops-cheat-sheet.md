# Microsoft Azure DevOps Cheat Sheet

Health status: https://status.dev.azure.com/



## Azure DevOps Pipelines

- [Add syntax highlighting for Azure Pipelines (VS Code)](https://marketplace.visualstudio.com/items?itemName=ms-azure-devops.azure-pipelines)

Good resources:
- https://docs.microsoft.com/en-us/azure/devops/pipelines/customize-pipeline
- https://docs.microsoft.com/en-us/azure/devops/pipelines/ecosystems/java-function
- https://docs.microsoft.com/en-us/azure/devops/pipelines/yaml-schema
- https://docs.microsoft.com/en-us/azure/devops/pipelines/process/variables
- [Great] [Azure Pipeline Parameters](https://www.colinsalmcorner.com/azure-pipeline-parameters/)
    - Includes usage of if-conditions, for-each, re-using steps, extending pipeline templates

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

### How to pass variables between steps, jobs, or stages
Great resource: https://medium.com/microsoftazure/how-to-pass-variables-in-azure-pipelines-yaml-tasks-5c81c5d31763

    trigger: none

    variables:
      arbitraryVar: arst

    jobs:
      - job: firstjob
        steps:
          - bash: |
              MY_VAR="my var value"
              echo "##vso[task.setvariable variable=BAR]$MY_VAR"
              # Use 'isOutput' to pass variable between jobs
              echo "##vso[task.setvariable variable=FOO;isOutput=true]$(arbitraryVar)"
            name: mystep
          - bash: |
              echo "BAR=$(BAR)"
              echo "FOO=$(FOO)"
              echo "mystep.FOO=$(mystep.FOO)"
              echo "MY_VAR=$MY_VAR"
              echo "mystep.MY_VAR=$mystep.MY_VAR"

      - job: secondjob
        # Need to explicitly mark the dependency
        dependsOn: firstjob
        variables:
          # Define the variable FOO from the previous job
          # Note the use of single quotes!
          FOO: $[ dependencies.firstjob.outputs['mystep.FOO'] ]
        steps:
          # The variable is now available for expansion within the job
          - bash: |
              echo "FOO=$(FOO)"
          # To send the variable to the script as environmental variable, it needs to be set in the env dictionary
          - bash: |
              echo "FOO=$FOO"
            env:
              FOO: $(FOO)


### How to pass variables from azure-pipelines.yaml to ARM templates

In the `AzureResourceManagerTemplateDeployment@3` task, this can easily be done with the `overrideParameters` key. For example:

    - task: AzureResourceManagerTemplateDeployment@3
        inputs:
            ...
            overrideParameters: -myArmTemplateKey myArmTemplateValue -myResourceName $(myValue)

More info: https://github.com/microsoft/azure-pipelines-tasks/blob/master/Tasks/AzureResourceManagerTemplateDeploymentV3/README.md

