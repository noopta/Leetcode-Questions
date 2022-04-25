// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    ArrayList<Integer> theList;
    int currentIndex;
    
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    int i = 0;
        theList = new ArrayList<Integer>();
        
        while(iterator.hasNext()){
            theList.add(iterator.next());
            i++;
        }
        currentIndex = 0;
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return theList.get(currentIndex);
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    int tempInt = theList.get(currentIndex);
        currentIndex++;
        
        return tempInt;
	}
	
	@Override
	public boolean hasNext() {
	    if(currentIndex >= theList.size()){
            return false;
        }
        
        return true;
	}
}