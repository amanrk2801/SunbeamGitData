#include<stdio.h>
#include<unistd.h>

int main(void)
{
	printf("program started !!!\n");
	fork();
	printf("program finished !!!\n");
	return 0;
}
