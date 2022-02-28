class Solution {
    public List<String> summaryRanges(int[] nums) {
        ArrayList<String> returnList = new ArrayList<String>();
        ArrayList<Integer> currentList = new ArrayList<Integer>();
        int i = 1;
        
        if(nums.length >= 1){
            currentList.add(nums[0]);
        }
        
        while(i < nums.length){
            if(nums[i] == (nums[i - 1] + 1)){
                currentList.add(nums[i]);
            } else {
                // process currentList
                String tempString = "";
                
                if(currentList.size() > 1){
                    tempString += String.valueOf(currentList.get(0)) + "->" + currentList.get(currentList.size() - 1); 
                } else {
                    tempString += String.valueOf(currentList.get(0));   
                }
                
                returnList.add(tempString);
                currentList = new ArrayList<Integer>();
                currentList.add(nums[i]);
            }
            
            i++;
        }
        
        if(currentList.size() > 0){
            String tempString = "";

            if(currentList.size() > 1){
                tempString += String.valueOf(currentList.get(0)) + "->" + currentList.get(currentList.size() - 1); 
            } else {
                tempString += String.valueOf(currentList.get(0));   
            }
            
            returnList.add(tempString);
        }
        
        return returnList;
    }
}