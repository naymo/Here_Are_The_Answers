//Naymish Vaghela
//Programming Language Concepts
//Test 2



#include <stdio.h>
#include <time.h>
#include <stdlib.h>

void staticFunction();
void stackFunction();
void heapFunction();


int main() {
    staticFunction();
    stackFunction();
    heapFunction();
}

void staticFunction() {
    clock_t start, end;
    double cpu_time_used;
    int i;
    start = clock();
    for(i = 0; i < 100000; i++) {
        static int static_array[500000];
    }
    end = clock();
    cpu_time_used = ((double) (end - start)) / CLOCKS_PER_SEC;
    printf("%f: Time taken for static declaration \n", cpu_time_used);
}

void stackFunction() {
    clock_t start, end;
    double cpu_time_used;
    int i;
    start = clock();
    for(i = 0; i < 100000; i++) {
        int stack_array[500000];
    }
    end = clock();
    cpu_time_used = ((double) (end - start)) / CLOCKS_PER_SEC;
    printf("%f: Time taken for stack declaration \n", cpu_time_used);
}

void heapFunction() {
    clock_t start, end;
    double cpu_time_used;
    int i;
    start = clock();
    for(i = 0; i < 100000; i++) {
        int *heap_array = (int *) malloc(500000 * sizeof(int));
    }
    end = clock();
    cpu_time_used = ((double) (end - start)) / CLOCKS_PER_SEC;
    printf("%f: Time taken for heap declaration \n", cpu_time_used);
}