//Thu May 19 09:18:22 CDT 2011
#include <vector>
#include <list>
#include <map>
#include <set>
#include <deque>
#include <queue>
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
#include <cctype>
#include <string>
#include <cstring>
#include <cstdio>
#include <cmath>
#include <cstdlib>
#include <ctime>

using namespace std;

class TallPeople {
private:
	vector<vector<int> > peopler;
	vector<vector<int> > peoplec;
public:
	vector<int> getPeople(vector<string> p) {
		init(p);
		int row = 0;
		int col = 1000;
		for (int i = 0; i < peopler.size(); i++)
			row = max(row, *min_element(peopler[i].begin(), peopler[i].end()));
		for (int i = 0; i < peoplec.size(); i++)
			col = min(col, *max_element(peoplec[i].begin(), peoplec[i].end()));
		vector<int> ret;
		ret.push_back(row);
		ret.push_back(col);
		return ret;
	}
	void init(vector<string> p) {
		for (int i = 0; i < p.size(); i++) {
			vector<int> tmp;
			int number;
			stringstream s(p[i]);
			while (s >> number)
				tmp.push_back(number);
			peopler.push_back(tmp);
		}
		for (int i = 0; i < peopler[0].size(); i++) {
			vector<int> tmp;
			for (int j = 0; j < peopler.size(); j++)
				tmp.push_back(peopler[j][i]);
			peoplec.push_back(tmp);
		}
		for (int i = 0; i < peopler.size(); i++) {
			for (int j = 0; j < peopler[i].size(); j++)
				cout << peopler[i][j] << " ";
			cout << endl;
		}
		for (int i = 0; i < peoplec.size(); i++) {
			for (int j = 0; j < peoplec[i].size(); j++)
				cout << peoplec[i][j] << " ";
			cout << endl;
		}
	}
};
