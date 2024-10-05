package programmers.practice;

public class _1로만들기 {
    public int solution(int[] num_list) {
        //12/2= 6 , 6/2 =3 , (3-1)%2=1;
        int len = num_list.length;
        int [] sumList = new int[len];
        for(int i = 0; i<num_list.length; i++){
            int cnt= 0;
            int target = num_list[i];
            while(true){
                if(target==1){
                    break;
                }
                if(target%2==0){
                    target/=2;
                    cnt++;
                }
                if(target%2==1){
                    target = (target-1)/2;
                    cnt++;
                }
            }
            sumList[i]=cnt;
        }
        System.out.println(sumList[0]);
        int answer = 0;

        return answer;
    }
}
