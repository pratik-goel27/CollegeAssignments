.data
count db 04h
value db 09h,10h,05h,03h
res db ?

.code 
MAIN PROC
MOV AX,data
MOV DS,AX     ;this is to initialize the DS(data segment)

MOV CL,count
DEC CL    ;4 elements are there in the array and we want to do 3 comparisions

LEA SI,value
MOV AL,[SI]   ;al = value[0] = 09h

UP: INC SI
    CMP AL,[SI]
    JNC NXT
    MOV AL,[SI]

NXT: DEC CL
     JNZ UP
   
LEA DI,res
MOV [DI],AL
END MAIN

