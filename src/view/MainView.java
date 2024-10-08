package view;

import viewmodel.CanvasViewModel;
import viewmodel.PropertyPanelViewModel;
import javax.swing.JFrame;
import java.awt.BorderLayout;

public class MainView extends JFrame {
    private CanvasView canvasView;
    private PropertyPanelView propertyPanelView;

    public MainView(CanvasViewModel canvasViewModel, PropertyPanelViewModel propertyPanelViewModel) {
        this.setTitle("Vector Graphic Editor");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 캔버스와 속성 창을 초기화하고 배치
        canvasView = new CanvasView(canvasViewModel);
        propertyPanelView = new PropertyPanelView(propertyPanelViewModel);

        // 캔버스와 속성 패널을 레이아웃에 배치
        this.setLayout(new BorderLayout());
        this.add(canvasView, BorderLayout.CENTER);
        this.add(propertyPanelView, BorderLayout.EAST);

        // 이벤트 등록
        canvasView.registerEvents();

        // 프레임 보이기
        this.setVisible(true);
    }

    // 캔버스와 속성 패널을 업데이트하는 메서드
    public void updateView() {
        propertyPanelView.updateProperties();
        canvasView.repaint();  // 캔버스에 그려진 객체들을 다시 렌더링
    }
}
