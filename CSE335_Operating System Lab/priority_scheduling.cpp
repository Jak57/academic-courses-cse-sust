/**
 Priority Scheduling Algorithm
 */

#include<bits/stdc++.h>
using namespace std;

const int N = 100005;
int n;

struct process {
    int id; // process id
    int at; // arrival time
    int bt; // burst time
    int p; // priority

    int ct; // completion time
    int tat; // turnaround time
    int wt; // waiting time
    int rt; // response time
};

process P[N];

void priority_scheduling()
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
                if (P[i].p < minimum)
                {
                    minimum = P[i].p;
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

            total_tat += P[index].tat;
            total_wt += P[index].wt;

            complete++;
            index = -1;
            minimum = INT_MAX;
        }
        else
            current_time++;
    }

    printf("Average turnaround time %lf\n", total_tat/(n*1.0));
    printf("Average waiting time %lf\n", total_wt/(n*1.0));
}

int main()
{
    int i;
    // Total number of process
    cin>> n;

    for (i = 0; i < n; i++)
        cin>> P[i].id >> P[i].at >> P[i].bt >> P[i].p;

    priority_scheduling();

    return 0;
}

/*
Ref: Educativesite.com

4
1 0 2 3
2 1 1 4
3 2 8 1
4 3 5 2
*/