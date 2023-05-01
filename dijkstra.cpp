#include <iostream>
#include <bits/stdc++.h>

using namespace std;

vector<int> dijkstra(int n, vector<vector<int>> adj[], int s)
{
  priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
  vector<int> dist(n, 1000000000);

  dist[s] = 0;

  pq.push({dist[s], s});

  while (!pq.empty())
  {
    int dis = pq.top().first;
    int node = pq.top().second;

    pq.pop();

    for (auto it : adj[node])
    {
      int wt = it[1];
      int adjNode = it[0];

      if (dis + wt < dist[adjNode])
      {
        dist[adjNode] = dis + wt;
        pq.push({dist[adjNode], adjNode});
      }
    }
  }

  return dist;
}

void printans (vector<int> v , int s){

  cout << "Src" << "\t\t\t\t" << "Dest" << "\t\t\t\t" << "Distance" << endl;
  for(int i = 0 ; i < v.size() ; i++){
    cout << s << "\t\t\t\t" << i << "\t\t\t\t" << v[i] << endl;
  }
  
}

int main()
{

  int n = 3;
  vector<vector<int>> adj[n];
  int s = 0;

  adj[0] = {{1, 1}, {2, 6}};
  adj[1] = {{2, 3}, {0, 1}};
  adj[2] = {{1, 3}, {0, 6}};

  printans(dijkstra(n , adj , s) , s);

  return 0;
}
