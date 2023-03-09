<table><tr><td> <em>Assignment: </em> It114 Milestone1</td></tr>
<tr><td> <em>Student: </em> Rockwell Dela Rosa (rmd2)</td></tr>
<tr><td> <em>Generated: </em> 3/9/2023 3:48:41 PM</td></tr>
<tr><td> <em>Grading Link: </em> <a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-008-S23/it114-milestone1/grade/rmd2" target="_blank">Grading</a></td></tr></table>
<table><tr><td> <em>Instructions: </em> <ol><li>Create a new branch called Milestone1</li><li>At the root of your repository create a folder called Project</li><ol><li>You will be updating this folder with new code as you do milestones</li><li>You won't be creating separate folders for milestones; milestones are just branches</li></ol><li>Create a milestone1.md file inside the Project folder</li><li>Git add/commit/push it to Github</li><li>Create a pull request from Milestone1 to main (don't complete/merge it yet)</li><li>Copy in the latest Socket sample code from the most recent Socket Part example of the lessons</li><ol><li>Recommended Part 5 (clients should be having names at this point and not ids)</li><li><a href="https://github.com/MattToegel/IT114/tree/Module5/Module5">https://github.com/MattToegel/IT114/tree/Module5/Module5</a>&nbsp;<br></li></ol><li>Git add/commit the baseline</li><li>Ensure the sample is working and fill in the below deliverables</li><li>Get the markdown content or the file and paste it into the milestone1.md file or replace the file with the downloaded version</li><li>Git add/commit/push all changes</li><li>Complete the pull request merge from step 5</li><li>Locally checkout main</li><li>git pull origin main</li></ol></td></tr></table>
<table><tr><td> <em>Deliverable 1: </em> Startup </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshot showing your server being started and running</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://raw.githubusercontent.com/ign2-r/it114-images/main/serverlistening.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Server is properly listening to its port from command line.<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Add screenshot showing your client being started and running</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://raw.githubusercontent.com/ign2-r/it114-images/main/clientconnected.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Client waits for input, then successfully connects to server.<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain the connection process</td></tr>
<tr><td> <em>Response:</em> <p>On the server-side, upon being instantiated, the server listens to its default port<br>of 3000, waiting for clients to connect. At this time, a lobby is<br>created as a default Room object for clients to join upon connecting. On<br>the client-side, upon being instantiated, the client waits for input from the user,<br>in which they can enter their name, then a command to connect to<br>a server based on an IP address (or localhost) and a port number.<br>If a valid IP (or localhost) and port are entered, a socket connection<br>is created between the two, using the client&#39;s object input and output stream<br>to relay I/O back and forth from the client and server. Private methods<br>from the client allow for the server to broadcast the arrival or departure<br>of a user.<br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 2: </em> Sending/Receiving </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshot(s) showing evidence related to the checklist</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://raw.githubusercontent.com/ign2-r/it114-images/main/roomsworking.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Shows two clients connected, and able to send messages. The messages are broadcast<br>to all in the same room, and show who it&#39;s from. When in<br>a new room, the messages from the first client no longer show to<br>the second one.<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Briefly explain how the messages are sent, broadcasted, and received</td></tr>
<tr><td> <em>Response:</em> <p>From the client perspective, messages are parsed through the sendMessage method which turns<br>text input by the user into a Payload that is sent through the<br>output stream to the ServerThread. This ServerThread contains methods that decipher whether the<br>user&#39;s output represents a connect, disconnect, or message type of payload. The Room<br>uses these ServerThreads to organize what is being sent and from who, then<br>uses these different threads to broadcast the appropriate messages to appropriate users through<br>the server (commands are not broadcast). This process goes both ways, in which<br>broadcasts from the room and server are sent to each individual client if<br>they are in the same room as other users sending messages.<br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 3: </em> Disconnecting / Terminating </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshot(s) showing evidence related to the checklist</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://raw.githubusercontent.com/ign2-r/it114-images/main/dcnoproblem.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Showing a client disconnecting from the server, and the server still running without<br>issue. Disconnect message is shown to client still connected to server.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://raw.githubusercontent.com/ign2-r/it114-images/main/servergoneclientsrun.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Showing output in clients after server is terminated; clients are now disconnected but<br>are still running.<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Briefly explain how the various disconnects/terminations are handled</td></tr>
<tr><td> <em>Response:</em> <p>From a Socket&#39;s perspective, a client gets disconnected, when the server-side socket connection<br>with the client is closed. The client program does not crash when the<br>server disconnects/terminates because the client-side socket is still open and available to make<br>connections. When a client disconnects, the server does not crash because the room<br>handles the disconnection of clients and is able to keep the socket connection<br>open for all other clients to the server.<br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 4: </em> Misc </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add the pull request for this branch</td></tr>
<tr><td> <a rel="noreferrer noopener" target="_blank" href="https://github.com/ign2-r/IT114-008/pull/9">https://github.com/ign2-r/IT114-008/pull/9</a> </td></tr>
<tr><td> <em>Sub-Task 2: </em> Talk about any issues or learnings during this assignment</td></tr>
<tr><td> <em>Response:</em> <p>I had an issue with my package heading at first; I kept trying<br>to compile and run the files but kept getting a number of different<br>errors because of my folder structure. I moved the folder containing the code<br>into the root of my repository and everything went smoothly afterward.<br></p><br></td></tr>
</table></td></tr>
<table><tr><td><em>Grading Link: </em><a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-008-S23/it114-milestone1/grade/rmd2" target="_blank">Grading</a></td></tr></table>