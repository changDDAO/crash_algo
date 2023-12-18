import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class P_Baek2784 {
	
	public void Solution() {
		final int WORDS_LEN = 6;
		boolean[] used = new boolean[WORDS_LEN];
		ArrayList<String> words_primitive = new ArrayList<String>(); 
		String[] words;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
			
			for (int i = 0; i < WORDS_LEN; i++)
				words_primitive.add(br.readLine());
			
			words_primitive.sort((a,b)->(a.compareTo(b)));
			words = words_primitive.toArray(new String[WORDS_LEN]);
		} catch (Exception e) {
			System.out.println("INPUT ERROR");
			return;
		}
		
		final int PUZZLE_ROW = 3;
		final int PUZZLE_COL = 3;
		char[][] puzzle = new char[PUZZLE_ROW][PUZZLE_COL];
		
		Stack<Integer> stack = new Stack<Integer>();
	
		int doneRow = 0;
		int doneCol = 0;
		
		stack.add(-1);
		
		StringBuilder preString = new StringBuilder();
		while (true) {
			
			// 행 채우기
			if (doneRow == doneCol) {
				
				// 만들어지고 있던 글자들 가져오기
				preString.delete(0, preString.length());
				for (int i = 0; i < doneCol; i++)
					preString.append(puzzle[doneRow][i]);
				
				// 만들어진 문자에 쓸 수 있는 문자열이 있는지 확인
				int validStringIdx = stack.pop() + 1;
				for (; validStringIdx < words.length; validStringIdx++)
					if (!used[validStringIdx] && words[validStringIdx].substring(0,doneCol).compareTo(preString.toString()) == 0)
						break;
				
				if (validStringIdx == words.length) {
					// 뒤로가기
					doneCol--;
					if (stack.isEmpty())
						break;
					used[stack.peek()] = false;
				}
				else {
					// 문자열 채워넣기
					for (int i = doneCol; i < PUZZLE_COL; i++)
						puzzle[doneRow][i] = words[validStringIdx].charAt(i);
					
					stack.push(validStringIdx);
					stack.push(-1);
					used[validStringIdx] = true;
					doneRow++;
				}
			}
			
			// 열 채우기
			else {
				
				// 만들어지고 있던 글자들 가져오기
				preString.delete(0, preString.length());
				for (int i = 0; i < doneRow; i++)
					preString.append(puzzle[i][doneCol]);
				
				// 만들어진 문자에 쓸 수 있는 문자열이 있는지 확인
				int validStringIdx = stack.pop() + 1;
				for (; validStringIdx < words.length; validStringIdx++)
					if (!used[validStringIdx] && words[validStringIdx].substring(0,doneRow).compareTo(preString.toString()) == 0)
						break;
				
				if (validStringIdx == words.length) {
					// 뒤로가기
					doneRow--;
					used[stack.peek()] = false;
				}
				else {
					// 문자열 채워넣기
					for (int i = doneRow; i < PUZZLE_ROW; i++)
						puzzle[i][doneCol] = words[validStringIdx].charAt(i);
					
					stack.push(validStringIdx);
					stack.push(-1);
					used[validStringIdx] = true;
					doneCol++;
					
					if (doneRow == PUZZLE_ROW && doneCol == PUZZLE_COL)
						break;
				}
			}
		}
		
		StringBuilder answer = new StringBuilder(); 
		if (doneRow == PUZZLE_ROW && doneCol == PUZZLE_COL)
			for (int i = 0; i < PUZZLE_ROW; i++) {
				for (int j = 0; j < PUZZLE_COL; j++)
					answer.append(puzzle[i][j]);
				answer.append("\n");
			}
		else
			answer.append(0);
		
		System.out.println(answer);
	}
}
