/**
  Round Robin Scheduling
 */

#include<bits/stdc++.h>
using namespace std;

const int N = 100005;
int n;
int tq; // time quantum

struct process {
	int id;	// process id
	int at; // arrival time
	int bt; // burst time

	int ct; // completion time
	int tat; // turnaround time
	int wt; // waiting time
	int rt; // remaining time
};
process P[N];

void round_robin()
{
	int i, change;
	int complete = 0;
	int current_time = 0;

	int total_tat = 0;
	int total_wt = 0;

	for (i = 0; i < n; i++)
		P[i].rt = P[i].bt;

	while (complete < n)
	{
		change = 0;
		for (i = 0; i < n; i++)
		{
			if (P[i].at <= current_time && P[i].rt > 0)
			{
				if (P[i].rt <= tq)
				{
					complete++;
					current_time += P[i].rt;

					P[i].ct = current_time;
					P[i].tat = P[i].ct - P[i].at;
					P[i].wt = P[i].tat - P[i].bt;
					P[i].rt = 0;

					total_tat += P[i].tat;
					total_wt += P[i].wt;
				}
				else
				{
					P[i].rt -= tq;
					current_time += tq;
				}
				change++;
			}
		}

		if (change == 0)
			current_time++;
	}

	printf("Average turnaround time %lf\n", total_tat/(n*1.0));
	printf("Average waiting time %lf\n", total_wt/(n*1.0));
}

int main()
{
	int i;
	cin>> n >> tq;

	for (i = 0; i < n; i++)
		cin>> P[i].id >> P[i].at >> P[i].bt;

	round_robin();

	return 0;
}

/*
Ref: Educativesite.com

4 3
1 0 2
2 1 1
3 2 8
4 3 5

*/