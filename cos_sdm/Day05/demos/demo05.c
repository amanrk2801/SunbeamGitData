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
		for(int i = 0 ; i < 5 ; i++)
		{
			printf("child : i = %d\n", i);
			sleep(1);
		}
	}
	else
	{
		// parent
		for(int i = 10 ; i > 0 ; i--)
		{
			if(i == 6)
				wait(&s);

			printf("parent : i = %d\n", i);
			sleep(1);
		}
	}
	printf("program finished !!!\n");
	return 0;
}



