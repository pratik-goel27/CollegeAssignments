;finding the smallest value from the array:-

.data
count db 04h
value db 09h,10h,05h,03h
res db ?
.code
MAIN PROC
MOV AX,data
MOV DS,AX     ;for initializing data segment
MOV CL,count
DEC CL
LEA SI,value
MOV AL,[SI]

UP: INC SI
    CMP AL,[SI]  ;if al > [si] then carry flag will be 0
    JC NXT
NXT: DEC CL
     JNZ UP
LEA DI,res
MOV [DI],AL
HLT