<table><tr><td> <em>Assignment: </em> IT114 Chatroom Milestone 2</td></tr>
<tr><td> <em>Student: </em> Rockwell Dela Rosa (rmd2)</td></tr>
<tr><td> <em>Generated: </em> 4/5/2023 4:14:50 AM</td></tr>
<tr><td> <em>Grading Link: </em> <a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-008-S23/it114-chatroom-milestone-2/grade/rmd2" target="_blank">Grading</a></td></tr></table>
<table><tr><td> <em>Instructions: </em> <p>Implement the features from Milestone2 from the proposal document:&nbsp; <a href="https://docs.google.com/document/d/1ONmvEvel97GTFPGfVwwQC96xSsobbSbk56145XizQG4/view">https://docs.google.com/document/d/1ONmvEvel97GTFPGfVwwQC96xSsobbSbk56145XizQG4/view</a></p>
</td></tr></table>
<table><tr><td> <em>Deliverable 1: </em> Payload </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Payload Screenshots</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://raw.githubusercontent.com/ign2-r/it114-images/main/payload.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Showing payload code, with content from terminal<br></p>
</td></tr>
</table></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 2: </em> Server-side commands </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Show the code for the mentioned commands</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://raw.githubusercontent.com/ign2-r/it114-images/main/rollandflip.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Showing roll dice and flip coin commands and implementations<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Explain the logic/implementation of each commands</td></tr>
<tr><td> <em>Response:</em> <p>I used regex to determine whether the string after the command was a<br>number. If it was, I took the number and parsed it into an<br>int and picked a random number using Math.random() from 1 to the number.<br>Otherwise, I took the string and split it using &quot;d&quot;. Then the two<br>remaining strings were parsed into ints and the value of the roll was<br>found by taking the number of dice and adding a random number between<br>1 and how many sides each dice had to a total. The flip<br>command was much simpler; using Math.random to generate a random double and if<br>it was 0.5 or greater, it was heads and anything else was tails.<br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 3: </em> Text Display </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Show the code for the various style handling via markdown or special characters</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://raw.githubusercontent.com/ign2-r/it114-images/main/stylecode.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Showing how bold, italics, underline and color are processed. <br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Show source message and the result output in the terminal (note, you won't actually see the styles until Milestone3)</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://raw.githubusercontent.com/ign2-r/it114-images/main/styleoutput.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Showing some test outputs of styling<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Explain how you got each style applied</td></tr>
<tr><td> <em>Response:</em> <p>I used the startsWith method on the message being sent to check the<br>beginning and end of the message for formatting tags. For bold, the user<br>would type &quot;**&quot; before and after a message, &quot;_<em>&quot; for underline, &quot;</em>&quot; for<br>italics, and &quot;#&quot; and a lowercase letter for any of the colors in<br>ROY G. BIV (some basic colors). Based on the prefixes and suffixes of<br>the message, the message would be altered to show the new style tags;<br>for example, typing #r hi r# would result in the message being passed<br>through and output as &lt;font color=&#39;red&#39;&gt; hi &lt;/font&gt;.<br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 4: </em> Misc </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Include the pull request for Milestone2 to main</td></tr>
<tr><td> <a rel="noreferrer noopener" target="_blank" href="https://github.com/ign2-r/IT114-008/pull/10">https://github.com/ign2-r/IT114-008/pull/10</a> </td></tr>
</table></td></tr>
<table><tr><td><em>Grading Link: </em><a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-008-S23/it114-chatroom-milestone-2/grade/rmd2" target="_blank">Grading</a></td></tr></table>