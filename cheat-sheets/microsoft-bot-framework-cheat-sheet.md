# Microsoft Bot Framework Cheat Sheet

A 'bot' (generically) is a program that automates a task. An easy example is a chat bot, where you ask for something, then provides an answer (hopefully). The bot is meant to feel more human-like, or at least intelligent.

## Quick Links
- Main page for Microsoft Bot Framework: https://dev.botframework.com/
  - Open source Bot Framework code: https://github.com/microsoft/botframework
- Bot samples: https://github.com/microsoft/BotBuilder-Samples
- Bot templates for Visual Studio: https://marketplace.visualstudio.com/items?itemName=BotBuilder.botbuilderv4
  - Note: Currently (as of 2019-07-25), only available for Windows (Source: https://marketplace.visualstudio.com/items?itemName=BotBuilder.botbuilderv4&ssr=false#qna)
  - Install via command line instead: https://github.com/microsoft/BotBuilder-Samples/tree/master/generators/dotnet-templates
- Design guidelines: https://docs.microsoft.com/en-us/azure/bot-service/bot-service-design-principles?view=azure-bot-service-4.0
- Migration from .bot file to appsettings.json file: https://docs.microsoft.com/en-us/azure/bot-service/bot-file-basics?view=azure-bot-service-4.0&tabs=csharp

### Training
- Quickstart: 'Create a bot with Azure Bot Service': https://docs.microsoft.com/en-us/azure/bot-service/abs-quickstart?view=azure-bot-service-4.0
- 'Tutorial: Create and deploy a basic bot': https://docs.microsoft.com/en-us/azure/bot-service/bot-builder-tutorial-basic-deploy?view=azure-bot-service-4.0&tabs=csharp%2Cnewrg
- Create a bot from scratch (command line): https://github.com/microsoft/BotBuilder-Samples/tree/master/generators/dotnet-templates
- 'Create Intelligent Bots with the Azure Bot Service' (#QnA #InDepth): https://docs.microsoft.com/en-us/learn/paths/create-bots-with-the-azure-bot-service/

## Basics

Features:
- Handle automated chat
- Understand natural language (using LUIS). More info: https://luis.ai
- Easy-to-handle question-and-answers. More info: https://www.qnamaker.ai
- Speech: "Hear commands, identify individual speakers, translate, and reply to customers in natural language with a branded voice." More info: https://azure.microsoft.com/en-us/services/cognitive-services/directory/speech
- Search: "Search across defined domains or the web for customer data, inventory status, research results, transaction records and more." More info: https://azure.microsoft.com/en-us/services/cognitive-services/directory/search/
- Vision: "Recognize faces, moderate content, and index images and video with computer vision services." More info: https://azure.microsoft.com/en-us/services/cognitive-services/directory/vision/

There are two options when it comes to using Bot Framework:
- Option 1: Bot Builder SDKs
  - More control/flexibility
- Option 2: Azure Bot Service
  - Start development faster with templates, server-less
  
Testing can be done locally with an emulator, or done on the web with a little bit of configuration.
- Emulator: https://docs.microsoft.com/en-us/azure/bot-service/bot-service-debug-emulator?view=azure-bot-service-4.0&tabs=csharp
- Web: https://docs.microsoft.com/en-us/azure/bot-service/abs-quickstart?view=azure-bot-service-4.0
- Create a unit test bot: https://docs.microsoft.com/en-us/azure/bot-service/unit-test-bots?view=azure-bot-service-4.0&tabs=csharp

Good to know:
- "A bot is inherently stateless. Once your bot is deployed, it may not run in the same process or on the same machine from one turn to the next." - Source: https://docs.microsoft.com/en-us/azure/bot-service/bot-builder-howto-v4-state?view=azure-bot-service-4.0&tabs=csharp

### Dialogs

There are three types of dialogs:
- Prompt: Get input from the user and handle validation. The InBuilt prompt handles: text, number, date-time, choice, confirmation (boolean), and attachment.
- Waterfall: Collect a series of input from the user. Works together with the Prompt dialog.
- Component: Reusable dialog, for example: a user information form


## Key Words
- Activity: Any kind of communication to or from the bot. A fundamental bot building block.
  - Activity Type: Message, ContactRelationUpdate, ConversationUpdate, DeleteUserData, EndOfConversation, Event (communication sent to a bot that is not visible to the user), InstallationUpdate, Invoke (reserved for internal use by the Microsoft Bot Framework), MessageReaction, Typing, MessageUpdate, MessageDelete, Suggestion, Trace, Handoff (transfer communication to human)
- Channel: The medium in which the bot communicates, for example: SMS, Skype, Slack, voice
- Turn: User's incoming Activity and the Activity the bot sends back. A fundamental bot building block.


## History
Microsoft introduced their Bot Framework to the public in 2016.
