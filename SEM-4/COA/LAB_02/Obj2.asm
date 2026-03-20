MOV SI,5000H
MOV CL,04H    ;this stores the counter.
MOV CH,00H
MOV BX,CX     ;storing the value of counter in another register for future.
MOV AX,0000H
MOV DX,0000H 
L2: INC SI
    INC SI 
    ADD AX,[SI]
    JNC L1
    INC DX
L1: DEC CX
    JNZ L2 
INC SI
INC SI
MOV [SI],AX 
INC SI
INC SI
MOV [SI],DX
DIV BX
INC SI
INC SI
MOV [SI],AX
INC SI
INC SI
MOV [SI],DX
HLT