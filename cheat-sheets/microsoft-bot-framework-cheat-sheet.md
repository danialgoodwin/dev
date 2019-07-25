
A 'bot' (generically) is a program that automates a task. An easy example is a chat bot, where you ask for something, then provides an answer (hopefully).

## Basics
There are two options when it comes to using Bot Framework:
- Option 1: Bot Builder SDKs
  - More control/flexibility
- Option 2: Azure Bot Service
  - Start development faster with templates, server-less


## Key Words
- Activity: Any kind of communication to or from the bot. A fundamental bot building block.
  - Activity Type: Message, ContactRelationUpdate, ConversationUpdate, DeleteUserData, EndOfConversation, Event (communication sent to a bot that is not visible to the user), InstallationUpdate, Invoke (reserved for internal use by the Microsoft Bot Framework), MessageReaction, Typing, MessageUpdate, MessageDelete, Suggestion, Trace, Handoff (transfer communication to human)
- Channel: The medium in which the bot communicates, for example: SMS, Skype, Slack, voice
- Turn: User's incoming Activity and the Activity the bot sends back. A fundamental bot building block.


## History
Microsoft introduced their Bot Framework to the public in 2016.
