# _Documentation for release 3: The final release_

## _Introduction_
The main goal for release 3 is to present the final product of the bank application. During release 3 we have worked mainly on two things; building a new client in a different technology, and building a REST-API. We decided to use React to make a our new client, mostly because we wanted to try something new. Therefore, very little functionality has been added in terms of the user experience and functionality of the application. Our primary focus has been on implementing a REST-API for remote access, in accordance with the task requirements. We used [Springboot](https://spring.io/projects/spring-boot) to create the server that communicates with our React client. 

## _Task managment_
In this release, we structured the further development into distinct parts: Implementing the REST-API and changing into a React client.

To ensure effective collaboration, the group decided to alter between pair programming and individual programming. We have, as long as it has been doable and worthwile, tried to assign issues or groups of issues to pairs of members. Two group members would work on developing REST-API, writing tests and implementing the API into our repo. The other two focused on the client. While one of them made the new client with REACT, the other one worked on finishing the product in JavaFX. This way of task distibrution ensured that each team member owned a specific area within the project, and could focus on their area. This optimized our quality, efficiency and productivity. It was easy to decide what area each team member would work on, because of our different interests within our group. Two of the members wanted to work with the backend, while the other two wanted to develop the frontend. This boosted our motivation for our tasks and helped maintain a smooth group dynamic.

In addition to our structured approach to task distribution, we utilized a common checklist to keep track of our progress and the tasks to come. We found this very helpful in our development process as it forced us to work in sprints with defined goals and tasks. This allowed us to focus on our tasks, and our task only, while working on the specific goal, as well as providing oppurtunities to reflect and share experience after completing a task. It also made the process more structured and transparrent.

To ensure continuous communication and workflow, we met regularly to work together. During these meetings we shared our experiences and our problems, while also working together. This made it possible for us to help each other when we came upon problems with our tasks. This approach not only improved our efficiency and adaptability in the face of changing requirements but also fostered a strong sense of teamwork and shared responsibility.

## _Methods to ensure code quality_
As in release 2, we still use Jacoco, Checkstyle and Spotbugs to ensure good code quality through the process. These tools all proved to be great once they were properly implemented. Jacoco has provided guidence and quality control when writing test, which we have done a lot of. CheckStyle has provided the group with a common ground for codingstyle. We regularly check the report to improve our many lines of code. This has increased our code quality, and hopefully makes the code easier to read. In this release, we also decided to switch from regular comments in the code, to JavaDocs for each method, to more easily and accuratly communicate what each method takes as paramaters, returns and its function. Spotbugs has worked as a safety net. Although the group faced few actual coding-errors, SpotBugs helped clear up few problems at times where we had type-safety problems. For example, our getTransactions-fucntion i the bank class, returned the list in use, and not a copy of it. This is a great example of how Spotbugs proved helpful to us.

After changing client to React, we also implemented Prettier and ESlint to continue our mission to write high quality code. These worked great, and proved very efficient in its use. 

Gitlabs pipelines proved great in ensuring that each commit and merge successfully passed all of the tests in the repo. Pipelines provides a structured and easy to read way to read the status of each commit or merge. We laso utilized the built in terminal to debug whenever the pipeline tests failed. Using pipeline gave us more confidence in our commits and merge requests.

Throughout the development of release 3, we have been stricht with our code reviews, focusing on formating, high quality code and good test coverage. This practice allows us to directly comment on specific parts of a group members code, facilitating more targeted and effective feedback. By engaging in code reviews, team members can pinpoint areas that need refinement, suggest improvements, and share insights that might not be immediately apparent to the original author. It also gives the reviewer a chance to see what the other group member has done, and learn from it. This collaborative approach not only enhances the overall quality of our code but also fosters a culture of continuous learning and mutual support within our team.

## _Utilizing gitlab_
Through the different iterations, we have developted our knowledge about gitlab and how to utilize all the built in functions. In release 3, we have implemented the pipeline for testing, code reviews for merge requests for quality code, and a systematic approach for creating milestones and issues. In this release, we have prioritized focusing on productive work habits, achieving a significantly enhanced workflow by utilizing issues for the release. We've done so by making a milestone for each release, as we did in release 1 and release 2. For the milestone we have created issues which show up as 'open', 'to do', 'doing' or 'closed' on the issue board, showcasing the tasks in progress and those that have been concluded. Each issue is assigned to the common milestone. The issues har also labeled appropriately, ensuring developers are aware of the development stage to which the issues pertain. In this realise, we have also made some "Epic" issues, as a parent issue for smaller issues. We used this to make it more structured when working againts a larger goal consisting of many smaller goals. An example of this, is with the documentation issue. From the beginning of the project, we have standarized our commit message format to make it easier to find earlier commits. We have also been stricht with our standard of making branches, and merging them, as well as utilizing our issue board. By having a "dev" branch, we are confident that our project is running perfectly before merging to master.



## _New classes_

### _UI_
 * RemoteBankApp.java
 * BankAccess.java
 * LocalBankAccess.java
 * RemoteBankAccess.java

### _React_
* page.tsx
* page.tsx (Transactions)
* layout.tsx
* global.css
* table.tsx
* button.tsx
* input.tsx
* table.tsx
* apiFunctions.js
* utils.ts

### _Restserver_
* BankController.java
* BankServerApp.java
* BankService.java
 --

## _Conclusive remarks_
Upon completing the project, our team has gained valuable experience. For some, it was the first opportunity to participate in a larger development project, while others honed their team-management and facilitation skills. We also explored new concepts and techniques beyond previous coursework, broadening our knowledge and skill set. Overall, the project was a rewarding experience, and we are proud to present the Bank application.

