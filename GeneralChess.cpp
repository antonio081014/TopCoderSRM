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

int dx[] = {2, 1, -1, -2, -2, -1, 1, 2};
int dy[] = {1, 2, 2, 1, -1, -2, -2, -1};

class GeneralChess {
public:
	vector <string> attackPositions(vector <string>);
	vector<pair<int, int> > pos;
};

vector <string> GeneralChess::attackPositions(vector <string> p) {
	stringstream s(p[0]);
	int x, y;
	char c;
	s >> x >> c >> y;
	for(int i=0; i<8; i++){
		pos.push_back(make_pair(x+dx[i], y+dy[i]));
	}
	for(int j=1; j<p.size(); j++){
		stringstream ss(p[j]);
		ss >> x >> c >> y;
//		cout << "Positions: " << x << ", " << y << endl;
		vector<pair<int, int> > tmp;
		for(int i=0; i<8; i++){
			tmp.push_back(make_pair(x+dx[i], y+dy[i]));
		}
		vector<pair<int, int> > tmpset;
		for(int i=0; i<pos.size(); i++){
			for(int k=0; k<tmp.size(); k++)
				if(pos[i].first == tmp[k].first && pos[i].second == tmp[k].second)
					tmpset.push_back(pos[i]);
		}
		pos = tmpset;
	}
	sort(pos.begin(), pos.end());
	vector<string> res;
	for(int i=0; i<pos.size(); i++){
		stringstream str;
		str << pos[i].first << "," << pos[i].second;
		res.push_back(str.str());
	}
	return res;
}


//Powered by [KawigiEdit] 2.0!
