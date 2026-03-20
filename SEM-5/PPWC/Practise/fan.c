#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>

int main(int argc, char *argv[]) {
    pid_t childpid;
    if(argc != 2) {
        fprintf(stderr, "2 arguments should be theren\n");
        return 1;
    }

    int n = atoi(argv[1]);
    for(int i = 1; i < n; i++) {
        if((childpid = fork()) <= 0) {
             printf("Child %d: PID=%ld, PPID=%ld\n",i, (long)getpid(), (long)getppid());
            break;
        }
        // fprintf(stderr, "Process:%d, Process ID:%ld, Parent Process ID:%ld\n", i, (long)getpid(), (long)getppid());
    }
    return 0;
}