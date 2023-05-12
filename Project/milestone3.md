<table><tr><td> <em>Assignment: </em> IT114 Chatroom Milestone3</td></tr>
<tr><td> <em>Student: </em> Rockwell Dela Rosa (rmd2)</td></tr>
<tr><td> <em>Generated: </em> 5/12/2023 3:11:02 AM</td></tr>
<tr><td> <em>Grading Link: </em> <a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-008-S23/it114-chatroom-milestone3/grade/rmd2" target="_blank">Grading</a></td></tr></table>
<table><tr><td> <em>Instructions: </em> <p>Implement the features from Milestone3 from the proposal document:&nbsp;&nbsp;<a href="https://docs.google.com/document/d/1ONmvEvel97GTFPGfVwwQC96xSsobbSbk56145XizQG4/view">https://docs.google.com/document/d/1ONmvEvel97GTFPGfVwwQC96xSsobbSbk56145XizQG4/view</a></p>
</td></tr></table>
<table><tr><td> <em>Deliverable 1: </em> Connection Screens </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshots showing the screens with the following data</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://raw.githubusercontent.com/ign2-r/it114-images/main/conscreens.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Showing screens with username, host and port<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Briefly explain the code for each step of the process</td></tr>
<tr><td> <em>Response:</em> <p>Upon running the ClientUI, a JPanel will open containing a host and port.<br>By default, they will be set to localhost and the port of 3000.<br>The public void methods make it so that the values entered in the<br>box will then be used to connect to the desired server. The next<br>button brings the user to a new screen in which they can set<br>their username (which is stored in clientName and proceed to connect. Upon connecting,<br>the onRoomJoin method will run, announcing to the lobby that the user has<br>joined.&nbsp;<br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 2: </em> Chatroom view </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshots showing the related UI</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://raw.githubusercontent.com/ign2-r/it114-images/main/relatedUI.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Showing user list, chat message area with chat history and create message area<br>with send button<br></p>
</td></tr>
<tr><td><img width="768px" src="https://raw.githubusercontent.com/ign2-r/it114-images/main/entersend.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Showing code snippet allowing enter key to send message<br></p>
</td></tr>
</table></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 3: </em> Chat Activities </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Show screenshots of the result of the following commands</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://raw.githubusercontent.com/ign2-r/it114-images/main/chattivities.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Showing flip and roll commands working with who triggered it and also in<br>a different text format.<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Show the code snippets for each command</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://raw.githubusercontent.com/ign2-r/it114-images/main/chattivities.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Showing server-side code for flip and roll generations as well as text format<br>logic<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain the code flow of each command</td></tr>
<tr><td> <em>Response:</em> <p>For the roll command, I added a case for the &quot;roll&quot; command in<br>the switch for the processCommands method. I made a String variable called dice<br>and assigned it to comm2[1], so that the text after the roll command<br>can be parsed in the rollDice method I created. In the rollDice method,<br>the text after the roll commands are processed with regex, so that if<br>it is just /roll #, it will broadcast the message of the result<br>accordingly, and otherwise, it&#39;ll broadcast the result for the /roll#d# version of the<br>command. In the /flip command, I pretty much have the same thing; another<br>case in the switch command, except it doesn&#39;t need the comm2, it just<br>runs the flipCoin method I created. In this method, a random number generator<br>creates the result for the coinflip (0.5 and above heads, otherwise tails), and<br>then broadcasts the results with who triggered it.<br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 4: </em> Custom Text </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Screenshots of examples</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://raw.githubusercontent.com/ign2-r/it114-images/main/messedupstyling.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Showing the effects working (not really, I could not figure out how to<br>get them to render properly)<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Briefly explain how you got the UI side to render the text accordingly</td></tr>
<tr><td> <em>Response:</em> <p>I could not get the UI to render the text properly, but I<br>did use the sendMessage method in Room.java to detect the prefixes and suffixes<br>and messages to alter the message with the proper styling tags.<br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 5: </em> Whisper </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707795-a9c94a71-7871-4572-bfae-ad636f8f8474.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshots showing a demo of whisper commands</td></tr>
<tr><td><table><tr><td>Missing Image</td></tr>
<tr><td> <em>Caption:</em> (missing)</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Show the server-side code snippets of how this feature works</td></tr>
<tr><td><table><tr><td>Missing Image</td></tr>
<tr><td> <em>Caption:</em> (missing)</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain the code logic of how this was achieved</td></tr>
<tr><td> <em>Response:</em> <p>(missing)</p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 6: </em> Mute/Unmute </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707795-a9c94a71-7871-4572-bfae-ad636f8f8474.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshots demoing this feature</td></tr>
<tr><td><table><tr><td>Missing Image</td></tr>
<tr><td> <em>Caption:</em> (missing)</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Add screenshots of the code snippets that achieve this feature</td></tr>
<tr><td><table><tr><td>Missing Image</td></tr>
<tr><td> <em>Caption:</em> (missing)</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain the code logic of how this was achieved</td></tr>
<tr><td> <em>Response:</em> <p>(missing)</p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 7: </em> Misc </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Pull request from milestone3 to main</td></tr>
<tr><td> <a rel="noreferrer noopener" target="_blank" href="https://github.com/ign2-r/IT114-008/pull/12">https://github.com/ign2-r/IT114-008/pull/12</a> </td></tr>
</table></td></tr>
<table><tr><td><em>Grading Link: </em><a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-008-S23/it114-chatroom-milestone3/grade/rmd2" target="_blank">Grading</a></td></tr></table>
