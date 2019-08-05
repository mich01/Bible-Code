# Bible-Code
Retrieve hidden messages from text phrases and paragraphs

PS: I wont bother to write a detailed description on this.

Before the digital age people used to send hidden messages in letters using carefully placed words in predefined positions in the letter e.g Every 7th word. 
The code defined here is used to extract hidden messages from a phrase or sentence using a Key.

# Here’s how it works:

Assuming we have a sentense:

# Hello there and warm greetings to you my friends.? Todd did you hear about this years calls about party for the initiation of news anchor list joinning communnial agency? I want you to be our custodian and lead the team coordinating retailers attendance and attire for the event. Also make sure three slots are set asside. Estimate all calls and do aggregate all entries.

And using the key:

# atm

The algorithm is supposed to do as follows:
Look for the first occurence of the first character in the key (a) then it looks for the second character in the key (t) after it finds it, it calculates the distance betwwn the keys and compares the last key (m) with the character appearing at the nth position were n is the position of the second character +the distance. If it matches it continues retrieving subsequent characters until the end of the phrase.
If this doesnt match with the key it will proceede with the next appearance of  the next key. 
And if that doesnt work it will look for the next appearance of the first key untill it loops through the whole phrase:

This is just a demo on how you can hide secret messages in text and. Please feel free to comment and request for any updates and code restructuring. (I know the code isn’t efficient but as long as it works we can develop more efficient code)
