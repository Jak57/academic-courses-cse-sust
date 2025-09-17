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
process P[N];

void first_come_first_served()
{
	int i;
	int complete = 0;
	int current_time = 0;
	int index = -1;
	int minimum = INT_MAX;

	int total_tat = 0;
	int total_wt = 0;

	while (complete < n)
	{
		for (i = 0; i < n; i++)
		{
			if (P[i].ct == 0 && P[i].at <= current_time)
			{
				if (P[i].at < minimum)
				{
					minimum = P[i].at;
					index = i;
				}
			}
		}

		if (index >= 0)
		{
			complete++;
			current_time += P[index].bt;
			P[index].ct = current_time;
			P[index].tat = P[index].ct - P[index].at;
			P[index].wt = P[index].tat - P[index].bt;

			total_tat += P[index].tat;
			total_wt += P[index].wt;

			index = -1;
			minimum = INT_MAX;
		}
		else
			current_time++;
	}

	for (i = 0; i < n; i++)
		printf("---- %d %d %d\n", P[i].ct, P[i].tat, P[i].wt);

	printf("Average turnaround time %lf\n", total_tat/(n*1.0));
	printf("Average waiting time %lf\n", total_wt/(n*1.0));
}

int main()
{
	int i;
	cin>> n;

	for (i = 0; i < n; i++)
	{
		cin>> P[i].id >> P[i].at >> P[i].bt;
	}

	first_come_first_served();

	return 0;
}

/**
Ref: Educativesite.com

4 
1 0 2
2 1 1
3 2 8
4 3 5

*/
