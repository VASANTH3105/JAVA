static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        // Your code here

        //sliding window approch

        ArrayList<Integer> list = new ArrayList<>();
        int left = 0 ;
        int right = 0;
        int count = 0;
        while(right < n) {
            count += arr[right];
            while(count > s && right < arr.length && left < right) {
                count -= arr[left];
                left++;
            }
            if(count == s) {
                list.add(left+1);
                list.add(right+1);
                return list;
            }
            
            right++;
        }
        list.add(-1);
        return list;
    }
//2
// Example 1:

// Input:
// N = 5
// A[] = {1,2,3,5}
// Output: 4
// Example 2:

// Input:
// N = 10
// A[] = {6,1,2,8,3,4,7,10,5}
// Output: 9
    int missingNumber(int array[], int n) {
        // Your Code Here
        int arrsum = n * (n+1)/2;
        int sum = 0;
        for(int i : array) {
            sum += i;
        }
        return (arrsum - sum);
    }

//kadane algo
long maxSubarraySum(int arr[], int n){
        
    // Your code here
    long maxsofar = arr[0];
    long maxend = 0;
    
    for(int i = 0 ; i < n ; i++) {
        maxend += arr[i];
        
        if(maxend > maxsofar) {
            maxsofar = maxend;
        }
        
        if(maxend < 0) {
            maxend = 0;
        }
    }
    return maxsofar;
}


ArrayList<Integer> leftView(Node root)
{
  // Your code here
  ArrayList<Integer> list = new ArrayList<>();
  
  addInList(root, list, 0);
  return list;
}

public void addInList(Node root, ArrayList<Integer> list, int level) {
    if (root == null) return;

    if (level == list.size()) {
        list.add(root.data);
    }

    addInList(root.left, list, level + 1);
    addInList(root.right, list, level + 1);
}


ArrayList<Integer> rightView(Node node) {
    //add code here.
    ArrayList<Integer> list = new ArrayList<>();
    insertRightNode(node, list, 0);
    return list;
}

void insertRightNode(Node node, ArrayList<Integer> list, int level) {
    if(node == null) return;
    if(level == list.size()) {
        list.add(node.data);
    }
    insertRightNode(node.right, list, level+1);
    insertRightNode(node.left, list, level+1);
}
