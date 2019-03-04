# WildflyLabs
Wildfly 14 / Java EE 1.8 repository for SOA Labs

## Using JBoss Dev Studio (Red Hat)

## Deployment info: 
  
 - Java 1.8 
 
 - Wildfly 14.0.1 
 
 - Config: Full HA (.xml) 
 
  
## Project properties: 
  
### Project Properties > Project facets > Java 1.8 
 
### Project Properties > Java Compiler > Enable project specific settings > ... 
 
   Compiler compliance level: 1.8, Use default compliance settings: checked 
 
### Project Properties > Java Build Path > JRE System Library [java-8-openjdk-amd64] > Alternate JRE > Installed JREs > Add > ... 
 
   (Name: java-8-openjdk-amd64; Location: /usr/lib/jvm/java-8-openjdk-amd64; Type: Standard VM) 
 
### Deployment Assembly > (Source: /src/; Deplyo Path: WEB-INF/classes) 
 
### Other deployments: 
 
   (Source: Maven Dependencies; WEB-INF/lib ) 
 
   (Source: /src/main/webapp; Deploy path: / ) 
 
   (Source: /target/m2e-wtp/web-resouorces; Deploy path: / ) 
 
  
## What to do when *.war file doesn't change name: 
  
### 1. Open pom.xml and add: 
```
   <project ...> 
 
     ... 
 
     <build> 
 
       <finalName> warName </finalName> 
 
     </build> 
 
   </project> 
``` 
### 2. Go to: 
 
   ~/jboss_dev_studio_workspace/Lab1/Lab1_Task7_hello1/.settings/org.eclipse.wst.common.component 
 
#### check line: <wb-module deploy-name="hello1"> 
 
   It should look like this: 
 

```
 <?xml version="1.0" encoding="UTF-8"?><project-modules id="moduleCoreId" project-version="1.5.0"> 
 
   <wb-module deploy-name="Lab1_Task7_hello1"> 
 
    <wb-resource deploy-path="/" source-path="/target/m2e-wtp/web-resources"/> 
 
     <wb-resource deploy-path="/" source-path="/src/main/webapp" tag="defaultRootSource"/> 
 
     <wb-resource deploy-path="/WEB-INF/classes" source-path="/src/main/java"/> 
 
     <property name="java-output-path" value="/Lab1_Task7_hello1/target/classes"/> 
 
     <property name="context-root" value="Lab1_Task7_hello1"/> 
 
   </wb-module> 
 
 </project-modules> 
```

