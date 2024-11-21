import greenfoot.*;

public class MyWorld extends World {
    public MyWorld() {
        super(600, 400, 1);
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Test test = new Test();
        addObject(test,236,159);
        Test test2 = new Test();
        addObject(test2,267,159);
        Test test3 = new Test();
        addObject(test3,298,159);
    }
}
