/*
 * 각 자동차 객체로, 이동 거리를 관리하는 클래스
 * */
package step3;

import java.util.Random;

public class Car {

    public int position;
    private static Random random = new Random();

    public Car(int position) {
        this.position = position;
    }

    /**
     * 자동차의 위치를 변경하는 메소드
     */
    public void move() {
        if (isMovable()) {
            this.position++;
        }
    }

    public int getPosition() {
        return this.position;
    }


    /**
     * 랜덤으로 생성된 숫자가 전진 조건인지 아닌지 판별하는 메소드
     */
    public static boolean isMovable() {
        return getRandomNumber() >= Constants.MOVE_CONDITION;
    }

    /**
     * 0에서 9사이의 랜덤값을 생성하는 메소드
     */
    private static int getRandomNumber() {
        return random.nextInt(Constants.RANDOM_RANGE);
    }

}
