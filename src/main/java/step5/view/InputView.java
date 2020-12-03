/*
 * 자동차 대수와 시도할 횟수를 입력 받는 UI 클래스
 * */
package step5.view;

import step5.util.Constants;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner;

    /**
     * scanner 클래스 init
     */
    public void init() {
        scanner = new Scanner(System.in);
    }

    /**
     * 자동차 이름 입력 메시지를 출력하는 메소드
     */
    public void showInputCarMessage() {
        System.out.println(Constants.CAR_NAMES_INPUT_MSG);
    }

    /**
     * 자동차 이름을 쉼표로 구분하는 메소드
     * @return 입력받은 자동차 이름 배열
     */
    public String[] inputCarName() {
        return inputNames().split(",");
    }

    /**
     * 자동차 이름을 스캐너로 입력받는 메소드
     * @return 사용자에게 입력받은 자동차 이름
     */
    private String inputNames() {
        return scanner.nextLine();
    }

    /**
     * 시도 횟수 입력 메시지를 출력하는 메소드
     */
    public void showInputRoundMessage() {
        System.out.println(Constants.MSG_ROUNDS);
    }

    /**
     * 시도 횟수를 사용자에게 입력 받는 메소드
     * @return 사용자에게 입력 받은 시도 횟수
     */
    public int inputRound() {
        return scanner.nextInt();
    }
}
