package com.oop.patientmanagement.Controller;

import com.oop.patientmanagement.Application;
import com.oop.patientmanagement.Model.PatientInfo;
import com.oop.patientmanagement.Model.PatientManagement;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

public class RemoveScreen {
    public TextField tf_searchByCitizenID;
    public Text textNoResults;
    public Text textShowResults;
    public Text textDateTime;
    public Text textDiseaseName;
    public Text textMedicine;
    public Text textAdvice;
    public Text textPatientName;
    public Text textDateOfBirth;
    public Text textGender;
    public Text textCitizenID;
    public Text textAddress;
    public Text textShowInform;
    private Stage stage;
    private Scene scene;
    private Parent root;
    public boolean visible;

    public void BackToMain(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(Application.class.getResource("home_screen.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("HỆ THỐNG QUẢN LÝ BỆNH NHÂN!");
        stage.setScene(scene);
        stage.show();
    }

    public void SearchInformationPatient() {
        String citizenID = tf_searchByCitizenID.getText();
        String string = PatientManagement.management.searchPatient(citizenID);
        if (!citizenID.isEmpty() && !string.equals("")) {
            visible = true;
            textShowInform.setLineSpacing(18.5);
            textShowInform.setText(string);
            PatientInfo patientInfo = PatientManagement.management.searchPatientInfo(citizenID);
            textPatientName.setText("Tên bệnh nhân:   \t" + patientInfo.getName());
            textDateOfBirth.setText("Ngày sinh:\t   " + patientInfo.getDateOfBirth());
            textGender.setText("Giới tính:\t   " + patientInfo.getGender());
            textCitizenID.setText("Số căn cước:\t   " + patientInfo.getCitizenID());
            textAddress.setText("Địa chỉ:   \t" + patientInfo.getAddress());
        } else {
            visible = false;
        }
        showAndHideResult();
    }

    public void showAndHideResult() {
        textNoResults.setVisible(!visible);
        textShowResults.setVisible(visible);
        textPatientName.setVisible(visible);
        textDateOfBirth.setVisible(visible);
        textGender.setVisible(visible);
        textCitizenID.setVisible(visible);
        textAddress.setVisible(visible);
        textDateTime.setVisible(visible);
        textAdvice.setVisible(visible);
        textMedicine.setVisible(visible);
        textDiseaseName.setVisible(visible);
        textShowInform.setVisible(visible);
    }

    public void RemovePatient() {
        if (tf_searchByCitizenID.getText().isEmpty()) {
            alertError();
        } else if (PatientManagement.management.searchPatient(tf_searchByCitizenID.getText()).isEmpty()) {
            alertNoResult();
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Hộp thoại xác nhận");
            alert.setHeaderText("Xác nhận");
            alert.setContentText("Bạn có chắc chắn muốn xoá thông tin bệnh nhân này?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                String citizenID = tf_searchByCitizenID.getText();
                PatientManagement.management.removePatient(citizenID);
                PatientManagement.management.readDataFromFile();
                alertSuccess();
            }
        }
    }

    public void alertError() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Hộp thoại thông báo");
        alert.setHeaderText("Thông báo");
        alert.setContentText("Bạn chưa nhập thông tin!");
        alert.show();
    }

    public void alertNoResult() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Hộp thoại thông báo");
        alert.setHeaderText("Thông báo");
        alert.setContentText("Không có dữ liệu cần xoá!");
        alert.show();
    }

    public void alertSuccess() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Hộp thoại thông báo");
        alert.setHeaderText("Thông báo");
        alert.setContentText("Xoá thông tin thành công!");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            refresh();
        }
    }

    public void refresh() {
        visible = false;
        showAndHideResult();
        textNoResults.setVisible(visible);
        tf_searchByCitizenID.setText("");
    }

}
