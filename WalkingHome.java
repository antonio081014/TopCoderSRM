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
#include <ctime>

using namespace std;

int dx[] = { 1, -1, 0, 0 };
int dy[] = { 0, 0, 1, -1 };
int grid[60][60];

class WalkingHome {
public:
	int fewestCrossings(vector <string>);
	void init(int m, int n) {
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				grid[i][j] = -1;
	}
};

int WalkingHome::fewestCrossings(vector <string> map) {
	int M = map.size();
	int N = map[0].size();
	init(M, N);
	int sx, sy, hx, hy;
	for (int i = 0; i < M; i++)
		for (int j = 0; j < N; j++) {
			if (map[i][j] == 'S') {
				sx = i;
				sy = j;
				map[i][j] = '.';
			}
			if (map[i][j] == 'H') {
				hx = i;
				hy = j;
				map[i][j] = '.';
			}
		}

	queue<pair<int, int> > q;
	q.push(make_pair(sx, sy));
	grid[sx][sy] = 0;
	while (!q.empty()) {
		int x1 = q.front().first;
		int y1 = q.front().second;
		int dist = grid[x1][y1];
		q.pop();
		for (int i = 0; i < 4; i++) {
			bool crossed = false;
			for (int j = 1;; j++) {
				int x2 = x1 + dx[i] * j;
				int y2 = y1 + dy[i] * j;
				if (x2 < 0 || x2 >= M || y2 < 0 || y2 >= N || map[x2][y2] == '*' || map[x2][y2] == 'F')
					break;
				if ((i < 2 && map[x2][y2] == '|') || (i >= 2 && map[x2][y2] == '-'))
					break;
				if ((i < 2 && map[x2][y2] == '-') || (i >= 2 && map[x2][y2]	== '|'))
					crossed = true;
				if (map[x2][y2] == '.') {
					if (crossed) {
//						cout << x2 << ", " << y2 << crossed << endl;
						if (grid[x2][y2] == -1 || grid[x2][y2] > dist + 1) {
							grid[x2][y2] = dist + 1;
							q.push(make_pair(x2, y2));
						}
					} else {
						if (grid[x2][y2] == -1 || grid[x2][y2] > dist){
							q.push(make_pair(x2, y2));
							grid[x2][y2] = dist;
						}
					}
					break; //This is very important;
				}
			}
		}
	}
//	for (int i = 0; i < M; i++) {
//		for (int j = 0; j < N; j++)
//			cout << grid[i][j] << ", ";
//		cout << endl;
//	}
	return grid[hx][hy];
}


//Powered by [KawigiEdit] 2.0!
