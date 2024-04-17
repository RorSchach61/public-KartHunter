# KartHunter- A magic the gathering deck builder. 

# Requirments
JDK 7 or later

# Description
This is a Magic the Gathering deck builder utility. To use download and open a command prompt, then navigate to KartHunter\out\artifacts\KartHunter_jar. Here you will notice three files, two text files and one .jar file. Use this command (without quotes) "java -jar KartHunter.jar" to run. You will be greeted by a prompt that introduced you to the following features of the program

|--Card search--| - enter a magic card and wait to be returned a card. Depending on the card it may take some time to locate and return it. The forest card is one example where it may seem like something has gone wrong, but it simply takes time for it fetch the card, be patient. You must include things like commas and apostraphies, but beyond that the input required is fairly user friendly.

|--Building deck--| - You can build a magic deck, once you have called for a card, entering "DECKS" (again without quotes) will add the selected card to the deck of your choosing. 

|--Deck management--| - You can manage your decks my entering "DECK MANAGER" (without quotes), this will bring up a prompt asking which deck you would like to manage, once enetered it will display the deck of your choosing.

|--Remove a card--| - You can access this feature through the deck management screen, go to manage decks, and select which deck you would like to remove a card from. Enter "REMOVE" (without quotes...). You will then be prompted to enter the exact name of the card you want to remove, this includes commas. I was unable to find a more convienent and better way to remove the cards. For example, take the card "Aesi, Tyrant of Gyre Strait". If in the remove card prompt a user entered "Aesi Tyrant of Gyre Strait", the card will not be found and will not be removed, this is because of the comma that is present. It is important that if you want to remove a card you enter the exact name. 

|--Exporting your deck--| - I wanted to expand this feature more but could not in the given time. Once you finish building your deck, the program will save to the text files named "savedDeckOne.txt" and "savedDeckTwo.txt". These files will be wiped whenever you rerun the application. Until then they will store all the pertinent info for each card contained within your magic deck. In the text file you will find actual useful information about the cards such as [NAME, MANA, TYPE, POWER/TOUGHNESS, AND EVEN ABILITY]. You can easily copy the info to another text file, or copy the text file to save the deck info. Its important to remember though, these text files are wiped and reset everytime you run the program.


NOTE: Certain cards will display elements of null type, I could not think of an easy way to fix this, so if a card displays one of its attributes as null, either in the final savedDeck.txt file or in the app itself, its because that attribute does not exist for a card of that type. For instance, searching for an island card will return an island with mana cost null, this is because basic lands do not cost any mana to cast. 

# Challenges

One of the first major challeneges I encountered was simply the scope of this project, I would be lying if I said I have enjoyed programming all that much up until this point, but I knew this project would require a lot of effort and time so I made sure to start exactly two weeks out from the due date. This included a lot of research, I didn't want to use local files because they were simply too big, and it would mean that the program  would update with new cards as new magic cards are released. I put a lot of focus into getting the api calls to work. It was sorta a big challenge just to get the program to call for and return a magic card, and I dedicated about two days trying to figure it out, ultimately switching IDEs to intellij was the simplest solution, though I am sure I could have made things work in Geany, it became far to confusing for me, and intellij essentially did most of the work for me, in regards to getting the dependencies to work. 

The next challenge I faced was the size of the magic api, there are over 27,000 unique cards in magic the gathering and hundreds are added each year. Making something that searched for a specific card out of the 27,000 was more difficult than I thought, creating a filter for the list was essential as without it, loading the entire list causes the program to hang for several minutes each time a card is needed to be called. This was grossly ineffecient. Iterating thorugh the list to display the deck confused me a good amount and I did end up asking chatgpt a few questions about it, it pointed me towards incorporating iterators. This made going through the list, and adding and removing cards a lot easier.

Another problem I encountered was forest cards, for some odd reason typing Forest would return the card 'Karplusan Forest', however I wanted it to just return a forest card, I added a conditional statement because I figured if a user is entering just "forest" into the console, they probably just want a basic land forest. This was an easy fix in hindsight but it took me awhile to come up with a solution.  

If I had to say one specific area of this project that gave me the most trouble, it would be the research that was required, the java magic sdk is not super well documented and while the discord on that page, did help a bit, my biggest problem was a lack of info. However I broke the project up into good chunks, essentially trying to work on one method per day, get it working then move onto the next thing as to not overwhelm myself. 

