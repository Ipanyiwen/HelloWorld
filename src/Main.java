public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println("just a change");
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("over!!!");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });
    }
}
