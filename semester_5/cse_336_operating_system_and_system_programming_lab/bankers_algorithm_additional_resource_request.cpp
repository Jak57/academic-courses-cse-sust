/**
 * Banker's algorithm: Request for additional resources
 * Process P1 requests for 1 instances of resource type A and
 * 2 instances of resource type C
 */

#include<bits/stdc++.h>
using namespace std;

int main()
{
	int n = 5, m = 3, i, j, k;
	bool found;

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
	// P1 requests for 1 instance of resource type A and 2
	// instance of resource type C
	int request[3] = {1, 0, 2};

	found = true;
	for (i = 0; i < m; i++)
	{
		if (request[i] > available[i])
		{
			found = false;
			break;
		}
	}

	if (!found)
	{
		cout<< "Not enough resources. So, request can't be granted." << "\n";
		return 0;
	}

	// Subtract requested resources from available resources
	for (i = 0; i < m; i++)
		available[i] -= request[i];

	// Add requested resources to allocation matrix
	for (j = 0; j < m; j++)
		allocation[1][j] += request[j];

	// Calculate need matrix
	int need[5][3];
	for (i = 0; i < n; i++)
	{
		for (j = 0; j < m; j++)
			need[i][j] = maximum[i][j] - allocation[i][j];
	}

	int finish[5];
	memset(finish, 0, sizeof(finish));
	vector<int> safe_sequence;

	for (k = 0; k < n; k++)
	{
		for (i = 0; i < n; i++)
		{
			if (finish[i] == 0)
			{
				found = true;
				for (j = 0; j < m; j++)
				{
					if (need[i][j] > available[j])
					{
						found = false;
						break;
					}
				}

				if (found)
				{
					finish[i] = 1;
					safe_sequence.push_back(i);
					// Add resources of process i to available resources
					for (j = 0; j < m; j++)
						available[j] += allocation[i][j];
				}
			}
		}
	}

	if (safe_sequence.size() == n)
	{
		cout<< "Request for additional resources can be granted." << "\n";
		cout<< "Safe sequence: ";
		for (i = 0; i < n; i++)
			printf("P%d ", safe_sequence[i]);
		cout<< "\n";
	}
	else
		cout<< "Request can't be granted." << "\n";

	return 0;
}

