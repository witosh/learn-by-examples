# Approach to create SOAP services

Definition of conceptual shortcuts:
*SOAP* **S**imple **O**bject **A**ccess **P**rotocol - is a data protocol
**WSDL** **W**eb **S**ervices **D**escription **L**anguage - contain a machine-readable description of the operations offered by the service

Web services are client and server applications. This services can commnunicate over HTTP protocol and provide standar way of interoperating between separate software application running on a variety platforms. SOAP is a data protocol and  is used for communicating structured data between application.

We can distinguish two types of approaches in the process of creating SOAP services:
- `code-first`, in this approach firstly we create code (fields and methods of our web service) and we generate WSDL file based on that.

- `ontract-first`, in this case, we have WSDL file and then we generate code.