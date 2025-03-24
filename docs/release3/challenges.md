# Challenges met

## Serializing and deserializing with JSON
During release 2, we met upon a challenge with serializing and deserializing with JSON. In the beginning we had an issue with turning transactions objects from JSON into deposit and withdraw objects, and making it back into a list with transaction objects. This problem occured because the transaction class is an abstract class and when we tried to read from the JSON file, it tried to make a transaction object, instead of deposit and withdraw.

To solve this, we first tried to make serialize and deserialize classes. This did not work at all, and the problem was still present. We then tried to use methods from the "Todo" example provided by the course manager, but because of the abstract class, this did not work either. We eventually, after a lot of research, understood that we needed include more infomation while saving to JSON. Therefore we used Jackson types in the transation class, to distinguish deposit and withdraw objects, when saving to JSON. This solved our problem and saved us a lot of headache. 

We learned a lot from this challenge. We got a deep understanding of how serializing and deserializing, and how the JSON format can be used effectively. This challenge also made us realise the importance of reasearch and planning ahead, as well as to never give up on our challenges. 

## Maven and POM-files
Throughout the whole duration of this course, we have had a lot of issues in understanding how the pom files should be set up and what they should contain. In release 1, we had some problem in setting up the structure of the project, and how to manage internal dependencies. In release 2 we struggled a lot with getting Jacoco to report the coverage of our UI tests. Finally in release 3 we had problems getting JPackage to work correctly and package the right files. All of these issues stemmed in some form because we lacked knowledge and experience in setting up multi-module projects in maven.

To solve these errors, we always started researching on the internet, but since our problems were almost always very case-specific, that was not very useful. We also tried using ChatGPT to debug our pom-files, which in some cases proved very useful. When that also did not work, we resorted to asking friends, that have more experience using maven, and often had experienced the same issues we were facing.

During these challenges we learned a lot of how maven operates and what a POM-file should contain. This made the development-process and debugging a lot smoother, as the project continued to develop. Even though we were still facing challenges in release 3, we now had the knowledge to resolve these issues on our own and continue development more rapid.
