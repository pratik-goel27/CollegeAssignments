.global _start

.section .data
RESULT: .word 0       // Memory to store factorial result


.section .text
_start:
    MOV R0, #5        // Number to find factorial of (n = 5)
    MOV R1, #1        // Initialize result to 1

fact_loop:
    CMP R0, #0        // Compare n with 0
    BEQ end_loop      // If n == 0, exit loop

    MUL R2, R1, R0    // R2 = R1 * R0
    MOV R1, R2        // Update result: R1 = R2
    SUBS R0, R0, #1   // Decrement n: R0 = R0 - 1
    B fact_loop       // Repeat the loop

end_loop:
    LDR R2, =RESULT   // Load address of RESULT into R2
    STR R1, [R2]      // Store result in RESULT

stop: B stop          // Infinite loop to halt execution


