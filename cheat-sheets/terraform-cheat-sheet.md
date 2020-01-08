# Terraform Cheat Sheet
[Terraform](https://www.terraform.io/) is a tool for managing cloud infrastructure. The benefits of using templates for infrasture management include:
- Ability to automate infrastructure management
- Understand infrastructure changes that will be made
- Ability to create multiple environments that are exactly the same
- (Terraform-specific) Deploy infrastructure to multiple clouds

Basic commands:
- `terraform init`: Prepare a directory for Terraform usage, including downloading dependencies
- `terraform plan`: Show changes
- `terraform apply`: Create (or update) resources described in the template files
- `terraform destroy`: Destroy resources desribed in the template files

# Resources
- [Terraform template samples](https://github.com/terraform-providers/terraform-provider-azurerm)
- [Terraform for ARM template developers](https://docs.microsoft.com/en-us/archive/blogs/cloud_solution_architect/terraform-for-the-arm-template-developer)


