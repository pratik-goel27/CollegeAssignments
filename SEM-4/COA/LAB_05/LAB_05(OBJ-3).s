.global _start

.section .data
count:   .word 7
array:   .word 0x15, 0x35, 0x32, 0x45, 0x10, 0x4f, 0x34
even:    .word 0, 0, 0, 0, 0, 0, 0
odd:     .word 0, 0, 0, 0, 0, 0, 0

.section .text
_start:
    // r0 = address of count
    LDR r0, =count
    LDR r1, [r0]        // r1 = number of elements

    LDR r3, =array      // r3 = array pointer (current input)
    LDR r4, =even       // r4 = even output pointer
    LDR r5, =odd        // r5 = odd output pointer

loop:
    LDR r6, [r3], #4    // r6 = current array value; r3 += 4

    ANDS r7, r6, #1     // r7 = r6 & 1 (check LSB to determine even/odd)
    BEQ store_even      // If result is 0 (even), jump to store_even

store_odd:
    STR r6, [r5], #4    // Store in odd array, increment odd pointer
    B check_next        // Go check next item

store_even:
    STR r6, [r4], #4    // Store in even array, increment even pointer

check_next:
    SUBS r1, r1, #1     // Decrement count
    BNE loop            // If not 0, repeat

stop:
    B stop              // Infinite loop (end)
