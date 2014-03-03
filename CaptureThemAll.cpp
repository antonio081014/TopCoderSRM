//Fri May 20 16:03:23 CDT 2011
#include <string>
#include <iostream>
#include <vector>
#include <map>
#include <queue>
#include <sstream>
#include <algorithm>

using namespace std;

int dx[] = { -2, -2, -1, 1, 2, 2, 1, -1 };
int dy[] = { 1, -1, -2, -2, -1, 1, 2, 2 };

class CaptureThemAll {
private:
	int grid[8][8];
public:
	int fastKnight(string knight, string rook, string queen) {
		int k2r = bfs(knight, rook);
		int k2q = bfs(knight, queen);
		int r2q = bfs(rook, queen);
		cout << k2r << ", " << k2q << ", " << r2q << endl;
		return min(k2r, k2q) + r2q;
	}

	int bfs(string a, string b) {
		int x1 = a[0] - 'a';
		int y1 = a[1] - '1';
		int x2 = b[0] - 'a';
		int y2 = b[1] - '1';
//		cout << "String b:" << x2 << ", " << y2 << endl;
		init(-1);
		grid[x1][y1] = 0;
		queue<pair<int, int> > q;
		q.push(make_pair(x1, y1));
		while (q.empty() == false) {
			x1 = q.front().first;
			y1 = q.front().second;
			q.pop();
			for (int i = 0; i < 8; i++) {
				int xx = x1 + dx[i];
				int yy = y1 + dy[i];
				if (checkBound(xx, yy) && grid[xx][yy] == -1) {
//					cout << xx << ", " << yy << endl;
					q.push(make_pair(xx, yy));
					grid[xx][yy] = grid[x1][y1] + 1;
					if (xx == x2 && yy == y2)
						return grid[xx][yy];
				}
			}
		}
		return grid[x2][y2];
	}

	bool checkBound(int x, int y) {
		if (x < 0 || x >= 8)
			return false;
		if (y < 0 || y >= 8)
			return false;
		return true;
	}

	void init(int k) {
		memset(grid, k, sizeof(grid));
	}
};
