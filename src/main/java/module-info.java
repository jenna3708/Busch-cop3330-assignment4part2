module ucf.assignments.ex4pt2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires javafx.graphics;

    opens ucf.assignments.ex4pt2 to javafx.fxml;
    exports ucf.assignments.ex4pt2;
}