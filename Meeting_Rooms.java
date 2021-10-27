class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        int i = 0;
        
        if(intervals.length == 0 || intervals == null){
            return true;
        }
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        int previousMeeting[] = intervals[0];
        
        for(i = 1; i < intervals.length; i++){
            int currentMeeting[] = intervals[i];
            if(doMeetingsOverlap(previousMeeting, currentMeeting)){
                return false;
            }
            
            previousMeeting = currentMeeting;
        }
        
        return true;
    }
    
    public boolean doMeetingsOverlap(int[] previousMeeting, int[] currentMeeting){
        
        if(currentMeeting[0] < previousMeeting[1]){
            return true;
        }
        return false;
    }
}