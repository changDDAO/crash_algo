const arr = [1,2,3,4,5,6,7,8,9,10];

const filtering = ()=>{
    let filterd = arr.reduce((acc, num)=>{
        if(num%2===0){
            acc.push(num);
        }
        return acc;
        }
        ,[]);
    console.log(filterd);
}

filtering();