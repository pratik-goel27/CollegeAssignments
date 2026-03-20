#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>

// int main(void)
// {
//     int i;

//     for (i = 0; i < 4; i++) {
//         pid_t pid = fork();

//         if (pid == 0) {
//             // Child continues the chain
//             printf("Process %d: PID=%d, PPID=%d\n",
//                    i, getpid(), getppid());
//         } else {
//             // Parent stops creating further children
//             break;
//         }
//     }

//     return 0;
// }

int main(int argc, char *argv[]) {
    pid_t childpid;
    if(argc != 2) {
        fprintf(stderr,"There should be 2 arguments provided\n");
        return 1;
    }

    int n = atoi(argv[1]);
    for(int i = 1; i < n; i++) {
        if((childpid = fork())) {
            break;
        }
        printf("Process:%d ,process id:%ld ,parent process id:%ld\n", i, (long)getpid(), (long)getppid());
    }
    return 0;
}
