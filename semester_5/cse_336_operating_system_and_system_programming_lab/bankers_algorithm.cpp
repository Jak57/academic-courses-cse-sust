/**
 * Banker's algorithm
 */

#include<bits/stdc++.h>
using namespace std;

int main()
{
	// P0, P1, P2, P3, P4 are process names here
	int n, m, i, j, k, flag;
	n = 5; // Number of processes
	m = 3; // Number of resources

	// Allocation matrix
	int allocation[5][3] = {
		{0, 1, 0},
		{2, 0, 0},
		{3, 0, 2},
		{2, 1, 1},
		{0, 0, 2}
	};

	// Maximum matrix
	int maximum[5][3] = {
		{7, 5, 3},
		{3, 2, 2},
		{9, 0, 2},
		{2, 2, 2},
		{4, 3, 3}
	};

	// Available resources 
	int available[3] = {3, 3, 2};
	// Indicates execution of a process is finished or not
	int finish[5];
	memset(finish, 0, sizeof(finish));
	// Stores safe sequence
	vector<int> safe_sequence;

	// Need matrix
	int need[5][3];
	for (i = 0; i < n; i++)
	{
		for (j = 0; j < m; j++)
			need[i][j] = maximum[i][j] - allocation[i][j];
	}

	for (k = 0; k < n; k++)
	{
		for (i = 0; i < n; i++)
		{
			if (finish[i] == 0)
			{
				flag = 0;
				for (j = 0; j < m; j++)
				{
					if (need[i][j] > available[j])
					{
						flag = 1;
						break;
					}
				}

				// If process can complete execution with available 
				// resources
				if (flag == 0)
				{
					safe_sequence.push_back(i);
					finish[i] = 1;

					// Add resources of completed process to
					// available resources
					for (j = 0; j < m; j++)
						available[j] += allocation[i][j];
				}
			}
		}
	}

	if (safe_sequence.size() != n)
		cout<< "The system is not in safe state" << "\n";
	else
	{
		cout<< "Safe sequence is: ";
		for (i = 0; i < n; i++)
		{
			if (i == n-1)
				printf("P%d\n", safe_sequence[i]);
			else
				printf("P%d -> ", safe_sequence[i]);
		}
	}


	return 0;
}

/*
Ref: Geeks for geeks

*/