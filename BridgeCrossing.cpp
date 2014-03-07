#include <vector>
#include <list>
#include <map>
#include <set>
#include <deque>
#include <stack>
#include <bitset>
#include <algorithm>
#include <functional>
#include <numeric>
#include <utility>
#include <sstream>
#include <iostream>
#include <iomanip>
#include <cstdio>
#include <cmath>
#include <cstdlib>
#include <ctime>

using namespace std;

class BridgeCrossing {
public:
	int minTime(vector <int>);
	int crossriver(vector<int> v, int T);
};

int BridgeCrossing::minTime(vector <int> times) {
	sort(times.begin(), times.end());
	return crossriver(times, times.size());
}

int BridgeCrossing::crossriver(vector<int> v, int T){
	if (T == 1)
	{
		return v[0];
	}
	if (T == 2)
	{
		return v[1];
	}
	if (T == 3)
	{
		return v[0] + v[1] + v[2];
	}
	if (v[0] + 3 * v[1] + v[T - 1] > 2 * v[0] + v[1] + v[T - 2] + v[T - 1])
	{
		return 2 * v[0] + v[T - 2] + v[T - 1] + crossriver(v, T - 2);
	}
	else
	{
		return v[0] + 2 * v[1] + v[T - 1] + crossriver(v, T - 2);
	}
}


//Powered by [KawigiEdit] 2.0!
