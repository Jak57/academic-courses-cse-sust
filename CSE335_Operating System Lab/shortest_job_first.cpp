/**
 Shortest Job First Scheduling algorithm
 */

#include<bits/stdc++.h>
using namespace std;

const int N = 100005;
int n;

struct process {
	int id; // process id
	int at; // arrival time
	int bt; // burst time

	int ct; // completion time
	int tat; // turnaround time
	int wt; // waiting time
	int rt; // response time
};

process P[N]; // array of processes

void SJF()
{
	int i;
	int complete = 0; // total completed process
	int current_time = 0;
	int index = -1;
	int minimum = INT_MAX;

	int ttat = 0; // total turnaround time
	int twt = 0; // total waiting time

	while (complete < n)
	{

		for (i = 0; i < n; i++)
		{
			if (P[i].ct == 0 && P[i].at <= current_time)
			{
				if (P[i].bt < minimum)
				{
					minimum = P[i].bt;
					index = i;
				}
			}
		}

		if (index >= 0)
		{
			current_time += P[index].bt;
			P[index].ct = current_time;
			P[index].tat = P[index].ct - P[index].at;
			P[index].wt = P[index].tat - P[index].bt;

			ttat += P[index].tat;
			twt += P[index].wt;

			complete++;
			minimum = INT_MAX;
			index = -1;
		}
		else
			current_time++;
	}

	printf("Average turnaround time %lf\n", ttat/(n*1.0));
	printf("Average waiting time %lf\n", twt/(n*1.0));
}

int main()
{
	int i;
	// Number of processes
	cin>> n;

	// Process Ids
	for (i = 0; i < n; i++)
		cin>> P[i].id;

	// rocess burst time
	for (i = 0; i < n; i++)
		cin>> P[i].bt;

	// Process arrival time
	for (i = 0; i < n; i++)
		cin>> P[i].at;

	SJF();

	return 0;
}

/*
Ref: Educativesite.com

4
1 2 3 4
2 1 8 5
0 1 2 3

*/
