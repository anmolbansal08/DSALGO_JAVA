package Graphs;

import java.util.ArrayList;
import java.util.HashSet;

public class Class1 {

	static class Edge {
		int n;
		int wt;

		public Edge(int n, int wt) {
			this.n = n;
			this.wt = wt;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
		for (int i = 0; i < 7; i++) {
			graph.add(new ArrayList<>());
		}
		addEdge(graph, 0, 1, 10);
		addEdge(graph, 1, 2, 10);
		addEdge(graph, 2, 3, 10);
		addEdge(graph, 0, 3, 40);
		addEdge(graph, 3, 4, 2);
		addEdge(graph, 4, 5, 3);
		addEdge(graph, 4, 6, 8);
		addEdge(graph, 5, 6, 3);
		 display(graph);
		// System.out.println(haspath(graph, 4, 6, new HashSet<>()));

//		printallpaths(graph, 0, 6, new HashSet<>(), "");
		// System.err.println(mincostpath(graph, 0, 6, new HashSet<>()));
//		mincostpath(graph, 0, 6, new HashSet<>(), "", 0);
//		System.out.println(minpath + "@" + mincostpath);
//	floor_path(graph, 0, 6, new HashSet<>(), "", 0, 30);
//System.out.println(floorpath+"@"+floorcost);
	}

	

	public static void addEdge(ArrayList<ArrayList<Edge>> graph, int s, int d, int wt) {
		graph.get(s).add(new Edge(d, wt));

		graph.get(d).add(new Edge(s, wt));
	}

	static void display(ArrayList<ArrayList<Edge>> graph) {
		System.out.println("---------------");
		for (int v = 0; v < graph.size(); v++) {
			System.out.print(v + "-->" + " ");
			for (int n = 0; n < graph.get(v).size(); n++) {
				Edge ne = graph.get(v).get(n);
				System.out.print(ne.n + "@" + ne.wt + " ");
			}
			System.out.println();
		}

	}
	

	static boolean haspath(ArrayList<ArrayList<Edge>> graph, int s, int d, HashSet<Integer> visited) {
		if (s == d) {
			return true;
		}
		visited.add(s);
		for (Edge ed : graph.get(s)) {
			int ev = ed.n;
			if (!visited.contains(ev)) {

				boolean haspath = haspath(graph, ev, d, visited);
				if (haspath == true) {
					return true;
				}
			}

		}
		return false;

	}

	static void printallpaths(ArrayList<ArrayList<Edge>> graph, int s, int d, HashSet<Integer> visited, String asf) {

		if (s == d) {
			System.out.println(asf + d + " ");
			return;
		}
		visited.add(s);
		for (int n = 0; n < graph.get(s).size(); n++) {
			Edge ne = graph.get(s).get(n);

			int ev = ne.n;
			if (!visited.contains(ev)) {
				printallpaths(graph, ev, d, visited, asf + s + " ");
			}

		}
		visited.remove(s);
	}

	static int mincostpath = Integer.MAX_VALUE;
	static String minpath = "";
	static int largestcostpath = Integer.MIN_VALUE;

	static void mincostpath(ArrayList<ArrayList<Edge>> graph, int s, int d, HashSet<Integer> visited, String psf,
			int sumsf) {
		if (s == d) {
			if (sumsf < mincostpath) {
				// System.out.println(psf + sumsf);
				mincostpath = sumsf;
				minpath = psf + d;
			}
			return;
		}
		visited.add(s);
		for (Edge ed : graph.get(s)) {

			if (!visited.contains(ed.n)) {
				mincostpath(graph, ed.n, d, visited, psf + s, sumsf + ed.wt);

			}

		}
		visited.remove(s);

	}

	static void largecostpath(ArrayList<ArrayList<Edge>> graph, int s, int d, HashSet<Integer> visited, String psf,
			int sumsf) {
		if (s == d) {
			if (sumsf < mincostpath) {
				// System.out.println(psf + sumsf);
				mincostpath = sumsf;
				minpath = psf + d;
			}
			return;
		}
		visited.add(s);
		for (Edge ed : graph.get(s)) {
			if (!visited.contains(ed.n)) {
				mincostpath(graph, ed.n, d, visited, psf + s, sumsf + ed.wt);

			}

		}
		visited.remove(s);

	}
	static int floorcost=0;
	static String floorpath="";
	static void floor_path(ArrayList<ArrayList<Edge>> graph, int s, int d, HashSet<Integer> visited, String psf,
			int sumsf,int floor) {
		if (s == d) {
			if (sumsf < floorcost&&sumsf<floor) {
				// System.out.println(psf + sumsf);
				floorcost = sumsf;
				floorpath = psf + d;
			}
			return;
		}
		visited.add(s);
		for (Edge ed : graph.get(s)) {

			if (!visited.contains(ed.n)) {
				mincostpath(graph, ed.n, d, visited, psf + s, sumsf + ed.wt);

			}

		}
		visited.remove(s);

	}
}
