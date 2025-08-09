#include<stdio.h>
#include<unistd.h>
#include<sys/wait.h>

int main(void)
{
	int s;
	printf("program started !!!\n");
	int ret = fork();
	if(ret == 0)
	{
		// child
		execl("/usr/bin/ls", "ls", NULL);
	}
	else
	{
		// parent
			wait(&s);
	}
	printf("program finished !!!\n");
	return 0;
}



