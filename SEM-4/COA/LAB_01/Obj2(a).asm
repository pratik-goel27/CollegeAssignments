MOV BH,0010H
MOV BL,0034H
MOV AH,BL

AND AH,00FH ;Getting lower nibble
SHL AH,4    ;shifting the nibble to left
AND BL,0F0H ;Getting higher nibble
SHR BL,4    ;shifting the nibble to right

OR AH,BL    ;joining the nibbles to get the final answer
HLT