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

class MNS {
public:
	int combos(vector <int>);
	bool checkMagic(vector<int> nn)
	{
		set<int> s;
		s.insert(nn[0] + nn[1] + nn[2]);
		s.insert(nn[3] + nn[4] + nn[5]);
		s.insert(nn[6] + nn[7] + nn[8]);

		s.insert(nn[0] + nn[3] + nn[6]);
		s.insert(nn[1] + nn[4] + nn[7]);
		s.insert(nn[2] + nn[5] + nn[8]);

		return (s.size() == 1);
	}
};

int MNS::combos(vector <int> numbers) {
	int score = 0;
	set<vector<int> > v;
	sort(numbers.begin(), numbers.end());

	if(checkMagic(numbers))
	{
		score++;
		v.insert(numbers);
	}
	while(next_permutation(numbers.begin(), numbers.end()))
	{
		if(checkMagic(numbers))
		{
			int sz = v.size();
			v.insert(numbers);
			if(sz != v.size())
				score++;
		}
	}
	return score;
}


//Powered by [KawigiEdit] 2.0!
