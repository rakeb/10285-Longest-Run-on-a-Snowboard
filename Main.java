import java.util.Scanner;

public class Main {
	private static int rowNbr[] = { -1, 0, 1, 0 };
	private static int colNbr[] = { 0, -1, 0, 1 };

	private static int ROW, COL, Counter, depth;

	static boolean isSafe(int M[][], int row, int col, boolean visited[][],
			int current) {
		return (row >= 0) && (row < ROW) && (col >= 0) && (col < COL)
				&& (M[row][col] < current && !visited[row][col]);
	}

	public static void DFS(int M[][], int row, int col, boolean visited[][]) {
		visited[row][col] = true;

		int current = M[row][col];
		for (int k = 0; k < 4; ++k) {
			if (isSafe(M, row + rowNbr[k], col + colNbr[k], visited, current)) {
				depth++;
				if (depth > Counter) {
					Counter++;
				}
				DFS(M, row + rowNbr[k], col + colNbr[k], visited);
			}
		}
		visited[row][col] = false;
		depth--;
	}

	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		while (n > 0) {
			int answer = -1;
			String name = sc.next();
			ROW = sc.nextInt();
			COL = sc.nextInt();

			int[][] grid = new int[ROW][COL];
			boolean[][] visited = new boolean[ROW][COL];
			for (int i = 0; i < ROW; i++) {
				for (int j = 0; j < COL; j++) {
					grid[i][j] = sc.nextInt();
					visited[i][j] = false;
				}
			}
			for (int i = 0; i < ROW; i++) {
				for (int j = 0; j < COL; j++) {
					Counter = 0;
					depth = 0;
					clearVisit(visited);
					DFS(grid, i, j, visited);
					if (Counter > answer) {
						answer = Counter;
					}

				}

			}
			System.out.println(name + ": " + (answer + 1));
			n--;
		}

	}

	private static void clearVisit(boolean[][] visited) {
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				visited[i][j] = false;
			}

		}
	}

}