public class Explosion extends GameObject {

    public Explosion(int x, int y, int width, int height, int speed, GameObjectManager gameObjectManager) {
        super(x, y, width, height, speed, 5, gameObjectManager);

        this.spriteDrawing = new char[][] {

                {'X','X','X','X','X','X','X','X','X','X'},
                {' ',' ',' ',' ','X','X',' ',' ',' ',' '},
                {'X','X','X','X','X','X','X','X','X','X'},
                {' ',' ',' ',' ','X','X',' ',' ',' ',' '},
                {'X','X','X','X','X','X','X','X','X','X'},
                {' ',' ',' ',' ','X','X',' ',' ',' ',' '},
                {'X','X','X','X','X','X','X','X','X','X'},
                {' ','X','X','X','X','X','X','X','X',' '},
                {'X','X','X','X','X','X','X','X','X','X'},
                {' ',' ','X','X','X','X','X','X',' ',' '},
        };
    }

    @Override
    public void tick() {
        super.tick();

        health -= 1;

    }

}
