function solution(todo_list, finished) {
    var answer = [];
    answer = todo_list.reduce((acc, todo, idx)=>{
        if(!finished[idx]){
            acc.push(todo);
        }
        return acc;
    },[]);

    return answer;
}