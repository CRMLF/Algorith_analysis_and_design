//
// Created by CRMLF on 2021/4/25.
//

#include<iostream>
#include<algorithm>

using namespace std;
const int maxn = 1e2 + 10;
const int Max = 1e4 + 10;

inline int rd() {
    int x;
    scanf("%d", &x);
    return x;
}

int n, m, cnt;// m万元，n个项目
int cost[maxn], val[maxn], dp[maxn] = {0};

int solve() {
    for (int i = 0; i < cnt; i++) {
        for (int j = m; j >= cost[i]; j--) {
            dp[j] = max(dp[j], dp[j - cost[i]] + val[i]);
        }
    }
    return dp[m];
}

int main() {
    m = rd();
    n = rd();
    cnt = 0;
    //对每个项目进行分解，将每一个项目转化为多个项目，问题就变成了0/1背包
    for (int i = 0; i <= m; i++) {
        int give = rd();//付出
        for (int j = 1; j <= n; j++) {
            cost[cnt] = give;
            val[cnt++] = rd();//价值
        }
    }
    printf("%d\n", solve());
    system("pause");
    return 0;
}
/*
5 4
0 0 0 0 0
1 11 0 2 20
2 12 5 10 21
3 13 10 30 22
4 14 15 32 23
5 15 20 40 24
*/
/*
61
*/
