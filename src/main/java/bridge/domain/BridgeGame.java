package bridge.domain;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private BridgeMaker bridgeMaker;
    private Bridge bridge;

    // 다리 생성 기능
    public void createBridge(int size) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        this.bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        List<String> createdBridge = bridgeMaker.makeBridge(size);
        bridge = new Bridge(createdBridge);
    }

    // Bridge 객체 유저가 입력할 키 리스트 초기화
    public void initBridgeUserKeyList() {
        bridge.initUserKeyList();
    }

    // 이동 기능
    public Bridge move(String key) {
        bridge.move(key);
        return bridge;
    }

    // 다리 끝가지 돌아간 경우 boolean값 반환 기능
    public boolean isBridgeEnd() {
        int bridgeSize = bridge.getBridge().size();
        int userKeyListSize = bridge.getUserKeyList().size();
        return bridgeSize == userKeyListSize;
    }

    public void retry() {
    }
}
