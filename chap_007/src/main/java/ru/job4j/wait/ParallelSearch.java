package ru.job4j.wait;

public class ParallelSearch {

    public static void main(String[] args)  {
        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<Integer>();
//        final Thread consumer = new Thread(
//                () -> {
//                    while (true){
//                        try{
//                            System.out.println(queue.poll());
//                        }
//                         catch (InterruptedException e){
//                            e.printStackTrace();
//                            Thread.currentThread().interrupt();
//                        }
//                    }
//                }
//        );
//        consumer.start();
        new Thread(
                () ->{
                    for(int i = 0; i!=3;i++){
                        queue.offer(i);
                        try {
                            Thread.sleep(500);
                        }catch (InterruptedException e){
                           e.printStackTrace();
                        }
                    }

                }
        ).start();
    }
}
