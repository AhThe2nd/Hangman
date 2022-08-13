# Hangman
Java Term Project - CP2561

Author: Andrew Howell

## Project Development

This is my Java term project for CP2561.

I felt that I learned a lot on this project, and I feel the 
need to outline some of these learnings as well as comment 
on the challenges I faced.

The main thing I would take away from this project is that
a task that might seem simple in your mind or on the surface
can get quite complicated and onerous when you actually
start coding them.

Likely the biggest challenge I faced was ensuring that the 
main and sub-loop game logic was written in the correct order.
This involved a lot of pseudo-code with many iterations until
I was pleased with the results.

One specific challenge of note was when I initially started
pulling words from my word lists. I would parse the words out
into character arrays, but when I printed them the output
was a single closing ]. After a lot of trial and error
I realized that my code was grabbing a random word from the
list, but it was also grabbing a carriage return character
as well. This tripped me up for an hour or two, but trimming
the whitespace solved my issue.

Due to many events in my personal life I was forced to work
on this project solo as my availability was sporadic, and I
would not be able to commit to meeting times. Ultimately,
this slowed development as I had no team members to bounce
ideas off of.

## Project Description

This is a standard Hangman-style game with 3 levels
of difficulty based on the length of the word.

The user is presented with a choice of difficulty at
the start of the game. They are then presented with a
word of that difficulty and are prompted to guess a letter.

If the letter is contained within the word, it is revealed,
and the user is prompted again. If the letter is not found
in the word, the user earns a strike, and a gallows ASCII
art is displayed. This art will progressively move through
the stages based on the number of strikes the user has.

If the user successfully uncovers the entire word, they win,
and are then prompted to play again or quit.

If the user earns 6 strikes, they lose, the word is revealed,
and they are prompted to play again or quit.

Words are chosen at random based on difficulty and will never
repeat within the same play session.

# Project Instructions

In order to run this project, download all the files and 
run the Game.main() method in an editor of your choice. The
program runs entirely in the console.

