# ChatOps bot

## Requirements
- Java 11
- Maven

## FAQ
1. I am get a `java.lang.NumberFormatException: For input string: "1674731088.876` when bot login to Discord ?
R: It can happen when you are connected to a VPN, disconnect and run bot again

2. I get `CloseCode(4014 / Disallowed intents` on bot connection 
R: Make sure you marked **Present intent** and  **Server member instents**, under **Bot > Privileged Gateway Intents** in the Discord Developer Portal