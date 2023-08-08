const num1 = [1,3,5,6];
const searchNum1= 4 ;
const expected1 = false;

const num2 = [4,5,6,8,12];
const searchNum2= 5 ;
const expected2 = true;

function binarySearch(sortedNums, searchNum){
    let start = 0;
    let end = sortedNums.length - 1;
     while (start <= end ){
       let mid =( start+end)/2;

       if(sortedNums[mid] == searchNum){
        return true 
       }
       
       if (sortedNums[mid] < searchNum){
        start = mid +1;
       }else{
        end = mid -1;
       }

     }
     return false;
}
// console.log(binarySearch(num2,searchNum2))

function binarySearchrec(sortednums,searchnum, start = 0,end = sortednums.length - 1){
    
    if (start <= end) {
        let mid =( start+end)/2;

        if (sortednums[mid] == searchnum){
            return true
        }else if(sortednums[mid] > searchnum) {
            binarySearchrec(sortednums,searchnum,start,mid-1);

        }else if(sortednums[mid] > searchnum) {
            binarySearchrec(sortednums,searchnum,mid + 1,end);
        }
        return false;
}}
console.log(binarySearchrec(num2,searchNum2))