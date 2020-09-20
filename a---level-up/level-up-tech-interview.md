Interviews are communication to withdraw information. Here, interview specifically refers to a job interview between an employee/manager and prospective employee.

Here are my notes.

"Technical interviews tend to follow the same general pattern: talk about your past work, some interactive coding, answering anything you're curious about, and selling you on the idea of coming to work for us." [[1]](https://www.facebook.com/notes/facebook-engineering/get-that-job-at-facebook/10150964382448920)

"The initial screening interview is a 45 minute talk with a potential coworker. The idea is to slot you with someone in your general area of expertise. They will explain who they are and what they do, ask you about interesting things from your resume, your skills, motivation, interests, and so on."

Contents
--------

[Resources From Interviewers](#Resources_From_Interviewers)

[If I were giving an interview](#If_I_were_giving_an_interview)

[Must Know Going Into Interview](#Must_Know_Going_Into_Interview)

[Interviewee Goal](#Interviewee_Goal)

-   [My 3 Things (I want the interviewer to know)](#My_3_Things_.28I_want_the_interviewer_to_know.29)

[Questions to Be Prepared For](#Questions_to_Be_Prepared_For)

-   [Facebook Questions (Info from email)](#Facebook_Questions_.28Info_from_email.29)
-   [General Questions](#General_Questions)
-   [Past Experience Questions](#Past_Experience_Questions)
-   [Thought Process Questions](#Thought_Process_Questions)

[Questions to Ask Interviewer](#Questions_to_Ask_Interviewer)

-   [Maybe](#Maybe)
-   [Meh](#Meh)

[Phone Interview](#Phone_Interview)

-   [From Interviewer's Perspective](#From_Interviewer.27s_Perspective)
-   [From Interviewee's Perspective](#From_Interviewee.27s_Perspective)

* * * * *

Resources From Interviewers
---------------------------

-   (Great) [Get That Job At Google](http://steve-yegge.blogspot.com/2008/03/get-that-job-at-google.html "http://steve-yegge.blogspot.com/2008/03/get-that-job-at-google.html")

If I were giving an interview
-----------------------------

-   I look for motivation and eagerness to learn.

Must Know Going Into Interview
------------------------------

-   What is on your resume and be prepared to talk about any point for at least 5-15 minutes.
-   Information about the city the job is located in.
-   As much as you can about the company, maybe even more than the interviewer.

### Interviewee Goal

-   [Take Control Of Your Interview](http://weblog.raganwald.com/2006/11/take-control-of-your-interview.html "http://weblog.raganwald.com/2006/11/take-control-of-your-interview.html")
    -   "Have three things you want the interviewer to know about you that you think they are unlikely to find out if they ask all the questions."
    -   These are things that would distinguish you from all the other candidates.
    -   Plan in advanced. Write at least a paragraph of each of the points that you would like to share.

#### My 3 Things (I want the interviewer to know)

1.  (Okay) Read AOSP source code (in multiple API versions) for fun and for getting around limitations in the system. Some parts of my LTE Discovery app only work because I am accessing hidden APIs. These are features that users pay for no other app has been able to copy yet. Leading question to ask interviewer: Do you ever need to read through the AOSP source code to help fix bugs and help create new features?
2.  (Maybe) I've been able to do all this Android development while simultaneous being pulled in all directions for running a startup business. I've carried multiple responsibilities with ease and have been able to accomplish all of them. (So, if I'm able to put more of my focus in Android development, then I can definitely do a lot more great things.) Leading question to ask interviewer: Do you ever have responsibilities outside of direct Android source code manipulation?
3.  (Maybe) I go to many meetups with other developers and entrepreneurs. I am able to establish myself as a person who knows what they are doing. When I offer my consulting services, I'm able to help out anybody that has questions related to Android or business.
4.  (Maybe) I'm a veteran and have spent a year overseas in Iraq and Kuwait. I know how to get things done that need to be done. Leading question to ask the interviewer: So, do you hire veterans?
5.  (Meh) When I learn new things, I like to blog about it, especially if there was no other easy source. If there was a great source, then I save a bookmark that source for easy reference later. Leading question to ask interviewer: How often do you write engineering blog posts about the work you do?
6.  (Meh) I love to learn. Our LLC had to do to taxes for the first time recently. My co-founder and I reached a consensus that we should make sure we do it right by taking it to a professional for the first year, at least. In preparation for that, I spent a week of my free time reading all/most of the necessary IRS publications so that I could speak fluently with the professional.

Questions to Be Prepared For
----------------------------

### Facebook Questions (Info from email)

-   Coding practice
    -   [[2]](http://www.careercup.com/page)
    -   [[3]](http://www.glassdoor.com/facebook)
    -   [[4]](http://codekata.pragprog.com/2007/01/code_kata_backg.html#more)
    -   Topcoder.com

-   Be as enthusiastic as possible so that the engineer is sure that you are very interested in coming to Facebook because of our technology, challenging issues we face, etc.

    Why do you want to come to Facebook?

Solve bigger problems, help more people, work on tough projects that challenge me so that I'm still always learning.

    What features would you improve on Facebook?

Well, as a business, I see that Facebook is going for brand-consistency across platforms. But, I wouldn't mind trying to apply some more real Android Holo design to the app so that it seems more like an Android app.

    What would you like to do at Facebook?

Where's the biggest place where I can make a change/difference? Though, after bootcamp, I should know for sure.

    What challenging problems have you solved in the past?

Creating an app that detects people's vital signs without touching them.

The user base for my popular niche app, LTE Discovery, probably has about a tenth or more of users using custom ROMs. The ROMs sometimes have conflicts on the apps, and has brought up some interesting bugs.

    What product or work related project are you most proud of?

Hmmm, besides Contactless Vital Signs app, I'm happy that people email me about liking the side projects that I have built, like Simply Tone Generator and Memorize Pi app.

    What do you do currently?

Currently, I am running a mobile app business that I co-founded with my friend from freshman year of college. We build both in-house apps and apps for different clients and provide some consulting to other entrepreneurs also.

Even before starting the company I had people coming up to me wanting to get apps developed. Though, as our in-house apps gets more profitable, we take on less clients.

    You should have 1-2 questions at the end of the interview about something that you are curious about, concerning Facebook, the environment, or our technology, etc.

(See fb.txt)

    Please research any recent news online for talking points and more information about Facebook. Tech Crunch is a good source, among others.

In the news recently was the update about Facebook removing the basic Chat feature from the main Facebook app.

    Know our Facebook product. The features, what you like about it, and think about ways you would improve it.

I am very impressed with the Messenger app, the floating heads are probably the best part.

Also, I'm not sure if this is the right time to mention bugs that I found while testing the app.. They've might have even been fixed internally already, or not going to fix it because a larger update would completely erase it. I did some developer testing by checking overdraw and GPU usage. Facebook and Messenger app were good for the most post, but the Pages Manager had over 3x overdraw everywhere and I think there is an invisible ProgressDialog, rather than a View.GONE ProgressDialog. Oh, and the friends list in Facebook app is all red also. But, having said that, I haven't done any profiling on low-memory devices, so it may not be a big enough impact to remove the extra overdraw.

### General Questions

-   Please tell me about yourself?

I am a computer engineer. Started developing Android applications three years ago, in my spare time. Prior to that I've had about two years in web development.

-   What is your most efficient technical skills?

I know enough Android development to get things done efficiently

-   Which technical area are you trying to improve?

Currently, my main focus is Android and Java. But, I learn many things to stay well-rounded and able to create things in many different mediums

-   What type of job or role are you looking for?

Android development, mainly

-   How do you feel that such job fits to you?

Android development is what I've been doing for the past year. Including talking to clients, users, and other business-related activities.

-   Why did you opt for this job?

I like to learn and create things. I like to help other people. When those two things overlap, I've pretty happy. At \_\_Facebook\_\_, I'm able to learn more, faster, and focus on my technical skills more than my business skills to truly be great. Also, I like Facebook's goal of making the world more open and being able to provide communication everywhere.

-   Why are you looking for a job?

I've run a business for over a year now. As the business has been getting more and more successful, I've been able to do less and less development. I'm now ready to move on to a job where I can do more creating and developing.

-   Describe two or three trends that you have noticed in your profession?

Hmmm,

-   Why should we hire you?

I can guarantee you that I will be a great fit. I get along great with others because I'm a team player, and I also thrive on solo projects because I'm highly self-motivated. And, I'm more motivated at learning and building things than others. I would be happy if I could just do those two things. I want to be at \_\_Facebook\_\_.

-   Give me an example of a time when you solved an analytically difficult problem.

-   Describe a situation in which you did �all the right things� and were still unsuccessful. What did you learn from the experience?

How do you stay professionally current?

Well, first off I'll say that staying professionally current doesn't mean only reading about Android, it would be more useful to stay current could many related topics also. The main resources I use for Android include being subscribed to all Google and Android Developers videos, Android Design, a weekly Android newsletter, a weekly Hacker News newsletter. Other things I read to expand myself in other directions is a weekly Quora email, LinkedIn Pulse, NPR's news quiz show "Wait Wait Don't Tell Me".

What qualities or experience make you the best candidate for this position?

Unique perspectives and many general experiences, combined with knowledge of Android

-   And much more relevant to the presented cv/resume...

### Past Experience Questions

Best practices: Effective while at work

I may not be exactly what you are looking for, but I can thrive and study in all conditions. I can effectively tune out my surroundings so that I can focus on my work. Hmmm, I guess one thing is that productivity goes down if I try to watch tv at the same time, so that's one reason why I don't watch tv much.

Career Aspirations: Expectations from work

I always want to be learning, creating things, and staying healthy with time for exercise. I'm a pretty simple person. That's all I need to happy.

Career Movement: Past work experience

Hmmm, three years I started Android development. Two years ago, I took a university-level Android course. My next step was achieving a student researcher position at my college. My first real Android job was Having said all that.. working for myself is probably the hardest. I'm always thinking "If I'm not building, then my competitors are building." That competition drives me to ultimate success.

Coding: Largest code project Programming: Largest piece of code Techincal Skills: Encountering technically complex problems Work Interest: Learning from work

### Thought Process Questions

How would you design a new browser? How would you design a new operating system? How would you design a railway track? How would you lead a team in Disneyland for entertainment activities? If you are a trip organizer for a small group of people? What software's a soccer play must use?

Questions to Ask Interviewer
----------------------------

Organized from best to ask, to less likely should ask.

-   What is a typical work day/week like?
-   What are the greatest challenges in this position?

-   How many projects do you (or we) concurrently work on?
-   What is the most exciting project you have worked on?

-   Are there any negatives about this job that I might encounter?
-   What traits are most valued (or looked for) in employees?

-   What would I be expected to accomplish in this position? (Then, I have to be prepared to answer any follow-up question from interviewer about this.)

### Maybe

-   Which blogs and publications are must-reads?
-   Do you support employees using public transportation?

### Meh

-   What is your motivation for working here?
-   Who are the leaders I should know about?

ps - Show enthusiasm. =b

Phone Interview
---------------

### From Interviewer's Perspective

More info: [Getting the Interview Phone Screen Right](http://blog.codinghorror.com/getting-the-interview-phone-screen-right/ "http://blog.codinghorror.com/getting-the-interview-phone-screen-right/")

-   Don't let candidate drive the interview. Interviewer should do most of the talking and guiding the conversation.
-   Watch out for candidates that only know one (programming) language.
-   Don't let candidate stay in comfort zone. Ask related questions that push them to the edges of their knowledge. Possibly about things they haven't seen or done before. Ideally, you want to know how the candidate will react when facing something new.

### From Interviewee's Perspective



---

## Resources
- ["Why do you want to work for us?" - Interview Question (Demystified)](https://dev.to/skaytech/why-do-you-want-to-work-for-us-interview-question-demystified-1gh2)
