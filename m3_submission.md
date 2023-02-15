<table><tr><td> <em>Assignment: </em> IT114 - Number Guesser</td></tr>
<tr><td> <em>Student: </em> Rockwell Dela Rosa (rmd2)</td></tr>
<tr><td> <em>Generated: </em> 2/15/2023 2:16:08 PM</td></tr>
<tr><td> <em>Grading Link: </em> <a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-008-S23/it114-number-guesser/grade/rmd2" target="_blank">Grading</a></td></tr></table>
<table><tr><td> <em>Instructions: </em> <ol><li>Create the below branch name</li><li>Implement the NumberGuess4 example from the lesson/slides</li><li>Add/commit the files as-is from the lesson material (this is the base template)</li><li>Pick two (2) of the following options to implement</li><ol><li>Display higher or lower as a hint after a wrong guess</li><li>Implement anti-data tampering of the save file data (reject user direct edits)</li><li>Add a difficulty selector that adjusts the max strikes per level</li><li>Display a cold, warm, hot indicator based on how close to the correct value the guess is (example, 10 numbers away is cold, 5 numbers away is warm, 2 numbers away is hot; adjust these per your preference)</li><li>Add a hint command that can be used once per level and only after 2 strikes have been used that reduces the range around the correct number (i.e., number is 5 and range is initially 1-15, new range could be 3-8 as a hint)</li><li>Implement separate save files based on a "What's your name?" prompt at the start of the game</li></ol><li>Fill in the below deliverables</li><li>Create an m3_submission.md file and fill in the markdown from this tool when you're done</li><li>Git add/commit/push your changes to the HW branch</li><li>Create a pull request to main</li><li>Complete the pull request</li><li>Grab the link to the m3_submission.md from the main branch and submit that direct link to github</li></ol></td></tr></table>
<table><tr><td> <em>Deliverable 1: </em> Implementation 1 (one of the picked items) </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Two Screenshots: Add a screenshot demonstrating the feature during runtime; Add a screenshot (or so) of the snippets of code that implement the feature</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://raw.githubusercontent.com/ign2-r/it114-images/main/demonstration.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Demonstrating the higher/lower feature working<br></p>
</td></tr>
<tr><td><img width="768px" src="https://raw.githubusercontent.com/ign2-r/it114-images/main/implement1.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Code snippet for higher/lower feature<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Briefly explain the logic behind your implementation</td></tr>
<tr><td> <em>Response:</em> <p>I used an if-else statement to determine whether the guess was higher or<br>lower than the number and printed the appropriate hint accordingly. If the guess<br>was greater, lower would print, and otherwise, higher would print.<br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 2: </em> Implementation 2 (one of the picked items) </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Two Screenshots: Add a screenshot demonstrating the feature during runtime; Add a screenshot (or so) of the snippets of code that implement the feature</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://raw.githubusercontent.com/ign2-r/it114-images/main/demonstration.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Demonstrating the cold/warm/hot feature working<br></p>
</td></tr>
<tr><td><img width="768px" src="https://raw.githubusercontent.com/ign2-r/it114-images/main/implement2.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Code snippet for cold/warm/hot feature<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Briefly explain the logic behind your implementation</td></tr>
<tr><td> <em>Response:</em> <p>I used the Math.abs() function on the difference between the guess and number<br>in order to get the (positive) distance of the guess from the number.<br>Then I used an if and else, and else-if statements to print the<br>appropriate cold/warm/hot statement based on the value of the distance of the guess.<br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 3: </em> Misc </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add a link to the related pull request of this hw</td></tr>
<tr><td> <a rel="noreferrer noopener" target="_blank" href="https://github.com/ign2-r/IT114-008/pull/7">https://github.com/ign2-r/IT114-008/pull/7</a> </td></tr>
<tr><td> <em>Sub-Task 2: </em> Discuss anything you learned during this lesson/hw or any struggles you had</td></tr>
<tr><td> <em>Response:</em> <p>During this lesson, I learned how classes use various methods and classes in<br>order to perform what seem like simple tasks. For example, simple user input<br>is parsed through so many variables and methods to output an appropriate response.<br>Furthermore, I learned how public and private elements in java interact with each<br>other and the importance of the usage between the two.<br></p><br></td></tr>
</table></td></tr>
<table><tr><td><em>Grading Link: </em><a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-008-S23/it114-number-guesser/grade/rmd2" target="_blank">Grading</a></td></tr></table>