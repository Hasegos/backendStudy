#include<stdio.h>

int main(int argc, char *argv[]){
    if(argc != 2){
        printf("missing command-line argument\n");
        return 1;
    }
    printf("hello, %s\n",argv[0]);
    return 0;
}