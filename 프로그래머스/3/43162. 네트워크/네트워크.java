class Solution {
    
    public static boolean[] visited;
    public static int[][] map;
    
    public int solution(int n, int[][] computers) {
        
        map = computers;
        visited = new boolean[n]; //방문 여부를 체크할 배열
        int count = 0; //네트워크 수 
        
        //2차원 배열을 모두 돌며 체크해준다.
        if(n==1){
            return 1;
        } else {
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(!visited[j] && i!=j){ //중복으로 dfs를 수행하는 것을 막기 위해 조건 체크
                        dfs(j);
                        count++;
                    }
                }
            }
        }
        

        return count;   
    }
    
    public static void dfs (int i){
        
        visited[i] = true; //방문 처리
        
        for(int k=0; k<map[i].length; k++){
            if(map[i][k] == 1 && !visited[k]){ //컴퓨터가 연결되어 있고, 방문을 하지 않은 경우에만 실행
                dfs(k);
            }
        }      
    }
        
}