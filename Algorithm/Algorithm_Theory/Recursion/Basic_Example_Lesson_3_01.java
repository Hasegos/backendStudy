import java.lang.Math;

/*
    1. 적어도 하나의 base case, 즉 순환하지 않고 종료되는 case가 있어야 함
    2. 모든 case는 결국 base case로 수렴해야 함
*/
public class Basic_Example_Lesson_3_01 {
    
    public static void main(String[] args) {
        
    }
    /*
        이 함수의 미션은 data[0]에서 data[n-1] 사이에서 target을 검색하는 것이다.
        하지만 검색 구간의 시간 인덱스 0은 보통 생략한다. 즉 암시적 매개변수이다.
        0은 암시적 n은 명시적 
    */
    int search(int [] data, int n, int target){
        for(int i = 0; i < n; i++){
            if(data[i] == target){
                return i;
            }
            return -1;
        }
    }
    /*
        이 함수의 미션은 data[begin]에서 data[end] 사이에서 target을
        검색한다. 즉, 검색구간의 시작점을 명시적(explicit)으로 지정한다.
        
        이 함수를 search(data, 0, n-1, target)으로 호출한다면
        앞 페이지의 함수와 완전히 동일한 일을 한다
        
        매개변수를 recursion을 생각해서 해야한다.
    */
    int search(int [] data, int begin, int end, int target){
        // 방법 1.
        if(begin > end)
            return -1;        
        else if(target == data[begin])
            return begin;        
        else 
            return search(data, begin + 1, end, target);
        
        // 방법 2.
        if(begin > end)
            return -1;        
        else if(target == data[begin])
            return begin;        
        else 
            return search(data, begin, end - 1, target);
        
        // 방법 3.
        if(begin > end)
            return -1;                
        else {
            int middle = (begin + end) / 2;
            if(data[middle] == target)
                return middle;
            int index = search(data, begin, middle-1, target);
            if(index != -1)
                return index;
            else
                return search(data, middle + 1, end, target);
                
        }            
    }
    /*
        매개변수의 명시화 : 최대값 찾기
        
        이 함수의 미션은 data[begin]에서 data[end] 사이에서
        최대값을 찾아 반환한다. begin <= end 라고 가정한다.
    */
    int findMax(int[] data, int begin, int end) {
        // 방법 1.
        if(begin == end)
            return data[begin];
        else 
            return Math.max(data[begin],findMax(data, begin + 1, end));
        
        // 방법 2.
        if(begin == end)
            return data[begin];
        else {
            int middle = (begin + end) / 2;
            int max1 = findMax(data, begin, middle);
            int max2 = findMax(data, middle + 1, end);
            return Math.max(max1,max2);
        }
    }
    
    // items[begin] 에서 items[end] 사이에서 target을 검색한다.
    public static int binarySearch(String[] items, String target, int begin, int end){
        if(begin > end)
            return -1;
        else {
            int middle = (begin + end) / 2;
            int comResult = target.compareTo(items[middle]);
            if(comResult == 0)
                return middle;
            else if(comResult < 0)
                return binarySearch(items, target, begin, middle - 1);
            else 
                return binarySearch(items, target, middle + 1, end);
        }        
    }    
}
