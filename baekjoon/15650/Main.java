import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int M;
	static StringBuilder sb = new StringBuilder();
	static int[] selected;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		selected = new int[M+1];

		sol(1); // 탐색은 1부터 진행함
		System.out.println(sb);
	}

	static void sol(int k){

		if(k == M+1){  // 다 골랐을 경우. 출력해주자.
			for(int i=1; i<M+1; i++){
				sb.append(selected[i]).append(" ");
			}
			sb.append("\n");
		}else{ // 아직 다 고르지 못함. 값을 넣어 보고 다음 함수 호출
			
			int start = selected[k-1];
			if(start == 0){
				start = 1;
			}

			for(int i=start; i<N+1; i++){

				boolean check = false;

				for(int j = 1; j<k; j++){
					if( i == selected[j]){
						check = true;
					}
				}
				if(!check){
					selected[k] = i; 
					sol(k+1); // k+1 부터 M까지 탐색은 재귀로 처리함
					selected[k] = 0;
				}
			}
		}
	}
}