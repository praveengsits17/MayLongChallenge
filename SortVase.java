package sortvases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

class Graph {

	int V;
	LinkedList<Integer>[] adjListArray;

	// constructor
	Graph(int V) {
		this.V = V;
		// define the size of array as
		// number of vertices
		adjListArray = new LinkedList[V + 1];

		// Create a new list for each vertex
		// such that adjacent nodes can be stored

		for (int i = 1; i <= V; i++) {
			adjListArray[i] = new LinkedList<Integer>();
		}
	}

	// Adds an edge to an undirected graph
	void addEdge(int src, int dest) {
		// Add an edge from src to dest.
		adjListArray[src].add(dest);

		// Since graph is undirected, add an edge from dest
		// to src also
		adjListArray[dest].add(src);
	}
	
	String str ="";
	ArrayList<String> alist = new ArrayList<String>();
	
	String DFSUtil(int v, boolean[] visited) {
		// Mark the current node as visited and print it
		visited[v] = true;
		
		str = v +" ";
		
		//System.out.print(v + " ");
		
		// Recur for all the vertices
		// adjacent to this vertex
		for (int x : adjListArray[v]) {
			if (!visited[x]) {
				visited[x] = true;
				//System.out.print(x + " ");
				str = str + x + " " ;
			}
			
		}	
		return str ;
	}

	
	void connectedComponents() {
		// Mark all the vertices as not visited
		boolean[] visited = new boolean[V + 1];
		for (int v = 1; v <= V; ++v) {
			str = "";
			if (!visited[v]) {
				// print all reachable vertices
				// from v
				alist.add(DFSUtil(v, visited));
			}
		}
		
		for(int h =0 ; h<alist.size(); h++) {
			System.out.println(alist.get(h));
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
