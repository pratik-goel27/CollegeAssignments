.data
count db 06h
value db 09h,0fh,14h,45h,24h,3Fh

.code
MAIN PROC 
MOV AX,DATA
MOV DS,AX

LEA DI,COUNT
MOV CH,[DI]
DEC CH     ;outer loop will go for (n-1) Bubble Sort

UP2: MOV CL, CH      ; Inner loop counter (each outer pass gets shorter)
     LEA SI, VALUE   ; SI points to start of array
UP1: MOV AL, [SI]         ; Load current element into AL
     CMP AL, [SI+1]       ; Compare it with next element
     JNC DOWN             ; Jump if AL <= [SI+1], no swap needed
   