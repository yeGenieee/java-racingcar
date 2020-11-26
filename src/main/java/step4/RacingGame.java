/*
 * 자동차 경주 게임을 진행하는 클래스
 * */

package step4;

import java.util.*;
import java.util.stream.Collectors;


public class RacingGame {
    private List<Car> carList;

    public RacingGame(String[] carNames) {
        this.carList = makeCarList(carNames);
    }

    /**
     * 입력받은 자동차 이름으로 자동차 클래스의 리스트를 만드는 메소드
     * @param carNames 입력받은 자동차 이름
     * @return 자동차 경주에서 사용될 자동차 리스트
     */
    public List<Car> makeCarList(String[] carNames) {
        carList = new ArrayList<>();

        for (String carName : carNames) {
            Car car = new Car(Constants.INITIAL_POSITION, carName);
            carList.add(car);
        }

        return carList;
    }

    /**
     * 자동차 경주 게임을 실행하는 메소드, 각 라운드를 실행하고 자동차들의 위치를 변경한다
     */
    public void playRace() {
        for (Car car : getCars()) {
            playEachCar(car);
        }
    }

    /**
     * 매 라운드마다 자동차의 전진 조건을 파악하여 자동차의 위치를 변경하는 메소드
     * @param car 각 자동차
     */
    private void playEachCar(Car car) {
        car.move();
    }

    /**
     * 자동차 경주게임에서의 우승한 자동차 리스트를 얻어오는 메소드
     * @return 우승한 자동차 리스트
     */
    public List<Car> getWinners() {
        return getCars().stream()
                .filter(c -> c.getPosition() == getMaxPosition())
                .collect(Collectors.toList());
    }

    /**
     * 우승한 자동차의 위치를 얻어오는 메소드
     * @return 우승한 자동차의 위치
     */
    private int getMaxPosition() {
        return getWinnerCar().getPosition();
    }

    /**
     * 우승한 자동차를 얻어온다 (각 자동차의 위치를 비교하여 max 자동차 객체를 얻어옴)
     * @return 우승한 자동차 객체
     */
    private Car getWinnerCar() {
        return getCars().stream()
                .max(Comparator.comparing(Car::getPosition))
                .orElse(null);
    }


    /**
     * RacingGame 클래스에서 관리하는 자동차 리스트 반환
     * @return 자동차 리스트
     */
    public List<Car> getCars() {
        return this.carList;
    }
}
