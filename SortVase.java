package sortvases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

class SortVase{

	int V;
	LinkedList<Integer>[] adjListArray;

	Graph(int V) {
		this.V = V;
		adjListArray = new LinkedList[V + 1];

		for (int i = 1; i <= V; i++) {
			adjListArray[i] = new LinkedList<Integer>();
		}
	}

	void addEdge(int src, int dest) {
		adjListArray[src].add(dest);
		adjListArray[dest].add(src);
	}

	void DFSUtil(int v, boolean[] visited) {
		visited[v] = true;
		System.out.print(v + " ");
		for (int x : adjListArray[v]) {
			if (!visited[x])
				DFSUtil(x, visited);
		}

	}

	void connectedComponents() {
		boolean[] visited = new boolean[V + 1];
		for (int v = 1; v <= V; ++v) {
			if (!visited[v]) {
				DFSUtil(v, visited);
				System.out.println();
			}
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String testcases = br.readLine();
		String t[] = testcases.split(" ");
		int T = Integer.parseInt(t[0]);

		for (int z = 0; z < T; z++) {

			String n_and_m = br.readLine();
			String[] n_m = n_and_m.split(" ");
			int N = Integer.parseInt(n_m[0]); // Value of n
			int M = Integer.parseInt(n_m[1]); // value of m

			String values = br.readLine();
			String[] arr_inputs = values.split(" ");

			int arr[] = new int[N];

			for (int w = 0; w < N; w++) {
				arr[w] = Integer.parseInt(arr_inputs[w]);
			}

			Graph g = new Graph(N); // Creating a graph with N vertices.

			for (int x = 0; x < M; x++) {
				String temp_value = br.readLine();
				String[] src_destination = temp_value.split(" ");
				int src = Integer.parseInt(src_destination[0]);
				int dest = Integer.parseInt(src_destination[1]);

				g.addEdge(src, dest);
			}

			System.out.println("Following are connected components");
			g.connectedComponents();
		}
	}
}
