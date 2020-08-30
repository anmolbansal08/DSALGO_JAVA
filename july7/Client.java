
package july7;

import july6.stacksstory.DynamicStack;
import july6.stacksstory.Stack;

public class Client {

	public static void main(String[] args) {
		// System.out.println(isBalancedExpression("[{(a+b)+(c+d)}]"));
		// System.out.println(duplicate("(()))"));
		// int[] prices = {10, 20, 30, 25, 22, 28, 50, 40, 45, 47, 35};
		// int[] spans = spans(prices);
		//// for(int val: spans){
		//// System.out.print(val + " ");
		// }
		// System.out.println(".");
		int arr[] = { 6, 2, 5, 4, 5, 1, 6 };
		System.out.println(LAH(arr));
	}

	public static boolean isBalancedExpression(String str) {
		Stack st = new DynamicStack(str.length());

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			if (ch == '(' || ch == '{' || ch == '[') {
				st.push(ch);
			} else if (ch == ')' || ch == '}' || ch == ']') {
				if (st.size() == 0) {
					return false; // extra closing brackets
				} else if (ch == ')' && st.top() != '(') {
					return false; // mismatch
				} else if (ch == '}' && st.top() != '{') {
					return false; // mismatch
				} else if (ch == ']' && st.top() != '[') {
					return false; // mismatch
				} else {
					st.pop();
				}
			}
		}

		if (st.size() != 0) {
			return false; // extra opening brackets
		} else {
			return true;
		}
	}

	public static boolean duplicate(String str) {
		DynamicStack st = new DynamicStack(str.length());

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			if (ch != ')') {
				st.push(ch);
			} else {
				if (st.top() == '(') {
					return true;
				} else {
					while (st.top() != '(') {
						st.pop();
					}
					st.pop();// one pop extra for rem last closing bracket.....
				}
			}
		}

		return false;
	}

	public static int[] spans(int[] prices) {
		StackUsingQueuesPushO1 st = new StackUsingQueuesPushO1(prices.length);
		int[] spans = new int[prices.length];

		spans[0] = 1;
		st.push(0);

		for (int i = 1; i < prices.length; i++) {
			// make pops
			while (st.size() > 0 && prices[st.top()] < prices[i]) {
				st.pop();
			}

			// set value
			spans[i] = st.size() == 0 ? i + 1 : i - st.top();

			// push
			st.push(i);
		}

		return spans;
	}

	public static int trappingrainwater(int arr[]) {
		int left[] = new int[arr.length];
		int right[] = new int[arr.length];
		int water = 0;
		left[0] = 1;
		for (int i = 1; i < left.length; i++) {
			left[i] = Math.max(arr[i], left[i - 1]);
		}
		right[arr.length - 1] = 0;
		for (int i = right.length - 2; i >= 0; i--) {

		}

		return water;
	}

	public static int LAH(int arr[]) {
		java.util.Stack<Integer> s = new java.util.Stack<>();
		int i = 0;
		int area = 0;
		int max_area = Integer.MIN_VALUE;
		for (i = 0; i < arr.length;) {
			if (s.empty() || arr[s.peek()] <= arr[i]) {
				s.push(i);
				i++;
			} else {
				int currtop = s.peek();
				s.pop();

				if (s.empty()) {
					area = arr[currtop] * i;
				} else {
					area = arr[currtop] * (i - s.peek() - 1);
				}
				max_area = Math.max(max_area, area);
			}
		}
		while (!s.empty()) {
			int tp = s.peek();
			s.pop();
			area = s.empty() ? arr[tp] * i : arr[tp] * (i - s.peek() - 1);
			max_area = Math.max(max_area, area);
		}
		return max_area;
	}

}
