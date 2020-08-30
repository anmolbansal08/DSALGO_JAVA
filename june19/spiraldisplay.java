package june19;

public class spiraldisplay {

	public static void main(String[] args) {
		// double db = 4.0 / 7;
		// System.out.println(db);
		// System.out.println(Math.round(db * 1000000) / 10000000.0);

		int[][] arr = { { 11, 12, 13 }, { 21, 22, 23 }, { 31, 32, 33 }, { 41, 42, 43 }, { 51, 52, 53 } };

		int rmin = 0;
		int rmax = arr.length - 1;
		int cmin = 0;
		int cmax = arr[0].length - 1;

		int cntr = 1;
		int tne = arr.length * arr[0].length;

		while (cntr <= tne) { // while elements are not exhausted
			// left wall
			for (int row = rmin; row <= rmax ; row++) {
				System.out.print(arr[row][cmin] + " ");
				cntr++;
			}
			cmin++;

			// south wall
			for (int col = cmin; col <= cmax ; col++) {
				System.out.print(arr[rmax][col] + " ");
				cntr++;
			}

			rmax--;

			// right wall
			for (int row = rmax; row >= rmin ; row--) {
				System.out.print(arr[row][cmax] + " ");
				cntr++;
			}
			cmax--;

			// north wall
			for (int col = cmax; col >= cmin ; col--) {
				System.out.print(arr[rmin][col] + " ");
				cntr++;
			}
			rmin++;

		}

	}

}
