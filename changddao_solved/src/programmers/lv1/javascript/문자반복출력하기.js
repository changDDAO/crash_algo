function solution(my_string, n) {
    let answer = '';
    answer = [...my_string].map(c => c.repeat(n)).join("");
    return answer;
}