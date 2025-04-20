function solution(num_list) {
    let answer = [];
    //오름차순 정렬
    num_list.sort((a,b)=>a-b);

    //method1
    // for(let i = 0; i<5; i++){
    //     answer.push(num_list[i]);
    // }
    //method2
    answer = num_list.slice(0,5);
    return answer;
}