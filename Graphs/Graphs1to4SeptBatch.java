package Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Graphs1to4SeptBatch {
	static boolean[] visited;
	static Integer[][] graph = new Integer[7][7];

	private static void addEdge(int u, int v, int wt) {
		graph[u][v] = wt;
		graph[v][u] = wt;
	}

	public static void main(String[] args) {
		addEdge(0, 1, 10);
		addEdge(1, 2, 10);
		addEdge(2, 3, 10);
		addEdge(0, 3, 40);
		addEdge(3, 4, 2);
		addEdge(4, 5, 3);
		addEdge(5, 6, 3);
		addEdge(4, 6, 8);
		// addEdge(2, 5, 5);
		visited = new boolean[7];
//		dijkstra(0);
		// System.out.println(gcc());
		// System.out.println(bfs(0, 6));
		// System.out.println(hasPath(0, 6));
		// printAllPaths(0, 6, "");

		sp = "";
		spd = Integer.MAX_VALUE;
		lp = "";
		lpd = Integer.MIN_VALUE;
		cp = "";
		cpd = Integer.MAX_VALUE;
		fp = "";
		fpd = Integer.MIN_VALUE;
		pq = new PriorityQueue<>(Collections.reverseOrder());
//		multisolver(0, 6, "", 0, 50, 45, 3);
		// System.out.println("------------------------------------");
		// System.out.println(sp + "@" + spd);
		// System.out.println(lp + "@" + lpd);
		// System.out.println(cp + "@" + cpd);
		// System.out.println(fp + "@" + fpd);
		// System.out.println(pq.peek().path + "@" + pq.peek().dist);

		 hamiltonianpnc(0, 6, 1, "");

//		knightsTour(5, 1, 3);
	}

	// v + e
	private static boolean hasPath(int s, int d) {
		if (s == d) {
			return true;
		}

		visited[s] = true;
		for (int n = 0; n < graph.length; n++) {
			if (graph[s][n] != null && visited[n] == false) {
				boolean hpfntod = hasPath(n, d);
				if (hpfntod == true) {
					return true;
				}
			}
		}

		return false;
	}

	// v ^ (v - 1)
	private static void printAllPaths(int s, int d, String psf) {
		if (s == d) {
			System.out.println(psf + d);
			return;
		}

		System.out.println("Reached " + s);
		visited[s] = true;
		for (int n = 0; n < graph.length; n++) {
			if (graph[s][n] != null && visited[n] == false) {
				System.out.println(s + " -> " + n);
				printAllPaths(n, d, psf + s);
				System.out.println(n + " -> " + s);
			}
		}
		visited[s] = false;
		System.out.println("Leaving " + s);
	}

	static int spd;
	static String sp;
	static int lpd;
	static String lp;
	static int cpd;
	static String cp;
	static int fpd;
	static String fp;
	static PriorityQueue<Pair> pq;

	private static void multisolver(int s, int d, String psf, int dsf, int cw, int fw, int k) {
		if (s == d) {
			psf += d;
			System.out.println(psf + "@" + dsf);
			if (dsf > lpd) {
				lpd = dsf;
				lp = psf;
			}

			if (dsf < spd) {
				spd = dsf;
				sp = psf;
			}

			if (dsf > cw && dsf < cpd) {
				cpd = dsf;
				cp = psf;
			}

			if (dsf < fw && dsf > fpd) {
				fpd = dsf;
				fp = psf;
			}

			if (pq.size() < k) {
				pq.add(new Pair(dsf, psf));
			} else if (dsf < pq.peek().dist) {
				pq.remove();
				pq.add(new Pair(dsf, psf));
			}

			return;
		}

		visited[s] = true;
		for (int n = 0; n < graph.length; n++) {
			if (graph[s][n] != null && visited[n] == false) {
				multisolver(n, d, psf + s, dsf + graph[s][n], cw, fw, k);
			}
		}
		visited[s] = false;
	}

	static class Pair implements Comparable<Pair> {
		int dist;
		String path;

		Pair(int dist, String path) {
			this.dist = dist;
			this.path = path;
		}

		@Override
		public int compareTo(Pair o) {
			return this.dist - o.dist;
		}

		// public String toString() {
		// return dist + "@" + path;
		// }

	}

	public static void hamiltonianpnc(int s, int os, int counter, String psf) {
		if (counter == graph.length) { // initially 1
			if (graph[s][os] != null) {
				System.out.println(psf + s + "*");
			} else {
				System.out.println(psf + s);
			}
		}

		visited[s] = true;
		for (int n = 0; n < graph.length; n++) {
			if (graph[s][n] != null && visited[n] == false) {
				hamiltonianpnc(n, os, counter + 1, psf + s);
			}
		}
		visited[s] = false;
	}

	public static void knightsTour(int n, int r, int c) {
		Integer[][] gv = new Integer[n][n];
		ktcounter = 0;
		knightsTour(gv, r, c, 1);
		System.out.println(ktcounter);
	}

	static int ktcounter = 0;

	private static void knightsTour(Integer[][] gv, int r, int c, int counter) {
		if (r < 0 || r >= gv.length || c < 0 || c >= gv.length || gv[r][c] != null) {
			return;
		}

		gv[r][c] = counter;
		if (counter == gv.length * gv.length) {
			ktcounter++;
			for (int i = 0; i < gv.length; i++) {
				for (int j = 0; j < gv.length; j++) {
					System.out.print(gv[i][j] + "\t");
				}
				System.out.println();
			}
			System.out.println("**************" + ktcounter + "**************");
		}

		knightsTour(gv, r + 1, c + 2, counter + 1);
		knightsTour(gv, r + 2, c + 1, counter + 1);
		knightsTour(gv, r + 2, c - 1, counter + 1);
		knightsTour(gv, r + 1, c - 2, counter + 1);
		knightsTour(gv, r - 1, c - 2, counter + 1);
		knightsTour(gv, r - 2, c - 1, counter + 1);
		knightsTour(gv, r - 2, c + 1, counter + 1);
		knightsTour(gv, r - 1, c + 2, counter + 1);
		gv[r][c] = null;
	}

	// v + e
	private static boolean bfs(int s, int d) {
		LinkedList<Integer> queue = new LinkedList<>();
		queue.addLast(s);

		while (queue.size() > 0) {
			Integer rv = queue.removeFirst();

			if (visited[rv] == true) {
				continue;
			} else {
				visited[rv] = true;
			}

			if (rv == d) {
				return true;
			}

			for (int n = 0; n < graph.length; n++) {
				if (graph[rv][n] != null && visited[n] == false) {
					queue.addLast(n);
				}
			}
		}

		return false;
	}

	// v + e
	private static boolean dfsi(int s, int d) {
		LinkedList<Integer> stack = new LinkedList<>();
		stack.addFirst(s);

		while (stack.size() > 0) {
			Integer rv = stack.removeFirst();

			if (visited[rv] == true) {
				continue;
			} else {
				visited[rv] = true;
			}

			if (rv == d) {
				return true;
			}

			for (int n = 0; n < graph.length; n++) {
				if (graph[rv][n] != null && visited[n] == false) {
					stack.addFirst(n);
				}
			}
		}

		return false;
	}

	// v + e
	private static ArrayList<ArrayList<Integer>> gcc() {
		ArrayList<ArrayList<Integer>> comps = new ArrayList<>();

		for (int v = 0; v < graph.length; v++) {
			if (visited[v] == false) {
				ArrayList<Integer> comp = gccbft(v);
				comps.add(comp);
			}
		}

		return comps;
	}

	private static ArrayList<Integer> gccbft(Integer s) {
		ArrayList<Integer> comp = new ArrayList<>();
		LinkedList<Integer> queue = new LinkedList<>();
		queue.addLast(s);

		while (queue.size() > 0) {
			Integer rem = queue.removeFirst();

			if (visited[rem]) {
				continue;
			} else {
				visited[rem] = true;
			}

			comp.add(rem);

			for (int n = 0; n < graph.length; n++) {
				if (graph[rem][n] != null && visited[n] == false) {
					queue.addLast(n);
				}
			}
		}

		return comp;
	}

	// v + e
	public boolean IsCyclic() {
		for (int v = 0; v < graph.length; v++) {
			if (visited[v] == false) {
				boolean cyclic = cyclicbft(v);
				if (cyclic) {
					return true;
				}
			}
		}

		return false;
	}

	private static boolean cyclicbft(Integer s) {
		LinkedList<Integer> queue = new LinkedList<>();
		queue.addLast(s);

		while (queue.size() > 0) {
			Integer rem = queue.removeFirst();

			if (visited[rem]) {
				return true;
			} else {
				visited[rem] = true;
			}

			for (int n = 0; n < graph.length; n++) {
				if (graph[rem][n] != null && visited[n] == false) {
					queue.addLast(n);
				}
			}
		}

		return false;
	}

	// v + e
	public static boolean IsConnected() {
		// ArrayList<String> comps = gcc();
		// if(comps.size() > 1){
		// return false;
		// } else {
		// return true;
		// }

		ArrayList<Integer> comp = gccbft(0);
		return comp.size() == graph.length;
	}

	// (v + e)logv
	public static void dijkstra(Integer s) {
		PriorityQueue<Dpair> pq = new PriorityQueue<>();
		pq.add(new Dpair(s, s + "", 0));

		while (pq.size() > 0) {
			Dpair rem = pq.remove();

			if (visited[rem.v] == true) {
				continue;
			} else {
				visited[rem.v] = true;
			}

			System.out.println(rem.v + " via " + rem.p + "@" + rem.d);
			for (int n = 0; n < graph.length; n++) {
				if (graph[rem.v][n] != null && visited[n] == false) {
					pq.add(new Dpair(n, rem.p + n, rem.d + graph[rem.v][n]));
				}
			}
		}
	}

	private static class Dpair implements Comparable<Dpair> {
		int v;
		String p;
		int d;

		Dpair(int v, String p, int d) {
			this.v = v;
			this.p = p;
			this.d = d;
		}

		@Override
		public int compareTo(Dpair o) {
			return this.d - o.d;
		}
	}

}
