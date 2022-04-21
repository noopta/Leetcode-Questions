class MyHashSet {
    ArrayList<Integer> hashList;
    int i;
    
    public MyHashSet() {
        hashList = new ArrayList<Integer>();
        i = 0;
    }
    
    public void add(int key) {
        hashList.add(key);
    }
    
    public void remove(int key) {
        for(i = 0; i < hashList.size(); i++){
            if(hashList.get(i) == key){
                hashList.remove(i);
                i--;
            }   
        }
    }
    
    public boolean contains(int key) {
        
        for(i = 0; i < hashList.size(); i++){
            if(hashList.get(i) == key){
                return true;
            }
        }
        
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */