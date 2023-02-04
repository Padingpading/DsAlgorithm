package com.padingpading.queue.z_test;


public class Test_RingArray {
    
    public class My_RingArray{
        private int[] obj;
        private int size;
        private int putI;
        private int pollI;
        private final int limit;
    
        public My_RingArray(int ringSize) {
            this.obj = new int[ringSize];
            this.size = 0;
            this.putI = 0;
            this.pollI = 0;
            this.limit = ringSize;
        }
        
        public void putI(int num){
            if(size==limit){
                throw new RuntimeException("容器已经满了");
            }
            obj[putI] = num;
            size++;
            //切换到下一个位置
            putI = next(putI);
            
        }
    
        public int poll(){
            if(size==0){
                throw  new RuntimeException("容器为空");
            }
            size--;
            int i = obj[pollI];
            //切换到下一个位置
            pollI = next(pollI);
            return i;
        }
        
        public boolean isEmpty() {
            return size == 0;
        }
        
        public int next(int i){
            return  i >= limit - 1 ? 0 : i++;
        }
    }
    
}
