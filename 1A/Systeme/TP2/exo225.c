#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>

int main(){

    fork(); printf("fork1\n");
    fork(); printf("fork2\n");
    fork(); printf("fork3\n");

    sleep(180);
    return 0;
}