I am faily happy with this project, when I first started I immediately felt a lot less confident in my programming abilities, and in hindsight, I definitely could have structured things a lot cleaner I realize this, but it works as intended. Screenshots are provided in the KartHunter folder, in there you will find a folder named screenshots that will house all my sc's. 

# SoftWare used

JDK 21

Maven v3.9.8 (for handling dependencies)

Intellij IDE (for help with dependencies) 



# Sources used:
Chatgpt, was used fairly extensively for questions about how to use the magic api, as well as how to use the sdks provided. It also answered questions I had about maven, xml, and about how to navigate the magic sdk repo. Also helped me migrate to a different IDE for this project. I was encountering difficulties using Geany and its build commands to incorporate maven into this project and get all the dependencies to work. I switched to intellij for this project and it made getting started significantly easier, as I was able to build my project and intellij handled the dependecies for me. All I had to do was declare that the project was going to be built using maven (something I am not super familiar with). I attempted to build this project in Geany but found it to be very confusing.

3/5/2024: I Used chatGPT to help solve the problem of calling all the cards. I was actually really stumped about what was happening, whenever I would call the list of magic cards, the program would appear to freeze. I samwhiched the call for the card list between to print statements and realized what was happening, the size of the magic api was causing the list to load in extremely slow. I was somewhat able to piece this together using info on the magic java sdk and discord but chatgpt helped confirmed my suspicions and better explained what people were saying the solution was, which was to make a filter for the list. Chatgpt also helped me in understanding how to iterate through my list. I was orignally trying to do stuff with hashmaps but it did not work out well. 

# CITATIONS: 

Stack Overflow

How to search for a string in an arraylist. (n.d.). Stack Overflow. Retrieved March 9, 2024, from https://stackoverflow.com/questions/8192665/how-to-search-for-a-string-in-an-arraylist

Stack Exchange Inc. (2012, December 13). How to write an exception to a text file. Stack Overflow. https://stackoverflow.com/questions/13885310/how-to-write-an-exception-to-a-text-file

Source I used for filtering, magic java sdk, discord and chatGPT had mentioned using a filter and this was the site I primarily used. 

Retrieved March 8, 2024, from https://www.baeldung.com/java-filter-collection-by-list


W3: 

Retrieved March 8, 2024, from https://www.w3schools.com/java/java_iterator.asp

G4G

https://www.geeksforgeeks.org/system-exit-in-java/

openAI

https://openai.com/chatgpt

Prompts:

Questions asked regarding loading the cards:

https://chat.openai.com/share/e27a49ad-4a7d-45c9-b377-131635fcde6b



Here are the questions I asked about maven:

I also asked questions when I encountered problems when compiling with geany using the suggested build commands. Chatgpt said I could try switching to an alternative IDE such as eclipse, however I chose to switch to intellij because it seemed to simplify the process of incorporating maven a lot more.

https://chat.openai.com/share/9c94693a-bd09-4e2a-bcf2-2cb720dc2302



Questions asked about HashMap:

https://chat.openai.com/share/445aaff3-4dfe-4a12-a879-cab596484347

Questions asked about the pom.xml, I was encountering a ton of issues using geany and I figured it had to be one of two things, the pom.xml file or my build commands, originally when I asked chatGPT about my pom.xml file it said it looked good, however strangely this time it says its only "mostly correct". Either way, when it originally told me my pom.xml file was fine I figured I may try to switch IDE's. At first I switched to eclipse but I basically googled, "most reccomended java IDE" and intellij was the first that popped up, once I learned it handled everything to do with maven, it was a done deal for me. I also asked chatGPT several questions regarding my file directories and how I had things set up when using geany, however I could not get it to recreate accurate replies. Essentially however, it told me how maven expects the file directory to be laid out, I attepted to replicate it and still encountered errors when trying to build with Geany. 
https://chat.openai.com/share/24a4234b-6b4e-4e90-a82e-bf6d3df23e49



MAGIC RELATED: There is also a discord link on the MTG java sdk that leads to a developer discord that I used fairly extensively. Many other people have also attempted to build a similar project so it gave me a good place to look for answers/additional understanding.

https://scryfall.com  [Used the defaultCard.json file found on scryfall to search for multiverse IDs of cards. This helped me find the forest MultiverseID for basic forest]


https://github.com/MagicTheGathering/mtg-sdk-java

https://magicthegathering.io/


