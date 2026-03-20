.global _start

.section .data
count:     .word 7
array:     .word 0x15, 0x35, 0x32, 0x45, 0x10, 0x4f, 0x34
largest:   .word 0

.section .text
_start:

    LDR r0, =count       // r0 = address of count
    LDR r1, [r0]         // r1 = value of count (array size)
    LDR r2, =array       // r2 = base address of array

    LDR r3, [r2], #4     // r3 = first element of array (assume largest so far)

loop:
    SUBS r1, r1, #1      // decrement count
    BEQ end              // if count == 0, end loop

    LDR r4, [r2], #4     // r4 = next array element
    CMP r3, r4           // compare current max with new value
    BGT loop             // if r3 > r4, skip update
    MOV r3, r4           // else update r3 = r4
    B loop               // repeat loop

end:
    LDR r5, =largest     // r5 = address of result
    STR r3, [r5]         // store largest value
    B .                  // infinite loop to end program
